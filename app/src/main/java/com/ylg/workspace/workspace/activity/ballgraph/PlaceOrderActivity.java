package com.ylg.workspace.workspace.activity.ballgraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ListViewAdapter_PlaceOrderActivity;
import com.ylg.workspace.workspace.adapter.TodayAdapter_Meetroom;
import com.ylg.workspace.workspace.bean.MeetRoom;
import com.ylg.workspace.workspace.bean.PlaceList;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceOrderActivity extends AppCompatActivity implements View.OnClickListener{
    private List<PlaceList.MsgEntity> datas;
//    private String[] name = new String[]{"北京市海淀区中关村南大街甲56号优客工场"};
    private ListView listView;
    private ListViewAdapter_PlaceOrderActivity adapter;
    //返回键
    private ImageView img_back;
    //大标题
    private TextView title_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeorder);
        init();
    }

    private void init() {
        //初始化返回键
        img_back = (ImageView)findViewById(R.id.iv_back);
        //绑定适配器
        img_back.setOnClickListener(this);
        //初始化标题内容
        title_tv = (TextView)findViewById(R.id.tv_title);
        title_tv.setText("预定场地");

        //初始化listview
        listView = (ListView)findViewById(R.id.placeorder_listview);
        //初始化集合并赋值(其他字段先不加值)
//        datas = new ArrayList<>();
//        datas.add(name[0]);
        //请求场地列表信息
        startRequestPlaceListDatas();
//        //初始化adapter
//        adapter = new ListViewAdapter_PlaceOrderActivity(this,datas);
//        //绑定adapter
//        listView.setAdapter(adapter);
    }

    private void startRequestPlaceListDatas() {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<PlaceList> call = api.getPlaceList();

        call.enqueue(new Callback<PlaceList>() {
            @Override
            public void onResponse(Call<PlaceList> call, Response<PlaceList> response) {
                if(response.body().getCode().equals("200")){
                    datas = response.body().getMsg();
                    //初始化adapter
                    adapter = new ListViewAdapter_PlaceOrderActivity(PlaceOrderActivity.this,datas);
                    //绑定adapter
                    listView.setAdapter(adapter);;
                }else if(response.body().getCode().equals("500")){//连接登录不成功
                    Log.e("数据请求不成功",response.body().getCode());
                }
            }

            @Override
            public void onFailure(Call<PlaceList> call, Throwable t) {
                Log.e("PlaceOrderActivity请求失败","PlaceOrderActivity请求失败");
            }
        });
    }

    @Override
    public void onClick(View view) {
        //关闭当前界面
        finish();
    }
}
