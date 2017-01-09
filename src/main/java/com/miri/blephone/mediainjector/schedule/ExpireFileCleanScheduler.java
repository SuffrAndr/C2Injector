package com.miri.blephone.mediainjector.schedule;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.miri.blephone.mediainjector.config.ConfigConstants;
import com.miri.blephone.mediainjector.config.GlobalConfig;
import com.miri.blephone.mediainjector.db.DBConstans;
import com.miri.blephone.mediainjector.db.dao.DbRepository;
import com.miri.blephone.mediainjector.db.domain.Clip;
import com.miri.blephone.mediainjector.db.domain.File;
import com.miri.blephone.mediainjector.uitls.FtpUtils;
import com.miri.blephone.mediainjector.uitls.UrlUtils;

@Service
public class ExpireFileCleanScheduler implements InitializingBean {

    private static final Logger DLOG     = LoggerFactory.getLogger(ExpireFileCleanScheduler.class);

    private static GlobalConfig instance = GlobalConfig.getInstance();

    private String              ftpStorePath;

    private int                 transferType;

    private String              ftpPrefix;

    @Autowired
    private DbRepository        dbRepository;

    /**
     * 生成ADI文件，讲Progam和Movice同时生成
     * @param clip 分集对象 {@link Clip}
     * @return
     */
    @Scheduled(fixedRate = 60000)
    public void build() {

        try {

            List<File> files = this.dbRepository.queryExpireFiles();

            for (File file : files) {

                try {

                    String urlPrefix = file.getUrlPrefix();
                    String filename = file.getFilename();

                    if (this.transferType != ConfigConstants.Values.SPECIAL_TRANSFERTYPE) {

                        if (StringUtils.isNotBlank(urlPrefix)) {

                            if (StringUtils.contains(urlPrefix, this.ftpPrefix)) {

                                ExpireFileCleanScheduler.DLOG.info("Clean {}{}", urlPrefix, filename);

                                String ftpPath = FtpUtils.getFtpPath(urlPrefix);

                                String filePrefix = UrlUtils.getUrl(this.ftpStorePath, ftpPath);

                                String filePath = UrlUtils.getUrl(filePrefix, filename);

                                ExpireFileCleanScheduler.DLOG.info("Clean File {}", filePath);

                                java.io.File expireFile = new java.io.File(filePath);

                                if (expireFile.exists()) {
                                    expireFile.delete();
                                }

                                this.dbRepository.updateDownloadStatusByOriginalId(file.getOriginalid(),
                                        DBConstans.FileDownload.DELETE);
                            }
                        }
                        else {
                            this.dbRepository.updateDownloadStatusByOriginalId(file.getOriginalid(),
                                    DBConstans.FileDownload.DELETE);
                        }
                    }
                }
                catch (Exception e) {
                    ExpireFileCleanScheduler.DLOG.error("Clean expire file fail.", e);
                }
            }
        }
        catch (Exception e) {
            ExpireFileCleanScheduler.DLOG.error("", e);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        this.ftpStorePath = ExpireFileCleanScheduler.instance.getString(ConfigConstants.MGTV.MEDIA_FTP_STOREPATH,
                "/home/gdydott/");

        this.transferType = ExpireFileCleanScheduler.instance.getInt(ConfigConstants.MGTV.MEDIA_TRANSFERTYPE);

        this.ftpPrefix = ExpireFileCleanScheduler.instance.getString(ConfigConstants.MGTV.MEDIA_FTP_PREFIX);
    }
}
