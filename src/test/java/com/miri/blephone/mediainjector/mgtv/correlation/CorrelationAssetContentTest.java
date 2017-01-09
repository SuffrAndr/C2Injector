package com.miri.blephone.mediainjector.mgtv.correlation;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.miri.blephone.mediainjector.mgtv.api.correlation.CorrelationAssetContent;

public class CorrelationAssetContentTest {
    public static void main(final String[] args) {
        try {
            final JAXBContext jaxb = JAXBContext.newInstance(CorrelationAssetContent.class);

            final Unmarshaller unmarshaller = jaxb.createUnmarshaller();

            final File f = new File("C:/Users/Night/Desktop/file.xml");

            final CorrelationAssetContent categoryAssetcontent = (CorrelationAssetContent) unmarshaller.unmarshal(f);

            System.out.println(ToStringBuilder.reflectionToString(categoryAssetcontent.getContent(),
                    ToStringStyle.MULTI_LINE_STYLE));

        }
        catch (final JAXBException e) {
            e.printStackTrace();
        }
    }
}
