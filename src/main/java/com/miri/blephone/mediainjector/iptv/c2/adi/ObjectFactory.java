//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2016.05.16 时间 04:00:29 PM CST
//

package com.miri.blephone.mediainjector.iptv.c2.adi;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each Java content interface and Java element
 * interface generated in the com.miri.blephone.mediainjector.api.iptv.adi package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java
 * representation for XML content. The Java representation of XML content can consist of
 * schema derived interfaces and classes representing the binding of schema type
 * definitions, element declarations and model groups. Factory methods for each of these
 * are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema
     * derived classes for package: com.miri.blephone.mediainjector.api.iptv.adi
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ADI }
     */
    public ADI createADI() {
        final ADI adi = new ADI();
        adi.setBizDomain("2");
        return adi;
    }

    /**
     * Create an instance of {@link ADI.Mappings }
     */
    public ADI.Mappings createADIMappings() {
        return new ADI.Mappings();
    }

    /**
     * Create an instance of {@link ADI.Objects }
     */
    public ADI.Objects createADIObjects() {
        return new ADI.Objects();
    }

    /**
     * Create an instance of {@link ADI.Reply }
     */
    public ADI.Reply createADIReply() {
        return new ADI.Reply();
    }

    /**
     * Create an instance of {@link PropertyType }
     */
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link ADI.Mappings.Mapping }
     */
    public ADI.Mappings.Mapping createADIMappingsMapping() {
        return new ADI.Mappings.Mapping();
    }

    /**
     * Create an instance of {@link ADI.Objects.Object }
     */
    public ADI.Objects.Object createADIObjectsObject() {
        return new ADI.Objects.Object();
    }

}
