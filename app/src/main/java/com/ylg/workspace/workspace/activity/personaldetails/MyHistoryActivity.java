package com.ylg.workspace.workspace.activity.personaldetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.adapter.FragAdapter;
import com.ylg.workspace.workspace.activity.personaldetails.fragment.DemandFragment;
import com.ylg.workspace.workspace.activity.personaldetails.fragment.FeedbackFragment;
import com.ylg.workspace.workspace.activity.personaldetails.fragment.RepairFragment;
import com.ylg.workspace.workspace.activity.personaldetails.fragment.makeAnAppointmentFragment;
import com.ylg.workspace.workspace.http.MD5;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MyHistoryActivity extends App implements View.OnClickListener{

    private ImageView iv_back;
    private TextView tv_title;
    private ImageView iv_intent;
    private RadioButton historycheckButton1;
    private RadioButton historycheckButton2;
    private RadioButton historycheckButton3;
    private RadioButton historycheckButton4;
    private ViewPager historyviewpager;
    private List<Fragment> mFragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.addActivity(this);
        setContentView(R.layout.activity_my_history);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        iv_intent = (ImageView) findViewById(R.id.iv_intent);
        iv_intent.setOnClickListener(this);
        iv_intent.setImageResource(R.drawable.message_reminder_icon);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("我的历史");

        historycheckButton1 = (RadioButton) findViewById(R.id.history_checkButton1);
        historycheckButton2 = (RadioButton) findViewById(R.id.history_checkButton2);
        historycheckButton3 = (RadioButton) findViewById(R.id.history_checkButton3);
        historycheckButton4 = (RadioButton) findViewById(R.id.history_checkButton4);
        historyviewpager = (ViewPager) findViewById(R.id.history_viewpager);
        historycheckButton1.setOnClickListener(this);
        historycheckButton2.setOnClickListener(this);
        historycheckButton3.setOnClickListener(this);
        historycheckButton4.setOnClickListener(this);

        historycheckButton1.setChecked(true);

        mFragments.add(new makeAnAppointmentFragment());
        mFragments.add(new RepairFragment());
        mFragments.add(new DemandFragment());
        mFragments.add(new FeedbackFragment());

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), mFragments);
        historyviewpager.setAdapter(adapter);
        historyviewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    historycheckButton1.setChecked(true);
                }else if (position == 1){
                    historycheckButton2.setChecked(true);
                }else if (position == 2){
                    historycheckButton3.setChecked(true);
                }else if (position == 3){
                    historycheckButton4.setChecked(true);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        App.removeActivity(this);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_intent:
              showCustomToast("暂未开放");
                break;
            case R.id.history_checkButton1:
                historyviewpager.setCurrentItem(0);
                break;
            case R.id.history_checkButton2:
                historyviewpager.setCurrentItem(1);
                break;
            case R.id.history_checkButton3:
                historyviewpager.setCurrentItem(2);
                break;
            case R.id.history_checkButton4:
                historyviewpager.setCurrentItem(3);
                break;
        }
    }

}
