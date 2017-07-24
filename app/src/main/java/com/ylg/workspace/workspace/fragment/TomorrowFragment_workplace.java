package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Workplace;
import com.ylg.workspace.workspace.adapter.TomorrowAdapter_Workplace;
import com.ylg.workspace.workspace.bean.WorkPlace;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TomorrowFragment_workplace extends Fragment {
    private List<WorkPlace.MsgEntity> datas;
    private TomorrowAdapter_Workplace adapter;
    private ListView listview;
    private View view;

    public TomorrowFragment_workplace() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tomorrowworkplace, container, false);
        //初始化
        init();
        return view;
    }

    private void init() {
        //初始化listview
        listview = (ListView)view.findViewById(R.id.workplace_lvtomorrow);
        //请求列表信息
        startRequestWorkPlaceDatas();


    }

    private void startRequestWorkPlaceDatas() {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<WorkPlace> call = api.getWorkPlaceList();

        call.enqueue(new Callback<WorkPlace>() {
            @Override
            public void onResponse(Call<WorkPlace> call, Response<WorkPlace> response) {
                if(response.body().getCode().equals("200")){
                    datas = response.body().getMsg();
                    //初始化adapter
                    adapter = new TomorrowAdapter_Workplace(view.getContext(),datas);
                    //绑定adapter
                    listview.setAdapter(adapter);
                }else if(response.body().getCode().equals("500")){//连接登录不成功
                    Log.e("数据请求不成功",response.body().getCode());
                }
            }

            @Override
            public void onFailure(Call<WorkPlace> call, Throwable t) {

            }
        });
    }

}
