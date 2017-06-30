package com.ylg.workspace.workspace.activity.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.GroupAdapter;
import com.ylg.workspace.workspace.adapter.InvestAdapter;

import java.util.ArrayList;
import java.util.List;

public class InvestActivity extends App implements View.OnClickListener {

    private PopupWindow popupWindow;

    private ListView lv_group;
    private ListView lv;

    private View view;

    private View top_title;

    private TextView tvtitle;

    private List<String> groups;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest);
        initView();
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tvtitle = (TextView) findViewById(R.id.tv_title);
        lv = (ListView) findViewById(R.id.invset_lv);
        Intent i = getIntent();
        String title = i.getStringExtra("getTitle");
        tvtitle.setText(title);
        tvtitle.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        List<String> l = new ArrayList<>();
        l.add("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        l.add("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        l.add("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        l.add("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
        lv.setAdapter(new InvestAdapter(this, l));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_title:
                showWindow(v);
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void showWindow(View parent) {

        if (popupWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = layoutInflater.inflate(R.layout.group_list, null);

            lv_group = (ListView) view.findViewById(R.id.lvGroup);
            // 加载数据
            groups = new ArrayList<String>();
            groups.add("投融资");
            groups.add("人力资源");
            groups.add("法律");
            groups.add("IT");


            GroupAdapter groupAdapter = new GroupAdapter(this, groups);
            lv_group.setAdapter(groupAdapter);
            // 创建一个PopuWidow对象
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        }

        // 使其聚集
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        // 显示的位置为:屏幕的宽度的一半-PopupWindow的高度的一半
        int xPos = windowManager.getDefaultDisplay().getWidth() / 2
                - popupWindow.getWidth() / 2;
        Log.i("coder", "xPos:" + xPos);

        popupWindow.showAsDropDown(parent, xPos, 4);

        lv_group.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {

                tvtitle.setText(groups.get(position));

                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        });
    }
}
