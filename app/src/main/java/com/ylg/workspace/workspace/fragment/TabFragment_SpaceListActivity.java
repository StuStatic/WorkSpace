package com.ylg.workspace.workspace.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ListViewAdapter_SpaceList;
import com.ylg.workspace.workspace.adapter.NeiborAdapter_Home;
import com.ylg.workspace.workspace.bean.NeiborCompany;
import com.ylg.workspace.workspace.bean.SpaceList;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.util.SetHomeListViewItemHeight;
import com.ylg.workspace.workspace.util.SetSpaceListListViewItemHeight;
import com.ylg.workspace.workspace.view.ListViewForScrollView_SpaceList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * writen by stu on 2017/7/16
 */
public class TabFragment_SpaceListActivity extends Fragment {
    /**
     * @author stu
     */
    private View view;
    private int page;
    public static final String PAGE_POSITION = "page_position";
    private String[] names = {"全部", "上海", "北京", "南京", "成都", "天津", "深圳", "广州", "杭州"};
    private TextView tv_fragment;
    private ListViewForScrollView_SpaceList listview;
    private ListView list;
    private ListViewAdapter_SpaceList adapter;
    private List<SpaceList.MsgEntity> datas;


    public TabFragment_SpaceListActivity() {
        // Required empty public constructor
    }

    public static TabFragment_SpaceListActivity getInstance(int position) {
        TabFragment_SpaceListActivity tabPageFragment = new TabFragment_SpaceListActivity();
        Bundle bundle = new Bundle();
        bundle.putInt(PAGE_POSITION, position);
        tabPageFragment.setArguments(bundle);
        return tabPageFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_spacelist, container, false);
        Log.e("fragmentcreate", "create");
        init(view.getContext());
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = this.getArguments().getInt(PAGE_POSITION);
        Log.e("page:", page + "");
    }

    private void init(final Context context) {
//        tv_fragment = (TextView) view.findViewById(R.id.itemtv_spacelist);
//        tv_fragment.setText(names[page]);

        //初始化lsitview
        listview = (ListViewForScrollView_SpaceList) view.findViewById(R.id.spacelist_lv);


        startRequest(context);


    }

    private void startRequest(final Context context) {
        //开始请求空间列表数据
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<SpaceList> call = api.getSpaceListData("北京");
        call.enqueue(new Callback<SpaceList>() {
            @Override
            public void onResponse(Call<SpaceList> call, Response<SpaceList> response) {
                Log.e("code:",response.body().getCode());
                if(response.body().getCode().equals("200")){
                    datas = response.body().getMsg();
                    //adapter
                    adapter = new ListViewAdapter_SpaceList(context, datas);
                    //绑定adapter
                    listview.setAdapter(adapter);
                    SetSpaceListListViewItemHeight.setHeight(listview);
                }else{
                    Toast.makeText(getContext(), "空间列表信息错误", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SpaceList> call, Throwable t) {

            }
        });
    }
}
