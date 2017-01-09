package com.miri.blephone.mediainjector.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.MQMsg;

public interface MQMsgMapper {

    void add(final MQMsg mQMsg);

    void updateMsgStatus(@Param(value = "id") final long id, @Param(value = "status") final short status);

    int countByPushcode(@Param(value = "pushcode") final String pushcode);

    void updateMsg(final MQMsg mQMsg);

    MQMsg queryByPushcode(@Param(value = "pushcode") final String pushcode);

    List<MQMsg> queryByStatus(@Param(value = "status") final short status);
}
