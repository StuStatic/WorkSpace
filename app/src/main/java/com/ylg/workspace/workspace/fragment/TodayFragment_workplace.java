package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Workplace;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment_workplace extends Fragment {
    private List<String> datas;
    private String[] title = new String[]{"百草园·优客工场"};
    private String[] address = new String[]{"北京市海淀区中关村南大街甲56号"};
    private String[] number = new String[]{"23号工位可以预定"};
    private String[] price = new String[]{"$199/天"};
    private TodayAdapter_Workplace adapter;
    private ListView listview;
    private View view;

    public TodayFragment_workplace() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_todayworkplace, container, false);
        //初始化
        init();
        return view;
    }

    private void init() {
        //初始化listview
        listview = (ListView)view.findViewById(R.id.workplace_lvtoday);
        //初始化集合并赋值(其他字段先不加值)
        datas = new ArrayList<>();
        datas.add(title[0]);
        //初始化adapter
        adapter = new TodayAdapter_Workplace(view.getContext(),datas);
        //绑定adapter
        listview.setAdapter(adapter);


    }

}
