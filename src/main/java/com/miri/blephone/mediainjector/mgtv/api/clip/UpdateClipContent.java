package com.miri.blephone.mediainjector.mgtv.api.clip;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.miri.blephone.mediainjector.mgtv.api.Images;
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
 *         &lt;element name="assetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="oriassetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="partid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="originalid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="partname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="othernme" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="extag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="eventtag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adaptor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="leader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="kind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="caption" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tags" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="story" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="awards" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="updatetime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="createtime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="relasetime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inital" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="simplespell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isintact" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="serialno" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="publisher" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="periods" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="seekpoints">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="begin" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="img" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="imghash" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="images">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="image" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="imageid" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                             &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="resolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="imgtype" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="imghash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
@XmlType(name = "content", propOrder = { "assetid", "oriassetid", "partid", "originalid", "partname", "othernme",
        "extag", "eventtag", "keyword", "director", "adaptor", "leader", "kind", "area", "language", "caption", "tags",
        "story", "awards", "year", "duration", "updatetime", "createtime", "relasetime", "inital", "simplespell",
        "isintact", "serialno", "publisher", "periods", "seekpoints", "images" })
public class UpdateClipContent {

    @XmlElement(required = true, nillable = false)
    protected String     assetid;

    @XmlElement(required = true, nillable = false)
    protected String     oriassetid;

    @XmlElement(required = true, nillable = false)
    protected String     partid;

    @XmlElement(required = true, nillable = false)
    protected String     originalid;

    @XmlElement(required = true, nillable = false)
    protected String     partname;
    @XmlElement(required = false)
    protected String     othernme;
    @XmlElement(required = false)
    protected String     extag;
    @XmlElement(required = false)
    protected String     eventtag;
    @XmlElement(required = false)
    protected String     keyword;
    @XmlElement(required = false)
    protected String     director;
    @XmlElement(required = false)
    protected String     adaptor;
    @XmlElement(required = false)
    protected String     leader;
    @XmlElement(required = false)
    protected String     kind;
    @XmlElement(required = false)
    protected String     area;
    @XmlElement(required = false)
    protected String     language;
    @XmlElement(required = false)
    protected String     caption;
    @XmlElement(required = false)
    protected String     tags;
    @XmlElement(required = false)
    protected String     story;
    @XmlElement(required = false)
    protected String     awards;
    @XmlElement(required = false)
    protected Integer    year;
    @XmlElement(required = true, nillable = false)
    protected int        duration;

    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    @XmlElement(required = false)
    protected Date       updatetime;

    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    @XmlElement(required = false)
    protected Date       createtime;

    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    @XmlElement(required = false)
    protected Date       relasetime;

    @XmlElement(required = false)
    protected String     inital;
    @XmlElement(required = false)
    protected String     simplespell;
    @XmlElement(required = true)
    protected int        isintact;
    @XmlElement(required = false)
    protected int        serialno;
    @XmlElement(required = false)
    protected String     publisher;
    @XmlElement(required = false)
    protected String     periods;
    @XmlElement(required = true)
    protected Seekpoints seekpoints;
    @XmlElement(required = true)
    protected Images     images;

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
     * 获取partname属性的值。
     * @return possible object is {@link String }
     */
    public String getPartname() {
        return this.partname;
    }

    /**
     * 设置partname属性的值。
     * @param value allowed object is {@link String }
     */
    public void setPartname(final String value) {
        this.partname = value;
    }

    /**
     * 获取othernme属性的值。
     * @return possible object is {@link String }
     */
    public String getOthernme() {
        return this.othernme;
    }

    /**
     * 设置othernme属性的值。
     * @param value allowed object is {@link String }
     */
    public void setOthernme(final String value) {
        this.othernme = value;
    }

    /**
     * 获取extag属性的值。
     * @return possible object is {@link String }
     */
    public String getExtag() {
        return this.extag;
    }

    /**
     * 设置extag属性的值。
     * @param value allowed object is {@link String }
     */
    public void setExtag(final String value) {
        this.extag = value;
    }

    /**
     * 获取eventtag属性的值。
     * @return possible object is {@link String }
     */
    public String getEventtag() {
        return this.eventtag;
    }

    /**
     * 设置eventtag属性的值。
     * @param value allowed object is {@link String }
     */
    public void setEventtag(final String value) {
        this.eventtag = value;
    }

    /**
     * 获取keyword属性的值。
     * @return possible object is {@link String }
     */
    public String getKeyword() {
        return this.keyword;
    }

    /**
     * 设置keyword属性的值。
     * @param value allowed object is {@link String }
     */
    public void setKeyword(final String value) {
        this.keyword = value;
    }

    /**
     * 获取director属性的值。
     * @return possible object is {@link String }
     */
    public String getDirector() {
        return this.director;
    }

    /**
     * 设置director属性的值。
     * @param value allowed object is {@link String }
     */
    public void setDirector(final String value) {
        this.director = value;
    }

    /**
     * 获取adaptor属性的值。
     * @return possible object is {@link String }
     */
    public String getAdaptor() {
        return this.adaptor;
    }

    /**
     * 设置adaptor属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAdaptor(final String value) {
        this.adaptor = value;
    }

    /**
     * 获取leader属性的值。
     * @return possible object is {@link String }
     */
    public String getLeader() {
        return this.leader;
    }

    /**
     * 设置leader属性的值。
     * @param value allowed object is {@link String }
     */
    public void setLeader(final String value) {
        this.leader = value;
    }

    /**
     * 获取kind属性的值。
     * @return possible object is {@link String }
     */
    public String getKind() {
        return this.kind;
    }

