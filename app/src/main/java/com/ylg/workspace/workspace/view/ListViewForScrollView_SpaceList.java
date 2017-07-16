package com.ylg.workspace.workspace.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by stu on 2017/7/16.
 */

public class ListViewForScrollView_SpaceList extends ListView {
    //    public ListViewForScrollView_SpaceList(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    /**
//     * 设置不滚动
//     */
//    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
//    {
//        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
//                MeasureSpec.AT_MOST);
//        super.onMeasure(widthMeasureSpec, expandSpec);
//
//    }
    public ListViewForScrollView_SpaceList(Context context) {
        super(context);
    }

    public ListViewForScrollView_SpaceList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewForScrollView_SpaceList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ListViewForScrollView_SpaceList(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2
                , MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
