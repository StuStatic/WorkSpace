package com.ylg.workspace.workspace.activity.personaldetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.country.CountryActivity;

public class LoginActivity extends App implements View.OnClickListener{

    private ImageView look_password;
    private TextView logincountry;
    private TextView loginfinsh;
    private RelativeLayout logincountryrl;
    private TextView loginphoneareacode;
    private EditText loginphone;
    private EditText loginpassword;
    private TextView loginforgotpassword;
    private Button loginbt;
    private Button loginregisterbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize() {
        look_password = (ImageView) findViewById(R.id.login_look_password);
        logincountry = (TextView) findViewById(R.id.login_country);
        loginfinsh = (TextView) findViewById(R.id.login_finsh);
        logincountryrl = (RelativeLayout) findViewById(R.id.login_country_rl);
        loginphoneareacode = (TextView) findViewById(R.id.login_phone_area_code);
        loginphone = (EditText) findViewById(R.id.login_phone);
        loginpassword = (EditText) findViewById(R.id.login_password);
        loginforgotpassword = (TextView) findViewById(R.id.login_forgot_password);
        loginbt = (Button) findViewById(R.id.login_bt);
        loginregisterbt = (Button) findViewById(R.id.login_register_bt);

        loginfinsh.setOnClickListener(this);
        loginbt.setOnClickListener(this);
        logincountryrl.setOnClickListener(this);
        loginregisterbt.setOnClickListener(this);
        loginforgotpassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_finsh://关闭界面
                finish();
                break;
            case R.id.login_bt://登陆

                break;
            case R.id.login_look_password://查看密码
                showCustomToast("暂未开放");
                break;
            case R.id.login_country_rl://国家区号的选择
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, CountryActivity.class);
                startActivityForResult(intent, 12);
                break;
            case R.id.login_register_bt://注册

                break;
            case R.id.login_forgot_password://忘记密码

                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 12:
                if (resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    String countryName = bundle.getString("countryName");
                    String countryNumber = bundle.getString("countryNumber");
                    logincountry.setText(countryName);
                    loginphoneareacode.setText(countryNumber);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }
}

