package com.ylg.workspace.workspace.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;

public class HtmlActivity extends App implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv;
    private ShareAction mShareAction;
    private WebView wb;
    private ImageView iv;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_html);
        initView();
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv_intent);
        iv.setImageResource(R.mipmap.share);
        wb = (WebView) findViewById(R.id.wv);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("访客预约");
        iv.setOnClickListener(this);
        url = getIntent().getStringExtra("htmlURL");

        wb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        wb.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        wb.getSettings().setSupportZoom(false);//是否可以缩放，默认true
        wb.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        wb.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        wb.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        wb.getSettings().setAppCacheEnabled(true);//是否使用缓存
        wb.getSettings().setDomStorageEnabled(true);//DOM Storage
        wb.loadUrl(url);
        wb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);   //在当前的webview中跳转到新的url
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_intent:
                showCustomToast("aaa");
//                ShareBoardConfig config = new ShareBoardConfig();
//                config.setMenuItemBackgroundShape(ShareBoardConfig.BG_SHAPE_NONE);
//                mShareAction.open(config);
                UMWeb web = new UMWeb("http://www.baidu.com");
                web.setTitle("This is music title");//标题
                web.setThumb(new UMImage(HtmlActivity.this, R.mipmap.ic_launcher));  //缩略图
                web.setDescription("my description");//描述
//                new ShareAction(HtmlActivity.this).withText("hello")
//                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN_CIRCLE,SHARE_MEDIA.WEIXIN)
//                        .setCallback(umShareListener).open();

                new ShareAction(HtmlActivity.this).withMedia(web).
                        setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(HtmlActivity.this, platform + " 分享成功", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(HtmlActivity.this, platform + " 分享失败", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(HtmlActivity.this, platform + " 分享取消", Toast.LENGTH_SHORT).show();
        }
    };

    // 设置回退
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wb.canGoBack()) {
            wb.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
