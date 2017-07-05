package com.ylg.workspace.workspace.activity.personaldetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.adapter.FragAdapter;
import com.ylg.workspace.workspace.activity.personaldetails.fragment.AllFragment;
import com.ylg.workspace.workspace.activity.personaldetails.fragment.CanceledFragment;
import com.ylg.workspace.workspace.activity.personaldetails.fragment.CompletedFragment;
import com.ylg.workspace.workspace.activity.personaldetails.fragment.PendingPaymentFragment;
import com.ylg.workspace.workspace.activity.personaldetails.fragment.PendingUseFragment;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends App implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv_title;
    private RadioButton checkButton1;
    private RadioButton checkButton2;
    private RadioButton checkButton3;
    private RadioButton checkButton4;
    private RadioButton checkButton5;
    private List<Fragment> mFragments = new ArrayList<>();
    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_my_activitys);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("我的活动");
        checkButton1 = (RadioButton) findViewById(R.id.checkButton1);
        checkButton2 = (RadioButton) findViewById(R.id.checkButton2);
        checkButton3 = (RadioButton) findViewById(R.id.checkButton3);
        checkButton4 = (RadioButton) findViewById(R.id.checkButton4);
        checkButton5 = (RadioButton) findViewById(R.id.checkButton5);
        checkButton1.setOnClickListener(this);
        checkButton2.setOnClickListener(this);
        checkButton3.setOnClickListener(this);
        checkButton4.setOnClickListener(this);
        checkButton5.setOnClickListener(this);
        checkButton1.setChecked(true);
        mFragments.add( new AllFragment());
        mFragments.add(new PendingPaymentFragment());
        mFragments.add(new PendingUseFragment());
        mFragments.add( new CompletedFragment());
        mFragments.add(new CanceledFragment());
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), mFragments);
        //设定适配器
        vp  = (ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
                    checkButton1.setChecked(true);
                }else if (position == 1){
                    checkButton2.setChecked(true);
                }else if (position == 2){
                    checkButton3.setChecked(true);
                }else if (position == 3){
                    checkButton4.setChecked(true);
                }else if (position == 4){
                    checkButton5.setChecked(true);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.checkButton1:
                vp.setCurrentItem(0);
                break;
            case R.id.checkButton2:
                vp.setCurrentItem(1);
                break;
            case R.id.checkButton3:
                vp.setCurrentItem(2);
                break;
            case R.id.checkButton4:
                vp.setCurrentItem(3);
                break;
            case R.id.checkButton5:
                vp.setCurrentItem(4);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }
}
