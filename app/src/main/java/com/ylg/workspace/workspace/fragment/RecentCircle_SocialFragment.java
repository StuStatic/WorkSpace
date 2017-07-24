package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ListViewAdapter_RecentCircle;

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
        listView = (ListView)view.findViewById(R.id.lv_recentcircle);
        datas = new ArrayList<>();
        //for循环,添加到集合list
        for (int i = 0; i < info.length; i++) {
            datas.add(info[i]);
        }
        adapter = new ListViewAdapter_RecentCircle(getContext(),datas);
        listView.setAdapter(adapter);
    }

}
