package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;

import java.util.List;

/**
 * Created by stu on 2017/7/4.
 */

public class ListViewAdapter_ExerviseActivity extends BaseAdapter{
    private List<String> datas ;
    private LayoutInflater inflater;
    //构造方法
    public ListViewAdapter_ExerviseActivity(Context context , List<String> datas){
        this.datas =datas;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return datas.size();
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
        ListViewAdapter_ExerviseActivity.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_exerciselistview,viewGroup ,false);
            viewHolder=new ListViewAdapter_ExerviseActivity.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ListViewAdapter_ExerviseActivity.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_title.setText(datas.get(i));

        //日期和图片暂时不设置


        return view;
    }
    private class ViewHolder{
        TextView tv_title,tv_location,tv_progress;
        ImageView img_title,img_location,img_progress;
        public ViewHolder(View view){
            //初始化TextView
            tv_title=(TextView)view.findViewById(R.id.title_tv);
            tv_progress=(TextView)view.findViewById(R.id.progress_tv);
            tv_location=(TextView)view.findViewById(R.id.location_tv);
            //初始化ImageView
            img_title=(ImageView)view.findViewById(R.id.title_img);
            img_location=(ImageView)view.findViewById(R.id.location_img);
            img_progress=(ImageView)view.findViewById(R.id.progress_img);
        }
    }
}
