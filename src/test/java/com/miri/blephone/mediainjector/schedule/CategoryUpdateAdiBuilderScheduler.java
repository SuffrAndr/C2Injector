package com.miri.blephone.mediainjector.schedule;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miri.blephone.mediainjector.converter.CategoryConverter;
import com.miri.blephone.mediainjector.db.DBConstans;
import com.miri.blephone.mediainjector.db.dao.DbRepository;
import com.miri.blephone.mediainjector.db.domain.Category;
import com.miri.blephone.mediainjector.db.domain.ObjectId;
import com.miri.blephone.mediainjector.db.domain.Poster;
import com.miri.blephone.mediainjector.db.domain.WsMsg;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI.Objects;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI.Objects.Object;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADIConstants;
import com.miri.blephone.mediainjector.iptv.c2.adi.ObjectFactory;
import com.miri.blephone.mediainjector.iptv.c2.adi.PropertyType;
import com.miri.blephone.mediainjector.mq.MsgDelegate;
import com.miri.blephone.mediainjector.uitls.IdUtils;
import com.miri.blephone.mediainjector.uitls.PropsTypeUtils;

@Service
public class CategoryUpdateAdiBuilderScheduler extends BuilderScheduler implements InitializingBean {

    private static final Logger DLOG = LoggerFactory.getLogger(MsgDelegate.class);

    @Autowired
    private DbRepository        dbRepository;

    private Marshaller          marshaller;

    @Autowired
    private CategoryConverter   categoryConverter;

    @Autowired
    private IdBuilder           idBuilder;

    // @Scheduled(fixedRate = 60000)
    public void build() {

        final List<Category> categories = this.dbRepository.querySeriesCategory(DBConstans.AssetStatus.UPDATE);

        for (final Category category : categories) {

            this.dbRepository.updateCategoryStatus(category.getOriginalid(), DBConstans.AssetStatus.ADI_BUILD);

            StringWriter writer = null;

            try {

                final ObjectFactory objectFactory = new ObjectFactory();
                final ADI adi = objectFactory.createADI();

                adi.setPriority(ADIConstants.Priority);

                final Objects objects = objectFactory.createADIObjects();

                final Object object = objectFactory.createADIObjectsObject();

                object.setElementType(ADIConstants.ElementType.Series);

                final String id = IdUtils.buildId(this.idBuilder.getCpCode(), this.idBuilder.getVersionCode(),
                        this.idBuilder.getObjTypeSeries(), category.getObjectId());

                object.setID(id);
                object.setCode(id);
                object.setAction(ADIConstants.Action.UPDATE);

                final List<PropertyType> propertyTypes = this.categoryConverter.convert(category);

                object.getProperty().addAll(propertyTypes);

                final List<Poster> posters = this.dbRepository.queryPosterByOriginalId(category.getOriginalid(),
                        Poster.PosterType.CATEGORY);
                object.getProperty().addAll(PropsTypeUtils.buildPosterProps(posters));
                objects.getObject().add(object);
                adi.setObjects(objects);

                writer = new StringWriter();
                this.marshaller.marshal(adi, writer);

                final String adiXml = writer.toString();
                final String storePath = this.storeFile(category.getOriginalid(), object.getAction(), adiXml);

                final WsMsg wsMsg = new WsMsg();
                wsMsg.setCorrelateId(id);
                wsMsg.setObjectId(category.getObjectId());
                wsMsg.setType(ObjectId.ObjectType.SERIES);
                wsMsg.setOpType(DBConstans.WsOpType.UPDATE);
                wsMsg.setStorePath(storePath);

                List<WsMsg> wsMsgs = this.dbRepository.queryWsMsgs(wsMsg);

                if (CollectionUtils.isEmpty(wsMsgs)) {
                    this.dbRepository.addWSMsg(wsMsg);
                }

                this.dbRepository.updateCategoryStatus(category.getOriginalid(), DBConstans.AssetStatus.ADI_DEPLOYED);
            }
            catch (final Exception e) {
                CategoryUpdateAdiBuilderScheduler.DLOG.error("Build adi xml fail.", e);
            }
            finally {
                IOUtils.closeQuietly(writer);
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
