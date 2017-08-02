package com.ylg.workspace.workspace.activity.personaldetails;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.shareboard.ShareBoardConfig;
import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.HtmlActivity;

public class SetUpActivity extends App implements View.OnClickListener{
    private TextView mTitle;
    private ImageView iv_back;
    private RelativeLayout set_up_personaldata,set_up_Logout,set_up_Notificationsettings,set_up_Setgesturepassword,set_up_Aboutthecreationspace;
    private RelativeLayout set_up_Contactus,set_up_Checkthenewversion,set_up_Modifypassword,set_up_ShareAPP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.addActivity(this);
        setContentView(R.layout.activity_set_up);
        init();
    }

    private void init() {
        mTitle = (TextView) findViewById(R.id.tv_title);
        mTitle.setText(R.string.set_up_title);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        set_up_personaldata = (RelativeLayout) findViewById(R.id.set_up_personaldata);
        set_up_personaldata.setOnClickListener(this);
        set_up_Contactus = (RelativeLayout) findViewById(R.id.set_up_Contactus);
        set_up_Contactus.setOnClickListener(this);
        set_up_Logout = (RelativeLayout) findViewById(R.id.set_up_Logout);
        set_up_Logout.setOnClickListener(this);
        set_up_Checkthenewversion = (RelativeLayout) findViewById(R.id.set_up_Checkthenewversion);
        set_up_Checkthenewversion.setOnClickListener(this);
        set_up_Notificationsettings = (RelativeLayout) findViewById(R.id.set_up_Notificationsettings);
        set_up_Notificationsettings.setOnClickListener(this);
        set_up_Modifypassword = (RelativeLayout) findViewById(R.id.set_up_Modifypassword);
        set_up_Modifypassword.setOnClickListener(this);
        set_up_Setgesturepassword = (RelativeLayout) findViewById(R.id.set_up_Setgesturepassword);
        set_up_Setgesturepassword.setOnClickListener(this);
        set_up_Aboutthecreationspace = (RelativeLayout) findViewById(R.id.set_up_Aboutthecreationspace);
        set_up_Aboutthecreationspace.setOnClickListener(this);
        set_up_ShareAPP = (RelativeLayout) findViewById(R.id.set_up_ShareAPP);
        set_up_ShareAPP.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.set_up_personaldata://个人资料
                startActivity(MyInformationActivity.class);
                break;
            case R.id.set_up_Notificationsettings://通知设置
                showShortMsg("暂未开通");
                break;
            case R.id.set_up_Modifypassword://修改密码
                showShortMsg("暂未开通");
                break;
            case R.id.set_up_Setgesturepassword://设置手势密码
                showShortMsg("暂未开通");
                break;
            case R.id.set_up_Aboutthecreationspace://关于易创客
                showShortMsg("暂未开通");
                break;
            case R.id.set_up_ShareAPP://分享APP
                UMWeb web = new UMWeb("http://m.pp.cn/detail.html?appid=7626884&ch_src=pp_dev&ch=default");
                web.setTitle("易创客APP");//标题
                web.setThumb(new UMImage(SetUpActivity.this, R.mipmap.ic_launcher));  //缩略图
                web.setDescription("易创客-由北京物联港科技发展有限公司根据自身优势为众创办公客户提供的一套系统");//描述
                new ShareAction(SetUpActivity.this).withMedia(web).
                        setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
                break;
            case R.id.set_up_Checkthenewversion://检查更新
                showShortMsg("暂未开通");
                break;
            case R.id.set_up_Contactus://联系我们
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-68467632-805"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.set_up_Logout://退出登陆
                App.KEY_LOGIN=1;
                input1("","","","","","","","","","","");
                input("","");
                finish();
                break;
        }
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);
            showShortMsg(platform + " 分享成功");
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            showShortMsg(platform + " 分享失败");
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            showShortMsg(platform + " 分享取消");
        }
    };



    @Override
    protected void onDestroy() {
        App.removeActivity(this);
        super.onDestroy();
    }
}