    /**
     * 设置kind属性的值。
     * @param value allowed object is {@link String }
     */
    public void setKind(final String value) {
        this.kind = value;
    }

    /**
     * 获取area属性的值。
     * @return possible object is {@link String }
     */
    public String getArea() {
        return this.area;
    }

    /**
     * 设置area属性的值。
     * @param value allowed object is {@link String }
     */
    public void setArea(final String value) {
        this.area = value;
    }

    /**
     * 获取language属性的值。
     * @return possible object is {@link String }
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * 设置language属性的值。
     * @param value allowed object is {@link String }
     */
    public void setLanguage(final String value) {
        this.language = value;
    }

    /**
     * 获取caption属性的值。
     * @return possible object is {@link String }
     */
    public String getCaption() {
        return this.caption;
    }

    /**
     * 设置caption属性的值。
     * @param value allowed object is {@link String }
     */
    public void setCaption(final String value) {
        this.caption = value;
    }

    /**
     * 获取tags属性的值。
     * @return possible object is {@link String }
     */
    public String getTags() {
        return this.tags;
    }

    /**
     * 设置tags属性的值。
     * @param value allowed object is {@link String }
     */
    public void setTags(final String value) {
        this.tags = value;
    }

    /**
     * 获取story属性的值。
     * @return possible object is {@link String }
     */
    public String getStory() {
        return this.story;
    }

    /**
     * 设置story属性的值。
     * @param value allowed object is {@link String }
     */
    public void setStory(final String value) {
        this.story = value;
    }

    /**
     * 获取awards属性的值。
     * @return possible object is {@link String }
     */
    public String getAwards() {
        return this.awards;
    }

    /**
     * 设置awards属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAwards(final String value) {
        this.awards = value;
    }

    /**
     * 获取year属性的值。
     * @return possible object is {@link Integer }
     */
    public Integer getYear() {
        return this.year;
    }

    /**
     * 设置year属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setYear(final Integer value) {
        this.year = value;
    }

    /**
     * 获取duration属性的值。
     * @return possible object is {@link int }
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * 设置duration属性的值。
     * @param value allowed object is {@link int }
     */
    public void setDuration(final int value) {
        this.duration = value;
    }

    /**
     * 获取updatetime属性的值。
     * @return possible object is {@link Date }
     */
    public Date getUpdatetime() {
        return this.updatetime;
    }

    /**
     * 设置updatetime属性的值。
     * @param value allowed object is {@link Date }
     */
    public void setUpdatetime(final Date value) {
        this.updatetime = value;
    }

    /**
     * 获取createtime属性的值。
     * @return possible object is {@link Date }
     */
    public Date getCreatetime() {
        return this.createtime;
    }

    /**
     * 设置createtime属性的值。
     * @param value allowed object is {@link Date }
     */
    public void setCreatetime(final Date value) {
        this.createtime = value;
    }

    /**
     * 获取relasetime属性的值。
     * @return possible object is {@link Date }
     */
    public Date getRelasetime() {
        return this.relasetime;
    }

    /**
     * 设置relasetime属性的值。
     * @param value allowed object is {@link Date }
     */
    public void setRelasetime(final Date value) {
        this.relasetime = value;
    }

    /**
     * 获取inital属性的值。
     * @return possible object is {@link String }
     */
    public String getInital() {
        return this.inital;
    }

    /**
     * 设置inital属性的值。
     * @param value allowed object is {@link String }
     */
    public void setInital(final String value) {
        this.inital = value;
    }

    /**
     * 获取simplespell属性的值。
     * @return possible object is {@link String }
     */
    public String getSimplespell() {
        return this.simplespell;
    }

    /**
     * 设置simplespell属性的值。
     * @param value allowed object is {@link String }
     */
    public void setSimplespell(final String value) {
        this.simplespell = value;
    }

    /**
     * 获取isintact属性的值。
     * @return possible object is {@link int }
     */
    public int getIsintact() {
        return this.isintact;
    }

    /**
     * 设置isintact属性的值。
     * @param value allowed object is {@link int }
     */
    public void setIsintact(final int value) {
        this.isintact = value;
    }

    /**
     * 获取serialno属性的值。
     * @return possible object is {@link int }
     */
    public int getSerialno() {
        return this.serialno;
    }

    /**
     * 设置serialno属性的值。
     * @param value allowed object is {@link Integer }
     */
    public void setSerialno(final Integer value) {
        this.serialno = value;
    }

    /**
     * 获取publisher属性的值。
     * @return possible object is {@link String }
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * 设置publisher属性的值。
     * @param value allowed object is {@link String }
     */
    public void setPublisher(final String value) {
        this.publisher = value;
    }

    /**
     * 获取periods属性的值。
     * @return possible object is {@link String }
     */
    public String getPeriods() {
        return this.periods;
    }

    /**
     * 设置periods属性的值。
     * @param value allowed object is {@link String }
     */
    public void setPeriods(final String value) {
        this.periods = value;
    }

    /**
     * 获取seekpoints属性的值。
     * @return possible object is {@link Seekpoints }
     */
    public Seekpoints getSeekpoints() {
        return this.seekpoints;
    }

    /**
     * 设置seekpoints属性的值。
     * @param value allowed object is {@link Seekpoints }
     */
    public void setSeekpoints(final Seekpoints value) {
        this.seekpoints = value;
    }

    /**
     * 获取images属性的值。
     * @return possible object is {@link UpdateClipAssetContent.Content.Images }
     */
    public Images getImages() {
        return this.images;
    }

    /**
     * 设置images属性的值。
     * @param value allowed object is {@link UpdateClipAssetContent.Content.Images }
     */
    public void setImages(final Images value) {
        this.images = value;
    }

}
