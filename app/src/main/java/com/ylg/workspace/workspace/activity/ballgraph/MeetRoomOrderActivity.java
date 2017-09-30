package com.ylg.workspace.workspace.activity.ballgraph;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.FragmentPagerAdapter_Workplace;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Meetroom;
import com.ylg.workspace.workspace.bean.MeetRoom;
import com.ylg.workspace.workspace.bean.MeetRoomOrder;
import com.ylg.workspace.workspace.bean.StartEndTime;
import com.ylg.workspace.workspace.fragment.OtherDateFragment_meetroom;
import com.ylg.workspace.workspace.fragment.TodayFragment_meetroom;
import com.ylg.workspace.workspace.fragment.TomorrowFragment_meetroom;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.util.TimeUtils;
import com.ylg.workspace.workspace.view.IphoneDialog;
import com.ylg.workspace.workspace.view.MyListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeetRoomOrderActivity extends AppCompatActivity implements View.OnClickListener {
    //左上角返回键
    private ImageView iv_back;
    //toolbar标题文字内容
    private TextView title_tv;
    //右上角图标
    private ImageView add;
    //adapter
    private FragmentPagerAdapter_Workplace pagerAdapter;
    //viewpager
    private ViewPager viewPager;
    //tablayout
    private TabLayout tabLayout;
    //fragment
    private TodayFragment_meetroom todayFragment;
    private TodayFragment_meetroom todayFragment1;
    private TomorrowFragment_meetroom tomorrowFragmentWorkplace;
    private OtherDateFragment_meetroom otherDateFragmentWorkplace;
    //初始化fragment集合
    private List<Fragment> fragmentList;

    private List<MeetRoom.MsgBean> datas;

    private MyListView listView;
    private TodayAdapter_Meetroom todayAdapter;
    private ImageView img_order;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    TimePickerView pvTime;
    private TextView tv_city;
    private IphoneDialog iphoneDialog;
    private String nowTime;
    private int spaceId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetroomorder);
        init();
    }

    private void init() {
        nowTime = TimeUtils.getNowTime();
        iphoneDialog = new IphoneDialog(this);
        //初始化返回键
        iv_back = (ImageView) findViewById(R.id.iv_back);
        //返回键绑定监听
        iv_back.setOnClickListener(this);
        //初始化标题内容
        title_tv = (TextView) findViewById(R.id.tv_title);
        title_tv.setText("定会议室");
        tv_city = (TextView) findViewById(R.id.tv_city);
        tv_city.setOnClickListener(this);
        //初始化右上角add按键
        add = (ImageView) findViewById(R.id.iv_intent);

        //add绑定监听
        add.setOnClickListener(this);
        //初始化listview
        listView = (MyListView) findViewById(R.id.meetroom_today_lv);

        tv1 = (TextView) findViewById(R.id.tab_tv1);
        tv2 = (TextView) findViewById(R.id.tab_tv2);
        tv3 = (TextView) findViewById(R.id.tab_tv3);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);

        //请求可用会议室列表
        spaceId = 69;
        startRequestMeetRoomData(spaceId);

        //时间选择器
        pvTime = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH_DAY);
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                if (TimeUtils.compareNowTime(TimeUtils.getTime1(date))) {
                    tv3.setText(TimeUtils.getTime1(date));
                    Log.d("zp", "onClick: " + date.toString());
                    todayAdapter.notifyDataSetChanged();
                    nowTime = TimeUtils.getTime1(date);
                    startRequestMeetRoomData(spaceId);
                } else {
                    Toast.makeText(MeetRoomOrderActivity.this, "请选择正确的时间", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //listview的item点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            }
        });
    }

    //开始请求数据
    private void startRequestMeetRoomData(final int id) {
        iphoneDialog.setMessage("请稍候...");
        iphoneDialog.show();
        final HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<MeetRoom> call = api.getMeetRoomList(id);

        call.enqueue(new Callback<MeetRoom>() {
            @Override
            public void onResponse(Call<MeetRoom> call, Response<MeetRoom> response) {

                MeetRoom room = response.body();
                Log.d("zp", "onResponse1: " + room.toString());
                if (room.getCode().equals("200") && room != null) {
                    datas = room.getMsg();
                    final List<StartEndTime> l = new ArrayList<StartEndTime>();
                    final int size = datas.size();
                    final List<MeetRoomOrder> l1 = new ArrayList<MeetRoomOrder>();
                    final List<Integer> l3 = new ArrayList<Integer>();
                    for (int j = 0; j < size; j++) {
                        l1.add(j, new MeetRoomOrder());
                    }
                    final List<MeetRoom.MsgBean> l2 = new ArrayList<MeetRoom.MsgBean>();

                    for (int i = 0; i < size; i++) {
                        l2.add(datas.get(i));
                        String s = datas.get(i).getOpenTime();
                        String s1 = "";
                        String s2 = "";

                        s1 = s.substring(0, 2);
                        s2 = s.substring(6, 8);
                        s1 = s.substring(0, 2);
                        s2 = s.substring(6, 8);

                        int i1 = Integer.parseInt(s1);
                        int i2 = Integer.parseInt(s2);
                        l.add(new StartEndTime(i1, i2));
                        Log.d("zp", "onResponse: id" + datas.get(i).getConferenceId());
                        Call call1 = api.getMeetRoomInfo(id, datas.get(i).getConferenceId(), nowTime);
                        final int finalI = i;
                        call1.enqueue(new Callback<MeetRoomOrder>() {
                            @Override
                            public void onResponse(Call<MeetRoomOrder> call, Response<MeetRoomOrder> response) {
                                MeetRoomOrder mo = response.body();
                                Log.d("zp", "onResponse2: " + mo.toString());
                                if (!mo.equals("")) {

                                    l1.add(finalI, mo);
                                    l1.remove(finalI + 1);
                                    l3.add(finalI);
                                    if (l3.size() == size) {
                                        Log.d("zp", "aaa" + l1.size());
                                        Log.d("zp", "aaa" + l1.toString());
                                        Log.d("zp", "aaa" + l2.toString());
                                        Log.d("zp", "aaa" + l.toString());
                                        iphoneDialog.dismiss();
                                        //初始化adapter
                                        todayAdapter = new TodayAdapter_Meetroom(l1, l, l2, nowTime, MeetRoomOrderActivity.this);
                                        //绑定adapter
                                        listView.setAdapter(todayAdapter);

                                    }
                                } else {
                                    iphoneDialog.dismiss();
                                    Toast.makeText(MeetRoomOrderActivity.this, "暂无数据", Toast.LENGTH_SHORT).show();
                                    Log.e("zp", "onResponse: fail");
                                }

                            }

                            @Override
                            public void onFailure(Call<MeetRoomOrder> call, Throwable t) {
                                iphoneDialog.dismiss();
                                Toast.makeText(MeetRoomOrderActivity.this, "请求失败!!", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }

                } else if (room.getCode().equals("202")) {
                    iphoneDialog.dismiss();
                    Toast.makeText(MeetRoomOrderActivity.this, "暂无数据", Toast.LENGTH_SHORT).show();
                } else {
                    iphoneDialog.dismiss();
                    Toast.makeText(MeetRoomOrderActivity.this, "请求失败...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MeetRoom> call, Throwable t) {
                iphoneDialog.dismiss();
                Toast.makeText(MeetRoomOrderActivity.this, "请求失败!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && data != null) {
            spaceId = data.getIntExtra("spaceId", 0);
            String s2 = data.getStringExtra("spaceName");
            tv_city.setText(s2);
            Log.d("zp", "onActivityResult: " + spaceId);
            todayAdapter.notifyDataSetChanged();
            startRequestMeetRoomData(spaceId);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_city:
                //跳转到会议室列表界面
                Intent i_list = new Intent(this, ConferenceListActivity.class);
                startActivityForResult(i_list, 100);
                break;
            case R.id.tab_tv1:
                tv1.setTextColor(getResources().getColor(R.color.colorBlue));
                tv2.setTextColor(getResources().getColor(R.color.black3));
                tv3.setTextColor(getResources().getColor(R.color.black3));
                todayAdapter.notifyDataSetChanged();
                nowTime = TimeUtils.getNowTime();
                startRequestMeetRoomData(spaceId);
                Log.d("zp", "onClick: " + nowTime);

                break;
            case R.id.tab_tv2:
                tv2.setTextColor(getResources().getColor(R.color.colorBlue));
                tv1.setTextColor(getResources().getColor(R.color.black3));
                tv3.setTextColor(getResources().getColor(R.color.black3));
                todayAdapter.notifyDataSetChanged();
                nowTime = TimeUtils.getTomTime();
                startRequestMeetRoomData(spaceId);
                Log.d("zp", "onClick: " + TimeUtils.getTomTime());

                break;
            case R.id.tab_tv3:
                tv3.setTextColor(getResources().getColor(R.color.colorBlue));
                tv1.setTextColor(getResources().getColor(R.color.black3));
                tv2.setTextColor(getResources().getColor(R.color.black3));
                pvTime.show();
                break;
        }
    }
}
