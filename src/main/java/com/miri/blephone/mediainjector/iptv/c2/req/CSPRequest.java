/**
 * CSPRequest.java This file was auto-generated from WSDL by the Apache Axis 1.4 Apr 22,
 * 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miri.blephone.mediainjector.iptv.c2.req;

public interface CSPRequest extends java.rmi.Remote {
    public CSPResult execCmd(final java.lang.String CSPID, final java.lang.String LSPID, final java.lang.String correlateID, final java.lang.String cmdFileURL) throws java.rmi.RemoteException;
}
