package com.miri.blephone.mediainjector.mgtv.api.file;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.miri.blephone.mediainjector.mgtv.api.Info;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assetcontent", propOrder = { "assettype", "assetdesc", "assetoperation", "content", "info" })
@XmlRootElement(name = "assetcontent")
public class DeleteFileAssetContent {

    @XmlElement(required = true, nillable = false)
    protected short             assettype;

    @XmlElement(required = true, nillable = false)
    protected short             assetdesc;

    @XmlElement(required = true, nillable = false)
    protected short             assetoperation;

    @XmlElement(required = true, nillable = false)
    protected DeltetFileContent content;

    @XmlElement(required = true, nillable = false)
    protected Info              info;

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
     * @return possible object is {@link DeltetFileContent.Content }
     */
    public DeltetFileContent getContent() {
        return this.content;
    }

    /**
     * 设置content属性的值。
     * @param value allowed object is {@link DeltetFileContent.Content }
     */
    public void setContent(final DeltetFileContent value) {
        this.content = value;
    }

    public Info getInfo() {
        return this.info;
    }

    public void setInfo(final Info info) {
        this.info = info;
    }

}
