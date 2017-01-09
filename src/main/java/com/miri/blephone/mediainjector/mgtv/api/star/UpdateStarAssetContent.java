//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2016.05.17 时间 05:28:00 PM CST
//

package com.miri.blephone.mediainjector.mgtv.api.star;

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
 *         &lt;element name="assettype" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="assetdesc" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="assetoperation" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="content">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="starid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="homeplace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="college" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="nation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="constellathion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="blood" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                   &lt;element name="intro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="initial" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="photourl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="imghash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fullspell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="simplespell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="occupation" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
public class UpdateStarAssetContent {

    @XmlElement(required = true)
    protected short assettype;
    @XmlElement(required = true)
    protected short assetdesc;
    @XmlElement(required = true)
    protected short assetoperation;
    @XmlElement(required = true)
    protected UpdateStarContent content;
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
     * @return possible object is {@link UpdateStarContent }
     */
    public UpdateStarContent getContent() {
        return this.content;
    }

    /**
     * 设置content属性的值。
     * @param value allowed object is {@link UpdateStarContent }
     */
    public void setContent(final UpdateStarContent value) {
        this.content = value;
    }

    /**
     * 获取info属性的值。
     * @return possible object is {@link UpdateStarAssetContent.Info }
     */
    public Info getInfo() {
        return this.info;
    }

    /**
     * 设置info属性的值。
     * @param value allowed object is {@link UpdateStarAssetContent.Info }
     */
    public void setInfo(final Info value) {
        this.info = value;
    }

}
