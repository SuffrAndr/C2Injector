//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2016.05.17 时间 04:30:56 PM CST
//

package com.miri.blephone.mediainjector.mgtv.api.clip;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.miri.blephone.mediainjector.mgtv.api.Info;

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
 *         &lt;element name="assettype" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="assetdesc" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="assetoperation" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="content">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="assetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="oriassetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="partid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="originalid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="partname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="othernme" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="extag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="eventtag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="adaptor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="leader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="kind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="caption" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tags" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="story" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="awards" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="updatetime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="createtime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="relasetime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="inital" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="simplespell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="isintact" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="serialno" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="publisher" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="periods" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="seekpoints">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="item">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="begin" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="img" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="imghash" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="images">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="image" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="imageid" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                                       &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="resolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="imgtype" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                                       &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                                       &lt;element name="imghash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="info">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pushcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="queuename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="contentprovider" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "assetcontent", propOrder = { "assettype", "assetdesc", "assetoperation", "content", "info" })
@XmlRootElement(name = "assetcontent")
public class UpdateClipAssetContent {

    @XmlElement(required = true, nillable = false)
    protected short assettype;

    @XmlElement(required = true, nillable = false)
    protected short assetdesc;

    @XmlElement(required = true, nillable = false)
    protected short assetoperation;

    @XmlElement(required = true)
    protected UpdateClipContent content;

    @XmlElement(required = true)
    protected Info info;

    /**
     * 获取assettype属性的值。
     */
    public short getAssettype() {
        return this.assettype;
    }

    /**
     * 设置assettype属性的值。
     */
    public void setAssettype(final short value) {
        this.assettype = value;
    }

    /**
     * 获取assetdesc属性的值。
     */
    public short getAssetdesc() {
        return this.assetdesc;
    }

    /**
     * 设置assetdesc属性的值。
     */
    public void setAssetdesc(final short value) {
        this.assetdesc = value;
    }

    /**
     * 获取assetoperation属性的值。
     */
    public short getAssetoperation() {
        return this.assetoperation;
    }

    /**
     * 设置assetoperation属性的值。
     */
    public void setAssetoperation(final short value) {
        this.assetoperation = value;
    }

    /**
     * 获取content属性的值。
     * @return possible object is {@link UpdateClipContent }
     */
    public UpdateClipContent getContent() {
        return this.content;
    }

    /**
     * 设置content属性的值。
     * @param value allowed object is {@link UpdateClipContent }
     */
    public void setContent(final UpdateClipContent value) {
        this.content = value;
    }

    /**
     * 获取info属性的值。
     * @return possible object is {@link Info }
     */
    public Info getInfo() {
        return this.info;
    }

    /**
     * 设置info属性的值。
     * @param value allowed object is {@link Info }
     */
    public void setInfo(final Info value) {
        this.info = value;
    }

}
