package com.miri.blephone.mediainjector.mgtv.api.column;

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
 *         &lt;element name="columnname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parentid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="extensionfield1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "content", propOrder = { "columnid", "columnname", "parentid", "order", "extensionfield1" })
public class ColumnContent {

    @XmlElement(required = true)
    protected String columnid;
    @XmlElement(required = true)
    protected String columnname;
    @XmlElement(required = true)
    protected String parentid;
    protected double order;
    @XmlElement(required = true)
    protected String extensionfield1;

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
     * 获取columnname属性的值。
     * @return possible object is {@link String }
     */
    public String getColumnname() {
        return this.columnname;
    }

    /**
     * 设置columnname属性的值。
     * @param value allowed object is {@link String }
     */
    public void setColumnname(final String value) {
        this.columnname = value;
    }

    /**
     * 获取parentid属性的值。
     * @return possible object is {@link String }
     */
    public String getParentid() {
        return this.parentid;
    }

    /**
     * 设置parentid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setParentid(final String value) {
        this.parentid = value;
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
}
