package com.miri.blephone.mediainjector.mgtv.api.file;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.miri.blephone.mediainjector.mgtv.jaxb.JaxbDateSerializer;

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
 *         &lt;element name="fileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="originalid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="entityfileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="assetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oriassetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oripartid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="partid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileformatdesc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="filebitrate" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="fileduration" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="fileformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="is3d" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="filehash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="videobitrate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="videoformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="videoinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="videointroduction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="videowidth" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="videoheight" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="videoscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="videolength" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="videosetcabac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formatsetreframes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="framerate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="criterion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vga" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="colorimetry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="scantype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datadensity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encodedlibrary" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encodedlibset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="audioformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="audioinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="audiointrodution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="audioversion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="audiomuxingmode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="audioduration" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="audiotrack" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="audiosampling" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="audioratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="filesource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isdrm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="encryptsolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="thirdfileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="overallbitratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "File", propOrder = { "fileid", "originalid", "entityfileid", "assetid", "oriassetid", "oripartid",
        "partid", "filename", "fileformatdesc", "filesize", "filebitrate", "fileduration", "fileformat", "is3D",
        "filehash", "videobitrate", "videoformat", "videoinfo", "videointroduction", "videowidth", "videoheight",
        "videoscale", "videolength", "videosetcabac", "formatsetreframes", "framerate", "criterion", "vga",
        "colorimetry", "scantype", "datadensity", "encodedlibrary", "encodedlibset", "audioformat", "audioinfo",
        "audiointrodution", "audioversion", "audiomuxingmode", "audioduration", "audiotrack", "audiosampling",
        "audioratemode", "filesource", "isdrm", "encryptsolution", "thirdfileid", "overallbitratemode", "createtime" })
public class VideoFile {

    @XmlElement(required = true)
    protected String  fileid;
    @XmlElement(required = true)
    protected String  originalid;
    @XmlElement(required = true)
    protected String  entityfileid;
    @XmlElement(required = true)
    protected String  assetid;
    @XmlElement(required = true)
    protected String  oriassetid;
    @XmlElement(required = true)
    protected String  oripartid;
    @XmlElement(required = true)
    protected String  partid;
    @XmlElement(required = true)
    protected String  filename;
    protected int     fileformatdesc;
    protected long    filesize;
    @XmlElement(required = true)
    protected Integer filebitrate;
    @XmlElement(required = true)
    protected Integer fileduration;
    @XmlElement(required = true)
    protected String  fileformat;
    @XmlElement(name = "is3d")
    protected short   is3D;
    @XmlElement(required = true)
    protected String  filehash;
    @XmlElement(required = true)
    protected String  videobitrate;
    @XmlElement(required = true)
    protected String  videoformat;
    @XmlElement(required = true)
    protected String  videoinfo;
    @XmlElement(required = true)
    protected String  videointroduction;
    @XmlElement(required = true)
    protected Integer videowidth;
    @XmlElement(required = true)
    protected Integer videoheight;
    @XmlElement(required = true)
    protected String  videoscale;
    @XmlElement(required = true)
    protected Integer videolength;
    @XmlElement(required = true)
    protected String  videosetcabac;
    @XmlElement(required = true)
    protected String  formatsetreframes;
    @XmlElement(required = true)
    protected String  framerate;
    @XmlElement(required = true)
    protected String  criterion;
    @XmlElement(required = true)
    protected String  vga;
    @XmlElement(required = true)
    protected String  colorimetry;
    @XmlElement(required = true)
    protected String  scantype;
    @XmlElement(required = true)
    protected String  datadensity;
    @XmlElement(required = true)
    protected String  encodedlibrary;
    @XmlElement(required = true)
    protected String  encodedlibset;
    @XmlElement(required = true)
    protected String  audioformat;
    @XmlElement(required = true)
    protected String  audioinfo;
    @XmlElement(required = true)
    protected String  audiointrodution;
    @XmlElement(required = true)
    protected String  audioversion;
    @XmlElement(required = true)
    protected String  audiomuxingmode;
    @XmlElement(required = true)
    protected Integer audioduration;
    @XmlElement(required = true)
    protected Integer audiotrack;
    @XmlElement(required = true)
    protected Integer audiosampling;
    @XmlElement(required = true)
    protected String  audioratemode;
    @XmlElement(required = true)
    protected String  filesource;
    @XmlElement(required = true)
    protected String  isdrm;
    @XmlElement(required = true)
    protected String  encryptsolution;
    @XmlElement(required = true)
    protected String  thirdfileid;
    @XmlElement(required = true)
    protected String  overallbitratemode;

    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    @XmlElement(required = true)
    protected Date    createtime;

