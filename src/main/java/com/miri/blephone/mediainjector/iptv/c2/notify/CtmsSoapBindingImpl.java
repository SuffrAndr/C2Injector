/**
 * CtmsSoapBindingImpl.java This file was auto-generated from WSDL by the Apache Axis 1.4
 * Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miri.blephone.mediainjector.iptv.c2.notify;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.miri.blephone.mediainjector.db.DBConstans;
import com.miri.blephone.mediainjector.db.dao.DbRepository;
import com.miri.blephone.mediainjector.db.domain.WsMsg;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADIConstants;
import com.miri.blephone.mediainjector.uitls.SpringFactoryUtils;

public class CtmsSoapBindingImpl implements CSPResponse {

	private static final Logger LOG = LoggerFactory.getLogger(CtmsSoapBindingImpl.class);

	public CSPResult resultNotify(final String CSPID, final String LSPID, final String correlateID, final int cmdResult,
			final String resultFileURL) throws RemoteException {

		CtmsSoapBindingImpl.LOG.info("correlateID [{}] {}", correlateID, cmdResult);

		CSPResult cspResult = null;
		try {

			final DbRepository dbRepository = SpringFactoryUtils.getBean("dbRepository");

			final List<WsMsg> wsMsgs = dbRepository.queryWSMsgByCorrelateId(correlateID);

			if (CollectionUtils.isNotEmpty(wsMsgs))

				for (final WsMsg wsMsg : wsMsgs) {

					int status = wsMsg.getStatus();

					int assetStatus = DBConstans.AssetStatus.ADI_DEPLOYED;
					if (cmdResult == 0) {
						status = DBConstans.WsStatus.INJECT_SUCESS;
						assetStatus = DBConstans.AssetStatus.INJECTED;
					} else
						status = DBConstans.WsStatus.INJECT_FAIL;

					wsMsg.setStatus(status);
					wsMsg.setUpdateTime(DateTime.now().toDate());
					wsMsg.setResultFileUrl(resultFileURL);

					dbRepository.updateWSMsgStatus(wsMsg);

					if (assetStatus == DBConstans.WsStatus.INJECT_SUCESS)
						dbRepository.updateStatusByObjectId(wsMsg.getType(), wsMsg.getObjectId(),
								wsMsg.getSubObjectId(), assetStatus);
					cspResult = new CSPResult(ADIConstants.Result.Sucess, StringUtils.EMPTY);

				}
			else
				cspResult = new CSPResult(ADIConstants.Result.FAIL,
						String.format("correlateID[%s] not found.", correlateID));
		} catch (final Exception e) {

			CtmsSoapBindingImpl.LOG.error("Notify soap fail.", e);

			cspResult = new CSPResult(ADIConstants.Result.FAIL, "Update stats fail.");
		}

		return cspResult;
	}
}
