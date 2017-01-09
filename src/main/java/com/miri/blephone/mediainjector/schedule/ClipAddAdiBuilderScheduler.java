package com.miri.blephone.mediainjector.schedule;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.miri.blephone.mediainjector.converter.ClipConverter;
import com.miri.blephone.mediainjector.converter.FileConverter;
import com.miri.blephone.mediainjector.db.DBConstans;
import com.miri.blephone.mediainjector.db.dao.DbRepository;
import com.miri.blephone.mediainjector.db.domain.Category;
import com.miri.blephone.mediainjector.db.domain.Clip;
import com.miri.blephone.mediainjector.db.domain.ObjectId;
import com.miri.blephone.mediainjector.db.domain.Poster;
import com.miri.blephone.mediainjector.db.domain.WsMsg;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI.Mappings;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI.Mappings.Mapping;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI.Objects;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI.Objects.Object;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADIConstants;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADIElementConstants;
import com.miri.blephone.mediainjector.iptv.c2.adi.ObjectFactory;
import com.miri.blephone.mediainjector.iptv.c2.adi.PropertyType;
import com.miri.blephone.mediainjector.mq.MsgDelegate;
import com.miri.blephone.mediainjector.uitls.IdUtils;
import com.miri.blephone.mediainjector.uitls.PropsTypeUtils;

@Service
public class ClipAddAdiBuilderScheduler extends BuilderScheduler implements InitializingBean {

    private static final Logger DLOG = LoggerFactory.getLogger(MsgDelegate.class);

    @Autowired
    private DbRepository        dbRepository;

    private Marshaller          marshaller;

    @Autowired
    private ClipConverter       clipConverter;

    @Autowired
    private FileConverter       fileConverter;

    @Autowired
    private IdBuilder           idBuilder;

