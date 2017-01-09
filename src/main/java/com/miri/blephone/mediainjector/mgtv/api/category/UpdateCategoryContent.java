package com.miri.blephone.mediainjector.mgtv.api.category;

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
 *         &lt;element name="originalid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="baseId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="assetpath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fstlvlid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="extag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clipname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="othernme" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="updatetime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="createtime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="relasetime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="playtime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inital" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullspell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="simplespell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serialcount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="producername" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="channel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="countrycode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="canDown" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="filmorsingleset" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="periods" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *                             &lt;element name="imageid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="resolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="imgtype" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                             &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "content", propOrder = { "assetid", "originalid", "baseId", "assetpath", "fstname", "fstlvlid", "extag",
        "clipname", "othernme", "keyword", "director", "adaptor", "leader", "kind", "area", "language", "caption",
        "tags", "story", "awards", "year", "duration", "updatetime", "createtime", "relasetime", "playtime", "inital",
        "fullspell", "simplespell", "serialcount", "productid", "producername", "channel", "countrycode", "canDown",
        "filmorsingleset", "periods", "images" })
public class UpdateCategoryContent {

    @XmlElement(required = true, nillable = false)
    protected String  assetid;

    @XmlElement(required = true, nillable = false)
    protected String  originalid;

    @XmlElement(required = false)
    protected String  baseId;
    @XmlElement(required = false)
    protected String  assetpath;

    @XmlElement(required = true, nillable = false)
    protected String  fstname;

    @XmlElement(required = true, nillable = false)
    protected int     fstlvlid;
    @XmlElement(required = false)
    protected String  extag;

    @XmlElement(required = true, nillable = false)
    protected String  clipname;
    @XmlElement(required = false)
    protected String  othernme;

    @XmlElement(required = true, nillable = false)
    protected String  keyword;

    @XmlElement(required = true, nillable = false)
    protected String  director;
    @XmlElement(required = false)
    protected String  adaptor;

    @XmlElement(required = true, nillable = false)
    protected String  leader;

    @XmlElement(required = true, nillable = false)
    protected String  kind;

    @XmlElement(required = true, nillable = false)
    protected String  area;
    @XmlElement(required = false)
    protected String  language;
    @XmlElement(required = false)
    protected String  caption;
    @XmlElement(required = false)
    protected String  tags;

    @XmlElement(required = true, nillable = false)
    protected String  story;
    @XmlElement(required = false)
    protected String  awards;
    protected int     year;

    @XmlElement(required = true, nillable = false)
    protected int     duration;

    @XmlElement(required = false)
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    protected Date    updatetime;

    @XmlElement(required = false)
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    protected Date    createtime;

    @XmlElement(required = true, nillable = false)
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    protected Date    relasetime;

    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    @XmlElement(required = true)
    protected Date    playtime;

    @XmlElement(required = false)
    protected String  inital;
    @XmlElement(required = false)
    protected String  fullspell;
    @XmlElement(required = false)
    protected String  simplespell;

    @XmlElement(required = true, nillable = false)
    protected int     serialcount;

    protected Integer productid;

    @XmlElement(required = true, nillable = false)
    protected String  producername;
    @XmlElement(required = true)
    protected String  channel;
    @XmlElement(required = true)
    protected String  countrycode;
    protected int     canDown;
    protected int     filmorsingleset;

    @XmlElement(required = true)
    protected String  periods;

    @XmlElement(required = true, nillable = false)
    protected Images  images;

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
     * 获取baseId属性的值。
     * @return possible object is {@link String }
     */
    public String getBaseId() {
        return this.baseId;
    }

    /**
     * 设置baseId属性的值。
     * @param value allowed object is {@link String }
     */
    public void setBaseId(final String value) {
        this.baseId = value;
    }

    /**
     * 获取assetpath属性的值。
     * @return possible object is {@link String }
     */
    public String getAssetpath() {
        return this.assetpath;
    }

    /**
     * 设置assetpath属性的值。
     * @param value allowed object is {@link String }
     */
    public void setAssetpath(final String value) {
        this.assetpath = value;
    }

