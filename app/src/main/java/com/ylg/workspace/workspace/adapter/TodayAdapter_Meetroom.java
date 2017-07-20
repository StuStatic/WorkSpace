package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private int state=0;//未选0（空白），被别人选1（灰灰），自己选2(绿)；

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
        final TodayAdapter_Meetroom.ViewHolder viewHolder;
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
         * 注：listview中的item内的视图的点击事件要在adapter中写
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


        //horizontalscrollview的点击事件
        if(viewHolder.item2.getVisibility()==View.VISIBLE){
           viewHolder.time01.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(state==0 && state!=1 && state!=2){//可选状态
                       viewHolder.time01.setImageResource(R.drawable.item_greenstate);
                       state=2;
                   }else if(state==1 && state!=0 && state!=2){//已被预订状态
                       Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                   }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                       viewHolder.time01.setImageResource(R.drawable.item_emptystate);
                       state=0;
                   }
               }
           });
            viewHolder.time02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time02.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time02.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time03.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time03.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time04.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time04.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time05.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time05.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time05.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time06.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time06.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time06.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time07.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time07.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time07.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time08.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time08.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time08.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time09.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time09.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time09.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time10.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time10.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time11.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time11.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time12.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time12.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time13.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time13.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time14.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time14.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time15.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time15.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time16.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time16.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time17.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time17.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time18.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time18.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time19.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time19.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time20.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time20.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time21.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time21.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time22.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time22.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time23.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time23.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });
            viewHolder.time24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==0 && state!=1 && state!=2){//可选状态
                        viewHolder.time24.setImageResource(R.drawable.item_greenstate);
                        state=2;
                    }else if(state==1 && state!=0 && state!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state==2 && state!=0 && state!=1){//自己的选定状态
                        viewHolder.time24.setImageResource(R.drawable.item_emptystate);
                        state=0;
                    }
                }
            });











        }

        return view;
    }
    private class ViewHolder{
        TextView tv_address,tv_peoplenum,tv_price,tv_floor;
        ImageView img,img_order_show,time01,time02,time03,time04,time05,time06,time07,time08,time09,time10,time11,time12,time13,time14,time15,time16,time17,time18,time19,time20,time21,time22,time23,time24;
        RelativeLayout item1;
        LinearLayout item2;
        HorizontalScrollView hsv;
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
            item2=(LinearLayout) view.findViewById(R.id.item2_meetroomtoday);
            //初始化显示布局
            item1=(RelativeLayout)view.findViewById(R.id.item1_meetroomtoday);
            //初始化horizontalscrollview
            hsv=(HorizontalScrollView)view.findViewById(R.id.meetroom_hsv);
            //初始化horizontalscrollview中的imageview
            time01=(ImageView)view.findViewById(R.id.meetroom_time01);
            time02=(ImageView)view.findViewById(R.id.meetroom_time02);
            time03=(ImageView)view.findViewById(R.id.meetroom_time03);
            time04=(ImageView)view.findViewById(R.id.meetroom_time04);
            time05=(ImageView)view.findViewById(R.id.meetroom_time05);
            time06=(ImageView)view.findViewById(R.id.meetroom_time06);
            time07=(ImageView)view.findViewById(R.id.meetroom_time07);
            time08=(ImageView)view.findViewById(R.id.meetroom_time08);
            time09=(ImageView)view.findViewById(R.id.meetroom_time09);
            time10=(ImageView)view.findViewById(R.id.meetroom_time10);
            time11=(ImageView)view.findViewById(R.id.meetroom_time11);
            time12=(ImageView)view.findViewById(R.id.meetroom_time12);
            time13=(ImageView)view.findViewById(R.id.meetroom_time13);
            time14=(ImageView)view.findViewById(R.id.meetroom_time14);
            time15=(ImageView)view.findViewById(R.id.meetroom_time15);
            time16=(ImageView)view.findViewById(R.id.meetroom_time16);
            time17=(ImageView)view.findViewById(R.id.meetroom_time17);
            time18=(ImageView)view.findViewById(R.id.meetroom_time18);
            time19=(ImageView)view.findViewById(R.id.meetroom_time19);
            time20=(ImageView)view.findViewById(R.id.meetroom_time20);
            time21=(ImageView)view.findViewById(R.id.meetroom_time21);
            time22=(ImageView)view.findViewById(R.id.meetroom_time22);
            time23=(ImageView)view.findViewById(R.id.meetroom_time23);
            time24=(ImageView)view.findViewById(R.id.meetroom_time24);






        }
    }
}
