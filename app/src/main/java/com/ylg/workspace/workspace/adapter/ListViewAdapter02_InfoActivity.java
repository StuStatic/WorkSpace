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
 * Created by stu on 2017/7/3.
 */

public class ListViewAdapter02_InfoActivity extends BaseAdapter {
    private List<String> datas ;
    private LayoutInflater inflater;
    //构造方法
    public ListViewAdapter02_InfoActivity(Context context , List<String> datas){
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
        ListViewAdapter02_InfoActivity.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_infolistview,viewGroup ,false);
            viewHolder=new ListViewAdapter02_InfoActivity.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ListViewAdapter02_InfoActivity.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_content.setText(datas.get(i));
        //日期和图片暂时不设置


        return view;
    }
    private class ViewHolder{
        TextView tv_content,tv_date;
        ImageView listview_img;
        public ViewHolder(View view){
            //初始化TextView
            tv_content=(TextView)view.findViewById(R.id.listview_content);
            tv_date=(TextView)view.findViewById(R.id.listview_date);
            //初始化ImageView
            listview_img=(ImageView)view.findViewById(R.id.listview_img);
        }
    }
}
