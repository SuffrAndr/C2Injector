package com.miri.blephone.mediainjector.config;

/**
 * 配置文件常量定义
 */
public interface ConfigConstants {

    /**
     * MGTV 配置常量定义
     */
    interface MGTV {

        String NOTIFY_URL          = "mgtv.notifyUrl";

        String MQ_HOST             = "mgtv.mq.host";
        String MQ_PORT             = "mgtv.mq.port";
        String MQ_VHOST            = "mgtv.mq.vhost";
        String MQ_USERNAME         = "mgtv.mq.username";
        String MQ_PASSWORD         = "mgtv.mq.password";

        String QUEUE_MEDIA         = "mgtv.queue.media.name";

        String QUEUE_CORRELATION   = "mgtv.queue.correlation.name";

        String QUEUE_COLUMN        = "mgtv.queue.column.name";

        String QUEUE_STAR          = "mgtv.queue.star.name";

        String MQ_TIMEOUT          = "mgtv.mq.timeout";

        String MQ_PERIOD           = "mgtv.mq.period";

        String MQ_STOREPATH        = "mgtv.mq.storePath";

        String MQ_SITE_ID          = "mgtv.mq.siteId";

        String IMG_URL             = "mgtv.img.url";

        String IMG_STOREPATH       = "mgtv.img.storePath";

        String MEDIA_FTP_PREFIX    = "mgtv.media.ftp.prefix";

        String MEDIA_FTP_STOREPATH = "mgtv.media.ftp.storePath";

        String IMG_FTP_PREFIX      = "mgtv.img.ftp.prefix";

        /**
         * FTP方式，自定义还是专线方式
         */
        String MEDIA_TRANSFERTYPE  = "mgtv.transferType";

    }

    /**
     * IPTV 配置常量定义
     */
    interface IPTV {

        /**
         * LSP WS服务地址
         */
        String NOTIFY_URL      = "iptv.ws.url";

        /**
         * CSP定义标识
         */
        String CSPID           = "iptv.cspId";

        /**
         * LSP定义标识
         */
        String LSPID           = "iptv.lspId";

        /**
         * soap消息存储路径
         */
        String STORE_PATH      = "iptv.storePath";

        /**
         * FTP前缀
         */
        String FTP_PREFIX      = "iptv.ftp.prefix";

        String OBJ_TYPE_SERIES = "iptv.objecType.series";

        String OBJ_TYPE_MOVICE = "iptv.objecType.movice";

        String CPCODE          = "iptv.cpCode";

        String VERSIONCODE     = "iptv.versionCode";
    }

    interface Values {

        /**
         * 自定义传输方式即：下载到FTP
         */
        int CUSTOMFTP_TRANSFERTYPE = 1;

        /**
         * 芒果专线方式
         */
        int SPECIAL_TRANSFERTYPE   = 2;
    }
}
