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
import com.ylg.workspace.workspace.activity.personaldetails.adapter.FragmentMakeAnAppinntmentAdapter;
import com.ylg.workspace.workspace.activity.personaldetails.bean.MakeAnAppointFrag;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.view.SwipeRefreshView;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class makeAnAppointmentFragment extends Fragment {

    private View mView;
    private ListView makefragmentanappointmentlv;
    private SwipeRefreshView makefragmentanappointmentsrv;
    private FragmentMakeAnAppinntmentAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_make_an_appointment, container, false);
        initView(mView);
        return mView;
    }

    private void initView(View mView) {
        http();
        makefragmentanappointmentlv = (ListView) mView.findViewById(R.id.make_fragment_an_appointment_lv);
        makefragmentanappointmentsrv = (SwipeRefreshView) mView.findViewById(R.id.make_fragment_an_appointment_srv);




        // 不能在onCreate中设置，这个表示当前是刷新状态，如果一进来就是刷新状态，SwipeRefreshLayout会屏蔽掉下拉事件
        //mSwipeRefreshView.setRefreshing(true);
        // 设置颜色属性的时候一定要注意是引用了资源文件还是直接设置16进制的颜色，因为都是int值容易搞混
        // 设置下拉进度的背景颜色，默认就是白色的
        makefragmentanappointmentsrv.setProgressBackgroundColorSchemeResource(android.R.color.white);
        // 设置下拉进度的主题颜色
        makefragmentanappointmentsrv.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        makefragmentanappointmentsrv.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                        // 加载完数据设置为不刷新状态，将下拉进度收起来
                        makefragmentanappointmentsrv.setRefreshing(false);
                    }
                }, 1200);

                // System.out.println(Thread.currentThread().getName());
                // 这个不能写在外边，不然会直接收起来
                //swipeRefreshLayout.setRefreshing(false);
            }
        });
        // 设置下拉加载更多
        makefragmentanappointmentsrv.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        http();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                        // 加载完数据设置为不加载状态，将加载进度收起来
                        makefragmentanappointmentsrv.setLoading(false);
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

    private void http() {
        HttpAPI httpAPI = Http.getInstance().create(HttpAPI.class);
        httpAPI.findVisitorByUserId(App.USER_ID).enqueue(new Callback<MakeAnAppointFrag>() {
            @Override
            public void onResponse(Call<MakeAnAppointFrag> call, Response<MakeAnAppointFrag> response) {
                if (response.body() != null) {
                    MakeAnAppointFrag body = response.body();
                    if (body.getCode().equals("200")) {
                        List<MakeAnAppointFrag.MsgBean> msg = body.getMsg();
                        adapter = new FragmentMakeAnAppinntmentAdapter(getActivity(), msg);
                        makefragmentanappointmentlv.setAdapter(adapter);

                    } else if (body.getCode().equals("202")) {
                        Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
                    } else if (body.getCode().equals("500")) {
                        Toast.makeText(getActivity(), "数据错误", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MakeAnAppointFrag> call, Throwable t) {
                Log.i("dyy",t.toString());
            }
        });
    }


}
