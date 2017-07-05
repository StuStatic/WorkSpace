package com.ylg.workspace.workspace.activity.personaldetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.adapter.MyActivitysAdapter;
import com.ylg.workspace.workspace.activity.personaldetails.bean.Activity;
import com.ylg.workspace.workspace.view.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AllFragment extends Fragment {
    private ListView mListView;
    private SwipeRefreshView mSRV;
    private MyActivitysAdapter mAdapter;
    private List<Activity> mList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        initView(view);
        return view;
    }

    private void initView(View mView) {
        mListView = (ListView) mView.findViewById(R.id.myactivity_lv);
        mSRV = (SwipeRefreshView) mView.findViewById(R.id.myactivity_srv);
        mList = new ArrayList<>();
        Activity mActivity1 = new Activity("单身交流会！！！","07/11 15:00-07/11 17:00","阳光100.优客工场","待使用");
        Activity mActivity2 = new Activity("单身交流会！！！","07/11 15:00-07/11 17:00","阳光100.优客工场","待使用");
        mList.add(mActivity1);
        mList.add(mActivity2);
        mAdapter = new MyActivitysAdapter(getActivity(),mList);
        mListView.setAdapter(mAdapter);
        // 不能在onCreate中设置，这个表示当前是刷新状态，如果一进来就是刷新状态，SwipeRefreshLayout会屏蔽掉下拉事件
        //mSwipeRefreshView.setRefreshing(true);
        // 设置颜色属性的时候一定要注意是引用了资源文件还是直接设置16进制的颜色，因为都是int值容易搞混
        // 设置下拉进度的背景颜色，默认就是白色的
        mSRV.setProgressBackgroundColorSchemeResource(android.R.color.white);
        // 设置下拉进度的主题颜色
        mSRV.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);

        mSRV.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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
//                        mBusinessAdapter.notifyDataSetChanged();
//                        showCustomToast("刷新了一条数据");
                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        mSRV.setRefreshing(false);
                    }
                }, 1200);

                // System.out.println(Thread.currentThread().getName());

                // 这个不能写在外边，不然会直接收起来
                //swipeRefreshLayout.setRefreshing(false);
            }
        });
        // 设置下拉加载更多
        mSRV.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        // 添加数据
                        for (int i = 0; i < 5; i++) {
                            // 这里要放在里面刷新，放在外面会导致刷新的进度条卡住
//                            mBusinessAdapter.notifyDataSetChanged();
                        }
                        // 加载完数据设置为不加载状态，将加载进度收起来
                        mSRV.setLoading(false);
                    }
                }, 1200);
            }
        });

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
