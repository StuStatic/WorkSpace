package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.service.bean.Service;
import com.ylg.workspace.workspace.bean.MeetRoom;
import com.ylg.workspace.workspace.bean.MeetRoomOrder;
import com.ylg.workspace.workspace.bean.StartEndTime;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.view.HorizontalListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by stu on 2017/7/11.
 */

public class TodayAdapter_Meetroom extends BaseAdapter {
    private List<MeetRoomOrder> l1;
    private List<StartEndTime> l;
    private List<MeetRoom.MsgBean> datas;
    private LayoutInflater inflater;
    private Context context;
    private int state01, state02, state03, state04, state05, state06, state07, state08, state09, state10, state11, state12, state13, state14, state15, state16, state17, state18, state19, state20, state21, state22, state23, state24;//未选0（空白），被别人选1（灰灰），自己选2(绿)；
    private double totaltime;
    private int currentItem = -1; //用于记录点击的 Item 的 position，是控制 item 展开的核心
    //构造方法
    private String startTime = "";
    private String endTime = "";
    private SimpleDateFormat sdf;
    private Date date;
    private String date1;

    public TodayAdapter_Meetroom(List<MeetRoomOrder> l1, List<StartEndTime> l, List<MeetRoom.MsgBean> datas, String date1, Context context) {
        this.l1 = l1;
        this.l = l;
        this.datas = datas;
        this.context = context;
        this.date1 = date1;
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
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final TodayAdapter_Meetroom.ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(context, R.layout.item_meetroomtodaylv, null);
            viewHolder = new TodayAdapter_Meetroom.ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (TodayAdapter_Meetroom.ViewHolder) view.getTag();

        }
        /**
         * 注意：我们在此给响应点击事件的区域（我的例子里是 showArea 的线性布局）添加Tag，为了记录点击的 position，我们正好用 position 设置 Tag
         * 若监听整个item布局该处使用viewHolder.item1.setTag(position)
         */
        viewHolder.img_order_show.setTag(position);
        //设置文字datas.get(position).getConferenceName()
        viewHolder.tv_address.setText(datas.get(position).getConferenceName());
        viewHolder.tv_peoplenum.setText(datas.get(position).getConferenceDescribe());
        viewHolder.tv_floor.setText(datas.get(position).getLocation());
        viewHolder.tv_noRoom.setText("您将被安排在" + datas.get(position).getLocation());
        viewHolder.tv_openTime.setText("会议室开放时间" + l.get(position).getStartTime() + ":00-" + l.get(position).getEndTime() + ":00");
        viewHolder.tv_price.setText(datas.get(position).getConferencePrice() + "");

