package com.miri.blephone.mediainjector.iptv.c2.adi;

public interface ADIConstants {

    /**
     * 优先级[1~9]
     */
    String Priority = "8";

    interface ElementType {
        /**
         * 节目信息
         */
        String Program         = "Program";

        /**
         * 媒体内容信息
         */
        String Movie           = "Movie";

        /**
         * 演员信息
         */
        String Cast            = "Cast";

        /**
         * 演员角色信息
         */
        String CastRoleMap     = "CastRoleMap";

        /**
         * TV 频道信息
         */
        String Channel         = "Channel";

        /**
         * 频道物理参数信息
         */
        String PhysicalChannel = "PhysicalChannel";

        /**
         * TV 时刻表信息
         */
        String Schedule        = "Schedule";

        /**
         * 图片信息
         */
        String Picture         = "Picture";

        /**
         * 图片信息
         */
        String Category        = "Category";

        /**
         * 连续剧
         */
        String Series          = "Series";
    }

    interface Action {

        /**
         * 注册
         */
        String REGIST = "REGIST";

        /**
         * 更新
         */
        String UPDATE = "UPDATE";

        /**
         * 删除
         */
        String DELETE = "DELETE";
    }

    interface Result {
        int Sucess = 0;
        int FAIL   = 1;
    }

}
