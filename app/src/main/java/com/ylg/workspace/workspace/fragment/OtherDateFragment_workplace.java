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
import com.ylg.workspace.workspace.adapter.OtherdateAdapter_Workplace;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherDateFragment_workplace extends Fragment {
    private View view;
    //时间选择器
    private TimePickerView pvTime;
    //控件是否初始化完成
    private boolean isViewCreated;
    //数据是否加载完毕
    private boolean isLoadDataCompleted;
    //使用的数据集合
    private List<String> datas;
    private String[] title = new String[]{"百草园·优客工场"};
    private String[] address = new String[]{"北京市海淀区中关村南大街甲56号"};
    private String[] number = new String[]{"23号工位可以预定"};
    private String[] price = new String[]{"$199/天"};
    private OtherdateAdapter_Workplace adapter;
    private ListView listview;

    public OtherDateFragment_workplace() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_otherdateworkplace, container, false);
        init();
       isViewCreated = true;
        Log.e("isViewCreated","isViewCreated");
        return view;
    }

    private void init() {
//        Toast.makeText(view.getContext(), "otherday fragment 启动", Toast.LENGTH_SHORT).show();
        //初始化listview
        listview = (ListView)view.findViewById(R.id.workplace_lvotherday);
        //初始化集合并赋值(其他字段先不加值)
        datas = new ArrayList<>();
        datas.add(title[0]);
        //初始化adapter
        adapter = new OtherdateAdapter_Workplace(view.getContext(),datas);
        //绑定adapter
        listview.setAdapter(adapter);

//        //初始化timepicker
//        pvTime = new TimePickerView(view.getContext(), TimePickerView.Type.YEAR_MONTH_DAY);
//        pvTime.setTime(new Date());
//        pvTime.setCyclic(false);
//        pvTime.setCancelable(true);
//        //展示时间选择器
//        pvTime.show();
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
        //初始化listview
        listview = (ListView)view.findViewById(R.id.workplace_lvotherday);
        //初始化集合并赋值(其他字段先不加值)
        datas = new ArrayList<>();
        datas.add(title[0]);
        //初始化adapter
        adapter = new OtherdateAdapter_Workplace(view.getContext(),datas);
        //绑定adapter
        listview.setAdapter(adapter);



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
