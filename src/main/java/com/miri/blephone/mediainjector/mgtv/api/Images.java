package com.miri.blephone.mediainjector.mgtv.api;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * anonymous complex type的 Java 类。
 * <p>
 * 以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="image" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="imageid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="resolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="imgtype" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                   &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="imghash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "image" })
public class Images {

    protected List<Image> image;

    /**
     * Gets the value of the image property.
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot.
     * Therefore any modification you make to the returned list will be present inside the
     * JAXB object. This is why there is not a <CODE>set</CODE> method for the image
     * property.
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getImage().add(newItem);
     * </pre>
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Image }
     */
    public List<Image> getImage() {
        if (this.image == null) {
            this.image = new ArrayList<>();
        }
        return this.image;
    }
}
