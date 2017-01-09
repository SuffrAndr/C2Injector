/**
 * CSPResult.java This file was auto-generated from WSDL by the Apache Axis 1.4 Apr 22,
 * 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miri.blephone.mediainjector.iptv.c2.req;

@SuppressWarnings("serial")
public class CSPResult implements java.io.Serializable {

    private int result;

    private java.lang.String errorDescription;

    public CSPResult() {
    }

    public CSPResult(final int result, final java.lang.String errorDescription) {
        this.result = result;
        this.errorDescription = errorDescription;
    }

    /**
     * Gets the result value for this CSPResult.
     * @return result
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Sets the result value for this CSPResult.
     * @param result
     */
    public void setResult(final int result) {
        this.result = result;
    }

    /**
     * Gets the errorDescription value for this CSPResult.
     * @return errorDescription
     */
    public java.lang.String getErrorDescription() {
        return this.errorDescription;
    }

    /**
     * Sets the errorDescription value for this CSPResult.
     * @param errorDescription
     */
    public void setErrorDescription(final java.lang.String errorDescription) {
        this.errorDescription = errorDescription;
    }

    private java.lang.Object __equalsCalc = null;

    @Override
    public synchronized boolean equals(final java.lang.Object obj) {
        if (!(obj instanceof CSPResult)) {
            return false;
        }
        final CSPResult other = (CSPResult) obj;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.__equalsCalc != null) {
            return this.__equalsCalc == obj;
        }
        this.__equalsCalc = obj;
        boolean _equals;
        _equals = true && this.result == other.getResult()
                && (this.errorDescription == null && other.getErrorDescription() == null
                        || this.errorDescription != null && this.errorDescription.equals(other.getErrorDescription()));
        this.__equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;

    @Override
    public synchronized int hashCode() {
        if (this.__hashCodeCalc) {
            return 0;
        }
        this.__hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += this.getResult();
        if (this.getErrorDescription() != null) {
            _hashCode += this.getErrorDescription().hashCode();
        }
        this.__hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
            CSPResult.class, true);

    static {
        CSPResult.typeDesc.setXmlType(new javax.xml.namespace.QName("iptv", "CSPResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        CSPResult.typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ErrorDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        CSPResult.typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return CSPResult.typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(final java.lang.String mechType,
            final java.lang.Class _javaType, final javax.xml.namespace.QName _xmlType) {
        return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, CSPResult.typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(final java.lang.String mechType,
            final java.lang.Class _javaType, final javax.xml.namespace.QName _xmlType) {
        return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, CSPResult.typeDesc);
    }
}
