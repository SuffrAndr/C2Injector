package com.miri.blephone.mediainjector.iptv.c2.notify.test;

import java.rmi.RemoteException;
import java.util.UUID;

import javax.xml.rpc.ServiceException;

public class NotifyTest {

    public static void main(final String[] args) {
        final CSPResponseServiceLocator locator = new CSPResponseServiceLocator();

        try {

            locator.setctmsEndpointAddress("http://127.0.0.1:8080/services/ctms");

            final CSPResponse response = locator.getctms();

            final String LSPID = UUID.randomUUID().toString();
            final String CSPID = UUID.randomUUID().toString();
            final int cmdResult = 0;
            final String correlateID = "eae0ca23c4604e29b32aa611dc9cee84";
            final String resultFileURL = "ftp://username:password@ip:port/..../xxx.xml";
            final CSPResult resultNotify = response.resultNotify(CSPID, LSPID, correlateID, cmdResult, resultFileURL);

            System.out.println(resultNotify.getResult());

        }
        catch (final ServiceException | RemoteException e) {
            e.printStackTrace();
        }

    }
}
