package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.ListViewAdapter_SpaceList;
import com.ylg.workspace.workspace.util.SetHomeListViewItemHeight;
import com.ylg.workspace.workspace.util.SetSpaceListListViewItemHeight;
import com.ylg.workspace.workspace.view.ListViewForScrollView_SpaceList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * writen by stu on 2017/7/16
 */
public class TabFragment_SpaceList extends Fragment {
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
    private String[] title = new String[]{"帝高阳之苗裔兮，朕皇考曰伯庸。", "摄提贞于孟陬兮，惟庚寅吾以降", "皇览揆余初度兮，肇锡余以嘉名：","名余曰正则兮，字余曰灵均。","纷吾既有此内美兮，又重之以修能。","扈江离与辟芷兮，纫秋兰以为佩。"};
    private List<String> datas;


    public TabFragment_SpaceList() {
        // Required empty public constructor
    }

    public static TabFragment_SpaceList getInstance(int position) {
        TabFragment_SpaceList tabPageFragment = new TabFragment_SpaceList();
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
        init();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = this.getArguments().getInt(PAGE_POSITION);
        Log.e("page:", page + "");
    }

    private void init() {
//        tv_fragment = (TextView) view.findViewById(R.id.itemtv_spacelist);
//        tv_fragment.setText(names[page]);

        //初始化listview集合数据
        datas = new ArrayList<>();
        //for循环,添加到集合list
        for (int i = 0; i < title.length; i++) {
            datas.add(title[i]);
            //初始化lsitview
            listview = (ListViewForScrollView_SpaceList) view.findViewById(R.id.spacelist_lv);
//            list = (ListView)view.findViewById(R.id.spacelist_lv);
            //adapter
            adapter = new ListViewAdapter_SpaceList(view.getContext(), datas);
            //绑定adapter
            listview.setAdapter(adapter);
           SetSpaceListListViewItemHeight.setHeight(listview);

//            list.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View view, MotionEvent event) {
//                    switch (event.getAction()) {
//                        case MotionEvent.ACTION_MOVE:
//                            return true;
//                        default:
//                            break;
//                    }
//                    return true;
//                }
//            });
            //setHeight
//            SetSpaceListListViewItemHeight.setHeight(listview);


        }

    }
}
