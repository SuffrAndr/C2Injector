//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2016.05.16 时间 04:00:29 PM CST
//

package com.miri.blephone.mediainjector.iptv.c2.adi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="Objects" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Object" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Property" type="{}PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="ElementType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Code" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Mappings" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Mapping" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Property" type="{}PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ParentType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ParentID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ElementType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ElementID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Reply" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Result" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="SPCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SubsidiaryID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="StaffID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CheckFlag" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BizDomain" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Priority" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "objects", "mappings", "reply" })
@XmlRootElement(name = "ADI")
public class ADI {

    @XmlElement(name = "Objects")
    protected ADI.Objects  objects;
    @XmlElement(name = "Mappings")
    protected ADI.Mappings mappings;
    @XmlElement(name = "Reply")
    protected ADI.Reply    reply;
    @XmlAttribute(name = "SPCode")
    protected String       spCode;
    @XmlAttribute(name = "SubsidiaryID")
    protected String       subsidiaryID;
    @XmlAttribute(name = "StaffID")
    protected String       staffID;
    @XmlAttribute(name = "CheckFlag")
    protected String       checkFlag;
    @XmlAttribute(name = "BizDomain")
    protected String       bizDomain;
    @XmlAttribute(name = "Priority")
    protected String       priority;

    /**
     * 获取objects属性的值。
     * @return possible object is {@link ADI.Objects }
     */
    public ADI.Objects getObjects() {
        return this.objects;
    }

    /**
     * 设置objects属性的值。
     * @param value allowed object is {@link ADI.Objects }
     */
    public void setObjects(final ADI.Objects value) {
        this.objects = value;
    }

    /**
     * 获取mappings属性的值。
     * @return possible object is {@link ADI.Mappings }
     */
    public ADI.Mappings getMappings() {
        return this.mappings;
    }

    /**
     * 设置mappings属性的值。
     * @param value allowed object is {@link ADI.Mappings }
     */
    public void setMappings(final ADI.Mappings value) {
        this.mappings = value;
    }

    /**
     * 获取reply属性的值。
     * @return possible object is {@link ADI.Reply }
     */
    public ADI.Reply getReply() {
        return this.reply;
    }

    /**
     * 设置reply属性的值。
     * @param value allowed object is {@link ADI.Reply }
     */
    public void setReply(final ADI.Reply value) {
        this.reply = value;
    }

    /**
     * 获取spCode属性的值。
     * @return possible object is {@link String }
     */
    public String getSPCode() {
        return this.spCode;
    }

    /**
     * 设置spCode属性的值。
     * @param value allowed object is {@link String }
     */
    public void setSPCode(final String value) {
        this.spCode = value;
    }

    /**
     * 获取subsidiaryID属性的值。
     * @return possible object is {@link String }
     */
    public String getSubsidiaryID() {
        return this.subsidiaryID;
    }

    /**
     * 设置subsidiaryID属性的值。
     * @param value allowed object is {@link String }
     */
    public void setSubsidiaryID(final String value) {
        this.subsidiaryID = value;
    }

    /**
     * 获取staffID属性的值。
     * @return possible object is {@link String }
     */
    public String getStaffID() {
        return this.staffID;
    }

    /**
     * 设置staffID属性的值。
     * @param value allowed object is {@link String }
     */
    public void setStaffID(final String value) {
        this.staffID = value;
    }

    /**
     * 获取checkFlag属性的值。
     * @return possible object is {@link String }
     */
    public String getCheckFlag() {
        return this.checkFlag;
    }

    /**
     * 设置checkFlag属性的值。
     * @param value allowed object is {@link String }
     */
    public void setCheckFlag(final String value) {
        this.checkFlag = value;
    }

    /**
     * 获取bizDomain属性的值。
     * @return possible object is {@link String }
     */
    public String getBizDomain() {
        return this.bizDomain;
    }

    /**
     * 设置bizDomain属性的值。
     * @param value allowed object is {@link String }
     */
    public void setBizDomain(final String value) {
        this.bizDomain = value;
    }

    /**
     * 获取priority属性的值。
     * @return possible object is {@link String }
     */
    public String getPriority() {
        return this.priority;
    }

