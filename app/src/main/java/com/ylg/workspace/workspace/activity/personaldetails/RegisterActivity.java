package com.ylg.workspace.workspace.activity.personaldetails;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.country.CountryActivity;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.http.MD5;
import com.ylg.workspace.workspace.http.bean.Register;
import com.ylg.workspace.workspace.http.bean.SendVerify;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends App implements View.OnClickListener {

    private TextView registerfinsh;
    private TextView registercountry;
    private RelativeLayout registercountryrl;
    private TextView registerphoneareacode;
    private EditText registerphone;
    private EditText registerpassword;
    private EditText registerpassword2;
    private EditText registerverification;
    private Button registerverificationbutton;
    private Button registerbt;
    private TextView registeragreement;
    private CountDownTimer timer;
    private ProgressDialog progressDialog;
    private HttpAPI httpAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_register);
        initialize();
    }

    private void initialize() {
        httpAPI = Http.getInstance().create(HttpAPI.class);

        progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("正在加载......");

        registerfinsh = (TextView) findViewById(R.id.register_finsh);
        registercountry = (TextView) findViewById(R.id.register_country);
        registercountryrl = (RelativeLayout) findViewById(R.id.register_country_rl);
        registerphoneareacode = (TextView) findViewById(R.id.register_phone_area_code);
        registerphone = (EditText) findViewById(R.id.register_phone);
        registerpassword = (EditText) findViewById(R.id.register_password);
        registerpassword2 = (EditText) findViewById(R.id.register_password2);
        registerverification = (EditText) findViewById(R.id.register_verification);
        registerverificationbutton = (Button) findViewById(R.id.register_verification_button);
        registerbt = (Button) findViewById(R.id.register_bt);
        registeragreement = (TextView) findViewById(R.id.register_agreement);

        registerfinsh.setOnClickListener(this);
        registercountryrl.setOnClickListener(this);
        registerverificationbutton.setOnClickListener(this);
        registerbt.setOnClickListener(this);
        registeragreement.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_finsh://取消
                startActivity(LoginActivity.class);
                finish();
                break;
            case R.id.register_country_rl://国家选择器
                Intent intent = new Intent();
                intent.setClass(RegisterActivity.this, CountryActivity.class);
                startActivityForResult(intent, 12);
                break;
            case R.id.register_verification_button://获取验证码
                progressDialog.show();
                String phoneNot = registerphone.getText().toString();
                if (phoneNot.length() == 11) {
                    registerverificationbutton.setClickable(false);
                    //倒计时
                    timer = new CountDownTimer(60000, 10) {
                        public void onTick(long millisUntilFinished) {
                            registerverificationbutton.setText(millisUntilFinished / 1000 + "秒");
                        }

                        public void onFinish() {
                            registerverificationbutton.setText("发送验证码");
                            registerverificationbutton.setClickable(true);
                        }
                    };
                    timer.start();
                    //网络请求
                    httpAPI.sendVerify(phoneNot).enqueue(new Callback<SendVerify>() {
                        @Override
                        public void onResponse(Call<SendVerify> call, Response<SendVerify> response) {
                            SendVerify body = response.body();
                            if (body == null) return;
                            Log.i("dyy", body.getCode().toString());
                            if (body.getCode().equals("200")) {
                                Toast.makeText(RegisterActivity.this, "短信发送成功注意查收", Toast.LENGTH_SHORT).show();
                            } else if (body.getCode().equals("500")) {
                                Toast.makeText(RegisterActivity.this, "已有此用户", Toast.LENGTH_SHORT).show();
                            } else if (body.getCode().equals("400")) {
                                Toast.makeText(RegisterActivity.this, "短信发送失败", Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                        @Override
                        public void onFailure(Call<SendVerify> call, Throwable t) {
                            Log.i("dyy", t.toString());
                            progressDialog.dismiss();
                            showCustomToast("获取验证码失败");
                        }
                    });
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(this, "请输入手机号.......", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_bt://注册

                String phone = registerphone.getText().toString();
                String password1 = registerpassword.getText().toString();
                String password2 = registerpassword2.getText().toString();
                String verification = registerverification.getText().toString();

                if (phone.length() == 11) {
                    if (password1.length() > 0 && password1.length() >= 6 && password1.length() <= 12) {
                        if (password2.length() > 0 && password2.length() >= 6 && password2.length() <= 12 && password1.equals(password2)) {
                            if (verification.length() != 0) {
                                Register(phone, password1, verification);
                                Log.i("dyy", "注册");
                            } else {
                                Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "请输入正确的确认密码", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_agreement://协议
                Toast.makeText(this, "暂未开放......", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //注册
    private void Register(String phone, String password, String verification) {
        progressDialog.show();
        Log.i("dyy", "注册：" + phone + "==" + verification);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        Log.i("dyy", "系统当前时间：" + format);
        try {
            String password1 = MD5.getMD5(password);
            httpAPI.register(phone, password1, "0", format, "0", verification).enqueue(new Callback<Register>() {
                @Override
                public void onResponse(Call<Register> call, Response<Register> response) {
                    Register body = response.body();
                    if (body == null) return;
                    String code = body.getCode();
                    progressDialog.dismiss();
                    if (code.length() == 0) return;
                    if (code.equals("200")) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    } else if (code.equals("500")) {
                        Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<Register> call, Throwable t) {
                    Log.i("dyy", t.toString());
                    progressDialog.dismiss();
                    showCustomToast("获取验证码失败");
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
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
                    registercountry.setText(countryName);
                    registerphoneareacode.setText(countryNumber);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
        if (timer != null) {
            timer.cancel();
        }
    }


}
