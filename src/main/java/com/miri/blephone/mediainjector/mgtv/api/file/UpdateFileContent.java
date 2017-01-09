package com.miri.blephone.mediainjector.mgtv.api.file;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "content", propOrder = { "videos" })
public class UpdateFileContent {

    @XmlElement(required = true)
    protected Videos videos;

    /**
     * 获取videos属性的值。
     * @return possible object is {@link Videos }
     */
    public Videos getVideos() {
        return this.videos;
    }

    /**
     * 设置videos属性的值。
     * @param value allowed object is {@link Videos }
     */
    public void setVideos(final Videos value) {
        this.videos = value;
    }
}
