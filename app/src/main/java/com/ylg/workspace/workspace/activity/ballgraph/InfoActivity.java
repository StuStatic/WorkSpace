package com.ylg.workspace.workspace.activity.ballgraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ListViewAdapter01_InfoActivity;
import com.ylg.workspace.workspace.adapter.ListViewAdapter02_InfoActivity;
import com.ylg.workspace.workspace.util.SetCompanyListViewItemHeight;
import com.ylg.workspace.workspace.util.SetSpaceListViewItemHeight;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{//
    private List<String> datas_space,datas_company;
    private ListView listView_space,listView_company;
    private String[] spaceInfo = new String[]{"帝高阳之苗裔兮，朕皇考曰伯庸。","摄提贞于孟陬兮，惟庚寅吾以降","皇览揆余初度兮，肇锡余以嘉名："};
    private String[] companyInfo = new String[]{"名余曰正则兮，字余曰灵均。","纷吾既有此内美兮，又重之以修能。","扈江离与辟芷兮，纫秋兰以为佩。"};
    private ListViewAdapter01_InfoActivity adapter_space;
    private ListViewAdapter02_InfoActivity adapter_company;
    //标题返回键
    private ImageView img_back;
    //大标题
    private TextView title_tv;

//    private ListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        init();
    }

    private void init() {
        //初始化ImageView
        img_back = (ImageView)findViewById(R.id.iv_back);
        //绑定监听器v
        img_back.setOnClickListener(this);
        //设置标题
        title_tv = (TextView)findViewById(R.id.tv_title);
        title_tv.setText("资讯");


        //初始化listview
        listView_space = (ListView)findViewById(R.id.lv_spaceinfo);
        listView_company = (ListView)findViewById(R.id.lv_companyInfo);
        //初始化List集合
        datas_space= new ArrayList<>();
        datas_company = new ArrayList<>();

        //for循环,添加到集合list
        for(int i=0; i<spaceInfo.length;i++){
            datas_space.add(spaceInfo[i]);
        }
        for(int j=0 ; j<companyInfo.length;j++){
            datas_company.add(companyInfo[j]);

        }

        //初始化adapter
        adapter_space = new ListViewAdapter01_InfoActivity(this,datas_space);
        listView_space.setAdapter(adapter_space);
        //重新设置listview的item的高度
        SetSpaceListViewItemHeight.setHeight(listView_space);
        //同上
        adapter_company = new ListViewAdapter02_InfoActivity(this,datas_company);
        listView_company.setAdapter(adapter_company);
        SetCompanyListViewItemHeight.setHeight(listView_company);



        //绑定适配器
        listView_space.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(InfoActivity.this, spaceInfo[i], Toast.LENGTH_SHORT).show();
            }
        });
        listView_company.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                Toast.makeText(InfoActivity.this, companyInfo[j], Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public void onClick(View view) {
        finish();
    }
}
