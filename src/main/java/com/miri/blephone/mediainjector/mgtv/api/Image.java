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
 *         &lt;element name="imageid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imgtype" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="imghash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "imageid", "filename", "resolution", "imgtype", "filesize", "imghash" })
public class Image {

    protected String  imageid;
    @XmlElement(required = true)
    protected String  filename;
    @XmlElement(required = true)
    protected String  resolution;
    @XmlElement(required = true)
    protected Integer imgtype;
    @XmlElement(required = true, defaultValue = "")
    protected long    filesize;
    @XmlElement(required = true)
    protected String  imghash;

    /**
     * 获取imageid属性的值。
     */
    public String getImageid() {
        return this.imageid;
    }

    /**
     * 设置imageid属性的值。
     */
    public void setImageid(final String value) {
        this.imageid = value;
    }

    /**
     * 获取filename属性的值。
     * @return possible object is {@link String }
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * 设置filename属性的值。
     * @param value allowed object is {@link String }
     */
    public void setFilename(final String value) {
        this.filename = value;
    }

    /**
     * 获取resolution属性的值。
     * @return possible object is {@link String }
     */
    public String getResolution() {
        return this.resolution;
    }

    /**
     * 设置resolution属性的值。
     * @param value allowed object is {@link String }
     */
    public void setResolution(final String value) {
        this.resolution = value;
    }

    /**
     * 获取imgtype属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getImgtype() {
        return this.imgtype;
    }

    /**
     * 设置imgtype属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setImgtype(final Integer value) {
        this.imgtype = value;
    }

    /**
     * 获取filesize属性的值。
     * @return possible object is {@link long }
     */
    public long getFilesize() {
        return this.filesize;
    }

    /**
     * 设置filesize属性的值。
     * @param value allowed object is {@link long }
     */
    public void setFilesize(final long value) {
        this.filesize = value;
    }

    /**
     * 获取imghash属性的值。
     * @return possible object is {@link String }
     */
    public String getImghash() {
        return this.imghash;
    }

    /**
     * 设置imghash属性的值。
     * @param value allowed object is {@link String }
     */
    public void setImghash(final String value) {
        this.imghash = value;
    }

}
