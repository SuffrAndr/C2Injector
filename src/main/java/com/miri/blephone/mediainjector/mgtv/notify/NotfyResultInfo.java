package com.miri.blephone.mediainjector.mgtv.notify;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "info", propOrder = { "cdnId", "assetType", "assetId", "partId", "fileId", "siteId" })
public class NotfyResultInfo {
    @XmlElement(name = "cdn_id")
    private String  cdnId;

    @XmlElement(name = "mg_asset_type")
    private Integer assetType;

    @XmlElement(name = "mg_asset_id")
    private String  assetId;

    @XmlElement(name = "mg_part_id")
    private String  partId;

    @XmlElement(name = "mg_file_id")
    private String  fileId;

    @XmlElement(name = "site_id")
    private String  siteId;
}
