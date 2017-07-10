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
 * Created by stu on 2017/7/10.
 */

public class TodayAdapter_Workplace extends BaseAdapter {
    private List<String> datas;
    private LayoutInflater inflater;
    //构造方法
    public TodayAdapter_Workplace(Context context , List<String> datas){
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
        TodayAdapter_Workplace.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_workplacetodaylv,viewGroup ,false);
            viewHolder=new TodayAdapter_Workplace.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(TodayAdapter_Workplace.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_title.setText(datas.get(i));
        viewHolder.tv_address.setText("北京市海淀区中关村南大街甲56号");
        viewHolder.tv_number.setText("23号工位可以预定");
        viewHolder.tv_price.setText("$199/天");
        //日期和图片暂时不设置


        return view;
    }
    private class ViewHolder{
        TextView tv_title,tv_address,tv_number,tv_price;
        ImageView img_title,img_order;
        public ViewHolder(View view){
            //初始化TextView
            tv_title=(TextView)view.findViewById(R.id.workplace_title_today);
            tv_address=(TextView)view.findViewById(R.id.workplace_address_today);
            tv_number=(TextView)view.findViewById(R.id.workplace_number_today);
            tv_price=(TextView)view.findViewById(R.id.workplace_price_today);
            //初始化ImageView
            img_title=(ImageView)view.findViewById(R.id.workplace_img_today);
            img_order=(ImageView)view.findViewById(R.id.workplace_order_today);
        }
    }
}
