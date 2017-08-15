package com.ylg.workspace.workspace.Application;

import android.app.Application;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.QueuedWork;


public class MyApplication extends Application {
    private IWXAPI api;
    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        QueuedWork.isUseThreadPool = false;
        UMShareAPI.get(this);
        api = WXAPIFactory.createWXAPI(this, App.App_ID);
    }

    {
        PlatformConfig.setWeixin("wxa41b37164b2030d6", "04e9bd9923b67ea9bf687ad1c8d91051");
        PlatformConfig.setQQZone("101415512", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("958434094", "c8126f4af61b6287bd2ce86a54360e7f", "http://sns.whalecloud.com");
    }
}
