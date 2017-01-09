package com.miri.blephone.mediainjector.mgtv.notify;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class NotfyResultTest {
    public static void main(final String[] args) {
        try {
            final JAXBContext jaxb = JAXBContext.newInstance(NotfyResult.class);

            final Marshaller marshaller = jaxb.createMarshaller();

            final StringWriter writer = new StringWriter();

            final NotfyResult notfyResult = new NotfyResult();

            final NotfyResultInfo info = new NotfyResultInfo();
            info.setAssetId("1");
            info.setAssetType(1);
            info.setCdnId("1");
            info.setFileId("1");
            info.setPartId("1");
            info.setSiteId("11");

            notfyResult.setInfo(info);

            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
            marshaller.marshal(notfyResult, writer);

            final String string = writer.toString();

            System.out.println(string);

        }
        catch (final JAXBException e) {
            e.printStackTrace();
        }
    }
}
