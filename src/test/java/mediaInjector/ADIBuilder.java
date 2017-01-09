package mediaInjector;

import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADIConstants;
import com.miri.blephone.mediainjector.iptv.c2.adi.ObjectFactory;
import com.miri.blephone.mediainjector.iptv.c2.adi.PropertyType;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI.Objects;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADI.Objects.Object;

public class ADIBuilder {
    public static void main(final String[] args) {
        try {
            final JAXBContext jaxb = JAXBContext.newInstance(ADI.class);

            final ObjectFactory objectFactory = new ObjectFactory();
            final ADI adi = objectFactory.createADI();

            adi.setPriority(ADIConstants.Priority);

            final Objects objects = objectFactory.createADIObjects();

            final Object obj = objectFactory.createADIObjectsObject();

            obj.setID(StringUtils.remove(UUID.randomUUID().toString(), '-'));
            obj.setCode(obj.getID());
            obj.setElementType(ADIConstants.ElementType.Program);

            final PropertyType propertyType = new PropertyType();
            propertyType.setName("Name");
            propertyType.setValue("大长今");

            final PropertyType propertyType1 = new PropertyType();
            propertyType1.setName("Language");
            propertyType1.setValue("韩语");

            obj.getProperty().addAll(Lists.newArrayList(propertyType, propertyType1));

            objects.getObject().add(obj);

            adi.setObjects(objects);

            final Marshaller marshaller = jaxb.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(adi, System.out);

        }
        catch (final JAXBException e) {
            e.printStackTrace();
        }
    }
}
