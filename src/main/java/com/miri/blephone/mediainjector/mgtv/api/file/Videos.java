package com.miri.blephone.mediainjector.mgtv.api.file;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="file">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="originalid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="entityfileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="assetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="oriassetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="oripartid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="partid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="fileformatdesc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                   &lt;element name="filebitrate" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="fileduration" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="fileformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="is3d" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                   &lt;element name="filehash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="videobitrate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="videoformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="videoinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="videointroduction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="videowidth" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="videoheight" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="videoscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="videolength" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="videosetcabac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="formatsetreframes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="framerate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="criterion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="vga" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="colorimetry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="scantype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="datadensity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="encodedlibrary" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="encodedlibset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="audioformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="audioinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="audiointrodution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="audioversion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="audiomuxingmode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="audioduration" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="audiotrack" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="audiosampling" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="audioratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="filesource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="isdrm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="encryptsolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="thirdfileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="overallbitratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "videos", propOrder = { "file" })
public class Videos {

    @XmlElement(required = true)
    protected List<VideoFile> file;

    /**
     * 获取file属性的值。
     * @return possible object is {@link UpdateFileAssetContent.Content.Videos.File }
     */
    public List<VideoFile> getFile() {
        if (this.file == null) {
            this.file = new ArrayList<>();
        }
        return this.file;
    }
}
