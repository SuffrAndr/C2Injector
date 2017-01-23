package mq;

import com.miri.blephone.mediainjector.iptv.c2.adi.*;
import com.miri.blephone.mediainjector.iptv.c2.adi.rsp.*;
import org.apache.commons.lang.*;
import org.apache.commons.lang3.tuple.*;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;

public class Test {

    public static void main(final String[] args) {

        // final String urlPrefix = "ftp://ftper:ftper@183.235.11.104:2121/aa";
        //
        // final String fileNmae =
        // "adi/resp_dc35107b6fdd4e5aa926211632bb6ff4_1467563494691.xml";
        // final String url =
        // com.miri.blephone.mediainjector.uitls.UrlUtils.getUrl(urlPrefix, fileNmae);
        //
        // System.out.println(url);

        final JAXBContext jaxb;
        try {
            jaxb = JAXBContext.newInstance(RspADI.class);
            Unmarshaller marshaller = jaxb.createUnmarshaller();

            File file = new File("D:/3.xml");

            RspADI rspADI = (RspADI) marshaller.unmarshal(file);

	        Pair<Integer, String> pair = readdRsp(rspADI);

	        System.out.print(pair);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Pair<Integer, String> readdRsp(RspADI rspADI) throws Exception {

        Pair<Integer, String> pair = new MutablePair<>();

        Integer left = 0;

        String right = "";

        if (rspADI != null) {
            final List<PropertyType> props = rspADI.getReply().getProperty();

            for (PropertyType propertyType : props) {

                String name = propertyType.getName();
                String value = propertyType.getValue();
                if (StringUtils.equals(name, ADIElementConstants.RESULT)) {
                    left = Integer.valueOf(value);
                }

                if (StringUtils.equals(name, ADIElementConstants.DESC)) {
                    right = value;
                }
            }

            pair.of(left, right);
        }

        return pair;
    }
}
