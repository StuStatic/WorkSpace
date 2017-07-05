package com.ylg.workspace.workspace.activity.ballgraph;

//import android.support.design.widget.TabLayout;
//import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.FragmentPagerAdapter_Workplace;

public class WorkplaceOrderActivity extends AppCompatActivity {
    //toolbar标题文字内容
    private TextView title_tv;
    //adapter
    private FragmentPagerAdapter_Workplace pagerAdapter;
    //viewpager
    private ViewPager viewPager;
    //tablayout
//    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workplaceorder);
        init();
    }

    private void init() {
        //初始化标题
        title_tv = (TextView)findViewById(R.id.tv_title);
        title_tv.setText("订工位");
        //初始化adapter
        pagerAdapter = new FragmentPagerAdapter_Workplace(getSupportFragmentManager(), this);
//        viewPager = (ViewPager) findViewById(R.id.workplace_viewpager);
//        viewPager.setAdapter(pagerAdapter);
//        tabLayout = (TabLayout) findViewById(R.id.workplace_tabs);
//        tabLayout.setupWithViewPager(viewPager);
//        //设置为MODE_SCROLLABLE,tab会集中在左侧
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}
