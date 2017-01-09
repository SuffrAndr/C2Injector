package com.miri.blephone.mediainjector.mgtv.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "assetcontent")
public class AssetContent {

    @XmlElement(required = true, nillable = false)
    protected short assettype;

    @XmlElement(required = true, nillable = false)
    protected short assetdesc;

    @XmlElement(required = true, nillable = false)
    protected short assetoperation;

    @XmlElement(required = true, nillable = false)
    protected Info  info;

    /**
     * 获取assettype属性的值。
     * @return possible object is {@link short }
     */
    public short getAssettype() {
        return this.assettype;
    }

    /**
     * 设置assettype属性的值。
     * @param value allowed object is {@link short }
     */
    public void setAssettype(final short value) {
        this.assettype = value;
    }

    /**
     * 获取assetdesc属性的值。
     * @return possible object is {@link short }
     */
    public short getAssetdesc() {
        return this.assetdesc;
    }

    /**
     * 设置assetdesc属性的值。
     * @param value allowed object is {@link short }
     */
    public void setAssetdesc(final short value) {
        this.assetdesc = value;
    }

    /**
     * 获取assetoperation属性的值。
     * @return possible object is {@link short }
     */
    public short getAssetoperation() {
        return this.assetoperation;
    }

    /**
     * 设置assetoperation属性的值。
     * @param value allowed object is {@link short }
     */
    public void setAssetoperation(final short value) {
        this.assetoperation = value;
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
