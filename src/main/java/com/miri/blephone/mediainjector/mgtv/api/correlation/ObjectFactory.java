//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2016.05.17 时间 04:23:25 PM CST
//

package com.miri.blephone.mediainjector.mgtv.api.correlation;

import javax.xml.bind.annotation.XmlRegistry;

import com.miri.blephone.mediainjector.mgtv.api.Info;

/**
 * This object contains factory methods for each Java content interface and Java element
 * interface generated in the com.miri.blephone.mediainjector.mgtv.api.correlation package.
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
     * derived classes for package: com.miri.blephone.mediainjector.mgtv.api.correlation
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CorrelationAssetContent }
     */
    public CorrelationAssetContent createAssetcontent() {
        return new CorrelationAssetContent();
    }

    /**
     * Create an instance of {@link CorrelationContent }
     */
    public CorrelationContent createAssetcontentContent() {
        return new CorrelationContent();
    }

    /**
     * Create an instance of {@link CorrelationAssetContent.Info }
     */
    public Info createAssetcontentInfo() {
        return new Info();
    }

}