    /**
     * 获取fileid属性的值。
     * @return possible object is {@link String }
     */
    public String getFileid() {
        return this.fileid;
    }

    /**
     * 设置fileid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setFileid(final String value) {
        this.fileid = value;
    }

    /**
     * 获取originalid属性的值。
     * @return possible object is {@link String }
     */
    public String getOriginalid() {
        return this.originalid;
    }

    /**
     * 设置originalid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setOriginalid(final String value) {
        this.originalid = value;
    }

    /**
     * 获取entityfileid属性的值。
     * @return possible object is {@link String }
     */
    public String getEntityfileid() {
        return this.entityfileid;
    }

    /**
     * 设置entityfileid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setEntityfileid(final String value) {
        this.entityfileid = value;
    }

    /**
     * 获取assetid属性的值。
     * @return possible object is {@link String }
     */
    public String getAssetid() {
        return this.assetid;
    }

    /**
     * 设置assetid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAssetid(final String value) {
        this.assetid = value;
    }

    /**
     * 获取oriassetid属性的值。
     * @return possible object is {@link String }
     */
    public String getOriassetid() {
        return this.oriassetid;
    }

    /**
     * 设置oriassetid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setOriassetid(final String value) {
        this.oriassetid = value;
    }

    /**
     * 获取oripartid属性的值。
     * @return possible object is {@link String }
     */
    public String getOripartid() {
        return this.oripartid;
    }

    /**
     * 设置oripartid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setOripartid(final String value) {
        this.oripartid = value;
    }

    /**
     * 获取partid属性的值。
     * @return possible object is {@link String }
     */
    public String getPartid() {
        return this.partid;
    }

    /**
     * 设置partid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setPartid(final String value) {
        this.partid = value;
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
     * 获取fileformatdesc属性的值。
     */
    public int getFileformatdesc() {
        return this.fileformatdesc;
    }

    /**
     * 设置fileformatdesc属性的值。
     */
    public void setFileformatdesc(final int value) {
        this.fileformatdesc = value;
    }

    /**
     * 获取filesize属性的值。
     */
    public long getFilesize() {
        return this.filesize;
    }

    /**
     * 设置filesize属性的值。
     */
    public void setFilesize(final long value) {
        this.filesize = value;
    }

    /**
     * 获取filebitrate属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getFilebitrate() {
        return this.filebitrate;
    }

    /**
     * 设置filebitrate属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setFilebitrate(final Integer value) {
        this.filebitrate = value;
    }

    /**
     * 获取fileduration属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getFileduration() {
        return this.fileduration;
    }

    /**
     * 设置fileduration属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setFileduration(final Integer value) {
        this.fileduration = value;
    }

    /**
     * 获取fileformat属性的值。
     * @return possible object is {@link String }
     */
    public String getFileformat() {
        return this.fileformat;
    }

    /**
     * 设置fileformat属性的值。
     * @param value allowed object is {@link String }
     */
    public void setFileformat(final String value) {
        this.fileformat = value;
    }

    /**
     * 获取is3D属性的值。
     */
    public short getIs3D() {
        return this.is3D;
    }

    /**
     * 设置is3D属性的值。
     */
    public void setIs3D(final short value) {
        this.is3D = value;
    }

    /**
     * 获取filehash属性的值。
     * @return possible object is {@link String }
     */
    public String getFilehash() {
        return this.filehash;
    }

    /**
     * 设置filehash属性的值。
     * @param value allowed object is {@link String }
     */
    public void setFilehash(final String value) {
        this.filehash = value;
    }

    /**
     * 获取videobitrate属性的值。
     * @return possible object is {@link String }
     */
    public String getVideobitrate() {
        return this.videobitrate;
    }

    /**
     * 设置videobitrate属性的值。
     * @param value allowed object is {@link String }
     */
    public void setVideobitrate(final String value) {
        this.videobitrate = value;
    }

    /**
     * 获取videoformat属性的值。
     * @return possible object is {@link String }
     */
    public String getVideoformat() {
        return this.videoformat;
    }

    /**
     * 设置videoformat属性的值。
     * @param value allowed object is {@link String }
     */
    public void setVideoformat(final String value) {
        this.videoformat = value;
    }

