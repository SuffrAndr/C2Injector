/**
 * CtmsSoapBindingImpl.java This file was auto-generated from WSDL by the Apache Axis 1.4
 * Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miri.blephone.mediainjector.iptv.c2.notify;

import com.miri.blephone.mediainjector.config.*;
import com.miri.blephone.mediainjector.db.*;
import com.miri.blephone.mediainjector.db.dao.*;
import com.miri.blephone.mediainjector.db.domain.*;
import com.miri.blephone.mediainjector.iptv.c2.adi.*;
import com.miri.blephone.mediainjector.iptv.c2.adi.rsp.*;
import com.miri.blephone.mediainjector.uitls.*;
import org.apache.commons.collections.*;
import org.apache.commons.lang.*;
import org.apache.commons.lang.builder.*;
import org.apache.commons.lang3.tuple.*;
import org.joda.time.*;
import org.slf4j.*;

import javax.xml.bind.*;
import java.rmi.*;
import java.util.*;

public class CtmsSoapBindingImpl implements CSPResponse {

    private static final Logger LOG = LoggerFactory.getLogger(CtmsSoapBindingImpl.class);
    static JAXBContext jaxb;

    static {
        try {
            jaxb = JAXBContext.newInstance(RspADI.class);
        }
        catch (JAXBException e) {
            LOG.error("JAXBContext init fial.", e);
        }
    }

    private final GlobalConfig globalConfig = GlobalConfig.getInstance();

    public CSPResult resultNotify(final String CSPID, final String LSPID, final String correlateID, final int cmdResult,
            final String resultFileURL) throws RemoteException {

        CtmsSoapBindingImpl.LOG.info("correlateID [{}] {}", correlateID, cmdResult);

        CSPResult cspResult = null;
        try {

            final DbRepository dbRepository = SpringFactoryUtils.getBean("dbRepository");

            String outputDir = this.globalConfig.getString(ConfigConstants.IPTV.STORE_PATH);

            final List<WsMsg> wsMsgs = dbRepository.queryWSMsgByCorrelateId(correlateID);

            if (CollectionUtils.isNotEmpty(wsMsgs))

                for (final WsMsg wsMsg : wsMsgs) {

                    int status = wsMsg.getStatus();

                    int assetStatus = DBConstans.AssetStatus.ADI_DEPLOYED;
                    if (cmdResult == 0) {
                        status = DBConstans.WsStatus.INJECT_SUCESS;
                        assetStatus = DBConstans.AssetStatus.INJECTED;
                    }
                    else {
                        status = DBConstans.WsStatus.INJECT_FAIL;
                    }

                    wsMsg.setStatus(status);
                    wsMsg.setUpdateTime(DateTime.now().toDate());
                    wsMsg.setResultFileUrl(resultFileURL);

                    String path = FtpUtils.downloadFile(resultFileURL, outputDir);

                    LOG.info("Download Rsp file [{}],Store file path [{}]", resultFileURL, path);
                    if (StringUtils.isNotBlank(path)) {

                        final RspADI rspADI = parseRsp(path);

                        Pair<Integer, String> pair = readdRsp(rspADI);

                        LOG.info("Readd  Rsp {}",
                                ToStringBuilder.reflectionToString(pair, ToStringStyle.SHORT_PREFIX_STYLE));

                        Integer left = pair.getLeft();
                        if (left != null) {

                            wsMsg.setNotifyRrrorDesc(pair.getRight());

                            if (left.intValue() == 0) {
                                status = DBConstans.WsStatus.INJECT_SUCESS;
                                assetStatus = DBConstans.AssetStatus.INJECTED;
                            }
                            else {
                                status = DBConstans.WsStatus.INJECT_FAIL;
	                            assetStatus = DBConstans.AssetStatus.INJECTED_FAIL;
                            }
                        }
                    }

                    dbRepository.updateWSMsgStatus(wsMsg);

                    // TODO:更新注释状态
                    dbRepository.updateStatusByObjectId(wsMsg.getType(), wsMsg.getObjectId(), wsMsg.getSubObjectId(),
                            assetStatus);

                    cspResult = new CSPResult(ADIConstants.Result.Sucess, StringUtils.EMPTY);

                }
            else
                cspResult = new CSPResult(ADIConstants.Result.FAIL,
                        String.format("correlateID[%s] not found.", correlateID));
        }
        catch (final Exception e) {

            CtmsSoapBindingImpl.LOG.error("Notify soap fail.", e);

            cspResult = new CSPResult(ADIConstants.Result.FAIL, "Update stats fail.");
        }

        return cspResult;
    }

    public RspADI parseRsp(String filePath) throws Exception {

        if (jaxb == null) {
            jaxb = JAXBContext.newInstance(RspADI.class);
        }

        Unmarshaller marshaller = jaxb.createUnmarshaller();

        java.io.File file = new java.io.File(filePath);

        RspADI rspADI = (RspADI) marshaller.unmarshal(file);

        return rspADI;
    }

    public Pair<Integer, String> readdRsp(RspADI rspADI) throws Exception {

        Pair<Integer, String> pair = new MutablePair<>();

        Integer left = 0;

        String right = "";

        if (rspADI != null) {
            final List<PropertyType> props = rspADI.getReply().getProperty();

            for (PropertyType propertyType : props) {

                String name = propertyType.getName();
                String value = propertyType.getValue();
                if (StringUtils.equals(name, ADIElementConstants.RESULT)) {
                    left = Integer.valueOf(value);
                }

                if (StringUtils.equals(name, ADIElementConstants.DESC)) {
                    right = value;
                }
            }

            pair = pair.of(left, right);
        }

        return pair;
    }

}
