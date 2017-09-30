package com.ylg.workspace.workspace.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.ballgraph.CircleActivity;
import com.ylg.workspace.workspace.adapter.FragmentPagerAdapter_SocialFragment;
import com.ylg.workspace.workspace.util.Dp2Px;

import java.util.ArrayList;
import java.util.List;


public class SocialFragment extends Fragment implements View.OnClickListener {
    /**
     * @author stu
     * writen by stu on 2017/7/19
     */
    private View view;
    private TextView tv_title;
    private ImageView img_back, img_add;
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
        img_back = (ImageView) view.findViewById(R.id.iv_back);
        //初始化标题
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        //初始化添加按钮
        img_add = (ImageView) view.findViewById(R.id.iv_intent);
        //返回键设置不可见
        img_back.setVisibility(View.GONE);
        //设置标题文字
        tv_title.setText("移动客户端");
        //设置添加按钮图片
        img_add.setImageResource(R.drawable.addpic);
        //添加按钮绑定监听
        img_add.setOnClickListener(this);

        //初始化tablayout
        tab = (TabLayout) view.findViewById(R.id.tab_social);
        /**
         * @author stu爸爸
         * 注：此步骤很牛逼
         */
        LinearLayout linearLayout = (LinearLayout) tab.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getContext(), R.drawable.tab_socialfragment));
        linearLayout.setDividerPadding(Dp2Px.dp2px(getContext(), 15));
        //初始化viewpagerl
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_social);

        //初始化fragment
        neiborFragment = new NeiborCompany_SocialFragment();
        circleFragment = new RecentCircle_SocialFragment();
        marketFragment = new SpaceMarket_SocialFragment();

        //初始化list集合
        fragmentList = new ArrayList<>();
        //将fragment加入集合
        fragmentList.add(circleFragment);
        fragmentList.add(neiborFragment);
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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_intent:
                startActivity(new Intent(getActivity(), CircleActivity.class));
                break;
        }
    }
}
