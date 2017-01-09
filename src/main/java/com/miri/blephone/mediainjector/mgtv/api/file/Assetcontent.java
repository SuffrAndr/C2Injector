//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2016.05.27 时间 09:44:57 AM CST 
//


package com.miri.blephone.mediainjector.mgtv.api.file;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assettype" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="assetdesc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="assetoperation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="content">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="videos">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="file" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="fileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="originalid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="entityfileid" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                                       &lt;element name="assetid" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                                       &lt;element name="oriassetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="oripartid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="partid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="fileformatdesc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                                       &lt;element name="filebitrate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="fileduration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="fileformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="is3d" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="filehash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="videobitrate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="videoformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="videoinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="videointroduction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="videowidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="videoheight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="videoscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="videolength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="videosetcabac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="formatsetreframes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="framerate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="criterion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="vga" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="colorimetry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="scantype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="datadensity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="encodedlibrary" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="encodedlibset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="audioformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="audioinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="audiointrodution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="audioversion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="audiomuxingmode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="audioduration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="audiotrack" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="audiosampling" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="audioratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="filesource" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="isdrm" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="encryptsolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="thirdfileid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="overallbitratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
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
 *         &lt;element name="info">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pushcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="queuename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="contentprovider" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "assettype",
    "assetdesc",
    "assetoperation",
    "content",
    "info"
})
@XmlRootElement(name = "assetcontent")
public class Assetcontent {

    protected int assettype;
    protected int assetdesc;
    protected int assetoperation;
    @XmlElement(required = true)
    protected Assetcontent.Content content;
    @XmlElement(required = true)
    protected Assetcontent.Info info;

    /**
     * 获取assettype属性的值。
     * 
     */
    public int getAssettype() {
        return assettype;
    }

    /**
     * 设置assettype属性的值。
     * 
     */
    public void setAssettype(int value) {
        this.assettype = value;
    }

    /**
     * 获取assetdesc属性的值。
     * 
     */
    public int getAssetdesc() {
        return assetdesc;
    }

    /**
     * 设置assetdesc属性的值。
     * 
     */
    public void setAssetdesc(int value) {
        this.assetdesc = value;
    }

    /**
     * 获取assetoperation属性的值。
     * 
     */
    public int getAssetoperation() {
        return assetoperation;
    }

    /**
     * 设置assetoperation属性的值。
     * 
     */
    public void setAssetoperation(int value) {
        this.assetoperation = value;
    }

    /**
     * 获取content属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Assetcontent.Content }
     *     
     */
    public Assetcontent.Content getContent() {
        return content;
    }

    /**
     * 设置content属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Assetcontent.Content }
     *     
     */
    public void setContent(Assetcontent.Content value) {
        this.content = value;
    }

    /**
     * 获取info属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Assetcontent.Info }
     *     
     */
    public Assetcontent.Info getInfo() {
        return info;
    }

