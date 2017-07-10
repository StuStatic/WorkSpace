package com.ylg.workspace.workspace.activity.personaldetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;

public class CreateEnterpriseActivity extends App implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private RelativeLayout mName;
    private RelativeLayout mLogo;
    private RelativeLayout mType;
    private RelativeLayout mContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_create_enterprise);
        initView();

    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("创建企业");
        mLogo = (RelativeLayout) findViewById(R.id.createEnterprise_logo);
        mName = (RelativeLayout) findViewById(R.id.createEnterprise_name);
        mType = (RelativeLayout) findViewById(R.id.createEnterprise_type);
        mContacts = (RelativeLayout) findViewById(R.id.createEnterprise_contacts);
        mLogo.setOnClickListener(this);
        mName.setOnClickListener(this);
        mType.setOnClickListener(this);
        mContacts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back://退出
                finish();
                break;
            case R.id.createEnterprise_logo://LOGO的选择

                break;
            case R.id.createEnterprise_name://企业名称

                break;
            case R.id.createEnterprise_type://企业类型

                break;
            case R.id.createEnterprise_contacts://联系人

                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }


}
