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
 * Created by stu on 2017/7/11.
 */

public class TomorrowAdapter_Meetroom extends BaseAdapter {
    private List<String> datas;
    private LayoutInflater inflater;
    //构造方法
    public TomorrowAdapter_Meetroom(Context context , List<String> datas){
        this.datas = datas;
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
        TomorrowAdapter_Meetroom.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_meetroomtomorrowlv,viewGroup ,false);
            viewHolder=new TomorrowAdapter_Meetroom.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(TomorrowAdapter_Meetroom.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_address.setText(datas.get(i));
        viewHolder.tv_peoplenum.setText("400-600人");
        viewHolder.tv_floor.setText("第2层");
        viewHolder.tv_price.setText("8万元/小时");
        //日期和图片暂时不设置


        return view;
    }
    private class ViewHolder{
        TextView tv_address,tv_peoplenum,tv_price,tv_floor;
        ImageView img;
        public ViewHolder(View view){
            //初始化TextView
            tv_floor=(TextView)view.findViewById(R.id.meetroom_floor_tomorrow);
            tv_address=(TextView)view.findViewById(R.id.meetroom_address_tomorrow);
            tv_peoplenum=(TextView)view.findViewById(R.id.meetroom_peoplenum_tomorrow);
            tv_price=(TextView)view.findViewById(R.id.meetroom_price_tomorrow);
            //初始化ImageView
            img=(ImageView)view.findViewById(R.id.meetroom_img_tomorrow);
        }
    }
}
