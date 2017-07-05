package com.ylg.workspace.workspace.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ylg.workspace.workspace.adapter.ListViewAdapter01_InfoActivity;

/**
 * Created by stu on 2017/7/3.
 */

public class SetSpaceListViewItemHeight {//

    public static void setHeight(ListView listView) {
        ListViewAdapter01_InfoActivity listAdapter = (ListViewAdapter01_InfoActivity) listView.getAdapter();
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
