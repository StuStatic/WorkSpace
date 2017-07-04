package com.ylg.workspace.workspace.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;

/**
 * Created by stu on 2017/7/3.
 */

public class ExpandableListViewAdater_Exercise extends BaseExpandableListAdapter {
    private Activity activity;
    private String[][] childArray;
    private String[] groupArray;

    public  ExpandableListViewAdater_Exercise(Activity a ,String[][] childs , String[] groups){
        activity = a;
        childArray=childs;
        groupArray=groups;
    }
    public  Object getChild(int  groupPosition, int  childPosition)
    {
        return  childArray[groupPosition][childPosition];
    }
    public  long  getChildId(int  groupPosition, int  childPosition)
    {
        return  childPosition;
    }
    public  int  getChildrenCount(int  groupPosition)
    {
//        return  childArray.get(groupPosition).size();
        return childArray[groupPosition].length;
    }
    public  View getChildView(int  groupPosition, int  childPosition,
                              boolean  isLastChild, View convertView, ViewGroup parent)
    {
        String string = childArray[groupPosition][childPosition];
        return  getGenericView(string);
    }
    // group method stub
    public  Object getGroup(int  groupPosition)
    {
        return  groupArray[groupPosition];
    }
    public  int  getGroupCount()
    {
        return  groupArray.length;
    }
    public  long  getGroupId(int  groupPosition)
    {
        return  groupPosition;
    }
    public  View getGroupView(int  groupPosition, boolean  isExpanded, View convertView, ViewGroup parent)
    {
        //控制箭头变化
//        if(isExpanded){
//            parentImageViw.setBackgroundResource(R.drawable.arrow_down);
//        }else{
//            parentImageViw.setBackgroundResource(R.drawable.arrow_up);
//        }
        String string = groupArray[groupPosition];
        return  getGenericView(string);
    }
    // View stub to create Group/Children 's View
    public  TextView getGenericView(String string)
    {
        // Layout parameters for the ExpandableListView
        AbsListView.LayoutParams layoutParams = new  AbsListView.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, 90 );
        TextView text = new  TextView(activity);
        text.setLayoutParams(layoutParams);
        // Center the text vertically
//        text.setGravity(Gravity.CENTER_VERTICAL | Gravity.HORIZONTAL_GRAVITY_MASK);
        text.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        // Set the text starting position
//        text.setPadding(36 , 0 , 0 , 0 );
        text.setText(string);
        text.setTextColor(Color.BLACK);
//        text.setTextSize("");
        return  text;
    }
    public  boolean  hasStableIds()
    {
        return  false ;
    }
    public  boolean  isChildSelectable(int  groupPosition, int  childPosition)
    {
        return  true ;
    }
}
