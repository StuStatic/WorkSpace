package com.ylg.workspace.workspace.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by stu on 2017/7/19.
 */

public class FragmentPagerAdapter_SocialFragment extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"最近的圈子","友邻企业","空间集市"};
    private Context context;
    private List<Fragment> fragmentList;
    public FragmentPagerAdapter_SocialFragment(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("getItem:",position+"");
        return  fragmentList.get(position);
    }

    @Override
    public int getCount() {
        Log.e("getCount:",fragmentList.size()+"");
        return fragmentList.size();

    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("getPageTitle:",position+"");
        return tabTitles[position];
    }
}
