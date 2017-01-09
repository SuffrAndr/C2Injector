
package com.miri.blephone.mediainjector.mgtv.api.star;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.miri.blephone.mediainjector.mgtv.api.Info;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assetcontent", propOrder = { "assettype", "assetdesc", "assetoperation", "content", "info" })
@XmlRootElement(name = "assetcontent")
public class DeleteStarAssetContent {

    @XmlElement(required = true)
    protected short assettype;
    @XmlElement(required = true)
    protected short assetdesc;
    @XmlElement(required = true)
    protected short assetoperation;
    @XmlElement(required = true)
    protected DeleteStarContent content;
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
     * @return possible object is {@link DeleteStarContent }
     */
    public DeleteStarContent getContent() {
        return this.content;
    }

    /**
     * 设置content属性的值。
     * @param value allowed object is {@link DeleteStarContent }
     */
    public void setContent(final DeleteStarContent value) {
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
