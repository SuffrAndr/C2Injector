package com.miri.blephone.mediainjector.mgtv.api.star;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "content", propOrder = { "id" })
public class DeleteStarContent {

    @XmlElement(required = true)
    protected String id;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}
