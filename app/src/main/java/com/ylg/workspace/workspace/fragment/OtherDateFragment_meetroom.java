package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bigkoo.pickerview.TimePickerView;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.OtherdateAdapter_Meetroom;
import com.ylg.workspace.workspace.adapter.OtherdateAdapter_Workplace;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Meetroom;
import com.ylg.workspace.workspace.bean.MeetRoom;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherDateFragment_meetroom extends Fragment {
    private List<MeetRoom.MsgEntity> datas;
    private ListView listView;
    //时间选择器
    private TimePickerView pvTime;
    //控件是否初始化完成
    private boolean isViewCreated;
    //数据是否加载完毕
    private boolean isLoadDataCompleted;
    private OtherdateAdapter_Meetroom otherdateAdapter;
//    private String[] address = new String[]{"东莞第四街道按摩大厅","山水庄园"};
    private View view;

    public OtherDateFragment_meetroom() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_otherdatemeetroom, container, false);
        init();
        isViewCreated = true;
        Log.e("isViewCreated","isViewCreated");
        return view;
    }

    private void init() {
        //初始化listview
        listView = (ListView)view.findViewById(R.id.meetroom_otherdate_lv);
//        //初始化集合并赋值(其他字段先不加值)
//        datas = new ArrayList<>();
//        datas.add(address[0]);
//        datas.add(address[1]);
        //初始化adapter

        //获取列表内容
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
                    otherdateAdapter = new OtherdateAdapter_Meetroom(view.getContext(),datas);
                    //绑定adapter
                    listView.setAdapter(otherdateAdapter);
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isViewCreated && !isLoadDataCompleted) {
//            isLoadDataCompleted = true;
            Log.e("setUserVisibleHint","setUserVisibleHint");
            loadData();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getUserVisibleHint()) {
//            isLoadDataCompleted = true;
            Log.e("isLoadDataCompleted","isLoadDataCompleted");
//            loadData();
        }
    }

    private void loadData() {
        //初始化timepicker
        pvTime = new TimePickerView(view.getContext(), TimePickerView.Type.YEAR_MONTH_DAY);
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);

        //展示时间选择器
        pvTime.show();

        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
//                tvTime.setText(getTime(date));
            }
        });
    }

}
