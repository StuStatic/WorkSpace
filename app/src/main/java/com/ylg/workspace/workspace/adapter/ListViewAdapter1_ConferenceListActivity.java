package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.FindAllSpaceToAPP;

/**
 * Created by stu on 2017/7/21.
 */

public class ListViewAdapter1_ConferenceListActivity extends BaseAdapter{
    private FindAllSpaceToAPP.MsgBean l ;
   private  Context context;
    //构造方法


    public ListViewAdapter1_ConferenceListActivity(FindAllSpaceToAPP.MsgBean l, Context context) {
        this.l = l;
        this.context = context;
    }

    @Override
    public int getCount() {
        return l.getCityList().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListViewAdapter1_ConferenceListActivity.ViewHolder viewHolder;
        if(view==null){
            view=View.inflate(context,R.layout.item_conferencelistlv1,null);
            viewHolder=new ListViewAdapter1_ConferenceListActivity.ViewHolder();
            viewHolder.tv_title = (TextView)view.findViewById(R.id.conferencelistlv1_tv);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ListViewAdapter1_ConferenceListActivity.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_title.setText(l.getCityList().get(i).getSpaceName());


        return view;
    }
    private class ViewHolder{
        TextView tv_title;
    }
}
