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

public class TomorrowAdapter_Workplace extends BaseAdapter{
    private List<String> datas;
    private LayoutInflater inflater;
    //构造方法
    public TomorrowAdapter_Workplace(Context context , List<String> datas){
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
        TomorrowAdapter_Workplace.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_workplacetomorrowlv,viewGroup ,false);
            viewHolder=new TomorrowAdapter_Workplace.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(TomorrowAdapter_Workplace.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_title.setText(datas.get(i));
        viewHolder.tv_address.setText("上海市浦东新区088号");
        viewHolder.tv_number.setText("29号工位可以预定");
        viewHolder.tv_price.setText("$288/天");
        //日期和图片暂时不设置


        return view;
    }
    private class ViewHolder{
        TextView tv_title,tv_address,tv_number,tv_price;
        ImageView img_title,img_order;
        public ViewHolder(View view){
            //初始化TextView
            tv_title=(TextView)view.findViewById(R.id.workplace_title_tomorrow);
            tv_address=(TextView)view.findViewById(R.id.workplace_address_tomorrow);
            tv_number=(TextView)view.findViewById(R.id.workplace_number_tomorrow);
            tv_price=(TextView)view.findViewById(R.id.workplace_price_tomorrow);
            //初始化ImageView
            img_title=(ImageView)view.findViewById(R.id.workplace_img_tomorrow);
            img_order=(ImageView)view.findViewById(R.id.workplace_order_tomorrow);
        }
    }
}
