package com.ylg.workspace.workspace.activity.ballgraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ExpandableListViewAdater_Exercise;

public class ExerciseActivity extends AppCompatActivity {

    //View
    private ExpandableListView expandableListView;

    //Model：定义的数据
    private String[] groups = {"全部社区", "全部类别"};

    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}
    private String[][] childs = {{"A1社区", "A2社区", "A3社区", "A4社区"}, {"论坛", "公开课", "沙龙", "直播","其他"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        //初始化
        init();
    }

    private void init() {
        //初始化
        expandableListView = (ExpandableListView)findViewById(R.id.expandablelistview);
        //设置默认箭头不可见
        expandableListView.setGroupIndicator(null);
        //开始绑定
        expandableListView.setAdapter(new ExpandableListViewAdater_Exercise(ExerciseActivity.this,childs,groups ));
    }
}
