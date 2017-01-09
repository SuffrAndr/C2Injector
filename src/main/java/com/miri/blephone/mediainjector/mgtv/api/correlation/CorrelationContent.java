package com.miri.blephone.mediainjector.mgtv.api.correlation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="columnid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="assetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="extensionfield1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oriassetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "content", propOrder = { "columnid", "assetid", "order", "extensionfield1", "oriassetid" })
public class CorrelationContent {

    @XmlElement(required = true)
    protected String columnid;
    @XmlElement(required = true)
    protected String assetid;
    protected double order;
    @XmlElement(required = true)
    protected String extensionfield1;
    @XmlElement(required = true)
    protected String oriassetid;

    /**
     * 获取columnid属性的值。
     * @return possible object is {@link String }
     */
    public String getColumnid() {
        return this.columnid;
    }

    /**
     * 设置columnid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setColumnid(final String value) {
        this.columnid = value;
    }

    /**
     * 获取assetid属性的值。
     * @return possible object is {@link String }
     */
    public String getAssetid() {
        return this.assetid;
    }

    /**
     * 设置assetid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAssetid(final String value) {
        this.assetid = value;
    }

    /**
     * 获取order属性的值。
     */
    public double getOrder() {
        return this.order;
    }

    /**
     * 设置order属性的值。
     */
    public void setOrder(final double value) {
        this.order = value;
    }

    /**
     * 获取extensionfield1属性的值。
     * @return possible object is {@link String }
     */
    public String getExtensionfield1() {
        return this.extensionfield1;
    }

    /**
     * 设置extensionfield1属性的值。
     * @param value allowed object is {@link String }
     */
    public void setExtensionfield1(final String value) {
        this.extensionfield1 = value;
    }

    /**
     * 获取oriassetid属性的值。
     * @return possible object is {@link String }
     */
    public String getOriassetid() {
        return this.oriassetid;
    }

    /**
     * 设置oriassetid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setOriassetid(final String value) {
        this.oriassetid = value;
    }
}
