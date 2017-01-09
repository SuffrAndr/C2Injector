//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2016.05.17 时间 05:02:00 PM CST
//

package com.miri.blephone.mediainjector.mgtv.api.category;

import javax.xml.bind.annotation.XmlRegistry;

import com.miri.blephone.mediainjector.mgtv.api.Image;
import com.miri.blephone.mediainjector.mgtv.api.Images;
import com.miri.blephone.mediainjector.mgtv.api.Info;

/**
 * This object contains factory methods for each Java content interface and Java element
 * interface generated in the com.miri.blephone.mediainjector.mgtv.api.category package.
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
     * derived classes for package: com.miri.blephone.mediainjector.mgtv.api.category
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateCategoryAssetContent }
     */
    public UpdateCategoryAssetContent createAssetcontent() {
        return new UpdateCategoryAssetContent();
    }

    /**
     * Create an instance of {@link UpdateCategoryAssetContent.Content }
     */
    public UpdateCategoryContent createAssetcontentContent() {
        return new UpdateCategoryContent();
    }

    /**
     * Create an instance of {@link Images }
     */
    public Images createAssetcontentContentImages() {
        return new Images();
    }

    /**
     * Create an instance of {@link UpdateCategoryAssetContent.Info }
     */
    public Info createAssetcontentInfo() {
        return new Info();
    }

    /**
     * Create an instance of {@link Images.Image }
     */
    public Image createAssetcontentContentImagesImage() {
        return new Image();
    }
}
