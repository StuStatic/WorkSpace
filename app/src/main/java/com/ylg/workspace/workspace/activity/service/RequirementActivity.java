package com.ylg.workspace.workspace.activity.service;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.service.bean.Service;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.view.IphoneDialog;
import com.ylg.workspace.workspace.view.tag.Tag;
import com.ylg.workspace.workspace.view.tag.TagListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequirementActivity extends App implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv;
    private final String[] titles = {"政策服务-政策资讯", "金融-理财服务", "法律-法律咨询", "人力资源-雇主品牌", "财税-财务审计"};
    private TagListView tlv;
    private final List<Tag> mTags = new ArrayList<Tag>();
    private EditText et;
    private Button button;
    private IphoneDialog iphoneDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirement);
        initView();
    }

    private void initView() {
        iphoneDialog = new IphoneDialog(this);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("发布需求");
        tlv = (TagListView) findViewById(R.id.tlv);
        et = (EditText) findViewById(R.id.et);
        button = (Button) findViewById(R.id.button);
        setUpDataInterest();
        tlv.setTags(mTags);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void setUpDataInterest() {
        for (int i = 0; i < 5; i++) {
            Tag tag = new Tag();
            tag.setId(i);
            tag.setChecked(true);
            tag.setTitle(titles[i]);
            mTags.add(tag);
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
                Toast.makeText(RequirementActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.removeActivity(this);
    }
}
