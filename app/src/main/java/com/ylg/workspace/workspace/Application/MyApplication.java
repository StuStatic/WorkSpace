package com.ylg.workspace.workspace.Application;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.QueuedWork;

/**
 * Created by Administrator on 2017/7/13.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        QueuedWork.isUseThreadPool = false;
        UMShareAPI.get(this);
    }

    {
        PlatformConfig.setWeixin("wxa8ea2d93af90c99d", "0f4410167040301eb559643e63f68080");
        PlatformConfig.setQQZone("101415512", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("958434094", "c8126f4af61b6287bd2ce86a54360e7f", "http://sns.whalecloud.com");
    }
}
