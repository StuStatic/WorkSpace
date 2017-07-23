package com.ylg.workspace.workspace.activity.personaldetails;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.adapter.BusinessAdapter;
import com.ylg.workspace.workspace.activity.personaldetails.bean.Business;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBusinessActivity extends App implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private List<Business> mList;
    private SwipeRefreshView mSwipeRefreshView;
    private ListView mListView;
    private BusinessAdapter mBusinessAdapter;
    private LinearLayout mLinearLayout_NEW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_my_business);
        initView();
    }

    private void initView() {
        mList = new ArrayList<>();
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("我的企业");
        mSwipeRefreshView = (SwipeRefreshView) findViewById(R.id.business_srv);
        mListView = (ListView) findViewById(R.id.business_lv);
        mLinearLayout_NEW = (LinearLayout) findViewById(R.id.business_ll_new);
        mLinearLayout_NEW.setOnClickListener(this);
        http();
        // 不能在onCreate中设置，这个表示当前是刷新状态，如果一进来就是刷新状态，SwipeRefreshLayout会屏蔽掉下拉事件
        //mSwipeRefreshView.setRefreshing(true);

        // 设置颜色属性的时候一定要注意是引用了资源文件还是直接设置16进制的颜色，因为都是int值容易搞混
        // 设置下拉进度的背景颜色，默认就是白色的
        mSwipeRefreshView.setProgressBackgroundColorSchemeResource(android.R.color.white);
        // 设置下拉进度的主题颜色
        mSwipeRefreshView.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);

        mSwipeRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 开始刷新，设置当前为刷新状态
                //swipeRefreshLayout.setRefreshing(true);

                // 这里是主线程
                // 一些比较耗时的操作，比如联网获取数据，需要放到子线程去执行
                // TODO 获取数据
                final Random random = new Random();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        http();
                        if (mBusinessAdapter !=null){
                            mBusinessAdapter.notifyDataSetChanged();
                        }
                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        mSwipeRefreshView.setRefreshing(false);
                    }
                }, 1200);

                // 这个不能写在外边，不然会直接收起来
                //swipeRefreshLayout.setRefreshing(false);
            }
        });
        // 设置下拉加载更多
        mSwipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        http();
                        if (mBusinessAdapter !=null){
                            mBusinessAdapter.notifyDataSetChanged();
                        }
                        // 加载完数据设置为不加载状态，将加载进度收起来
                        mSwipeRefreshView.setLoading(false);
                    }
                }, 1200);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                Log.i("dyy","退出......");
                finish();
                break;
            case R.id.business_ll_add://加入企业

                break;
            case R.id.business_ll_new://创建企业
                startActivity(CreateEnterpriseActivity.class);
                break;
        }
    }
    //网络请求
    private void http(){
        //第一个参数是文件名，第二个参数是模式（不明白可以去补习一下SharedPreferences的知识）
        SharedPreferences shared = getSharedPreferences("mypsd2", MODE_PRIVATE);
        String companyId = shared.getString("companyId", "");//同上，若没找到就让它为空""企业ID
        HttpAPI httpAPI = Http.getInstance().create(HttpAPI.class);
        httpAPI.findMyCompany(companyId).enqueue(new Callback<Business>() {
            @Override
            public void onResponse(Call<Business> call, Response<Business> response) {
                Log.i("dyy",response.body().toString());
                if (response.body().toString().length() != 0){
                    Business body = response.body();
                    if (body.getCode().equals("200")){
                        List<Business.MsgBean> msg = body.getMsg();
                        mBusinessAdapter = new BusinessAdapter(getApplication(),msg);
                        mListView.setAdapter(mBusinessAdapter);
                    }else if (body.getCode().equals("202")){
                        Toast.makeText(MyBusinessActivity.this, "没有企业，请加入企业。", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Log.i("dyy","我的企业数据错误");
                }
            }
            @Override
            public void onFailure(Call<Business> call, Throwable t) {
                Log.i("dyy","我的企业:"+t.toString());
            }
        });
    }

}
