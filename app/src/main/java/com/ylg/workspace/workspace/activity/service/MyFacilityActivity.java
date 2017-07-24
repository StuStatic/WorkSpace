package com.ylg.workspace.workspace.activity.service;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.view.SlideButton;

public class MyFacilityActivity extends App implements View.OnClickListener{

    private TextView tvtitle;
    private ImageView iv_back;
    private SlideButton sbt1;
    private SlideButton sbt2;
    private SlideButton sbt3;
    private LinearLayout ll_kongtiao;
    private LinearLayout ll_chuanglian;
    private LinearLayout ll_light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_facility);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tvtitle = (TextView) findViewById(R.id.tv_title);
        tvtitle.setText("我的设备");
        iv_back.setOnClickListener(this);
        sbt1 = (SlideButton) findViewById(R.id.sbt1);
        sbt2 = (SlideButton) findViewById(R.id.sbt2);
        sbt3 = (SlideButton) findViewById(R.id.sbt3);
        ll_kongtiao = (LinearLayout) findViewById(R.id.ll_kongtiao);
        ll_chuanglian = (LinearLayout) findViewById(R.id.ll_chuanglian);
        ll_light = (LinearLayout) findViewById(R.id.ll_light);
        sbt1.setOnSlideButtonClickListener(new SlideButton.OnSlideButtonClickListener() {
            @Override
            public void onClicked(boolean isChecked) {
                if (isChecked){
                    ll_kongtiao.setVisibility(View.VISIBLE);
                }else {
                    ll_kongtiao.setVisibility(View.GONE);
                }
            }
        });
        sbt2.setOnSlideButtonClickListener(new SlideButton.OnSlideButtonClickListener() {
            @Override
            public void onClicked(boolean isChecked) {
                if (isChecked){
                    ll_chuanglian.setVisibility(View.VISIBLE);
                }else {
                    ll_chuanglian.setVisibility(View.GONE);
                }
            }
        });
        sbt3.setOnSlideButtonClickListener(new SlideButton.OnSlideButtonClickListener() {
            @Override
            public void onClicked(boolean isChecked) {
                if (isChecked){
                    ll_light.setVisibility(View.VISIBLE);
                }else {
                    ll_light.setVisibility(View.GONE);
                }
            }
        });
    }
}