        int i1 = l.get(position).getStartTime();
        int i2 = l.get(position).getEndTime();
        Log.d("zp", "getView: " + l1.toString());
        Log.d("zp", "getView: " + l1.size());
//        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        try {
//            date = sdf.parse();
//            sdf = new SimpleDateFormat("yyyy/MM/dd");
//            date1 = sdf.format(date)+" ";
//            Log.d("zp", "date:"+date1);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        HorizontalListViewAdapter hlv = new HorizontalListViewAdapter(context, l1.get(position), i1, i2);
        //hlv.notifyDataSetChanged();
        viewHolder.horizontalListView.setAdapter(hlv);
        viewHolder.iv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startTime.equals("")) {
                    Toast.makeText(context, "您还未选择时间段", Toast.LENGTH_SHORT).show();
                } else {
                    HttpAPI api = Http.getInstance().create(HttpAPI.class);
                    Log.d("zp", "onClick: " + datas.get(position).getSpaceId() + "---" + datas.get(position).getConferenceId());
                    Call call = api.orderMeetRoom(datas.get(position).getSpaceId(), datas.get(position).getConferenceId(), startTime, endTime);

                    call.enqueue(new Callback<Service>() {
                        @Override
                        public void onResponse(Call<Service> call, Response<Service> response) {
                            Service service = response.body();
                            Log.d("zp", "aaaaaaa:" + service.toString());
                            if (service != null && service.getCode().equals("200")) {
                                Toast.makeText(context, "预约成功", Toast.LENGTH_SHORT).show();
                            } else if (service != null && service.getCode().equals("202")) {
                                Toast.makeText(context, "该时段已被预约", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "预约失败", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<Service> call, Throwable t) {
                            Toast.makeText(context, "预约失败！", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        hlv.setSubClickListener(new HorizontalListViewAdapter.SubClickListener() {
            @Override
            public void OnTopicClickListener(double d1, double d2) {
                Log.d("zp", "d1:" + d1 + "d2:" + d2);
                viewHolder.tv_totaltime.setText((d2 - d1 + 0.5) + "");
                String s2 = String.valueOf(d2);
                String s1 = String.valueOf(d1);
                if (s2.contains(".5")) {
                    s2 = String.valueOf(d2 + 1.0).substring(0, s2.length() - 2);

                    if (s1.contains(".5")) {
                        s1 = s1.substring(0, s1.length() - 2);
                        startTime = date1 + " " + s1 + ":30";
                        endTime = date1 + " " + s2 + ":00";
                        Log.d("zp", "OnTopicClickListener: " + startTime + "==" + endTime);
                        viewHolder.tv_long.setText("(" + s1 + ":30-" + s2 + ":00)");
                    } else {
                        s1 = s1.substring(0, s1.length() - 2);
                        startTime = date1 + " " + s1 + ":00";
                        endTime = date1 + " " + s2 + ":00";
                        Log.d("zp", "OnTopicClickListener: " + startTime + "==" + endTime);
                        viewHolder.tv_long.setText("(" + s1 + ":00-" + s2 + ":00)");
                    }
                } else {
                    s2 = String.valueOf(d2).substring(0, s2.length() - 2);

                    if (s1.contains(".5")) {
                        s1 = s1.substring(0, s1.length() - 2);
                        startTime = date1 + " " + s1 + ":30";
                        endTime = date1 + " " + s2 + ":30";
                        Log.d("zp", "OnTopicClickListener: " + startTime + "==" + endTime);
                        viewHolder.tv_long.setText("(" + s1 + ":30-" + s2 + ":30)");
                    } else {
                        s1 = s1.substring(0, s1.length() - 2);
                        startTime = date1 + " " + s1 + ":00";
                        endTime = date1 + " " + s2 + ":00";
                        Log.d("zp", "OnTopicClickListener: " + startTime + "==" + endTime);
                        viewHolder.tv_long.setText("(" + s1 + ":00-" + s2 + ":30)");
                    }
                }
            }

            @Override
            public void OnTopicClickListener1(double d1, double d2) {
                Log.d("zp", "d1:" + d1 + "d2:" + d2);
                viewHolder.tv_totaltime.setText((d2 - d1) + "");
                String s2 = String.valueOf(d2);
                String s1 = String.valueOf(d1);
                if (s2.contains(".5")) {
                    s2 = s2.substring(0, s2.length() - 2);
                    s1 = s1.substring(0, s1.length() - 2);
                    startTime = date1 + " " + s1 + ":00";
                    endTime = date1 + " " + s2 + ":30";
                    Log.d("zp", "OnTopicClickListener: " + startTime + "==" + endTime);
                    viewHolder.tv_long.setText("(" + s1 + ":00-" + s1 + ":30)");
                } else {
                    s2 = s2.substring(0, s2.length() - 2);
                    s1 = s1.substring(0, s1.length() - 2);
                    startTime = date1 + " " + s1 + ":30";
                    endTime = date1 + " " + s2 + ":00";
                    Log.d("zp", "OnTopicClickListener: " + startTime + "==" + endTime);
                    viewHolder.tv_long.setText("(" + s1 + ":30-" + s2 + ":00)");
                }
            }
        });


        //日期和图片暂时不设置
        Glide.with(context).load(Http.API_URL + datas.get(position).getConferencePicture()).into(viewHolder.img);
        //根据 currentItem 记录的点击位置来设置"对应Item"的可见性（在list依次加载列表数据时，每加载一个时都看一下是不是需改变可见性的那一条）
        if (currentItem == position) {
            viewHolder.item2.setVisibility(View.VISIBLE);


        } else {
            viewHolder.item2.setVisibility(View.GONE);
            viewHolder.tv_totaltime.setText("0.0");
            viewHolder.tv_long.setText("");
//            startTime="";
//            endTime="";

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


        return view;
    }


    private class ViewHolder {
        TextView tv_address, tv_peoplenum, tv_price, tv_floor, tv_totaltime, tv_noRoom, tv_openTime, tv_long;
        ImageView img, img_order_show, time01, iv_order;
        RelativeLayout item1;
        LinearLayout item2;
        HorizontalListView horizontalListView;

        public ViewHolder(View view) {
            //初始化TextView
            iv_order = (ImageView) view.findViewById(R.id.iv_order);
            tv_long = (TextView) view.findViewById(R.id.tv_long);
            horizontalListView = (HorizontalListView) view.findViewById(R.id.horizontalListView);
            tv_floor = (TextView) view.findViewById(R.id.meetroom_floor_today);
            tv_address = (TextView) view.findViewById(R.id.meetroom_address_today);
            tv_peoplenum = (TextView) view.findViewById(R.id.meetroom_peoplenum_today);
            tv_price = (TextView) view.findViewById(R.id.meetroom_price_today);
            //初始化ImageView
            img = (ImageView) view.findViewById(R.id.meetroom_img_today);
            //明面上的订购按钮
            img_order_show = (ImageView) view.findViewById(R.id.meetroom_order_show);
            //初始化item隐藏布局item2
            item2 = (LinearLayout) view.findViewById(R.id.item2_meetroomtoday);
            //初始化显示布局
            item1 = (RelativeLayout) view.findViewById(R.id.item1_meetroomtoday);

            //初始化horizontalscrollview中的imageview
            time01 = (ImageView) view.findViewById(R.id.meetroom_time01);

            //共计小时数
            tv_totaltime = (TextView) view.findViewById(R.id.meetroom_totaltime);
            tv_openTime = (TextView) view.findViewById(R.id.tv_openTime);
            tv_noRoom = (TextView) view.findViewById(R.id.tv_noRoom);

        }
    }
}
