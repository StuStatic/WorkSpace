package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Meetroom;
import com.ylg.workspace.workspace.bean.MeetRoom;
import com.ylg.workspace.workspace.bean.MeetRoomOrder;
import com.ylg.workspace.workspace.bean.StartEndTime;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment_meetroom extends Fragment implements View.OnClickListener {
    private List<MeetRoom.MsgBean> datas;
    private ListView listView;
    private TodayAdapter_Meetroom todayAdapter;
    private String[] address = new String[]{"东四多功能共享会议室", "人民大会堂", "省办公厅第一会议室"};
    private View view;
    private ImageView img_order;
    private SimpleDateFormat formatter;
    private Date date;

    public TodayFragment_meetroom() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_todaymeetroom, container, false);
        init();
        return view;
    }

    private void init() {

        //初始化listview
        listView = (ListView) view.findViewById(R.id.meetroom_today_lv);
        formatter = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = formatter.parse("2017/8/4");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //请求可用会议室列表
        startRequestMeetRoomDatas();

        //listview的item点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            }
        });
    }

    //开始请求数据
    private void startRequestMeetRoomDatas() {
        final HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<MeetRoom> call = api.getMeetRoomList(69);

        call.enqueue(new Callback<MeetRoom>() {
            @Override
            public void onResponse(Call<MeetRoom> call, Response<MeetRoom> response) {
                Log.e("MeetRoomBody", response.body().toString());
                MeetRoom room = response.body();
                if (room.getCode().equals("200") && !room.equals("")) {
                    datas = room.getMsg();
                    final List<StartEndTime> l=new ArrayList<StartEndTime>();
                    final List<MeetRoomOrder> l1=new ArrayList<MeetRoomOrder>();
                    final int size= datas.size();
                    for (int i = 0; i < size; i++) {
                        String s=datas.get(i).getOpenTime();
                        String s1=s.substring(0,2);
                        String s2=s.substring(6,8);
                        int i1=Integer.parseInt(s1);
                        int i2=Integer.parseInt(s2);
                        l.add(new StartEndTime(i1,i2));

                        Call call1=api.getMeetRoomInfo(69,datas.get(i).getConferenceId(),"2017/08/04");
                        call1.enqueue(new Callback<MeetRoomOrder>() {
                            @Override
                            public void onResponse(Call<MeetRoomOrder> call, Response<MeetRoomOrder> response) {
                                MeetRoomOrder mo=response.body();
                                if (!mo.equals("")){

                                   l1.add(mo);
                                    if (l1.size()==size){
                                        //初始化adapter
                                        //todayAdapter = new TodayAdapter_Meetroom(l1,l,datas,getContext());
                                        //绑定adapter
                                        listView.setAdapter(todayAdapter);
                                    }
                                }else {
                                    Toast.makeText(getContext(), "失败..", Toast.LENGTH_SHORT).show();
                                    Log.e("zp", "onResponse: fail");
                                }

                            }

                            @Override
                            public void onFailure(Call<MeetRoomOrder> call, Throwable t) {

                            }
                        });


                    }

                } else if (response.body().getCode().equals("500")) {//连接登录不成功
                    Log.e("数据请求不成功", response.body().getCode());
                }
            }

            @Override
            public void onFailure(Call<MeetRoom> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.meetroom_order_show:
                break;
        }
    }
}
