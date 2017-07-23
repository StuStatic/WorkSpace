package com.ylg.workspace.workspace.activity.personaldetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.adapter.MyActivitysEndAdapter;
import com.ylg.workspace.workspace.activity.personaldetails.bean.NotMyActivity;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.view.SwipeRefreshView;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PendingUseFragment extends Fragment {

    private ListView myactivitylvend;
    private SwipeRefreshView myactivitysrvend;
    private MyActivitysEndAdapter mMyActivitysNoAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pending_use, container, false);
        initialize(view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void initialize(View view) {
        Http();

        myactivitylvend = (ListView) view.findViewById(R.id.myactivity_lv_end);
        myactivitysrvend = (SwipeRefreshView) view.findViewById(R.id.myactivity_srv_end);

        // 不能在onCreate中设置，这个表示当前是刷新状态，如果一进来就是刷新状态，SwipeRefreshLayout会屏蔽掉下拉事件
        //mSwipeRefreshView.setRefreshing(true);
        // 设置颜色属性的时候一定要注意是引用了资源文件还是直接设置16进制的颜色，因为都是int值容易搞混
        // 设置下拉进度的背景颜色，默认就是白色的
        myactivitysrvend.setProgressBackgroundColorSchemeResource(android.R.color.white);
        // 设置下拉进度的主题颜色
        myactivitysrvend.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);

        myactivitysrvend.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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
                        Http();
                        if (mMyActivitysNoAdapter !=null){

                            mMyActivitysNoAdapter.notifyDataSetChanged();
                        }

                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        myactivitysrvend.setRefreshing(false);
                    }
                }, 1200);

                // 这个不能写在外边，不然会直接收起来
                //swipeRefreshLayout.setRefreshing(false);
            }
        });
        // 设置下拉加载更多
        myactivitysrvend.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Http();
                        if (mMyActivitysNoAdapter !=null){

                            mMyActivitysNoAdapter.notifyDataSetChanged();
                        }

                        // 加载完数据设置为不加载状态，将加载进度收起来
                        myactivitysrvend.setLoading(false);
                    }
                }, 1200);
            }
        });

    }

    /**
     * 网络请求
     */
    private void Http() {
        HttpAPI httpAPI = Http.getInstance().create(HttpAPI.class);
        httpAPI.findByUserIdMyActivity1(App.USER_ID, "2").enqueue(new Callback<NotMyActivity>() {
            @Override
            public void onResponse(Call<NotMyActivity> call, Response<NotMyActivity> response) {
                NotMyActivity body = response.body();
                Log.i("dyy","未开始启动");
                if (response.body() != null) {
                    if (body.getCode().equals("200")) {
                        mMyActivitysNoAdapter = new MyActivitysEndAdapter(getActivity(), body.getMsg());
                        myactivitylvend.setAdapter(mMyActivitysNoAdapter);
                    } else if (body.getCode().equals("202")) {
                        Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.i("dyy", "数据有问题");
                }
            }

            @Override
            public void onFailure(Call<NotMyActivity> call, Throwable t) {
                Log.i("dyy", "数据有问题"+t.toString());
            }
        });
    }

}
