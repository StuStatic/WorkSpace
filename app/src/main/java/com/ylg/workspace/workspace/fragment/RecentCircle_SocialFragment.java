package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ListViewAdapter_RecentCircle;
import com.ylg.workspace.workspace.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecentCircle_SocialFragment extends Fragment {
    private View view;
    private ListView listView;
    private ListViewAdapter_RecentCircle adapter;
    private String[] info = new String[]{"帝高阳之苗裔兮，朕皇考曰伯庸。"};
    private List<String> datas;
    private SwipeRefreshView swipeRefreshView;
    public RecentCircle_SocialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recentcircle, container, false);
        init();
        return  view;
    }

    private void init() {
        swipeRefreshView=(SwipeRefreshView)view.findViewById(R.id.srv_rencentcircle);
        listView = (ListView)view.findViewById(R.id.lv_recentcircle);
        datas = new ArrayList<>();
        //for循环,添加到集合list
        for (int i = 0; i < info.length; i++) {
            datas.add(info[i]);
        }
        adapter = new ListViewAdapter_RecentCircle(getContext(),datas);
        listView.setAdapter(adapter);

        // 下拉时触发SwipeRefreshLayout的下拉动画，动画完毕之后就会回调这个方法

        swipeRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // 开始刷新，设置当前为刷新状态
                //swipeRefreshLayout.setRefreshing(true);

                // 这里是主线程
                // 一些比较耗时的操作，比如联网获取数据，需要放到子线程去执行
                // TODO 获取数据

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        adapter.notifyDataSetChanged();
                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        swipeRefreshView.setRefreshing(false);
                    }
                }, 3000);

                // System.out.println(Thread.currentThread().getName());

                // 这个不能写在外边，不然会直接收起来
                swipeRefreshView.setRefreshing(false);
            }
        });


    }

}