    /**
     * 设置info属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Assetcontent.Info }
     *     
     */
    public void setInfo(Assetcontent.Info value) {
        this.info = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="videos">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="file" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="fileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="originalid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="entityfileid" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                             &lt;element name="assetid" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                             &lt;element name="oriassetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="oripartid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="partid" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="fileformatdesc" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *                             &lt;element name="filebitrate" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="fileduration" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="fileformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="is3d" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="filehash" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="videobitrate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="videoformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="videoinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="videointroduction" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="videowidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="videoheight" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="videoscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="videolength" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="videosetcabac" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="formatsetreframes" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="framerate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="criterion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="vga" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="colorimetry" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="scantype" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="datadensity" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="encodedlibrary" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="encodedlibset" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="audioformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="audioinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="audiointrodution" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="audioversion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="audiomuxingmode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="audioduration" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="audiotrack" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="audiosampling" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="audioratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="filesource" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="isdrm" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="encryptsolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="thirdfileid" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="overallbitratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "videos"
    })
    public static class Content {

        @XmlElement(required = true)
        protected Assetcontent.Content.Videos videos;

        /**
         * 获取videos属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Assetcontent.Content.Videos }
         *     
         */
        public Assetcontent.Content.Videos getVideos() {
            return videos;
        }

        /**
         * 设置videos属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Assetcontent.Content.Videos }
         *     
         */
        public void setVideos(Assetcontent.Content.Videos value) {
            this.videos = value;
        }


        /**
         * <p>anonymous complex type的 Java 类。
         * 
         * <p>以下模式片段指定包含在此类中的预期内容。
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="file" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="fileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="originalid" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="entityfileid" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *                   &lt;element name="assetid" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *                   &lt;element name="oriassetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="oripartid" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="partid" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="fileformatdesc" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}short"/>
         *                   &lt;element name="filebitrate" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="fileduration" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="fileformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="is3d" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="filehash" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="videobitrate" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="videoformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="videoinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="videointroduction" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="videowidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="videoheight" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="videoscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="videolength" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
         *                   &lt;element name="audioduration" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="audiotrack" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="audiosampling" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="audioratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="filesource" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="isdrm" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="encryptsolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="thirdfileid" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "file"
        })
        public static class Videos {

            protected List<Assetcontent.Content.Videos.File> file;

            /**
             * Gets the value of the file property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the file property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFile().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Assetcontent.Content.Videos.File }
             * 
             * 
             */
            public List<Assetcontent.Content.Videos.File> getFile() {
                if (file == null) {
                    file = new ArrayList<Assetcontent.Content.Videos.File>();
                }
                return this.file;
            }


            /**
             * <p>anonymous complex type的 Java 类。
             * 
             * <p>以下模式片段指定包含在此类中的预期内容。
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="fileid" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="originalid" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="entityfileid" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="assetid" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="oriassetid" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="oripartid" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="partid" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="fileformatdesc" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="filesize" type="{http://www.w3.org/2001/XMLSchema}short"/>
             *         &lt;element name="filebitrate" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="fileduration" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="fileformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="is3d" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="filehash" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="videobitrate" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="videoformat" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="videoinfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="videointroduction" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="videowidth" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="videoheight" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="videoscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="videolength" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
             *         &lt;element name="audioduration" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="audiotrack" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="audiosampling" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="audioratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="filesource" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="isdrm" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="encryptsolution" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="thirdfileid" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="overallbitratemode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "fileid",
                "originalid",
                "entityfileid",
                "assetid",
                "oriassetid",
                "oripartid",
                "partid",
                "filename",
                "fileformatdesc",
                "filesize",
                "filebitrate",
                "fileduration",
                "fileformat",
                "is3D",
                "filehash",
                "videobitrate",
                "videoformat",
                "videoinfo",
                "videointroduction",
                "videowidth",
                "videoheight",
                "videoscale",
                "videolength",
                "videosetcabac",
                "formatsetreframes",
                "framerate",
                "criterion",
                "vga",
                "colorimetry",
                "scantype",
                "datadensity",
                "encodedlibrary",
                "encodedlibset",
                "audioformat",
                "audioinfo",
                "audiointrodution",
                "audioversion",
                "audiomuxingmode",
                "audioduration",
                "audiotrack",
                "audiosampling",
                "audioratemode",
                "filesource",
                "isdrm",
                "encryptsolution",
                "thirdfileid",
                "overallbitratemode"
            })
            public static class File {

                @XmlElement(required = true)
                protected String fileid;
                @XmlElement(required = true)
                protected String originalid;
                protected short entityfileid;
                protected short assetid;
                @XmlElement(required = true)
                protected String oriassetid;
                @XmlElement(required = true)
                protected String oripartid;
                protected int partid;
                @XmlElement(required = true)
                protected String filename;
                protected int fileformatdesc;
                protected short filesize;
                protected int filebitrate;
                protected int fileduration;
                @XmlElement(required = true)
                protected String fileformat;
                @XmlElement(name = "is3d")
                protected int is3D;
                @XmlElement(required = true)
                protected String filehash;
                @XmlElement(required = true)
                protected String videobitrate;
                @XmlElement(required = true)
                protected String videoformat;
                @XmlElement(required = true)
                protected String videoinfo;
                @XmlElement(required = true)
                protected String videointroduction;
                protected int videowidth;
                protected int videoheight;
                @XmlElement(required = true)
                protected String videoscale;
                protected int videolength;
                @XmlElement(required = true)
                protected String videosetcabac;
                @XmlElement(required = true)
                protected String formatsetreframes;
                @XmlElement(required = true)
                protected String framerate;
                @XmlElement(required = true)
                protected String criterion;
                @XmlElement(required = true)
                protected String vga;
                @XmlElement(required = true)
                protected String colorimetry;
                @XmlElement(required = true)
                protected String scantype;
                @XmlElement(required = true)
                protected String datadensity;
                @XmlElement(required = true)
                protected String encodedlibrary;
                @XmlElement(required = true)
                protected String encodedlibset;
                @XmlElement(required = true)
                protected String audioformat;
                @XmlElement(required = true)
                protected String audioinfo;
                @XmlElement(required = true)
                protected String audiointrodution;
                @XmlElement(required = true)
                protected String audioversion;
                @XmlElement(required = true)
                protected String audiomuxingmode;
                protected int audioduration;
                protected int audiotrack;
                protected int audiosampling;
                @XmlElement(required = true)
                protected String audioratemode;
                @XmlElement(required = true)
                protected String filesource;
                protected int isdrm;
                @XmlElement(required = true)
                protected String encryptsolution;
                protected int thirdfileid;
                @XmlElement(required = true)
                protected String overallbitratemode;

                /**
                 * 获取fileid属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFileid() {
                    return fileid;
                }

                /**
                 * 设置fileid属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFileid(String value) {
                    this.fileid = value;
                }

                /**
                 * 获取originalid属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOriginalid() {
                    return originalid;
                }

                /**
                 * 设置originalid属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOriginalid(String value) {
                    this.originalid = value;
                }

                /**
                 * 获取entityfileid属性的值。
                 * 
                 */
                public short getEntityfileid() {
                    return entityfileid;
                }

                /**
                 * 设置entityfileid属性的值。
                 * 
                 */
                public void setEntityfileid(short value) {
                    this.entityfileid = value;
                }

                /**
                 * 获取assetid属性的值。
                 * 
                 */
                public short getAssetid() {
                    return assetid;
                }

                /**
                 * 设置assetid属性的值。
                 * 
                 */
                public void setAssetid(short value) {
                    this.assetid = value;
                }

                /**
                 * 获取oriassetid属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOriassetid() {
                    return oriassetid;
                }

                /**
                 * 设置oriassetid属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOriassetid(String value) {
                    this.oriassetid = value;
                }

                /**
                 * 获取oripartid属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOripartid() {
                    return oripartid;
                }

                /**
                 * 设置oripartid属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOripartid(String value) {
                    this.oripartid = value;
                }

                /**
                 * 获取partid属性的值。
                 * 
                 */
                public int getPartid() {
                    return partid;
                }

                /**
                 * 设置partid属性的值。
                 * 
                 */
                public void setPartid(int value) {
                    this.partid = value;
                }

                /**
                 * 获取filename属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFilename() {
                    return filename;
                }

                /**
                 * 设置filename属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFilename(String value) {
                    this.filename = value;
                }

                /**
                 * 获取fileformatdesc属性的值。
                 * 
                 */
                public int getFileformatdesc() {
                    return fileformatdesc;
                }

                /**
                 * 设置fileformatdesc属性的值。
                 * 
                 */
                public void setFileformatdesc(int value) {
                    this.fileformatdesc = value;
                }

                /**
                 * 获取filesize属性的值。
                 * 
                 */
                public short getFilesize() {
                    return filesize;
                }

                /**
                 * 设置filesize属性的值。
                 * 
                 */
                public void setFilesize(short value) {
                    this.filesize = value;
                }

                /**
                 * 获取filebitrate属性的值。
                 * 
                 */
                public int getFilebitrate() {
                    return filebitrate;
                }

                /**
                 * 设置filebitrate属性的值。
                 * 
                 */
                public void setFilebitrate(int value) {
                    this.filebitrate = value;
                }

                /**
                 * 获取fileduration属性的值。
                 * 
                 */
                public int getFileduration() {
                    return fileduration;
                }

                /**
                 * 设置fileduration属性的值。
                 * 
                 */
                public void setFileduration(int value) {
                    this.fileduration = value;
                }

                /**
                 * 获取fileformat属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFileformat() {
                    return fileformat;
                }

                /**
                 * 设置fileformat属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFileformat(String value) {
                    this.fileformat = value;
                }

                /**
                 * 获取is3D属性的值。
                 * 
                 */
                public int getIs3D() {
                    return is3D;
                }

                /**
                 * 设置is3D属性的值。
                 * 
                 */
                public void setIs3D(int value) {
                    this.is3D = value;
                }

                /**
                 * 获取filehash属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFilehash() {
                    return filehash;
                }

                /**
                 * 设置filehash属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFilehash(String value) {
                    this.filehash = value;
                }

                /**
                 * 获取videobitrate属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVideobitrate() {
                    return videobitrate;
                }

                /**
                 * 设置videobitrate属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVideobitrate(String value) {
                    this.videobitrate = value;
                }

                /**
                 * 获取videoformat属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVideoformat() {
                    return videoformat;
                }

                /**
                 * 设置videoformat属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVideoformat(String value) {
                    this.videoformat = value;
                }

                /**
                 * 获取videoinfo属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVideoinfo() {
                    return videoinfo;
                }

                /**
                 * 设置videoinfo属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVideoinfo(String value) {
                    this.videoinfo = value;
                }

                /**
                 * 获取videointroduction属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVideointroduction() {
                    return videointroduction;
                }

                /**
                 * 设置videointroduction属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVideointroduction(String value) {
                    this.videointroduction = value;
                }

                /**
                 * 获取videowidth属性的值。
                 * 
                 */
                public int getVideowidth() {
                    return videowidth;
                }

                /**
                 * 设置videowidth属性的值。
                 * 
                 */
                public void setVideowidth(int value) {
                    this.videowidth = value;
                }

                /**
                 * 获取videoheight属性的值。
                 * 
                 */
                public int getVideoheight() {
                    return videoheight;
                }

                /**
                 * 设置videoheight属性的值。
                 * 
                 */
                public void setVideoheight(int value) {
                    this.videoheight = value;
                }

                /**
                 * 获取videoscale属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVideoscale() {
                    return videoscale;
                }

                /**
                 * 设置videoscale属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVideoscale(String value) {
                    this.videoscale = value;
                }

                /**
                 * 获取videolength属性的值。
                 * 
                 */
                public int getVideolength() {
                    return videolength;
                }

                /**
                 * 设置videolength属性的值。
                 * 
                 */
                public void setVideolength(int value) {
                    this.videolength = value;
                }

                /**
                 * 获取videosetcabac属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVideosetcabac() {
                    return videosetcabac;
                }

                /**
                 * 设置videosetcabac属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVideosetcabac(String value) {
                    this.videosetcabac = value;
                }

                /**
                 * 获取formatsetreframes属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFormatsetreframes() {
                    return formatsetreframes;
                }

                /**
                 * 设置formatsetreframes属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFormatsetreframes(String value) {
                    this.formatsetreframes = value;
                }

                /**
                 * 获取framerate属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFramerate() {
                    return framerate;
                }

                /**
                 * 设置framerate属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFramerate(String value) {
                    this.framerate = value;
                }

                /**
                 * 获取criterion属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCriterion() {
                    return criterion;
                }

                /**
                 * 设置criterion属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCriterion(String value) {
                    this.criterion = value;
                }

                /**
                 * 获取vga属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getVga() {
                    return vga;
                }

                /**
                 * 设置vga属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setVga(String value) {
                    this.vga = value;
                }

                /**
                 * 获取colorimetry属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getColorimetry() {
                    return colorimetry;
                }

                /**
                 * 设置colorimetry属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setColorimetry(String value) {
                    this.colorimetry = value;
                }

                /**
                 * 获取scantype属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getScantype() {
                    return scantype;
                }

                /**
                 * 设置scantype属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setScantype(String value) {
                    this.scantype = value;
                }

                /**
                 * 获取datadensity属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDatadensity() {
                    return datadensity;
                }

                /**
                 * 设置datadensity属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDatadensity(String value) {
                    this.datadensity = value;
                }

                /**
                 * 获取encodedlibrary属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEncodedlibrary() {
                    return encodedlibrary;
                }

                /**
                 * 设置encodedlibrary属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEncodedlibrary(String value) {
                    this.encodedlibrary = value;
                }

                /**
                 * 获取encodedlibset属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEncodedlibset() {
                    return encodedlibset;
                }

                /**
                 * 设置encodedlibset属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEncodedlibset(String value) {
                    this.encodedlibset = value;
                }

                /**
                 * 获取audioformat属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAudioformat() {
                    return audioformat;
                }

                /**
                 * 设置audioformat属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAudioformat(String value) {
                    this.audioformat = value;
                }

                /**
                 * 获取audioinfo属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAudioinfo() {
                    return audioinfo;
                }

                /**
                 * 设置audioinfo属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAudioinfo(String value) {
                    this.audioinfo = value;
                }

                /**
                 * 获取audiointrodution属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAudiointrodution() {
                    return audiointrodution;
                }

                /**
                 * 设置audiointrodution属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAudiointrodution(String value) {
                    this.audiointrodution = value;
                }

                /**
                 * 获取audioversion属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAudioversion() {
                    return audioversion;
                }

                /**
                 * 设置audioversion属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAudioversion(String value) {
                    this.audioversion = value;
                }

                /**
                 * 获取audiomuxingmode属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAudiomuxingmode() {
                    return audiomuxingmode;
                }

                /**
                 * 设置audiomuxingmode属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAudiomuxingmode(String value) {
                    this.audiomuxingmode = value;
                }

                /**
                 * 获取audioduration属性的值。
                 * 
                 */
                public int getAudioduration() {
                    return audioduration;
                }

                /**
                 * 设置audioduration属性的值。
                 * 
                 */
                public void setAudioduration(int value) {
                    this.audioduration = value;
                }

                /**
                 * 获取audiotrack属性的值。
                 * 
                 */
                public int getAudiotrack() {
                    return audiotrack;
                }

                /**
                 * 设置audiotrack属性的值。
                 * 
                 */
                public void setAudiotrack(int value) {
                    this.audiotrack = value;
                }

                /**
                 * 获取audiosampling属性的值。
                 * 
                 */
                public int getAudiosampling() {
                    return audiosampling;
                }

                /**
                 * 设置audiosampling属性的值。
                 * 
                 */
                public void setAudiosampling(int value) {
                    this.audiosampling = value;
                }

                /**
                 * 获取audioratemode属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAudioratemode() {
                    return audioratemode;
                }

                /**
                 * 设置audioratemode属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAudioratemode(String value) {
                    this.audioratemode = value;
                }

                /**
                 * 获取filesource属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFilesource() {
                    return filesource;
                }

                /**
                 * 设置filesource属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFilesource(String value) {
                    this.filesource = value;
                }

                /**
                 * 获取isdrm属性的值。
                 * 
                 */
                public int getIsdrm() {
                    return isdrm;
                }

                /**
                 * 设置isdrm属性的值。
                 * 
                 */
                public void setIsdrm(int value) {
                    this.isdrm = value;
                }

                /**
                 * 获取encryptsolution属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEncryptsolution() {
                    return encryptsolution;
                }

                /**
                 * 设置encryptsolution属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEncryptsolution(String value) {
                    this.encryptsolution = value;
                }

                /**
                 * 获取thirdfileid属性的值。
                 * 
                 */
                public int getThirdfileid() {
                    return thirdfileid;
                }

                /**
                 * 设置thirdfileid属性的值。
                 * 
                 */
                public void setThirdfileid(int value) {
                    this.thirdfileid = value;
                }

                /**
                 * 获取overallbitratemode属性的值。
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOverallbitratemode() {
                    return overallbitratemode;
                }

                /**
                 * 设置overallbitratemode属性的值。
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOverallbitratemode(String value) {
                    this.overallbitratemode = value;
                }

            }

        }

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="pushcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="queuename" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="contentprovider" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pushcode",
        "queuename",
        "contentprovider"
    })
    public static class Info {

        @XmlElement(required = true)
        protected String pushcode;
        @XmlElement(required = true)
        protected String queuename;
        @XmlElement(required = true)
        protected String contentprovider;

        /**
         * 获取pushcode属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPushcode() {
            return pushcode;
        }

        /**
         * 设置pushcode属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPushcode(String value) {
            this.pushcode = value;
        }

        /**
         * 获取queuename属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQueuename() {
            return queuename;
        }

        /**
         * 设置queuename属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQueuename(String value) {
            this.queuename = value;
        }

        /**
         * 获取contentprovider属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContentprovider() {
            return contentprovider;
        }

        /**
         * 设置contentprovider属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContentprovider(String value) {
            this.contentprovider = value;
        }

    }

}
