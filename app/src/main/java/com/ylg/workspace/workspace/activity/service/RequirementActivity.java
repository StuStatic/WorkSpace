package com.ylg.workspace.workspace.activity.service;

import android.content.Intent;
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
    //private final String[] titles = {"政策服务-政策资讯", "金融-理财服务", "法律-法律咨询", "人力资源-雇主品牌", "财税-财务审计"};
    private TagListView tlv;
    private final List<Tag> mTags = new ArrayList<Tag>();
    private EditText et;
    private Button button;
    private IphoneDialog iphoneDialog;
    private LinearLayout ll;
    private final List<String> list = new ArrayList<>();
    // private List<Integer> index = new ArrayList<>();
    private String index = "";
    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirement);
        initView();
    }

    private void initView() {
        iphoneDialog = new IphoneDialog(this);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        ll = (LinearLayout) findViewById(R.id.ll);
        iv_back.setOnClickListener(this);
        ll.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("发布需求");
        tlv = (TagListView) findViewById(R.id.tlv);
        et = (EditText) findViewById(R.id.et);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
//        setUpDataInterest();
//        tlv.setTags(mTags);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data != null) {
//                Bundle bundle = data.getExtras();
//                if (bundle != null) {
                String result = data.getStringExtra("service");
                text = text + result + ",";
                int i = data.getIntExtra("index", 0);
                index = index + i + ",";
                showShortMsg(result);
                list.add(result);
                //handler.sendEmptyMessage(0);
                setUpDataInterest();
                tlv.setTags(mTags);
                list.clear();

                //}
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll:
                if (mTags.size() > 5) {
                    showShortMsg("最多选择6项");
                    return;
                }
                startActivityForResult(new Intent(RequirementActivity.this, ChooseServiceActivity.class), 0);
                break;
            case R.id.button:
                String string = et.getText().toString().trim();
                if (string.equals("") || mTags.size() < 1) {
                    showShortMsg("还有未填写信息");
                    return;
                }
                getData("1", String.valueOf(App.USER_ID), string, split(index), split(text));
                break;
        }
    }

    private void setUpDataInterest() {
        for (int i = 0; i < list.size(); i++) {
            Tag tag = new Tag();
            tag.setId(i);
            tag.setChecked(true);
            tag.setTitle(list.get(i));
            mTags.add(tag);
        }
    }

    private String split(String s) {
        String s1 = s.substring(0, s.length() - 2);
        Log.d("zp", "split: " + s1);
        return s1;
    }

    private void getData(String spaceId, String userId, String describe, String facilitatorType, String facilitatorLabel) {

        HttpAPI httpAPI = Http.getInstance().create(HttpAPI.class);
        httpAPI.postRequirement(spaceId, userId, describe, facilitatorType, facilitatorLabel).enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {
                iphoneDialog.dismiss();
                Service service = response.body();
                Log.e("zp", "aaaaaaaaa" + service.toString());
                if (service.getCode().equals("200")) {
                    showShortMsg("提交成功");
                    finish();
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
