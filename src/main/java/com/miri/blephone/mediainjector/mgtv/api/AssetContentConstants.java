package com.miri.blephone.mediainjector.mgtv.api;

public interface AssetContentConstants {

    /**
     * 点播
     */
    int ASSET_TYPE_VIDEO              = 1;

    int ASSET_TYPE_LIVE               = 2;

    /**
     * 明星
     */
    int ASSET_TYPE_STAR               = 3;

    /**
     * 集合
     */
    int ASSET_DESC_CLIP               = 1;

    /**
     * 分集
     */
    int ASSET_DESC_CLIPPART           = 2;

    /**
     * 文件
     */
    int ASSET_DESC_FILE               = 3;

    /**
     * 栏目
     */
    int ASSET_DESC_COLUMN             = 98;

    /**
     * 关系
     */
    int ASSET_DESC_CORRELATION        = 99;

    /**
     * 增加和修改
     */
    int ASSET_OPERATION_ADD_OR_UPDATE = 1;

    /**
     * 删除
     */
    int ASSET_OPERATION_DELETE        = 2;

    /**
     * 取消发布
     */
    int ASSET_OPERATION_CANCEL        = 3;

    interface Result {
        int Sucess = 1;
    }
}
