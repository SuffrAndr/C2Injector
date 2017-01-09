/**
 * CSPRequestServiceLocator.java This file was auto-generated from WSDL by the Apache Axis
 * 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miri.blephone.mediainjector.iptv.c2.req;

@SuppressWarnings("serial")
public class CSPRequestServiceLocator extends org.apache.axis.client.Service
        implements com.miri.blephone.mediainjector.iptv.c2.req.CSPRequestService {

    public CSPRequestServiceLocator() {
    }

    public CSPRequestServiceLocator(final org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CSPRequestServiceLocator(final java.lang.String wsdlLoc, final javax.xml.namespace.QName sName)
            throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ctms
    private java.lang.String ctms_address = "http://127.0.0.1";

    public java.lang.String getctmsAddress() {
        return this.ctms_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ctmsWSDDServiceName = "ctms";

    public java.lang.String getctmsWSDDServiceName() {
        return this.ctmsWSDDServiceName;
    }

    public void setctmsWSDDServiceName(final java.lang.String name) {
        this.ctmsWSDDServiceName = name;
    }

    public com.miri.blephone.mediainjector.iptv.c2.req.CSPRequest getctms() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(this.ctms_address);
        }
        catch (final java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return this.getctms(endpoint);
    }

    public com.miri.blephone.mediainjector.iptv.c2.req.CSPRequest getctms(final java.net.URL portAddress)
            throws javax.xml.rpc.ServiceException {
        try {
            final com.miri.blephone.mediainjector.iptv.c2.req.CtmsSoapBindingStub _stub = new com.miri.blephone.mediainjector.iptv.c2.req.CtmsSoapBindingStub(
                    portAddress, this);
            _stub.setPortName(this.getctmsWSDDServiceName());
            return _stub;
        }
        catch (final org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setctmsEndpointAddress(final java.lang.String address) {
        this.ctms_address = address;
    }

    /**
     * For the given interface, get the stub implementation. If this service has no port
     * for the given interface, then ServiceException is thrown.
     */
    @Override
    public java.rmi.Remote getPort(final Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.miri.blephone.mediainjector.iptv.c2.req.CSPRequest.class
                    .isAssignableFrom(serviceEndpointInterface)) {
                final com.miri.blephone.mediainjector.iptv.c2.req.CtmsSoapBindingStub _stub = new com.miri.blephone.mediainjector.iptv.c2.req.CtmsSoapBindingStub(
                        new java.net.URL(this.ctms_address), this);
                _stub.setPortName(this.getctmsWSDDServiceName());
                return _stub;
            }
        }
        catch (final java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  "
                + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation. If this service has no port
     * for the given interface, then ServiceException is thrown.
     */
    @Override
    public java.rmi.Remote getPort(final javax.xml.namespace.QName portName, final Class serviceEndpointInterface)
            throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return this.getPort(serviceEndpointInterface);
        }
        final java.lang.String inputPortName = portName.getLocalPart();
        if ("ctms".equals(inputPortName)) {
            return this.getctms();
        }
        else {
            final java.rmi.Remote _stub = this.getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    @Override
    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("iptv", "CSPRequestService");
    }

    private java.util.HashSet ports = null;

    @Override
    public java.util.Iterator getPorts() {
        if (this.ports == null) {
            this.ports = new java.util.HashSet();
            this.ports.add(new javax.xml.namespace.QName("iptv", "ctms"));
        }
        return this.ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(final java.lang.String portName, final java.lang.String address)
            throws javax.xml.rpc.ServiceException {

        if ("ctms".equals(portName)) {
            this.setctmsEndpointAddress(address);
        }
        else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(final javax.xml.namespace.QName portName, final java.lang.String address)
            throws javax.xml.rpc.ServiceException {
        this.setEndpointAddress(portName.getLocalPart(), address);
    }

}
