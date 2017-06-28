package com.ylg.workspace.workspace.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ylg.workspace.workspace.R;

public class WelcomeActivity extends AppCompatActivity {
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if(message.what==1) {
                //主线程跳转
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                //关闭本界面
                finish();
            }
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    //初始化控件
    private void init() {


        //延迟3s发送消息
        handler.sendEmptyMessageDelayed(1,3000);
    }


}
