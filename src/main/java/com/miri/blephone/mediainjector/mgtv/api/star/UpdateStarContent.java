package com.miri.blephone.mediainjector.mgtv.api.star;

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
 *         &lt;element name="starid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="homeplace" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="college" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="constellathion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="blood" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="intro" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="initial" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="photourl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imghash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullspell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="simplespell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="occupation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "content", propOrder = { "starid", "name", "ename", "sex", "birthday", "homeplace", "college", "nation",
        "constellathion", "blood", "height", "weight", "intro", "initial", "photourl", "imghash", "fullspell",
        "simplespell", "occupation" })
public class UpdateStarContent {

    @XmlElement(required = true)
    protected String starid;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String ename;
    @XmlElement(required = true)
    protected String sex;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    protected Date   birthday;
    @XmlElement(required = true)
    protected String homeplace;
    @XmlElement(required = true)
    protected String college;
    @XmlElement(required = true)
    protected String nation;
    @XmlElement(required = true)
    protected String constellathion;
    @XmlElement(required = true)
    protected String blood;
    protected double height;
    protected double weight;
    @XmlElement(required = true)
    protected String intro;
    @XmlElement(required = true)
    protected String initial;
    @XmlElement(required = true)
    protected String photourl;
    @XmlElement(required = true)
    protected String imghash;
    @XmlElement(required = true)
    protected String fullspell;
    @XmlElement(required = true)
    protected String simplespell;
    @XmlElement(required = true)
    protected String occupation;

    /**
     * 获取starid属性的值。
     * @return possible object is {@link String }
     */
    public String getStarid() {
        return this.starid;
    }

    /**
     * 设置starid属性的值。
     * @param value allowed object is {@link String }
     */
    public void setStarid(final String value) {
        this.starid = value;
    }

    /**
     * 获取name属性的值。
     * @return possible object is {@link String }
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置name属性的值。
     * @param value allowed object is {@link String }
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * 获取ename属性的值。
     * @return possible object is {@link String }
     */
    public String getEname() {
        return this.ename;
    }

    /**
     * 设置ename属性的值。
     * @param value allowed object is {@link String }
     */
    public void setEname(final String value) {
        this.ename = value;
    }

    /**
     * 获取sex属性的值。
     * @return possible object is {@link String }
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * 设置sex属性的值。
     * @param value allowed object is {@link String }
     */
    public void setSex(final String value) {
        this.sex = value;
    }

    /**
     * 获取birthday属性的值。
     * @return possible object is {@link Date }
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * 设置birthday属性的值。
     * @param value allowed object is {@link Date }
     */
    public void setBirthday(final Date value) {
        this.birthday = value;
    }

    /**
     * 获取homeplace属性的值。
     * @return possible object is {@link String }
     */
    public String getHomeplace() {
        return this.homeplace;
    }

    /**
     * 设置homeplace属性的值。
     * @param value allowed object is {@link String }
     */
    public void setHomeplace(final String value) {
        this.homeplace = value;
    }

    /**
     * 获取college属性的值。
     * @return possible object is {@link String }
     */
    public String getCollege() {
        return this.college;
    }

    /**
     * 设置college属性的值。
     * @param value allowed object is {@link String }
     */
    public void setCollege(final String value) {
        this.college = value;
    }

    /**
     * 获取nation属性的值。
     * @return possible object is {@link String }
     */
    public String getNation() {
        return this.nation;
    }

    /**
     * 设置nation属性的值。
     * @param value allowed object is {@link String }
     */
    public void setNation(final String value) {
        this.nation = value;
    }

    /**
     * 获取constellathion属性的值。
     * @return possible object is {@link String }
     */
    public String getConstellathion() {
        return this.constellathion;
    }

    /**
     * 设置constellathion属性的值。
     * @param value allowed object is {@link String }
     */
    public void setConstellathion(final String value) {
        this.constellathion = value;
    }

    /**
     * 获取blood属性的值。
     * @return possible object is {@link String }
     */
    public String getBlood() {
        return this.blood;
    }

    /**
     * 设置blood属性的值。
     * @param value allowed object is {@link String }
     */
    public void setBlood(final String value) {
        this.blood = value;
    }

    /**
     * 获取height属性的值。
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * 设置height属性的值。
     */
    public void setHeight(final double value) {
        this.height = value;
    }

    /**
     * 获取weight属性的值。
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * 设置weight属性的值。
     */
    public void setWeight(final double value) {
        this.weight = value;
    }

    /**
     * 获取intro属性的值。
     * @return possible object is {@link String }
     */
    public String getIntro() {
        return this.intro;
    }

    /**
     * 设置intro属性的值。
     * @param value allowed object is {@link String }
     */
    public void setIntro(final String value) {
        this.intro = value;
    }

    /**
     * 获取initial属性的值。
     * @return possible object is {@link String }
     */
    public String getInitial() {
        return this.initial;
    }

    /**
     * 设置initial属性的值。
     * @param value allowed object is {@link String }
     */
    public void setInitial(final String value) {
        this.initial = value;
    }

    /**
     * 获取photourl属性的值。
     * @return possible object is {@link String }
     */
    public String getPhotourl() {
        return this.photourl;
    }

    /**
     * 设置photourl属性的值。
     * @param value allowed object is {@link String }
     */
    public void setPhotourl(final String value) {
        this.photourl = value;
    }

    /**
     * 获取imghash属性的值。
     * @return possible object is {@link String }
     */
    public String getImghash() {
        return this.imghash;
    }

    /**
     * 设置imghash属性的值。
     * @param value allowed object is {@link String }
     */
    public void setImghash(final String value) {
        this.imghash = value;
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
     * 获取occupation属性的值。
     * @return possible object is {@link String }
     */
    public String getOccupation() {
        return this.occupation;
    }

    /**
     * 设置occupation属性的值。
     * @param value allowed object is {@link String }
     */
    public void setOccupation(final String value) {
        this.occupation = value;
    }

}
