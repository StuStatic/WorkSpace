package com.ylg.workspace.workspace.activity.service;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.service.bean.Service;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.view.IphoneDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackActivity extends App implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv;
    private EditText et1;
    private EditText et2;
    private Button b;
    private IphoneDialog iphoneDialog;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initView();
    }

    private void initView() {
        iphoneDialog = new IphoneDialog(this);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("意见反馈");
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        b = (Button) findViewById(R.id.button);
        ll = (LinearLayout) findViewById(R.id.ll);
        b.setOnClickListener(this);
        ll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.button:

                String s1 = et1.getText().toString().trim();
                String s2 = et2.getText().toString().trim();
                if (s1.equals("") || s2.equals("")) {
                    showCustomToast("还有未填写信息");
                    return;
                }

                iphoneDialog.setMessage("请稍候...");
                iphoneDialog.show();
                getData("1", "1", "哈登", s2, s1, "0");
                break;
            case R.id.ll:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:13304520452"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;

        }
    }

    private void getData(String spaceId, String userId, String userName, String tel, String opinionContent, String spared1) {

        HttpAPI httpAPI = Http.getInstance().create(HttpAPI.class);
        httpAPI.feedBack(spaceId, userId, userName, tel, opinionContent, spared1).enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {
                iphoneDialog.dismiss();
                Service service = response.body();
                Log.e("zp", "aaaaaaaaa" + service.toString());
                if (service != null) {
                    showShortMsg(service.getResult());

                }
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                iphoneDialog.dismiss();
                Log.e("zp", t.toString());
                Toast.makeText(FeedbackActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
