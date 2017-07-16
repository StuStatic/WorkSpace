package com.ylg.workspace.workspace.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ylg.workspace.workspace.fragment.TabFragment_SpaceList;

/**
 * Created by stu on 2017/7/16.
 */

public class TabAdapter_SpaceListActivity extends FragmentPagerAdapter {
    private String[] names;

    public TabAdapter_SpaceListActivity(FragmentManager fm, String[] names) {
        super(fm);
        this.names = names;
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment_SpaceList.getInstance(position);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return names[position];
    }
}
