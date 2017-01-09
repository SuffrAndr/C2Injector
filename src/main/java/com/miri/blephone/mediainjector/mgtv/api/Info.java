package com.miri.blephone.mediainjector.mgtv.api;

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
 *         &lt;element name="pushcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="queuename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contentprovider" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "pushcode", "queuename", "contentprovider" })
public class Info {

    @XmlElement(required = true)
    protected String pushcode;
    @XmlElement(required = true)
    protected String queuename;
    @XmlElement(required = true)
    protected String contentprovider;

    /**
     * 获取pushcode属性的值。
     * @return possible object is {@link String }
     */
    public String getPushcode() {
        return this.pushcode;
    }

    /**
     * 设置pushcode属性的值。
     * @param value allowed object is {@link String }
     */
    public void setPushcode(final String value) {
        this.pushcode = value;
    }

    /**
     * 获取queuename属性的值。
     * @return possible object is {@link String }
     */
    public String getQueuename() {
        return this.queuename;
    }

    /**
     * 设置queuename属性的值。
     * @param value allowed object is {@link String }
     */
    public void setQueuename(final String value) {
        this.queuename = value;
    }

    /**
     * 获取contentprovider属性的值。
     * @return possible object is {@link String }
     */
    public String getContentprovider() {
        return this.contentprovider;
    }

    /**
     * 设置contentprovider属性的值。
     * @param value allowed object is {@link String }
     */
    public void setContentprovider(final String value) {
        this.contentprovider = value;
    }

}
