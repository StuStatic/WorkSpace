package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;

import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.FragmentPagerAdapter_SocialFragment;

import java.util.ArrayList;
import java.util.List;


public class SocialFragment extends Fragment implements View.OnClickListener {
    /**
     * @author stu
     * writen by stu on 2017/7/19
     */
    private View view;
    private TextView tv_title;
    private ImageView img_back ,img_add;
    private TabLayout tab;
    private ViewPager viewPager;
    private NeiborCompany_SocialFragment neiborFragment;
    private RecentCircle_SocialFragment circleFragment;
    private SpaceMarket_SocialFragment marketFragment;
    private List<Fragment> fragmentList;
    private FragmentPagerAdapter_SocialFragment adapter;

    public SocialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_social, container, false);
        init();
        return view;
    }

    private void init() {
        initView();

        initData();
    }



    private void initView() {
        //初始化返回键
        img_back = (ImageView)view.findViewById(R.id.iv_back);
        //初始化标题
        tv_title=(TextView)view.findViewById(R.id.tv_title);
        //初始化添加按钮
        img_add=(ImageView)view.findViewById(R.id.iv_intent);

        //初始化tablayout
        tab = (TabLayout) view.findViewById(R.id.tab_social);
        //初始化viewpager
        viewPager=(ViewPager)view.findViewById(R.id.viewpager_social);

        //初始化fragment
        neiborFragment = new NeiborCompany_SocialFragment();
        circleFragment = new RecentCircle_SocialFragment();
        marketFragment = new SpaceMarket_SocialFragment();

        //初始化list集合
        fragmentList = new ArrayList<>();
        //将fragment加入集合
        fragmentList.add(neiborFragment);
        fragmentList.add(circleFragment);
        fragmentList.add(marketFragment);

        //初始化adapter
        adapter = new FragmentPagerAdapter_SocialFragment(getChildFragmentManager(), fragmentList);
        //绑定适配器
        viewPager.setAdapter(adapter);
//        tabLayout绑定viewpager
        tab.setupWithViewPager(viewPager);
        //设置为MODE_SCROLLABLE,tab会集中在左侧
        tab.setTabMode(TabLayout.MODE_FIXED);
    }

    private void initData() {
        //返回键设置不可见
        img_back.setVisibility(View.GONE);
        //设置标题文字
        tv_title.setText("移动客户端");
        //设置添加按钮图片
        img_add.setImageResource(R.drawable.addpic);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_intent:
                Toast.makeText(getContext(), "开始添加", Toast.LENGTH_SHORT).show();
        }
    }
}