    /**
     * 获取videoinfo属性的值。
     * @return possible object is {@link String }
     */
    public String getVideoinfo() {
        return this.videoinfo;
    }

    /**
     * 设置videoinfo属性的值。
     * @param value allowed object is {@link String }
     */
    public void setVideoinfo(final String value) {
        this.videoinfo = value;
    }

    /**
     * 获取videointroduction属性的值。
     * @return possible object is {@link String }
     */
    public String getVideointroduction() {
        return this.videointroduction;
    }

    /**
     * 设置videointroduction属性的值。
     * @param value allowed object is {@link String }
     */
    public void setVideointroduction(final String value) {
        this.videointroduction = value;
    }

    /**
     * 获取videowidth属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getVideowidth() {
        return this.videowidth;
    }

    /**
     * 设置videowidth属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setVideowidth(final Integer value) {
        this.videowidth = value;
    }

    /**
     * 获取videoheight属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getVideoheight() {
        return this.videoheight;
    }

    /**
     * 设置videoheight属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setVideoheight(final Integer value) {
        this.videoheight = value;
    }

    /**
     * 获取videoscale属性的值。
     * @return possible object is {@link String }
     */
    public String getVideoscale() {
        return this.videoscale;
    }

    /**
     * 设置videoscale属性的值。
     * @param value allowed object is {@link String }
     */
    public void setVideoscale(final String value) {
        this.videoscale = value;
    }

    /**
     * 获取videolength属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getVideolength() {
        return this.videolength;
    }

    /**
     * 设置videolength属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setVideolength(final Integer value) {
        this.videolength = value;
    }

    /**
     * 获取videosetcabac属性的值。
     * @return possible object is {@link String }
     */
    public String getVideosetcabac() {
        return this.videosetcabac;
    }

    /**
     * 设置videosetcabac属性的值。
     * @param value allowed object is {@link String }
     */
    public void setVideosetcabac(final String value) {
        this.videosetcabac = value;
    }

    /**
     * 获取formatsetreframes属性的值。
     * @return possible object is {@link String }
     */
    public String getFormatsetreframes() {
        return this.formatsetreframes;
    }

    /**
     * 设置formatsetreframes属性的值。
     * @param value allowed object is {@link String }
     */
    public void setFormatsetreframes(final String value) {
        this.formatsetreframes = value;
    }

    /**
     * 获取framerate属性的值。
     * @return possible object is {@link String }
     */
    public String getFramerate() {
        return this.framerate;
    }

    /**
     * 设置framerate属性的值。
     * @param value allowed object is {@link String }
     */
    public void setFramerate(final String value) {
        this.framerate = value;
    }

    /**
     * 获取criterion属性的值。
     * @return possible object is {@link String }
     */
    public String getCriterion() {
        return this.criterion;
    }

    /**
     * 设置criterion属性的值。
     * @param value allowed object is {@link String }
     */
    public void setCriterion(final String value) {
        this.criterion = value;
    }

    /**
     * 获取vga属性的值。
     * @return possible object is {@link String }
     */
    public String getVga() {
        return this.vga;
    }

    /**
     * 设置vga属性的值。
     * @param value allowed object is {@link String }
     */
    public void setVga(final String value) {
        this.vga = value;
    }

    /**
     * 获取colorimetry属性的值。
     * @return possible object is {@link String }
     */
    public String getColorimetry() {
        return this.colorimetry;
    }

    /**
     * 设置colorimetry属性的值。
     * @param value allowed object is {@link String }
     */
    public void setColorimetry(final String value) {
        this.colorimetry = value;
    }

    /**
     * 获取scantype属性的值。
     * @return possible object is {@link String }
     */
    public String getScantype() {
        return this.scantype;
    }

    /**
     * 设置scantype属性的值。
     * @param value allowed object is {@link String }
     */
    public void setScantype(final String value) {
        this.scantype = value;
    }

    /**
     * 获取datadensity属性的值。
     * @return possible object is {@link String }
     */
    public String getDatadensity() {
        return this.datadensity;
    }

    /**
     * 设置datadensity属性的值。
     * @param value allowed object is {@link String }
     */
    public void setDatadensity(final String value) {
        this.datadensity = value;
    }

    /**
     * 获取encodedlibrary属性的值。
     * @return possible object is {@link String }
     */
    public String getEncodedlibrary() {
        return this.encodedlibrary;
    }

