package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.util.Log;
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

import com.bumptech.glide.Glide;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.PlaceList;
import com.ylg.workspace.workspace.http.Http;

import java.util.List;

/**
 * Created by stu on 2017/7/11.
 */

public class ListViewAdapter_PlaceOrderActivity extends BaseAdapter {
    private List<PlaceList.MsgEntity> datas;
    private LayoutInflater inflater;
    private Context context;
    private int state01,state02,state03,state04,state05,state06,state07,state08,state09,state10,state11,state12,state13,state14,state15,state16,state17,state18,state19,state20,state21,state22,state23,state24;//未选0（空白），被别人选1（灰灰），自己选2(绿)；
    private double totaltime;
    private int currentItem = -1; //用于记录点击的 Item 的 position，是控制 item 展开的核心
    //构造方法
    public ListViewAdapter_PlaceOrderActivity(Context context , List<PlaceList.MsgEntity> datas){
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
        final ListViewAdapter_PlaceOrderActivity.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_placeorderlv,viewGroup ,false);
            viewHolder=new ListViewAdapter_PlaceOrderActivity.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ListViewAdapter_PlaceOrderActivity.ViewHolder) view.getTag();

        }
        /**
         * 注意：我们在此给响应点击事件的区域（我的例子里是 showArea 的线性布局）添加Tag，为了记录点击的 position，我们正好用 position 设置 Tag
         * 若监听整个item布局该处使用viewHolder.item1.setTag(position)
         * 注：listview中的item内的视图的点击事件要在adapter中写
         * writen by stu爸爸
         */
        viewHolder.img_order_show.setTag(position);
        //设置文字
        viewHolder.tv_name.setText(datas.get(position).getSiteName());
        viewHolder.tv_address.setText(datas.get(position).getLocation());
        viewHolder.tv_floor.setText(datas.get(position).getPeopleNum()+"");
        viewHolder.tv_price.setText(datas.get(position).getSitePrice()+"");
        //日期和图片暂时不设置
        Glide.with(context).load(Http.API_URL+datas.get(position).getSitePicture()).into(viewHolder.img);

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
//                Toast.makeText(context, "哈哈哈哈", Toast.LENGTH_SHORT).show();
                //通知adapter数据改变需要重新加载
                notifyDataSetChanged(); //必须有的一步
            }
        });


        //horizontalscrollview的点击事件
        if(viewHolder.item2.getVisibility()==View.VISIBLE){
            viewHolder.time01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state01==0 && state01!=1 && state01!=2){//可选状态
                        viewHolder.time01.setImageResource(R.drawable.order_greenstate);
                        state01=2;//更改选中状态
                        totaltime=totaltime+0.5;
                        Log.e("totaltime1:",totaltime+"");
                        viewHolder.tv_totaltime.setText(totaltime+"");//动态设置总时间
                    }else if(state01==1 && state01!=0 && state01!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state01==2 && state01!=0 && state01!=1){//自己的选定状态
                        viewHolder.time01.setImageResource(R.drawable.item_emptystate);
                        state01=0;
                        totaltime=totaltime-0.5;
                        Log.e("totaltime2:",totaltime+"");
                        viewHolder.tv_totaltime.setText(totaltime+"");
                    }

                }
            });
            viewHolder.time02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state02==0 && state02!=1 && state02!=2){//可选状态
                        viewHolder.time02.setImageResource(R.drawable.order_greenstate);
                        state02=2;
                        totaltime=totaltime+0.5;
                    }else if(state02==1 && state02!=0 && state02!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state02==2 && state02!=0 && state02!=1){//自己的选定状态
                        viewHolder.time02.setImageResource(R.drawable.item_emptystate);
                        state02=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");

                }
            });
            viewHolder.time03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state03==0 && state03!=1 && state03!=2){//可选状态
                        viewHolder.time03.setImageResource(R.drawable.order_greenstate);
                        state03=2;
                        totaltime=totaltime+0.5;
                    }else if(state03==1 && state03!=0 && state03!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state03==2 && state03!=0 && state03!=1){//自己的选定状态
                        viewHolder.time03.setImageResource(R.drawable.item_emptystate);
                        state03=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state04==0 && state04!=1 && state04!=2){//可选状态
                        viewHolder.time04.setImageResource(R.drawable.order_greenstate);
                        state04=2;
                        totaltime=totaltime+0.5;
                    }else if(state04==1 && state04!=0 && state04!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state04==2 && state04!=0 && state04!=1){//自己的选定状态
                        viewHolder.time04.setImageResource(R.drawable.item_emptystate);
                        state04=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time05.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state05==0 && state05!=1 && state05!=2){//可选状态
                        viewHolder.time05.setImageResource(R.drawable.order_greenstate);
                        state05=2;
                        totaltime=totaltime+0.5;
                    }else if(state05==1 && state05!=0 && state05!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state05==2 && state05!=0 && state05!=1){//自己的选定状态
                        viewHolder.time05.setImageResource(R.drawable.item_emptystate);
                        state05=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time06.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state06==0 && state06!=1 && state06!=2){//可选状态
                        viewHolder.time06.setImageResource(R.drawable.order_greenstate);
                        state06=2;
                        totaltime=totaltime+0.5;
                    }else if(state06==1 && state06!=0 && state06!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state06==2 && state06!=0 && state06!=1){//自己的选定状态
                        viewHolder.time06.setImageResource(R.drawable.item_emptystate);
                        state06=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time07.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state07==0 && state07!=1 && state07!=2){//可选状态
                        viewHolder.time07.setImageResource(R.drawable.order_greenstate);
                        state07=2;
                        totaltime=totaltime+0.5;
                    }else if(state07==1 && state07!=0 && state07!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state07==2 && state07!=0 && state07!=1){//自己的选定状态
                        viewHolder.time07.setImageResource(R.drawable.item_emptystate);
                        state07=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time08.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state08==0 && state08!=1 && state08!=2){//可选状态
                        viewHolder.time08.setImageResource(R.drawable.order_greenstate);
                        state08=2;
                        totaltime=totaltime+0.5;
                    }else if(state08==1 && state08!=0 && state08!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state08==2 && state08!=0 && state08!=1){//自己的选定状态
                        viewHolder.time08.setImageResource(R.drawable.item_emptystate);
                        state08=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time09.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state09==0 && state09!=1 && state09!=2){//可选状态
                        viewHolder.time09.setImageResource(R.drawable.order_greenstate);
                        state09=2;
                        totaltime=totaltime+0.5;
                    }else if(state09==1 && state09!=0 && state09!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state09==2 && state09!=0 && state09!=1){//自己的选定状态
                        viewHolder.time09.setImageResource(R.drawable.item_emptystate);
                        state09=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state10==0 && state10!=1 && state10!=2){//可选状态
                        viewHolder.time10.setImageResource(R.drawable.order_greenstate);
                        state10=2;
                        totaltime=totaltime+0.5;
                    }else if(state10==1 && state10!=0 && state10!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state10==2 && state10!=0 && state10!=1){//自己的选定状态
                        viewHolder.time10.setImageResource(R.drawable.item_emptystate);
                        state10=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state11==0 && state11!=1 && state11!=2){//可选状态
                        viewHolder.time11.setImageResource(R.drawable.order_greenstate);
                        state11=2;
                        totaltime=totaltime+0.5;
                    }else if(state11==1 && state11!=0 && state11!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state11==2 && state11!=0 && state11!=1){//自己的选定状态
                        viewHolder.time11.setImageResource(R.drawable.item_emptystate);
                        state11=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state12==0 && state12!=1 && state12!=2){//可选状态
                        viewHolder.time12.setImageResource(R.drawable.order_greenstate);
                        state12=2;
                        totaltime=totaltime+0.5;
                    }else if(state12==1 && state12!=0 && state12!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state12==2 && state12!=0 && state12!=1){//自己的选定状态
                        viewHolder.time12.setImageResource(R.drawable.item_emptystate);
                        state12=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state13==0 && state13!=1 && state13!=2){//可选状态
                        viewHolder.time13.setImageResource(R.drawable.order_greenstate);
                        state13=2;
                        totaltime=totaltime+0.5;
                    }else if(state13==1 && state13!=0 && state13!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state13==2 && state13!=0 && state13!=1){//自己的选定状态
                        viewHolder.time13.setImageResource(R.drawable.item_emptystate);
                        state13=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state14==0 && state14!=1 && state14!=2){//可选状态
                        viewHolder.time14.setImageResource(R.drawable.order_greenstate);
                        state14=2;
                        totaltime=totaltime+0.5;
                    }else if(state14==1 && state14!=0 && state14!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state14==2 && state14!=0 && state14!=1){//自己的选定状态
                        viewHolder.time14.setImageResource(R.drawable.item_emptystate);
                        state14=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state15==0 && state15!=1 && state15!=2){//可选状态
                        viewHolder.time15.setImageResource(R.drawable.order_greenstate);
                        state15=2;
                        totaltime=totaltime+0.5;
                    }else if(state15==1 && state15!=0 && state15!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state15==2 && state15!=0 && state15!=1){//自己的选定状态
                        viewHolder.time15.setImageResource(R.drawable.item_emptystate);
                        state15=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state16==0 && state16!=1 && state16!=2){//可选状态
                        viewHolder.time16.setImageResource(R.drawable.order_greenstate);
                        state16=2;
                        totaltime=totaltime+0.5;
                    }else if(state16==1 && state16!=0 && state16!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state16==2 && state16!=0 && state16!=1){//自己的选定状态
                        viewHolder.time16.setImageResource(R.drawable.item_emptystate);
                        state16=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state17==0 && state17!=1 && state17!=2){//可选状态
                        viewHolder.time17.setImageResource(R.drawable.order_greenstate);
                        state17=2;
                        totaltime=totaltime+0.5;
                    }else if(state17==1 && state17!=0 && state17!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state17==2 && state17!=0 && state17!=1){//自己的选定状态
                        viewHolder.time17.setImageResource(R.drawable.item_emptystate);
                        state17=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state18==0 && state18!=1 && state18!=2){//可选状态
                        viewHolder.time18.setImageResource(R.drawable.order_greenstate);
                        state18=2;
                        totaltime=totaltime+0.5;
                    }else if(state18==1 && state18!=0 && state18!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state18==2 && state18!=0 && state18!=1){//自己的选定状态
                        viewHolder.time18.setImageResource(R.drawable.item_emptystate);
                        state18=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");

                }
            });
            viewHolder.time19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state19==0 && state19!=1 && state19!=2){//可选状态
                        viewHolder.time19.setImageResource(R.drawable.order_greenstate);
                        state19=2;
                        totaltime=totaltime+0.5;
                    }else if(state19==1 && state19!=0 && state19!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state19==2 && state19!=0 && state19!=1){//自己的选定状态
                        viewHolder.time19.setImageResource(R.drawable.item_emptystate);
                        state19=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state20==0 && state20!=1 && state20!=2){//可选状态
                        viewHolder.time20.setImageResource(R.drawable.order_greenstate);
                        state20=2;
                        totaltime=totaltime+0.5;
                    }else if(state20==1 && state20!=0 && state20!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state20==2 && state20!=0 && state20!=1){//自己的选定状态
                        viewHolder.time20.setImageResource(R.drawable.item_emptystate);
                        state20=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state21==0 && state21!=1 && state21!=2){//可选状态
                        viewHolder.time21.setImageResource(R.drawable.order_greenstate);
                        state21=2;
                        totaltime=totaltime+0.5;
                    }else if(state21==1 && state21!=0 && state21!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state21==2 && state21!=0 && state21!=1){//自己的选定状态
                        viewHolder.time21.setImageResource(R.drawable.item_emptystate);
                        state21=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state22==0 && state22!=1 && state22!=2){//可选状态
                        viewHolder.time22.setImageResource(R.drawable.order_greenstate);
                        state22=2;
                        totaltime=totaltime+0.5;
                    }else if(state22==1 && state22!=0 && state22!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state22==2 && state22!=0 && state22!=1){//自己的选定状态
                        viewHolder.time22.setImageResource(R.drawable.item_emptystate);
                        state22=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(state23==0 && state23!=1 && state23!=2){//可选状态
                        viewHolder.time23.setImageResource(R.drawable.order_greenstate);
                        state23=2;
                        totaltime=totaltime+0.5;
                    }else if(state23==1 && state23!=0 && state23!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state23==2 && state23!=0 && state23!=1){//自己的选定状态
                        viewHolder.time23.setImageResource(R.drawable.item_emptystate);
                        state23=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });
            viewHolder.time24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("time24_click","time24_click");
                    if(state24==0 && state24!=1 && state24!=2){//可选状态
                        viewHolder.time24.setImageResource(R.drawable.order_greenstate);
                        state24=2;
                        totaltime=totaltime+0.5;
                    }else if(state24==1 && state24!=0 && state24!=2){//已被预订状态
                        Toast.makeText(context, "该时间段已被预订", Toast.LENGTH_SHORT).show();
                    }else if(state24==2 && state24!=0 && state24!=1){//自己的选定状态
                        viewHolder.time24.setImageResource(R.drawable.item_emptystate);
                        state24=0;
                        totaltime=totaltime-0.5;
                    }
                    viewHolder.tv_totaltime.setText(totaltime+"");
                }
            });

        }


        return view;
    }
    private class ViewHolder{
        TextView tv_address,tv_name,tv_price,tv_floor,tv_content01,tv_content02,tv_content03,tv_content04,tv_totaltime;
        ImageView img,img_order_show,time01,time02,time03,time04,time05,time06,time07,time08,time09,time10,time11,time12,time13,time14,time15,time16,time17,time18,time19,time20,time21,time22,time23,time24;
        RelativeLayout item1;
        LinearLayout item2;
        HorizontalScrollView hsv;
        public ViewHolder(View view){
            //初始化TextView
            tv_name=(TextView)view.findViewById(R.id.placeorder_name);
            tv_address=(TextView)view.findViewById(R.id.placeorder_address);
            tv_floor=(TextView)view.findViewById(R.id.placeorder_floor);
            tv_price=(TextView)view.findViewById(R.id.placeorder_price);
            tv_content01=(TextView)view.findViewById(R.id.placeorder_tv01);
            tv_content02=(TextView)view.findViewById(R.id.placeorder_tv02);
            tv_content03=(TextView)view.findViewById(R.id.placeorder_tv03);
            tv_content04=(TextView)view.findViewById(R.id.placeorder_tv04);
            //初始化ImageView
            img=(ImageView)view.findViewById(R.id.placeorder_img);
            //明面上的订购按钮
            img_order_show=(ImageView)view.findViewById(R.id.placeorder_order_show);
            //初始化item隐藏布局item2
            item2=(LinearLayout) view.findViewById(R.id.item2_placeorder);
            //初始化显示布局
            item1=(RelativeLayout)view.findViewById(R.id.item1_placeorder);
            //初始化horizontalscrollview
            hsv=(HorizontalScrollView)view.findViewById(R.id.placeorder_hsv);
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

            //共计小时数
            tv_totaltime=(TextView)view.findViewById(R.id.placeorder_totaltime);

        }
    }
}
