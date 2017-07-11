package com.ylg.workspace.workspace.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ylg.workspace.workspace.adapter.ListViewAdapter02_InfoActivity;
import com.ylg.workspace.workspace.adapter.NeiborAdapter_Home;

/**
 * Created by stu on 2017/7/11.
 */

public class SetHomeListViewItemHeight {
    //手动设置item的高度（否则会与scrollview冲突，出现每个listview值显示一个item的情况）
    public static void setHeight(ListView listView) {
        NeiborAdapter_Home listAdapter = (NeiborAdapter_Home) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
