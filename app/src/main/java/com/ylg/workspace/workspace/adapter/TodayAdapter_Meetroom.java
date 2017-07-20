package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;

import java.util.List;

/**
 * Created by stu on 2017/7/11.
 */

public class TodayAdapter_Meetroom extends BaseAdapter {
    private List<String> datas;
    private LayoutInflater inflater;
    private Context context;
    private RelativeLayout item1,item2;
    private int currentItem = -1; //用于记录点击的 Item 的 position，是控制 item 展开的核心
    //构造方法
    public TodayAdapter_Meetroom(Context context , List<String> datas){
        this.datas = datas;
        this.context = context;
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
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        TodayAdapter_Meetroom.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_meetroomtodaylv,viewGroup ,false);
            viewHolder=new TodayAdapter_Meetroom.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(TodayAdapter_Meetroom.ViewHolder) view.getTag();

        }
        /**
         * 注意：我们在此给响应点击事件的区域（我的例子里是 showArea 的线性布局）添加Tag，为了记录点击的 position，我们正好用 position 设置 Tag
         * 若监听整个item布局该处使用viewHolder.item1.setTag(position)
         * writen by stu爸爸
         */
        viewHolder.img_order_show.setTag(position);
        //设置文字
        viewHolder.tv_address.setText(datas.get(position));
        viewHolder.tv_peoplenum.setText("12-14人");
        viewHolder.tv_floor.setText("第4层");
        viewHolder.tv_price.setText("150元/30分钟");
        //日期和图片暂时不设置

        //根据 currentItem 记录的点击位置来设置"对应Item"的可见性（在list依次加载列表数据时，每加载一个时都看一下是不是需改变可见性的那一条）
        if (currentItem == position) {
            viewHolder.item2.setVisibility(View.VISIBLE);
        } else {
            viewHolder.item2.setVisibility(View.GONE);
        }
        //可见的订购按钮点击事件、
        viewHolder.img_order_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //用 currentItem 记录点击位置
                int tag = (Integer) view.getTag();
                if (tag == currentItem) { //再次点击
                    currentItem = -1; //给 currentItem 一个无效值
                } else {
                    currentItem = tag;
                }
                Toast.makeText(context, "哈哈哈哈", Toast.LENGTH_SHORT).show();
                //通知adapter数据改变需要重新加载
                notifyDataSetChanged(); //必须有的一步
            }
        });

        return view;
    }
    private class ViewHolder{
        TextView tv_address,tv_peoplenum,tv_price,tv_floor;
        ImageView img,img_order_show;
         RelativeLayout item1;
        RelativeLayout item2;
        public ViewHolder(View view){
            //初始化TextView
            tv_floor=(TextView)view.findViewById(R.id.meetroom_floor_today);
            tv_address=(TextView)view.findViewById(R.id.meetroom_address_today);
            tv_peoplenum=(TextView)view.findViewById(R.id.meetroom_peoplenum_today);
            tv_price=(TextView)view.findViewById(R.id.meetroom_price_today);
            //初始化ImageView
            img=(ImageView)view.findViewById(R.id.meetroom_img_today);
            //明面上的订购按钮
            img_order_show=(ImageView)view.findViewById(R.id.meetroom_order_show);
            //初始化item隐藏布局item2
            item2=(RelativeLayout)view.findViewById(R.id.item2_meetroomtoday);
            //初始化显示布局
            item1=(RelativeLayout)view.findViewById(R.id.item1_meetroomtoday);
        }
    }
}
