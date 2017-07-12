package com.ylg.workspace.workspace.activity.ballgraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ExpandableListViewAdater_Exercise;
import com.ylg.workspace.workspace.adapter.ListViewAdapter_ExerviseActivity;

import java.util.ArrayList;
import java.util.List;

public class ExerciseActivity extends AppCompatActivity implements View.OnClickListener{

    //View
    private ExpandableListView expandableListView01,expandableListView02;
    //返回键图标
    private ImageView img_back;
    //TextView
    private TextView title_tv;

    //Model：定义的数据
    private String[] groups01 = {"全部社区"};
    private String[] groups02 = {"全部类别"};

    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}
    private String[][] childs01 = {{"A1社区", "A2社区", "A3社区", "A4社区"}};
    private String[][] childs02 = {{"论坛", "公开课", "沙龙", "直播","其他"}};

    //listview中的title应用实例
    private String[] titles = new String[]{"单身交流会01","久违的58同城"};
    private List<String> datas;
    private ListView listView;
    private ListViewAdapter_ExerviseActivity adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        //初始化
        init();
    }

    private void init() {
        //初始化返回键图标
        img_back = (ImageView)findViewById(R.id.iv_back);
        //绑定点击事件
        img_back.setOnClickListener(this);
        //初始化标题内容
        title_tv = (TextView)findViewById(R.id.tv_title);
        title_tv.setText("活动列表");

        //初始化expandableListView
        expandableListView01 = (ExpandableListView)findViewById(R.id.expandablelistview01);
        expandableListView02 = (ExpandableListView)findViewById(R.id.expandablelistview02);
        //设置默认箭头不可见
        expandableListView01.setGroupIndicator(null);
        expandableListView02.setGroupIndicator(null);
        //加上分割线
        expandableListView01.setChildDivider(getResources().getDrawable(R.drawable.line_itemdivider));
        //开始绑定
        expandableListView01.setAdapter(new ExpandableListViewAdater_Exercise(ExerciseActivity.this,childs01,groups01 ));
        expandableListView02.setAdapter(new ExpandableListViewAdater_Exercise(ExerciseActivity.this,childs02,groups02 ));


        //初始化listview
        listView = (ListView)findViewById(R.id.lv_exercise);
        //初始化集合
        datas = new ArrayList<>();
        //将数组里内容加入到集合中
        datasAdd();
        //初始化adapter
        adapter = new ListViewAdapter_ExerviseActivity(this,datas);
        //绑定adapter
        listView.setAdapter(adapter);
    }

    //将数组内容加入到集合之中
    private void datasAdd() {
        //for循环,添加到集合list
        for(int i=0; i<titles.length;i++){
            datas.add(titles[i]);
        }
    }



    @Override
    public void onClick(View view) {
        //关闭界面
        finish();
    }
}
