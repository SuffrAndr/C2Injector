package com.miri.blephone.mediainjector.mgtv;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.miri.blephone.mediainjector.mgtv.api.AssetContent;
import com.miri.blephone.mediainjector.mgtv.api.category.DeleteCategoryAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.category.UpdateCategoryAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.clip.DeleteClipAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.clip.UpdateClipAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.column.ColumnAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.correlation.CorrelationAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.file.DeleteFileAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.file.UpdateFileAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.star.DeleteStarAssetContent;
import com.miri.blephone.mediainjector.mgtv.api.star.UpdateStarAssetContent;
import com.miri.blephone.mediainjector.mgtv.notify.NotfyResult;

@Component
public class XmlMapperWrapper implements InitializingBean {

    private JAXBContext assetContentJaxb;
    private JAXBContext updateCategoryAssetJaxb;

    private JAXBContext deleteCategoryAssetJaxb;

    private JAXBContext deleteStarJaxb;

    private JAXBContext correlationJaxb;

    private JAXBContext updateClipAssetJaxb;
    private JAXBContext deleteClipAssetJaxb;
    private JAXBContext updateFileAssetJaxb;
    private JAXBContext deleteFileAssetJaxb;
    private JAXBContext columnJaxb;
    private JAXBContext updateStarJaxb;
    private JAXBContext notfyResultJaxb;

    public Unmarshaller getAssetContentUnmarshaller() throws JAXBException {
        return this.assetContentJaxb.createUnmarshaller();
    }

    public Unmarshaller getUpdateCategoryAssetContentUnmarshaller() throws JAXBException {
        return this.updateCategoryAssetJaxb.createUnmarshaller();
    }

    public Unmarshaller getDeleteCategoryAssetContenttUnmarshaller() throws JAXBException {
        return this.deleteCategoryAssetJaxb.createUnmarshaller();
    }

    public Unmarshaller getUpdateClipAssetContentUnmarshaller() throws JAXBException {
        return this.updateClipAssetJaxb.createUnmarshaller();
    }

    public Unmarshaller getDeleteClipAssetContentUnmarshaller() throws JAXBException {
        return this.deleteClipAssetJaxb.createUnmarshaller();
    }

    public Unmarshaller getUpdateFileAssetContentUnmarshaller() throws JAXBException {
        return this.updateFileAssetJaxb.createUnmarshaller();
    }

    public Unmarshaller getDeleteFileAssetContentUnmarshaller() throws JAXBException {
        return this.deleteFileAssetJaxb.createUnmarshaller();
    }

    public Unmarshaller getColumnAssetContentUnmarshaller() throws JAXBException {
        return this.columnJaxb.createUnmarshaller();
    }

    public Unmarshaller getCorrelationAssetContentUnmarshaller() throws JAXBException {
        return this.correlationJaxb.createUnmarshaller();
    }

    public Unmarshaller getUpdateStarAssetContentUnmarshaller() throws JAXBException {
        return this.updateStarJaxb.createUnmarshaller();
    }

    public Unmarshaller getDeleteStarAssetContentUnmarshaller() throws JAXBException {
        return this.deleteStarJaxb.createUnmarshaller();
    }

    public Marshaller getNotfyResultMarshaller() throws JAXBException {
        final Marshaller notfyResultMarshaller = this.notfyResultJaxb.createMarshaller();
        notfyResultMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        return notfyResultMarshaller;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        this.assetContentJaxb = JAXBContext.newInstance(AssetContent.class);

        this.updateCategoryAssetJaxb = JAXBContext.newInstance(UpdateCategoryAssetContent.class);

        this.deleteCategoryAssetJaxb = JAXBContext.newInstance(DeleteCategoryAssetContent.class);

        this.updateClipAssetJaxb = JAXBContext.newInstance(UpdateClipAssetContent.class);

        this.deleteClipAssetJaxb = JAXBContext.newInstance(DeleteClipAssetContent.class);

        this.updateFileAssetJaxb = JAXBContext.newInstance(UpdateFileAssetContent.class);

        this.deleteFileAssetJaxb = JAXBContext.newInstance(DeleteFileAssetContent.class);

        this.columnJaxb = JAXBContext.newInstance(ColumnAssetContent.class);

        this.correlationJaxb = JAXBContext.newInstance(CorrelationAssetContent.class);

        this.notfyResultJaxb = JAXBContext.newInstance(NotfyResult.class);

        this.updateStarJaxb = JAXBContext.newInstance(UpdateStarAssetContent.class);
        this.deleteStarJaxb = JAXBContext.newInstance(DeleteStarAssetContent.class);
    }

}
