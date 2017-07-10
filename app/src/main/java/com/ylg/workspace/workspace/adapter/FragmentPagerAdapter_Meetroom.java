package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by stu on 2017/7/10.
 */

public class FragmentPagerAdapter_Meetroom extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"今天","明天","其他日期"};
    private Context context;
    private List<Fragment> fragmentList;

    public FragmentPagerAdapter_Meetroom(FragmentManager fm, Context context, List<Fragment> fragmentList) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {

        return  fragmentList.get(position);
    }

    @Override
    public int getCount() {

        return fragmentList.size();

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }
}
