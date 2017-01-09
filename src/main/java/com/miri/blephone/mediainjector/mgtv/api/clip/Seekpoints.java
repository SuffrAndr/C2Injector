package com.miri.blephone.mediainjector.mgtv.api.clip;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

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
 *         &lt;element name="item">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="begin" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="img" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="imghash" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "item" })
public class Seekpoints {

    @XmlElement(required = true)
    protected Item item;

    /**
     * 获取item属性的值。
     * @return possible object is {@link ProgramAssetcontent.Content.Seekpoints.Item }
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * 设置item属性的值。
     * @param value allowed object is {@link ProgramAssetcontent.Content.Seekpoints.Item }
     */
    public void setItem(final Item value) {
        this.item = value;
    }

    /**
     * <p>
     * anonymous complex type的 Java 类。
     * <p>
     * 以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="begin" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="img" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="imghash" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    public static class Item {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "begin")
        protected Integer begin;
        @XmlAttribute(name = "end")
        protected Integer end;
        @XmlAttribute(name = "type")
        protected Integer type;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "img")
        protected String img;
        @XmlAttribute(name = "imghash")
        protected String imghash;

        /**
         * 获取value属性的值。
         * @return possible object is {@link String }
         */
        public String getValue() {
            return this.value;
        }

        /**
         * 设置value属性的值。
         * @param value allowed object is {@link String }
         */
        public void setValue(final String value) {
            this.value = value;
        }

        /**
         * 获取begin属性的值。
         * @return possible object is {@link Integer }
         */
        public Integer getBegin() {
            return this.begin;
        }

        /**
         * 设置begin属性的值。
         * @param value allowed object is {@link Integer }
         */
        public void setBegin(final Integer value) {
            this.begin = value;
        }

        /**
         * 获取end属性的值。
         * @return possible object is {@link Integer }
         */
        public Integer getEnd() {
            return this.end;
        }

        /**
         * 设置end属性的值。
         * @param value allowed object is {@link Integer }
         */
        public void setEnd(final Integer value) {
            this.end = value;
        }

        /**
         * 获取type属性的值。
         * @return possible object is {@link Integer }
         */
        public Integer getType() {
            return this.type;
        }

        /**
         * 设置type属性的值。
         * @param value allowed object is {@link Integer }
         */
        public void setType(final Integer value) {
            this.type = value;
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
         * 获取img属性的值。
         * @return possible object is {@link String }
         */
        public String getImg() {
            return this.img;
        }

        /**
         * 设置img属性的值。
         * @param value allowed object is {@link String }
         */
        public void setImg(final String value) {
            this.img = value;
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
    }
}
