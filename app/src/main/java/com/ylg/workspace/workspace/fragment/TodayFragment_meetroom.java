package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Meetroom;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Workplace;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment_meetroom extends Fragment {
    private List<String> datas;
    private ListView listView;
    private TodayAdapter_Meetroom todayAdapter;
    private String[] address = new String[]{"东四多功能共享会议室"};
    private View view;

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
        listView = (ListView)view.findViewById(R.id.meetroom_today_lv);
        //初始化集合并赋值(其他字段先不加值)
        datas = new ArrayList<>();
        datas.add(address[0]);
        //初始化adapter
        todayAdapter = new TodayAdapter_Meetroom(view.getContext(),datas);
        //绑定adapter
        listView.setAdapter(todayAdapter);
    }

}
