package com.ylg.workspace.workspace.activity.ballgraph;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.FragmentPagerAdapter_Workplace;
import com.ylg.workspace.workspace.fragment.OtherDateFragment_meetroom;
import com.ylg.workspace.workspace.fragment.TodayFragment_meetroom;
import com.ylg.workspace.workspace.fragment.TomorrowFragment_meetroom;

import java.util.ArrayList;
import java.util.List;

public class MeetRoomOrderActivity extends AppCompatActivity implements View.OnClickListener{
    //左上角返回键
    private ImageView iv_back;
    //toolbar标题文字内容
    private TextView title_tv;
    //adapter
    private FragmentPagerAdapter_Workplace pagerAdapter;
    //viewpager
    private ViewPager viewPager;
    //tablayout
    private TabLayout tabLayout;
    //fragment
    private TodayFragment_meetroom todayFragment;
    private TomorrowFragment_meetroom tomorrowFragmentWorkplace;
    private OtherDateFragment_meetroom otherDateFragmentWorkplace;
    //初始化fragment集合
    private List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetroomorder);
        init();
    }

    private void init() {
        //初始化返回键
        iv_back = (ImageView)findViewById(R.id.iv_back);
        //返回键绑定监听
        iv_back.setOnClickListener(this);
        //初始化标题内容
        title_tv = (TextView)findViewById(R.id.tv_title);
        title_tv.setText("预定场地");

        //初始化viewpager
        viewPager = (ViewPager) findViewById(R.id.meetroom_viewpager);
        //初始化tablayout
        tabLayout = (TabLayout) findViewById(R.id.meetroom_tabs);

        //初始化fragment
        todayFragment = new TodayFragment_meetroom();
        tomorrowFragmentWorkplace = new TomorrowFragment_meetroom();
        otherDateFragmentWorkplace = new OtherDateFragment_meetroom();

        //初始化fragment集合
        fragmentList = new ArrayList<>();

        //将fragment加入集合
        fragmentList.add(todayFragment);
        fragmentList.add(tomorrowFragmentWorkplace);
        fragmentList.add(otherDateFragmentWorkplace);

        //初始化adapter
        pagerAdapter = new FragmentPagerAdapter_Workplace(getSupportFragmentManager(), this , fragmentList);
        //绑定适配器
        viewPager.setAdapter(pagerAdapter);
//        tabLayout绑定viewpager
        tabLayout.setupWithViewPager(viewPager);
        //设置为MODE_SCROLLABLE,tab会集中在左侧
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void onClick(View view) {
        //close the page
        finish();
    }
}