    /**
     * 设置priority属性的值。
     * @param value allowed object is {@link String }
     */
    public void setPriority(final String value) {
        this.priority = value;
    }

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
     *         &lt;element name="Mapping" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Property" type="{}PropertyType" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ParentType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ParentID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ElementType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ElementID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    @XmlType(name = "", propOrder = { "mapping" })
    public static class Mappings {

        @XmlElement(name = "Mapping")
        protected List<ADI.Mappings.Mapping> mapping;

        /**
         * Gets the value of the mapping property.
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot.
         * Therefore any modification you make to the returned list will be present inside
         * the JAXB object. This is why there is not a <CODE>set</CODE> method for the
         * mapping property.
         * <p>
         * For example, to add a new item, do as follows:
         * 
         * <pre>
         * getMapping().add(newItem);
         * </pre>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ADI.Mappings.Mapping }
         */
        public List<ADI.Mappings.Mapping> getMapping() {
            if (this.mapping == null) {
                this.mapping = new ArrayList<>();
            }
            return this.mapping;
        }

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
         *         &lt;element name="Property" type="{}PropertyType" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ParentType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ParentID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ElementType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ElementID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "property" })
        public static class Mapping {

            @XmlElement(name = "Property")
            protected List<PropertyType> property;
            @XmlAttribute(name = "ID")
            protected String             id;
            @XmlAttribute(name = "ParentType", required = true)
            protected String             parentType;
            @XmlAttribute(name = "ParentID", required = true)
            protected String             parentID;

            @XmlAttribute(name = "ParentCode", required = true)
            protected String             parentCode;

            @XmlAttribute(name = "ElementType", required = true)
            protected String             elementType;
            @XmlAttribute(name = "ElementID", required = true)
            protected String             elementID;

            @XmlAttribute(name = "ElementCode", required = true)
            protected String             elementCode;

            @XmlAttribute(name = "Action", required = true)
            protected String             action;

            /**
             * Gets the value of the property property.
             * <p>
             * This accessor method returns a reference to the live list, not a snapshot.
             * Therefore any modification you make to the returned list will be present
             * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
             * for the property property.
             * <p>
             * For example, to add a new item, do as follows:
             * 
             * <pre>
             * getProperty().add(newItem);
             * </pre>
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PropertyType }
             */
            public List<PropertyType> getProperty() {
                if (this.property == null) {
                    this.property = new ArrayList<>();
                }
                return this.property;
            }

            /**
             * 获取id属性的值。
             * @return possible object is {@link String }
             */
            public String getID() {
                return this.id;
            }

            /**
             * 设置id属性的值。
             * @param value allowed object is {@link String }
             */
            public void setID(final String value) {
                this.id = value;
            }

            /**
             * 获取parentType属性的值。
             * @return possible object is {@link String }
             */
            public String getParentType() {
                return this.parentType;
            }

            /**
             * 设置parentType属性的值。
             * @param value allowed object is {@link String }
             */
            public void setParentType(final String value) {
                this.parentType = value;
            }

            /**
             * 获取parentID属性的值。
             * @return possible object is {@link String }
             */
            public String getParentID() {
                return this.parentID;
            }

            /**
             * 设置parentID属性的值。
             * @param value allowed object is {@link String }
             */
            public void setParentID(final String value) {
                this.parentID = value;
            }

            public String getParentCode() {
                return this.parentCode;
            }

            public void setParentCode(final String parentCode) {
                this.parentCode = parentCode;
            }

            /**
             * 获取elementType属性的值。
             * @return possible object is {@link String }
             */
            public String getElementType() {
                return this.elementType;
            }

            /**
             * 设置elementType属性的值。
             * @param value allowed object is {@link String }
             */
            public void setElementType(final String value) {
                this.elementType = value;
            }

            /**
             * 获取elementID属性的值。
             * @return possible object is {@link String }
             */
            public String getElementID() {
                return this.elementID;
            }

            /**
             * 设置elementID属性的值。
             * @param value allowed object is {@link String }
             */
            public void setElementID(final String value) {
                this.elementID = value;
            }

            public String getElementCode() {
                return this.elementCode;
            }

            public void setElementCode(final String elementCode) {
                this.elementCode = elementCode;
            }

            /**
             * 获取action属性的值。
             * @return possible object is {@link String }
             */
            public String getAction() {
                return this.action;
            }

            /**
             * 设置action属性的值。
             * @param value allowed object is {@link String }
             */
            public void setAction(final String value) {
                this.action = value;
            }

        }

    }

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
     *         &lt;element name="Object" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Property" type="{}PropertyType" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="ElementType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Code" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    @XmlType(name = "", propOrder = { "object" })
    public static class Objects {

        @XmlElement(name = "Object")
        protected List<ADI.Objects.Object> object;

        /**
         * Gets the value of the object property.
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot.
         * Therefore any modification you make to the returned list will be present inside
         * the JAXB object. This is why there is not a <CODE>set</CODE> method for the
         * object property.
         * <p>
         * For example, to add a new item, do as follows:
         * 
         * <pre>
         * getObject().add(newItem);
         * </pre>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ADI.Objects.Object }
         */
        public List<ADI.Objects.Object> getObject() {
            if (this.object == null) {
                this.object = new ArrayList<>();
            }
            return this.object;
        }

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
         *         &lt;element name="Property" type="{}PropertyType" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="ElementType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Code" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "property" })
        public static class Object {

            @XmlElement(name = "Property")
            protected List<PropertyType> property;
            @XmlAttribute(name = "ElementType", required = true)
            protected String             elementType;
            @XmlAttribute(name = "ID", required = true)
            protected String             id;
            @XmlAttribute(name = "Action", required = true)
            protected String             action;
            @XmlAttribute(name = "Code", required = true)
            protected String             code;

            /**
             * Gets the value of the property property.
             * <p>
             * This accessor method returns a reference to the live list, not a snapshot.
             * Therefore any modification you make to the returned list will be present
             * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
             * for the property property.
             * <p>
             * For example, to add a new item, do as follows:
             * 
             * <pre>
             * getProperty().add(newItem);
             * </pre>
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PropertyType }
             */
            public List<PropertyType> getProperty() {
                if (this.property == null) {
                    this.property = new ArrayList<>();
                }
                return this.property;
            }

            /**
             * 获取elementType属性的值。
             * @return possible object is {@link String }
             */
            public String getElementType() {
                return this.elementType;
            }

            /**
             * 设置elementType属性的值。
             * @param value allowed object is {@link String }
             */
            public void setElementType(final String value) {
                this.elementType = value;
            }

            /**
             * 获取id属性的值。
             * @return possible object is {@link String }
             */
            public String getID() {
                return this.id;
            }

            /**
             * 设置id属性的值。
             * @param value allowed object is {@link String }
             */
            public void setID(final String value) {
                this.id = value;
            }

            /**
             * 获取action属性的值。
             * @return possible object is {@link String }
             */
            public String getAction() {
                return this.action;
            }

            /**
             * 设置action属性的值。
             * @param value allowed object is {@link String }
             */
            public void setAction(final String value) {
                this.action = value;
            }

            /**
             * 获取code属性的值。
             * @return possible object is {@link String }
             */
            public String getCode() {
                return this.code;
            }

            /**
             * 设置code属性的值。
             * @param value allowed object is {@link String }
             */
            public void setCode(final String value) {
                this.code = value;
            }
        }
    }

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
     *         &lt;element name="Result" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "result", "description" })
    public static class Reply {

        @XmlElement(name = "Result", required = true)
        protected String result;
        @XmlElement(name = "Description", required = true)
        protected String description;

        /**
         * 获取result属性的值。
         * @return possible object is {@link String }
         */
        public String getResult() {
            return this.result;
        }

        /**
         * 设置result属性的值。
         * @param value allowed object is {@link String }
         */
        public void setResult(final String value) {
            this.result = value;
        }

        /**
         * 获取description属性的值。
         * @return possible object is {@link String }
         */
        public String getDescription() {
            return this.description;
        }

        /**
         * 设置description属性的值。
         * @param value allowed object is {@link String }
         */
        public void setDescription(final String value) {
            this.description = value;
        }

    }

}
