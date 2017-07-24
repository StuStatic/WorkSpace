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
import android.widget.RelativeLayout;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Meetroom;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Workplace;
import com.ylg.workspace.workspace.bean.MeetRoom;
import com.ylg.workspace.workspace.bean.SlidePic;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment_meetroom extends Fragment implements View.OnClickListener{
    private List<MeetRoom.MsgEntity> datas;
    private ListView listView;
    private TodayAdapter_Meetroom todayAdapter;
    private String[] address = new String[]{"东四多功能共享会议室","人民大会堂","省办公厅第一会议室"};
    private View view;
    private ImageView img_order;

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
        //初始化img_order
//        img_order=(ImageView)view.findViewById(R.id.meetroom_order_show);
//        img_order.setOnClickListener(this);
        //初始化listview
        listView = (ListView)view.findViewById(R.id.meetroom_today_lv);


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
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<MeetRoom> call = api.getMeetRoomList(69);

        call.enqueue(new Callback<MeetRoom>() {
            @Override
            public void onResponse(Call<MeetRoom> call, Response<MeetRoom> response) {
                Log.e("MeetRoomBody",response.body().toString());
                if(response.body().getCode().equals("200")){
                    datas = response.body().getMsg();
                    //初始化adapter
                    todayAdapter = new TodayAdapter_Meetroom(view.getContext(),datas);
                    //绑定adapter
                    listView.setAdapter(todayAdapter);
                }else if(response.body().getCode().equals("500")){//连接登录不成功
                    Log.e("数据请求不成功",response.body().getCode());
                }
            }

            @Override
            public void onFailure(Call<MeetRoom> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.meetroom_order_show:
                break;
        }
    }
}
