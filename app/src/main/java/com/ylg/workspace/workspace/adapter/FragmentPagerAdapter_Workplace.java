package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ylg.workspace.workspace.fragment.TodayFragment;

/**
 * Created by stu on 2017/7/4.
 */

public class FragmentPagerAdapter_Workplace extends FragmentPagerAdapter{
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"今天","明天","其他日期"};
    private Context context;

    public FragmentPagerAdapter_Workplace(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return TodayFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
