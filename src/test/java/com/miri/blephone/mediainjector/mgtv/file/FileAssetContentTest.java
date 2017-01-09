package com.miri.blephone.mediainjector.mgtv.file;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.miri.blephone.mediainjector.mgtv.api.file.UpdateFileAssetContent;

public class FileAssetContentTest {
    public static void main(final String[] args) {
        try {
            final JAXBContext jaxb = JAXBContext.newInstance(UpdateFileAssetContent.class);

            final Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            final File f = new File("C:/Users/Night/Desktop/file.xml");

            final UpdateFileAssetContent categoryAssetcontent = (UpdateFileAssetContent) unmarshaller.unmarshal(f);

            System.out.println(ToStringBuilder.reflectionToString(
                    categoryAssetcontent.getContent().getVideos().getFile(), ToStringStyle.MULTI_LINE_STYLE));

        }
        catch (final JAXBException e) {
            e.printStackTrace();
        }
    }
}
