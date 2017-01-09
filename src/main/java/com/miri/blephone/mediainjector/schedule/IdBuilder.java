package com.miri.blephone.mediainjector.schedule;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.miri.blephone.mediainjector.config.ConfigConstants;
import com.miri.blephone.mediainjector.config.GlobalConfig;

import lombok.Getter;

@Service
public class IdBuilder implements InitializingBean {

    @Getter
    private String             cpCode;

    @Getter
    private String             versionCode;

    @Getter
    private String             objTypeSeries;

    @Getter
    private String             objTypeMovice;

    private final GlobalConfig globalConfig = GlobalConfig.getInstance();

    @Override
    public void afterPropertiesSet() throws Exception {
        this.cpCode = this.globalConfig.getString(ConfigConstants.IPTV.CPCODE);
        this.versionCode = this.globalConfig.getString(ConfigConstants.IPTV.VERSIONCODE);

        this.objTypeSeries = this.globalConfig.getString(ConfigConstants.IPTV.OBJ_TYPE_SERIES);

        this.objTypeMovice = this.globalConfig.getString(ConfigConstants.IPTV.OBJ_TYPE_MOVICE);
    }
}
