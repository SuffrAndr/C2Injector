package com.miri.blephone.mediainjector.mgtv.notify;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xmlresult")
public class NotfyResult {
    private String          msgid;
    private Integer         state;
    private String          msg;

    @XmlElement(name = "info")
    private NotfyResultInfo info;
}