    /**
     * 生成ADI文件，讲Progam和Movice同时生成
     * @param clip 分集对象 {@link Clip}
     * @return
     */
    @Scheduled(fixedRate = 60000)
    public void build() {

        final List<Clip> clips = this.dbRepository.queryClipSeriesByStatus(DBConstans.AssetStatus.INIT_ADD,
                DBConstans.AssetStatus.INJECTED);

        for (final Clip clip : clips) {

            final List<com.miri.blephone.mediainjector.db.domain.File> files = this.dbRepository
                    .queryFilesByOripartId(clip.getOriginalid());

            if (CollectionUtils.isNotEmpty(files)) {

                final com.miri.blephone.mediainjector.db.domain.File file = files.get(NumberUtils.INTEGER_ZERO);

                final Category category = this.dbRepository.queryCategoryByOriginalId(clip.getOriassetid());

                if (category != null) {

                    this.dbRepository.updateFileStatus(file.getOriginalid(), DBConstans.AssetStatus.ADI_BUILD);
                    this.dbRepository.updateClipStatus(clip.getOriginalid(), DBConstans.AssetStatus.ADI_BUILD);

                    StringWriter writer = null;

                    try {

                        final ObjectFactory objectFactory = new ObjectFactory();
                        final ADI adi = objectFactory.createADI();

                        adi.setPriority(ADIConstants.Priority);

                        final Objects objects = objectFactory.createADIObjects();

                        final Object pObj = objectFactory.createADIObjectsObject();

                        final String id = IdUtils.buildId(this.idBuilder.getCpCode(), this.idBuilder.getVersionCode(),
                                this.idBuilder.getObjTypeSeries(), clip.getObjectId());

                        pObj.setID(id);
                        pObj.setCode(id);
                        pObj.setAction(ADIConstants.Action.REGIST);
                        pObj.setElementType(ADIConstants.ElementType.Program);

                        final List<PropertyType> propertyTypes = this.clipConverter.convert(category, clip);

                        pObj.getProperty().addAll(propertyTypes);

                        final List<Poster> posters = this.dbRepository.queryPosterByOriginalId(category.getOriginalid(),
                                Poster.PosterType.CATEGORY);

                        pObj.getProperty().addAll(PropsTypeUtils.buildPosterProps(posters));

                        final Mappings mappings = objectFactory.createADIMappings();

                        final Object mObj = objectFactory.createADIObjectsObject();

                        mObj.setElementType(ADIConstants.ElementType.Movie);

                        final String mId = IdUtils.buildId(this.idBuilder.getCpCode(), this.idBuilder.getVersionCode(),
                                this.idBuilder.getObjTypeSeries(), file.getObjectId());

                        mObj.setID(mId);
                        mObj.setCode(mId);
                        mObj.setAction(ADIConstants.Action.REGIST);
                        mObj.getProperty().addAll(this.fileConverter.convert(clip, file));
                        objects.getObject().add(mObj);

                        // TOOD:增加文件Mapping
                        final Mapping fp = objectFactory.createADIMappingsMapping();
                        fp.setAction(ADIConstants.Action.REGIST);

                        fp.setElementType(ADIConstants.ElementType.Movie);
                        fp.setElementID(mObj.getID());
                        fp.setElementCode(mObj.getID());

                        fp.setParentID(pObj.getID());
                        fp.setParentCode(pObj.getID());
                        fp.setParentType(ADIConstants.ElementType.Program);

                        final PropertyType type = new PropertyType();
                        type.setName(ADIElementConstants.TYPE);
                        type.setValue(String.valueOf(0));

                        final PropertyType sequence = new PropertyType();
                        sequence.setName(ADIElementConstants.Picture.SEQUENCE);
                        sequence.setValue(String.valueOf(clip.getSerialno()));
                        fp.getProperty().addAll(Lists.newArrayList(type, sequence));

                        mappings.getMapping().add(fp);

                        final Mapping smp = objectFactory.createADIMappingsMapping();
                        smp.setAction(ADIConstants.Action.REGIST);
                        smp.setElementType(ADIConstants.ElementType.Program);
                        smp.setElementID(pObj.getID());
                        smp.setElementCode(pObj.getID());

                        final String sId = IdUtils.buildId(this.idBuilder.getCpCode(), this.idBuilder.getVersionCode(),
                                this.idBuilder.getObjTypeSeries(), category.getObjectId());

                        smp.setParentID(sId);
                        smp.setParentCode(sId);
                        smp.setParentType(ADIConstants.ElementType.Series);

                        final PropertyType smps = new PropertyType();
                        smps.setName(ADIElementConstants.Picture.SEQUENCE);
                        smps.setValue(String.valueOf(clip.getSerialno()));
                        smp.getProperty().addAll(Lists.newArrayList(smps));

                        mappings.getMapping().add(smp);

                        objects.getObject().add(pObj);
                        adi.setObjects(objects);
                        adi.setMappings(mappings);

                        writer = new StringWriter();

                        this.marshaller.marshal(adi, writer);

                        final String adiXml = writer.toString();

                        final String storePath = this.storeFile(clip.getOriginalid(), pObj.getAction(), adiXml);

                        final WsMsg wsMsg = new WsMsg();
                        wsMsg.setCorrelateId(id);
                        wsMsg.setObjectId(clip.getObjectId());
                        wsMsg.setType(ObjectId.ObjectType.PROGRAM);
                        wsMsg.setOpType(DBConstans.WsOpType.REGIST);
                        wsMsg.setStorePath(storePath);
                        wsMsg.setSubObjectId(file.getObjectId());

                        List<WsMsg> wsMsgs = this.dbRepository.queryWsMsgs(wsMsg);

                        if (CollectionUtils.isEmpty(wsMsgs)) {
                            this.dbRepository.addWSMsg(wsMsg);
                        }

                        this.dbRepository.updateFileStatus(file.getOriginalid(), DBConstans.AssetStatus.ADI_DEPLOYED);
                        this.dbRepository.updateClipStatus(clip.getOriginalid(), DBConstans.AssetStatus.ADI_DEPLOYED);
                    }
                    catch (final Exception e) {
                        ClipAddAdiBuilderScheduler.DLOG.error("Build adi xml fail.", e);
                    }
                    finally {
                        IOUtils.closeQuietly(writer);
                    }
                }
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        final JAXBContext jaxb = JAXBContext.newInstance(ADI.class);

        this.marshaller = jaxb.createMarshaller();

        this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }
}
