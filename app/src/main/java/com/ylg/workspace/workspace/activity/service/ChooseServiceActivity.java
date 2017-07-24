package com.ylg.workspace.workspace.activity.service;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.service.adapter.MyAdapter;
import com.ylg.workspace.workspace.activity.service.adapter.SubAdapter;
import com.ylg.workspace.workspace.activity.service.bean.ServiceType;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseServiceActivity extends App implements View.OnClickListener {

    private MyListView listView;
    private MyListView subListView;
    private MyAdapter myAdapter;
    private SubAdapter subAdapter;
    private TextView tvtitle;
    private ImageView iv_back;

    private List<String> left = new ArrayList<>();
    private List<List<String>> right = new ArrayList<>();
    private List<List<Integer>> index = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_service);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tvtitle = (TextView) findViewById(R.id.tv_title);
        listView = (MyListView) findViewById(R.id.listView);
        subListView = (MyListView) findViewById(R.id.subListView);
        tvtitle.setText("选择服务类别");
        iv_back.setOnClickListener(this);
        getData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                // TODO Auto-generated method stub
                final int location = position;
                myAdapter.setSelectedPosition(location);
                myAdapter.notifyDataSetInvalidated();
                subAdapter = new SubAdapter(getApplicationContext(), right.get(location), location);
                subListView.setAdapter(subAdapter);
                subListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1,
                                            int position, long arg3) {
                        // TODO Auto-generated method stub
                        Intent mIntent = new Intent();
                        mIntent.putExtra("service", left.get(location) + "-" + right.get(location).get(position));
                        mIntent.putExtra("index", index.get(location).get(position));
                        // 设置结果，并进行传送
                        setResult(0, mIntent);
                        finish();
                        //Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void selectDefault() {
        final int location = 0;
        myAdapter.setSelectedPosition(0);
        myAdapter.notifyDataSetInvalidated();
        subAdapter = new SubAdapter(getApplicationContext(), right.get(0), 0);
        subListView.setAdapter(subAdapter);
        subListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                Intent mIntent = new Intent();
                mIntent.putExtra("service", left.get(location) + "-" + right.get(location).get(position));
                mIntent.putExtra("index", index.get(location).get(position));
                // 设置结果，并进行传送
                setResult(0, mIntent);
                finish();
                // TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), right[location][position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<ServiceType> call = api.getServiceType();

        call.enqueue(new Callback<ServiceType>() {
            @Override
            public void onResponse(Call<ServiceType> call, Response<ServiceType> response) {
                ServiceType serviceType = response.body();
                if (serviceType.getCode().equals("200")) {

                    Log.d("zp", "onResponse: " + serviceType.toString());
                    for (int i = 0; i < serviceType.getMsg().size(); i++) {
                        left.add(serviceType.getMsg().get(i).getLabelClassify());
                        List<String> list = new ArrayList<String>();
                        List<Integer> list1 = new ArrayList<>();
                        for (int j = 0; j < serviceType.getMsg().get(i).getClassifySubclass().size(); j++) {
                            list.add(serviceType.getMsg().get(i).getClassifySubclass().get(j).getClassifySubclass());
                            list1.add(serviceType.getMsg().get(i).getClassifySubclass().get(j).getLabelId());
                        }
                        right.add(list);
                        index.add(list1);
                    }
                    Log.d("zp", "right " + right.toString());
                    myAdapter = new MyAdapter(getApplicationContext(), left);
                    listView.setAdapter(myAdapter);

                    selectDefault();

                } else {
                    showShortMsg("请求失败");
                }
            }

            @Override
            public void onFailure(Call<ServiceType> call, Throwable t) {
                showShortMsg("请求失败");
            }
        });
    }
}
