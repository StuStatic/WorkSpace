package com.ylg.workspace.workspace.activity.service;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;

public class FeedbackActivity extends App implements View.OnClickListener{

    private ImageView iv_back;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("意见反馈");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;

        }
    }
}
