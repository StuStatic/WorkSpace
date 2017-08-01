package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.fragment.TabFragment_SpaceListActivity;

/**
 * Created by stu on 2017/7/16.
 */

public class TabAdapter_SpaceListActivity extends FragmentPagerAdapter {
    private String[] names;
    private Context context;

    public TabAdapter_SpaceListActivity(FragmentManager fm, String[] names,Context context) {
        super(fm);
        this.context = context;
        this.names = names;

    }


    @Override
    public Fragment getItem(int position) {
        return TabFragment_SpaceListActivity.getInstance(position);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return names[position];
    }

    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_spacelisttab,null);
        TextView textView = (TextView)view.findViewById(R.id.tv_spacelisttab);
        textView.setText(names[position]);
        return  view;
    }
}
