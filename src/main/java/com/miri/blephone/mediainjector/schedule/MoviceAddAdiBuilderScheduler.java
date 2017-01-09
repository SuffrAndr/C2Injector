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
import com.miri.blephone.mediainjector.iptv.c2.adi.ObjectFactory;
import com.miri.blephone.mediainjector.iptv.c2.adi.PropertyType;
import com.miri.blephone.mediainjector.mq.MsgDelegate;
import com.miri.blephone.mediainjector.uitls.IdUtils;
import com.miri.blephone.mediainjector.uitls.PropsTypeUtils;

@Service
public class MoviceAddAdiBuilderScheduler extends BuilderScheduler implements InitializingBean {

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

    @Scheduled(fixedRate = 60000)
    public void build() {

        final List<Clip> clips = this.dbRepository.queryMovicesByStatus(DBConstans.AssetStatus.INIT_ADD,
                DBConstans.AssetStatus.INIT_ADD);

        for (Clip clip : clips) {

            final Category category = this.dbRepository.queryCategoryByOriginalId(clip.getOriassetid());

            final List<com.miri.blephone.mediainjector.db.domain.File> files = this.dbRepository
                    .queryFilesByOripartId(clip.getOriginalid());

            // TODO:电影比较特殊，只有一个单集
            if (CollectionUtils.isNotEmpty(files)) {

                final com.miri.blephone.mediainjector.db.domain.File file = files.get(NumberUtils.INTEGER_ZERO);

                this.dbRepository.updateFileStatus(file.getOriginalid(), DBConstans.AssetStatus.ADI_BUILD);
                this.dbRepository.updateClipStatus(clip.getOriginalid(), DBConstans.AssetStatus.ADI_BUILD);
                this.dbRepository.updateCategoryStatus(category.getOriginalid(), DBConstans.AssetStatus.ADI_BUILD);

                StringWriter writer = null;

                try {

                    final ObjectFactory objectFactory = new ObjectFactory();
                    final ADI adi = objectFactory.createADI();

                    adi.setPriority(ADIConstants.Priority);

                    final Objects objects = objectFactory.createADIObjects();

                    final String id = IdUtils.buildId(this.idBuilder.getCpCode(), this.idBuilder.getVersionCode(),
                            this.idBuilder.getObjTypeMovice(), category.getObjectId());

                    final Object pObj = objectFactory.createADIObjectsObject();

                    pObj.setID(id);
                    pObj.setCode(id);
                    pObj.setElementType(ADIConstants.ElementType.Program);
                    pObj.setAction(ADIConstants.Action.REGIST);

                    final List<PropertyType> propertyTypes = this.clipConverter.convert(true, category, clip);
                    pObj.getProperty().addAll(propertyTypes);

                    final List<Poster> posters = this.dbRepository.queryPosterByOriginalId(category.getOriginalid(),
                            Poster.PosterType.CATEGORY);

                    pObj.getProperty().addAll(PropsTypeUtils.buildPosterProps(posters));

                    final Mappings mappings = objectFactory.createADIMappings();

                    final String mId = IdUtils.buildId(this.idBuilder.getCpCode(), this.idBuilder.getVersionCode(),
                            this.idBuilder.getObjTypeSeries(), category.getObjectId());

                    final Object mObj = objectFactory.createADIObjectsObject();

                    mObj.setID(mId);
                    mObj.setCode(mId);
                    mObj.setElementType(ADIConstants.ElementType.Movie);
                    mObj.setAction(ADIConstants.Action.REGIST);
                    mObj.getProperty().addAll(this.fileConverter.convert(clip, file));

                    // TOOD:增加文件Mapping
                    final Mapping fp = objectFactory.createADIMappingsMapping();
                    fp.setAction(ADIConstants.Action.REGIST);
                    fp.setElementType(ADIConstants.ElementType.Movie);
                    fp.setElementID(mObj.getID());
                    fp.setElementCode(mObj.getID());

                    fp.setParentID(pObj.getID());
                    fp.setParentCode(pObj.getID());
                    fp.setParentType(ADIConstants.ElementType.Program);
                    mappings.getMapping().add(fp);

                    objects.getObject().addAll(Lists.newArrayList(pObj, mObj));
                    adi.setObjects(objects);
                    adi.setMappings(mappings);

                    writer = new StringWriter();

                    this.marshaller.marshal(adi, writer);

                    final String adiXml = writer.toString();

                    final String storePath = this.storeFile(clip.getOriginalid(), mObj.getAction(), adiXml);

                    final WsMsg wsMsg = new WsMsg();
                    wsMsg.setCorrelateId(id);
                    wsMsg.setObjectId(category.getObjectId());
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
                    this.dbRepository.updateCategoryStatus(category.getOriginalid(),
                            DBConstans.AssetStatus.ADI_DEPLOYED);
                }
                catch (final Exception e) {
                    MoviceAddAdiBuilderScheduler.DLOG.error("Build adi xml fail.", e);
                }
                finally {
                    IOUtils.closeQuietly(writer);
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
