package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.FindAllSpaceToAPP;
import com.ylg.workspace.workspace.util.Utility;
import com.ylg.workspace.workspace.view.MyListView;

/**
 * Created by stu on 2017/7/21.
 */

public class ListViewAdapter_ConferenceListActivity extends BaseAdapter{
    private FindAllSpaceToAPP findAllSpaceToAPP;
    private Context context;
    //构造方法
    private SubClickListener1 subClickListener;

    public ListViewAdapter_ConferenceListActivity(FindAllSpaceToAPP findAllSpaceToAPP, Context context) {
        this.findAllSpaceToAPP = findAllSpaceToAPP;
        this.context = context;
    }

    public void setSubClickListener1(SubClickListener1 topicClickListener) {
        this.subClickListener = topicClickListener;
    }

    public interface SubClickListener1 {
        void OnTopicClickListener(int s1, String s2);

    }


    @Override    public int getCount() {
        return findAllSpaceToAPP.getMsg().size();
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ListViewAdapter_ConferenceListActivity.ViewHolder viewHolder;
        if(view==null){
            view=View.inflate(context,R.layout.item_conferencelistlv,null);
            viewHolder=new ListViewAdapter_ConferenceListActivity.ViewHolder();
            viewHolder.tv_title = (TextView)view.findViewById(R.id.conferencelistlv_tv);
            viewHolder.myListView = (MyListView) view.findViewById(R.id.myListView);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ListViewAdapter_ConferenceListActivity.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_title.setText(findAllSpaceToAPP.getMsg().get(i).getCityName());
        viewHolder.myListView.setAdapter(new ListViewAdapter1_ConferenceListActivity(findAllSpaceToAPP.getMsg().get(i),context));
        Utility.setListViewHeightBasedOnChildren(viewHolder.myListView);
        //日期和图片暂时不设置
        viewHolder.myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("zp", "onItemClick: aaa");
                if (subClickListener != null) {
                    Log.d("zp", "onItemClick: bbb");
                    subClickListener.OnTopicClickListener(findAllSpaceToAPP.getMsg().get(i).getCityList().get(position).getSpaceId(), findAllSpaceToAPP.getMsg().get(i).getCityList().get(position).getSpaceName());
                }
            }
        });

        return view;
    }
    private class ViewHolder{
        TextView tv_title;
        MyListView myListView;

    }
}
