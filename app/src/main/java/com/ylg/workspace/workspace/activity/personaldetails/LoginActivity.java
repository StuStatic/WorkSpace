package com.ylg.workspace.workspace.activity.personaldetails;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.country.CountryActivity;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.http.MD5;
import com.ylg.workspace.workspace.http.bean.Login;

import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends App implements View.OnClickListener {

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
    private boolean is = true;
    private ProgressDialog progressDialog;

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
        look_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_finsh://关闭界面
                finish();
                break;
            case R.id.login_bt://登陆
                String phone = loginphone.getText().toString();
                String password = loginpassword.getText().toString();
                Log.i("dyy", phone + password);
                if (phone.length() == 11) {
                    if (password.length() == 6) {
                        login(phone, password);
                    } else {
                        showCustomToast("请输入正确的密码");
                    }
                } else {
                    showCustomToast("请输入正确的账号");
                }

                break;
            case R.id.login_look_password://查看密码
                if (is) {
                    is = false;
                    loginpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    is = true;
                    loginpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.login_country_rl://国家区号的选择
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, CountryActivity.class);
                startActivityForResult(intent, 12);
                break;
            case R.id.login_register_bt://注册
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.login_forgot_password://忘记密码

                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 12:
                if (resultCode == RESULT_OK) {
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

    //登陆
    private void login(final String phone, final String password) {
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("正在加载......");
        progressDialog.show();
        HttpAPI httpAPI = Http.getInstance().create(HttpAPI.class);
        try {
            final String md5 = MD5.getMD5(password);
            httpAPI.login(phone, md5).enqueue(new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    Login body = response.body();
                    if (body == null) return;
                    String code = body.getCode();
                    if (code.equals("200")) {
                        if (body.getMsg().getPassword().equals(md5)) {
                            App.KEY_LOGIN = 2;
                            input(phone,password);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("headPortrait", body.getMsg().getHeadPortrait());//头像地址
                            bundle.putSerializable("realName", body.getMsg().getRealName());//用户名字
                            bundle.putSerializable("sex", body.getMsg().getSex());//用户性别
                            bundle.putSerializable("username", body.getMsg().getUserName());//用户名称
                            bundle.putSerializable("spared1", body.getMsg().getSpared1());
                            bundle.putSerializable("industry", body.getMsg().getIndustry());//行业
                            bundle.putSerializable("site", body.getMsg().getIndustry());//收货地址
                            bundle.putSerializable("constellation", body.getMsg().getConstellation());//星座
                            bundle.putSerializable("companyId", body.getMsg().getCompanyId());//企业ID

                            bundle.putSerializable("skill", body.getMsg().getSkill());//技能（先不用）
                            bundle.putSerializable("interest", body.getMsg().getSkill());//兴趣（先不用）

                            input1(body.getMsg().getHeadPortrait(),body.getMsg().getRealName(),body.getMsg().getSex(),body.getMsg().getUserName(),body.getMsg().getSpared1(),body.getMsg().getIndustry(),body.getMsg().getSite(),body.getMsg().getSkill(),body.getMsg().getInterest(),body.getMsg().getConstellation(),body.getMsg().getCompanyId());
                            App.USER_ID = body.getMsg().getUserId();
                            Intent i = new Intent();
                            i.putExtras(bundle);
                            setResult(1, i);
                            progressDialog.dismiss();
                            Log.i("dyy", "登陆：" + body.getMsg().toString());
                            finish();
                        }
                    } else if (code.equals("500")) {
                        showCustomToast("账号/密码错误");
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    Log.i("dyy", t.toString());
                    progressDialog.dismiss();
                    showCustomToast("登陆失败");
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }

    /**
     * 存
     */
    private void input(String name,String password) {
        //第一个参数是文件名，第二个参数是模式（不明白可以去补习一下SharedPreferences的知识）
        SharedPreferences.Editor edit = getSharedPreferences("mypsd", MODE_PRIVATE).edit();
        edit.putString("name", name);
        edit.putString("psd", password);
        edit.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }
}

