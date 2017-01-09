package com.miri.blephone.mediainjector.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.WsMsg;

public interface WsMsgMapper {

	void add(final WsMsg wsMsg);

	List<WsMsg> queryByCorrelateId(@Param("correlateId") final String correlateId);

	void update(final WsMsg wsMsg);

	List<WsMsg> queryByStatus(final List<Integer> status);

	List<WsMsg> queryWsMsgs(final WsMsg wsMsg);
}
