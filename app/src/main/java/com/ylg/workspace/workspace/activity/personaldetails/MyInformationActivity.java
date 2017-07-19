package com.ylg.workspace.workspace.activity.personaldetails;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.view.tag.Tag;
import com.ylg.workspace.workspace.view.tag.TagListView;

import java.util.ArrayList;
import java.util.List;

public class MyInformationActivity extends App implements View.OnClickListener{
    private ImageView iv_back,information_user_Headportrait,information_user_sex;
    private TextView tv_title,information_user_constellation,information_user_name,information_delivery_industry_tv,information_delivery_personalizedsignature_tv;
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

        information_user_Headportrait = (ImageView) findViewById(R.id.information_user_Headportrait);
        information_user_sex = (ImageView) findViewById(R.id.information_user_sex);
        information_user_constellation = (TextView) findViewById(R.id.information_user_constellation);
        information_user_name = (TextView) findViewById(R.id.information_user_name);
        information_delivery_industry_tv = (TextView) findViewById(R.id.information_delivery_industry_tv);
        information_delivery_personalizedsignature_tv = (TextView) findViewById(R.id.information_delivery_personalizedsignature_tv);
    }

    @Override
    protected void onStart() {
        super.onStart();
        out();
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
    private void out(){
        //第一个参数是文件名，第二个参数是模式（不明白可以去补习一下SharedPreferences的知识）
        SharedPreferences shared = getSharedPreferences("mypsd2", MODE_PRIVATE);
        //第一个参数就是关键字，第二个参数为默认值，意思是说如果没找到值就用默认值代替
        String headPortrait = shared.getString("headPortrait", "");//同上，若没找到就让它为空""头像地址
        String sex = shared.getString("sex", "");//同上，若没找到就让它为空""用户性别
        String username = shared.getString("username", "");//同上，若没找到就让它为空""用户名称
        String spared1 = shared.getString("spared1", "");//同上，若没找到就让它为空""

        String industry = shared.getString("industry", "");//同上，若没找到就让它为空""行业
        String constellation = shared.getString("constellation", "");//同上，若没找到就让它为空""星座

        String skill = shared.getString("skill", "");//同上，若没找到就让它为空""技能（先不用）
        String interest = shared.getString("interest", "");//同上，若没找到就让它为空""兴趣（先不用）

        information_user_constellation.setText(constellation);
        if (headPortrait.length() != 0) {
            Glide.with(this)
                    .load(Http.API_URL + headPortrait)
                    .placeholder(R.drawable.my_head_icon)
                    .error(R.drawable.my_head_icon)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .crossFade()
                    .into(information_user_Headportrait);
        } else {
            information_user_Headportrait.setImageResource(R.drawable.my_head_icon);
        }
        information_user_name.setText(username);
        if (sex.equals("man")) {
            information_user_sex.setImageResource(R.drawable.maniconno);
        } else {
            information_user_sex.setImageResource(R.drawable.girliconno);
        }
        information_delivery_personalizedsignature_tv.setText(spared1);
        information_delivery_industry_tv.setText(industry);
    }











}
