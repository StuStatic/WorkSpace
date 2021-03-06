package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

//import com.ylg.workspace.workspace.fragment.TodayFragment_workplace;

import java.util.List;

/**
 * Created by stu on 2017/7/4.
 */

public class FragmentPagerAdapter_Workplace extends FragmentPagerAdapter{
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"今天","明天","其他日期"};
    private Context context;
    private List<Fragment> fragmentList;

    public FragmentPagerAdapter_Workplace(FragmentManager fm, Context context, List<Fragment> fragmentList) {
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
