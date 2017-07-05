package com.ylg.workspace.workspace.Application;

import android.Manifest;

/**
 * Created by Administrator on 2017/1/17.
 */

public class Constants {

    /**
     * 位置信息权限请求标志
     */
    public static final int QUEST_CODE_LOCTION = 1;
    /**
     * 发送短信权限请求标志
     */
    public static final int QUEST_CODE_SEND_SMS = 2;
    /**
     * 摄像头权限标志
     */
    public static final int QUEST_CODE_CAMERA = 3;
    /**
     * 批量请求权限
     */
    public static final int QUEST_CODE_ALL = 4;
    /**
     * 拨打电话权限
     */
    public static final int QUEST_CODE_CALL_PHONE = 5;
    //拍照，相册
    public static final String[] permArray = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};
}
