package com.ylg.workspace.workspace.activity.personaldetails;

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

public class MyInformationActivity extends App implements View.OnClickListener{
    private ImageView iv_back;
    private TextView tv_title;
    private TagListView mTagListView,mTagListInterest;
    private final List<Tag> mTagsSkill = new ArrayList<Tag>();
    private final List<Tag> mTags = new ArrayList<Tag>();
    private final String[] titlesSkill = { "产品设计","移动开发" };
    private final String[] titlesInterest = { "设计","旅游","美食","宠物","人像素描","电影录像" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.addActivity(this);
        setContentView(R.layout.activity_my_information);
        init();
    }

    private void init() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("个人资料");
        mTagListView = (TagListView) findViewById(R.id.information_tag_skill);
        setUpDataSkill();
        mTagListView.setTags(mTagsSkill);

        mTagListInterest = (TagListView) findViewById(R.id.information_tag_interest);
        setUpDataInterest();
        mTagListInterest.setTags(mTags);
    }

    private void setUpDataInterest() {
        for (int i = 0; i < 6; i++) {
            Tag tag = new Tag();
            tag.setId(i);
            tag.setChecked(true);
            tag.setTitle(titlesInterest[i]);
            mTags.add(tag);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.removeActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
    private void setUpDataSkill() {
        for (int i = 0; i < 2; i++) {
            Tag tag = new Tag();
            tag.setId(i);
            tag.setChecked(true);
            tag.setTitle(titlesSkill[i]);
            mTagsSkill.add(tag);
        }
    }

}
