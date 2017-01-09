/**
 * CSPResponse.java This file was auto-generated from WSDL by the Apache Axis 1.4 Apr 22,
 * 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miri.blephone.mediainjector.iptv.c2.notify;

import java.rmi.RemoteException;

public interface CSPResponse extends java.rmi.Remote {
    public CSPResult resultNotify(final String CSPID, final String LSPID, final String correlateID, final int cmdResult, final String resultFileURL) throws RemoteException;
}
