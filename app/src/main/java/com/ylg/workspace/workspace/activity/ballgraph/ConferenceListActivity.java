package com.ylg.workspace.workspace.activity.ballgraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ListViewAdapter_ConferenceListActivity;

import java.util.ArrayList;
import java.util.List;

public class ConferenceListActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter_ConferenceListActivity adapter;
    private List<String> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferencelist);
        init();
    }

    private void init() {
        datas=new ArrayList<>();
        datas.add("方圆大厦·优客工厂");
        datas.add("海淀黄庄·创新会议室");
        datas.add("天安门城楼");
        datas.add("爱琴海酒吧");
        listView=(ListView)findViewById(R.id.conferencelist_lv);
        adapter = new ListViewAdapter_ConferenceListActivity(this,datas);
        listView.setAdapter(adapter);
    }
}
