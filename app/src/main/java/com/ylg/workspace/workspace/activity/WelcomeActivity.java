package com.ylg.workspace.workspace.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.http.MD5;
import com.ylg.workspace.workspace.http.bean.Login;

import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeActivity extends App {
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                //主线程跳转
//                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
//                startActivity(intent);
                output();
//                startActivity(MainActivity.class);
                //关闭本界面

            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.addActivity(this);
        setContentView(R.layout.activity_welcome);
        init();
    }

    //初始化控件
    private void init() {
        //延迟3s发送消息
        handler.sendEmptyMessageDelayed(1, 3000);
    }
    //登陆
    private void login(final String phone, final String password) {
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
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("headPortrait", body.getMsg().getHeadPortrait());//头像地址
                            bundle.putSerializable("realName", body.getMsg().getRealName());//用户名字
                            bundle.putSerializable("sex", body.getMsg().getSex());//用户性别
                            bundle.putSerializable("username", body.getMsg().getUserName());//用户名称
                            bundle.putSerializable("spared1", body.getMsg().getSpared1());
                            bundle.putSerializable("industry", body.getMsg().getIndustry());//行业
                            bundle.putSerializable("site", body.getMsg().getIndustry());//收货地址
                            bundle.putSerializable("constellation", body.getMsg().getConstellation());//收货地址

                            bundle.putSerializable("skill", body.getMsg().getSkill());//技能（先不用）
                            bundle.putSerializable("interest", body.getMsg().getSkill());//兴趣（先不用）
                            App.USER_ID = body.getMsg().getUserId();
                            App.COMPANY_ID = body.getMsg().getCompanyId();
                            input1(body.getMsg().getHeadPortrait(),body.getMsg().getRealName(),body.getMsg().getSex(),body.getMsg().getUserName(),body.getMsg().getSpared1(),body.getMsg().getIndustry(),body.getMsg().getSite(),body.getMsg().getSkill(),body.getMsg().getInterest(),body.getMsg().getConstellation());
                            Intent i = new Intent(WelcomeActivity.this,MainActivity.class);
                            i.putExtras(bundle);
                            startActivity(i);
                            Log.i("dyy", "登陆：" + body.getMsg().toString());
                            finish();
                        }
                    } else if (code.equals("500")) {
                        /**
                         * 7.13日 stu 修改 登录失败情况下 同样能跳转界面
                         * 7.19  DYY修改 使用框架跳转
                         */
                        showCustomToast("账号/密码错误");
                        startActivity(MainActivity.class);
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {

                    Log.i("dyy", t.toString());
                    showCustomToast("登陆失败");
                    /**
                     * 7.13日 stu 修改 登录失败情况下 同样能跳转界面
                     * 7.19  DYY修改 使用框架跳转
                     */
                    startActivity(MainActivity.class);
                    finish();
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    /**
     * 取
     */
    private void output() {
        //第一个参数是文件名，第二个参数是模式（不明白可以去补习一下SharedPreferences的知识）
        SharedPreferences shared = getSharedPreferences("mypsd", MODE_PRIVATE);
        //第一个参数就是关键字，第二个参数为默认值，意思是说如果没找到值就用默认值代替
        String name1 = shared.getString("name", "");//同上，若没找到就让它为空""
        String psd1 = shared.getString("psd", "");
        if (name1.length() != 0 && psd1.length() != 0 ){
            login(name1,psd1);
        }else {
            startActivity(MainActivity.class);
            Log.e("startActivity","startAcitivity");
            finish();
        }
    }




}
