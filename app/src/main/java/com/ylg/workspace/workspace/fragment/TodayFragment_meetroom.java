package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment_meetroom extends Fragment implements View.OnClickListener{
    private List<String> datas;
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
        //初始化集合并赋值(其他字段先不加值)
        datas = new ArrayList<>();
        datas.add(address[0]);
        datas.add(address[1]);
        datas.add(address[2]);
        //初始化adapter
        todayAdapter = new TodayAdapter_Meetroom(view.getContext(),datas);
        //绑定adapter
        listView.setAdapter(todayAdapter);
        //listview的item点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
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
