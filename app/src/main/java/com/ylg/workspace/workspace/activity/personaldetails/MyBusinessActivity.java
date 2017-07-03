package com.ylg.workspace.workspace.activity.personaldetails;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.adapter.BusinessAdapter;
import com.ylg.workspace.workspace.activity.personaldetails.bean.Business;
import com.ylg.workspace.workspace.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyBusinessActivity extends App implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private List<Business> mList;
    private SwipeRefreshView mSwipeRefreshView;
    private ListView mListView;
    private BusinessAdapter mBusinessAdapter;
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
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("我的企业");
        mSwipeRefreshView = (SwipeRefreshView) findViewById(R.id.business_srv);
        mListView = (ListView) findViewById(R.id.business_lv);

        //虚拟数据
        Business b = new Business();
        b.setName("北京物联港科技发展有限公司");
        b.setTime("2017-07-03");
        mList.add(b);


        mBusinessAdapter = new BusinessAdapter(this,mList);
        mListView.setAdapter(mBusinessAdapter);
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
                        mBusinessAdapter.notifyDataSetChanged();
//                        showCustomToast("刷新了一条数据");
                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        mSwipeRefreshView.setRefreshing(false);
                    }
                }, 1200);

                // System.out.println(Thread.currentThread().getName());

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

                        // 添加数据
                        for (int i = 0; i < 5; i++) {
                            // 这里要放在里面刷新，放在外面会导致刷新的进度条卡住
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
                finish();
                break;
            case R.id.business_ll_add://加入企业

                break;
            case R.id.business_ll_new://创建企业

                break;
        }
    }
}
