package com.miri.blephone.mediainjector.config;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 全局配置类,支持5分钟热刷新
 */
public final class GlobalConfig {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalConfig.class);

    private static GlobalConfig instance = new GlobalConfig();

    private static PropertiesConfiguration configuration;

    {
        GlobalConfig.init();
    }

    private GlobalConfig() {
    }

    /**
     * @return the instance
     */
    public synchronized static GlobalConfig getInstance() {
        return GlobalConfig.instance;
    }

    private static void init() {
        try {
            final Resource resource = new ClassPathResource("application.properties");
            GlobalConfig.configuration = new PropertiesConfiguration(resource.getFile());

            final FileChangedReloadingStrategy fileChangedReloadingStrategy = new FileChangedReloadingStrategy();
            fileChangedReloadingStrategy.setRefreshDelay(50000);

            GlobalConfig.configuration.setReloadingStrategy(fileChangedReloadingStrategy);

            GlobalConfig.LOG.info("Load config {} sucess.", resource.getFilename());
        }
        catch (final ConfigurationException e) {
            GlobalConfig.LOG.error("Reader config fial.", e);
        }
        catch (final IOException e) {
            GlobalConfig.LOG.error("Reader config fial.", e);
        }
    }

    public String getString(final String key) {
        return GlobalConfig.configuration.getString(key);
    }

    public String getString(final String key, final String defaultValue) {
        return GlobalConfig.configuration.getString(key, defaultValue);
    }

    public String[] getStringArray(final String key) {
        return GlobalConfig.configuration.getStringArray(key);
    }

    public int getInt(final String key) {
        return GlobalConfig.configuration.getInt(key);
    }

    public int getInt(final String key, final int defaultValue) {
        return GlobalConfig.configuration.getInt(key, defaultValue);
    }

    public long getLong(final String key) {
        return GlobalConfig.configuration.getLong(key);
    }

    public long getLong(final String key, final long defaultValue) {
        return GlobalConfig.configuration.getLong(key, defaultValue);
    }
}
