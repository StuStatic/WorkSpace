package com.ylg.workspace.workspace.activity.ballgraph;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ExpandableListViewAdater_Exercise;
import com.ylg.workspace.workspace.adapter.ListViewAdapter01_InfoActivity;
import com.ylg.workspace.workspace.bean.Info;

import java.util.ArrayList;
import java.util.List;

public class NeiborActivity extends AppCompatActivity implements View.OnClickListener{
    /**
     * @author stu
     * @param savedInstanceState
     */
    //View
    private ExpandableListView expandableListView01,expandableListView02;
    //返回键图标
    private ImageView img_back;

    //Model：定义的数据
    private String[] groups01 = {"全部类别"};
    private String[] groups02 = {"全部企业"};

    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}
    private String[][] childs01 = {{"法律", "人力资源", "软件服务商", "硬件服务商","其他"}};
    private String[][] childs02 = {{"服务商企业","普通企业"}};

    //listview
    private ListView listview;
    private List<Info.MsgBean> datas_neibor;
    private ListViewAdapter01_InfoActivity adapter;
    private String[] spaceInfo = new String[]{"帝高阳之苗裔兮，朕皇考曰伯庸。","摄提贞于孟陬兮，惟庚寅吾以降","皇览揆余初度兮，肇锡余以嘉名："};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neibor);
        init();
    }

    private void init() {
        //初始化返回键
        img_back =(ImageView)findViewById(R.id.neibor_back);
        //绑定监听
        img_back.setOnClickListener(this);

        //初始化expandableListView
        expandableListView01 = (ExpandableListView)findViewById(R.id.neibor_exlv01);
        expandableListView02 = (ExpandableListView)findViewById(R.id.neibor_exlv02);
        //设置默认箭头不可见
//        expandableListView01.setGroupIndicator(null);
//        expandableListView02.setGroupIndicator(null);

        //加上分割线
//        expandableListView01.setChildDivider();
        //开始绑定
        expandableListView01.setAdapter(new ExpandableListViewAdater_Exercise(NeiborActivity.this,childs01,groups01 ));
        expandableListView02.setAdapter(new ExpandableListViewAdater_Exercise(NeiborActivity.this,childs02,groups02 ));

        //初始化listview
        listview = (ListView)findViewById(R.id.neibor_listview);
        datas_neibor = new ArrayList<>();
        //for循环,添加到集合list
//        for(int i=0; i<spaceInfo.length;i++){
//            datas_neibor.add(spaceInfo[i]);
//        }
        //初始化adapter
        adapter = new ListViewAdapter01_InfoActivity(this,datas_neibor);
        //绑定适配器
        listview.setAdapter(adapter);


    }

    //view的点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.neibor_back:
                //关闭界面
                finish();
                break;
        }

    }
}
