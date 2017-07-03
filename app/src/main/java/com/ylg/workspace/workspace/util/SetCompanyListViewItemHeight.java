package com.ylg.workspace.workspace.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ylg.workspace.workspace.adapter.Adapter01_CircleGraph;
import com.ylg.workspace.workspace.adapter.Adapter02_CircleGraph;

/**
 * Created by stu on 2017/7/3.
 */

public class SetCompanyListViewItemHeight {
    //手动设置item的高度（否则会与scrollview冲突，出现每个listview值显示一个item的情况）
    public static void setHeight(ListView listView) {
        Adapter02_CircleGraph listAdapter = (Adapter02_CircleGraph) listView.getAdapter();
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
