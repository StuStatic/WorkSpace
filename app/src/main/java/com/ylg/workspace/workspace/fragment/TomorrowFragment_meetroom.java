package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.TomorrowAdapter_Meetroom;
import com.ylg.workspace.workspace.bean.MeetRoom;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TomorrowFragment_meetroom extends Fragment {
    private List<MeetRoom.MsgBean> datas;
    private ListView listView;
    private TomorrowAdapter_Meetroom tomorrowAdapter;
//    private String[] address = new String[]{"多功能会议室"};
    private View view;

    public TomorrowFragment_meetroom() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tomorrowmeetroom, container, false);
        init();
        return view;
    }

    private void init() {
        //初始化listview
        listView = (ListView)view.findViewById(R.id.meetroom_tomorrow_lv);
        //初始化集合并赋值(其他字段先不加值)
        //请求数据
        startRequestMeetRoomDatas();

    }

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
                    tomorrowAdapter = new TomorrowAdapter_Meetroom(view.getContext(),datas);
                    //绑定adapter
                    listView.setAdapter(tomorrowAdapter);
                }else if(response.body().getCode().equals("500")){//连接登录不成功
                    Log.e("数据请求不成功",response.body().getCode());
                }
            }

            @Override
            public void onFailure(Call<MeetRoom> call, Throwable t) {

            }
        });
    }

}
