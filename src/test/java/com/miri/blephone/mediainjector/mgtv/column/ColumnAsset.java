package com.miri.blephone.mediainjector.mgtv.column;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.miri.blephone.mediainjector.mgtv.api.column.ColumnAssetContent;

public class ColumnAsset {
    public static void main(final String[] args) {
        try {
            final JAXBContext jaxb = JAXBContext.newInstance(ColumnAssetContent.class);

            final Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            final File reader = new File("C:/Users/Night/Desktop/column.xml");

            final ColumnAssetContent assetcontent = (ColumnAssetContent) unmarshaller.unmarshal(reader);

            System.out.println(
                    ToStringBuilder.reflectionToString(assetcontent.getContent(), ToStringStyle.MULTI_LINE_STYLE));

        }
        catch (final JAXBException e) {
            e.printStackTrace();
        }
    }
}
