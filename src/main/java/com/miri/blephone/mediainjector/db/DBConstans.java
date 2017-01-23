package com.miri.blephone.mediainjector.db;

public interface DBConstans {

    interface MQMsgStatus {
        short INIT = 1;
        short PROCESSING = 2;
        short SUCESS = 3;
        short FAIL = 4;
        short REPEAT = 5;
    }

    interface AssetStatus {

        /**
         * 重复添加
         */
        int REPATE_ADD = -1;
        int INIT_ADD = 1;
        int UPDATE = 2;
        int DELETE = 3;
        int ADI_BUILD = 4;
        int ADI_DEPLOYED = 5;
        int INJECTED = 6;
        int INJECTED_FAIL = 7;
    }

    interface WsStatus {
        int INIT = 1;
        int SEND_SUCESS = 2;
        int SEND_FAIL = 3;
        int EXECUTE_SUCESS = 4;
        int EXECUTE_FAIL = 5;
        int INJECT_SUCESS = 6;
        int INJECT_FAIL = 7;
        int NOTIFY_SUCESS = 8;
        int NOTIFY_FAIL = 9;
    }

    interface PosterStatus {
        short NOT_DOWNLOAD = 0;
        short DOWNLOADED = 1;
    }

    interface Definition {

        /**
         * 2:高清
         */
        int HD = 2;
    }

    interface WsOpType {

        int REGIST = 1;
        int UPDATE = 2;
        int DELETE = 3;
    }

    interface FileDownload {

        int FAIL = -1;
        int NO = 1;
        int YES = 2;
        int DELETE = 3;
    }

    interface ImageType {

        int TRANSVERSE = 1;

        int VERTICAL = 1;
    }
}