    /**
     * 获取fstname属性的值。
     * @return possible object is {@link String }
     */
    public String getFstname() {
        return this.fstname;
    }

    /**
     * 设置fstname属性的值。
     * @param value allowed object is {@link String }
     */
    public void setFstname(final String value) {
        this.fstname = value;
    }

    /**
     * 获取fstlvlid属性的值。
     */
    public int getFstlvlid() {
        return this.fstlvlid;
    }

    /**
     * 设置fstlvlid属性的值。
     */
    public void setFstlvlid(final int value) {
        this.fstlvlid = value;
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
     * 获取clipname属性的值。
     * @return possible object is {@link String }
     */
    public String getClipname() {
        return this.clipname;
    }

    /**
     * 设置clipname属性的值。
     * @param value allowed object is {@link String }
     */
    public void setClipname(final String value) {
        this.clipname = value;
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
     */
    public int getYear() {
        return this.year;
    }

    /**
     * 设置year属性的值。
     */
    public void setYear(final int value) {
        this.year = value;
    }

    /**
     * 获取duration属性的值。
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * 设置duration属性的值。
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
     * 获取playtime属性的值。
     * @return possible object is {@link Date }
     */
    public Date getPlaytime() {
        return this.playtime;
    }

    /**
     * 设置playtime属性的值。
     * @param value allowed object is {@link Date }
     */
    public void setPlaytime(final Date value) {
        this.playtime = value;
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
     * 获取fullspell属性的值。
     * @return possible object is {@link String }
     */
    public String getFullspell() {
        return this.fullspell;
    }

    /**
     * 设置fullspell属性的值。
     * @param value allowed object is {@link String }
     */
    public void setFullspell(final String value) {
        this.fullspell = value;
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
     * 获取serialcount属性的值。
     */
    public int getSerialcount() {
        return this.serialcount;
    }

    /**
     * 设置serialcount属性的值。
     */
    public void setSerialcount(final int value) {
        this.serialcount = value;
    }

    /**
     * 获取productid属性的值。
     */
    public Integer getProductid() {
        return this.productid;
    }

    /**
     * 设置productid属性的值。
     */
    public void setProductid(final Integer value) {
        this.productid = value;
    }

    /**
     * 获取producername属性的值。
     * @return possible object is {@link String }
     */
    public String getProducername() {
        return this.producername;
    }

    /**
     * 设置producername属性的值。
     * @param value allowed object is {@link String }
     */
    public void setProducername(final String value) {
        this.producername = value;
    }

    /**
     * 获取channel属性的值。
     * @return possible object is {@link String }
     */
    public String getChannel() {
        return this.channel;
    }

    /**
     * 设置channel属性的值。
     * @param value allowed object is {@link String }
     */
    public void setChannel(final String value) {
        this.channel = value;
    }

    /**
     * 获取countrycode属性的值。
     * @return possible object is {@link String }
     */
    public String getCountrycode() {
        return this.countrycode;
    }

    /**
     * 设置countrycode属性的值。
     * @param value allowed object is {@link String }
     */
    public void setCountrycode(final String value) {
        this.countrycode = value;
    }

    /**
     * 获取canDown属性的值。
     */
    public int getCanDown() {
        return this.canDown;
    }

    /**
     * 设置canDown属性的值。
     */
    public void setCanDown(final int value) {
        this.canDown = value;
    }

    /**
     * 获取filmorsingleset属性的值。
     */
    public int getFilmorsingleset() {
        return this.filmorsingleset;
    }

    /**
     * 设置filmorsingleset属性的值。
     */
    public void setFilmorsingleset(final int value) {
        this.filmorsingleset = value;
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
     * 获取images属性的值。
     * @return possible object is {@link Images }
     */
    public Images getImages() {
        return this.images;
    }

    /**
     * 设置images属性的值。
     * @param value allowed object is {@link Images }
     */
    public void setImages(final Images value) {
        this.images = value;
    }

}
