package com.ylg.workspace.workspace.activity.service;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.view.tag.Tag;
import com.ylg.workspace.workspace.view.tag.TagListView;
import java.util.ArrayList;
import java.util.List;

public class RequirementActivity extends App implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv;
    private final String[] titles = {"政策服务-政策资讯", "金融-理财服务", "法律-法律咨询", "人力资源-雇主品牌", "财税-财务审计"};
    private TagListView tlv;
    private final List<Tag> mTags = new ArrayList<Tag>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirement);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("发布需求");
        tlv = (TagListView) findViewById(R.id.tlv);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.removeActivity(this);
    }
}