    /**
     * 设置encodedlibrary属性的值。
     * @param value allowed object is {@link String }
     */
    public void setEncodedlibrary(final String value) {
        this.encodedlibrary = value;
    }

    /**
     * 获取encodedlibset属性的值。
     * @return possible object is {@link String }
     */
    public String getEncodedlibset() {
        return this.encodedlibset;
    }

    /**
     * 设置encodedlibset属性的值。
     * @param value allowed object is {@link String }
     */
    public void setEncodedlibset(final String value) {
        this.encodedlibset = value;
    }

    /**
     * 获取audioformat属性的值。
     * @return possible object is {@link String }
     */
    public String getAudioformat() {
        return this.audioformat;
    }

    /**
     * 设置audioformat属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAudioformat(final String value) {
        this.audioformat = value;
    }

    /**
     * 获取audioinfo属性的值。
     * @return possible object is {@link String }
     */
    public String getAudioinfo() {
        return this.audioinfo;
    }

    /**
     * 设置audioinfo属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAudioinfo(final String value) {
        this.audioinfo = value;
    }

    /**
     * 获取audiointrodution属性的值。
     * @return possible object is {@link String }
     */
    public String getAudiointrodution() {
        return this.audiointrodution;
    }

    /**
     * 设置audiointrodution属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAudiointrodution(final String value) {
        this.audiointrodution = value;
    }

    /**
     * 获取audioversion属性的值。
     * @return possible object is {@link String }
     */
    public String getAudioversion() {
        return this.audioversion;
    }

    /**
     * 设置audioversion属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAudioversion(final String value) {
        this.audioversion = value;
    }

    /**
     * 获取audiomuxingmode属性的值。
     * @return possible object is {@link String }
     */
    public String getAudiomuxingmode() {
        return this.audiomuxingmode;
    }

    /**
     * 设置audiomuxingmode属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAudiomuxingmode(final String value) {
        this.audiomuxingmode = value;
    }

    /**
     * 获取audioduration属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getAudioduration() {
        return this.audioduration;
    }

    /**
     * 设置audioduration属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setAudioduration(final Integer value) {
        this.audioduration = value;
    }

    /**
     * 获取audiotrack属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getAudiotrack() {
        return this.audiotrack;
    }

    /**
     * 设置audiotrack属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setAudiotrack(final Integer value) {
        this.audiotrack = value;
    }

    /**
     * 获取audiosampling属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getAudiosampling() {
        return this.audiosampling;
    }

    /**
     * 设置audiosampling属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setAudiosampling(final Integer value) {
        this.audiosampling = value;
    }

    /**
     * 获取audioratemode属性的值。
     * @return possible object is {@link String }
     */
    public String getAudioratemode() {
        return this.audioratemode;
    }

    /**
     * 设置audioratemode属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAudioratemode(final String value) {
        this.audioratemode = value;
    }

    /**
     * 获取filesource属性的值。
     * @return possible object is {@link String }
     */
    public String getFilesource() {
        return this.filesource;
    }

    /**
     * 设置filesource属性的值。
     * @param value allowed object is {@link String }
     */
    public void setFilesource(final String value) {
        this.filesource = value;
    }

    /**
     * 获取isdrm属性的值。
     * @return possible object is {@link String }
     */
    public String getIsdrm() {
        return this.isdrm;
    }

    /**
     * 设置isdrm属性的值。
     * @param value allowed object is {@link String }
     */
    public void setIsdrm(final String value) {
        this.isdrm = value;
    }

    /**
     * 获取encryptsolution属性的值。
     * @return possible object is {@link String }
     */
    public String getEncryptsolution() {
        return this.encryptsolution;
    }

    /**
     * 设置encryptsolution属性的值。
     * @param value allowed object is {@link String }
     */
    public void setEncryptsolution(final String value) {
        this.encryptsolution = value;
    }

    /**
     * 获取thirdfileid属性的值。
     * @return possible object is {@link String }
     */
    public String getThirdfileid() {
        return this.thirdfileid;
    }

    /**
     * 设置thirdfileid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setThirdfileid(final String value) {
        this.thirdfileid = value;
    }

    /**
     * 获取overallbitratemode属性的值。
     * @return possible object is {@link String }
     */
    public String getOverallbitratemode() {
        return this.overallbitratemode;
    }

    /**
     * 设置overallbitratemode属性的值。
     * @param value allowed object is {@link String }
     */
    public void setOverallbitratemode(final String value) {
        this.overallbitratemode = value;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
