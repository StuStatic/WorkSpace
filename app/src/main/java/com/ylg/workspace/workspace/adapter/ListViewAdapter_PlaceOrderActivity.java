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

public class ListViewAdapter_PlaceOrderActivity extends BaseAdapter {
    private List<String> datas;
    private LayoutInflater inflater;
    //构造方法
    public ListViewAdapter_PlaceOrderActivity(Context context , List<String> datas){
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
        ListViewAdapter_PlaceOrderActivity.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_placeorderlv,viewGroup ,false);
            viewHolder=new ListViewAdapter_PlaceOrderActivity.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ListViewAdapter_PlaceOrderActivity.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_address.setText(datas.get(i));
//        viewHolder.tv_peoplenum.setText("12-14人");
//        viewHolder.tv_floor.setText("第4层");
//        viewHolder.tv_price.setText("150元/30分钟");
        //日期和图片暂时不设置


        return view;
    }
    private class ViewHolder{
        TextView tv_address,tv_name,tv_price,tv_floor,tv_content01,tv_content02,tv_content03,tv_content04;
        ImageView img;
        public ViewHolder(View view){
            //初始化TextView
            tv_name=(TextView)view.findViewById(R.id.placeorder_name);
            tv_address=(TextView)view.findViewById(R.id.placeorder_address);
            tv_floor=(TextView)view.findViewById(R.id.placeorder_floor);
            tv_content01=(TextView)view.findViewById(R.id.placeorder_tv01);
            tv_content02=(TextView)view.findViewById(R.id.placeorder_tv02);
            tv_content03=(TextView)view.findViewById(R.id.placeorder_tv03);
            tv_content04=(TextView)view.findViewById(R.id.placeorder_tv04);
            //初始化ImageView
            img=(ImageView)view.findViewById(R.id.placeorder_img);

        }
    }
}
