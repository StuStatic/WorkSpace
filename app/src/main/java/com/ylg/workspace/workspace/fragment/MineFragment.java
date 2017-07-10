package com.ylg.workspace.workspace.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
//import com.ylg.workspace.workspace.activity.personaldetails.MyActivity;
import com.ylg.workspace.workspace.activity.personaldetails.LoginActivity;
import com.ylg.workspace.workspace.activity.personaldetails.MyActivity;
import com.ylg.workspace.workspace.activity.personaldetails.MyBusinessActivity;
import com.ylg.workspace.workspace.activity.personaldetails.MyHistoryActivity;
import com.ylg.workspace.workspace.activity.personaldetails.MyInformationActivity;
import com.ylg.workspace.workspace.activity.personaldetails.SetUpActivity;
import com.ylg.workspace.workspace.http.bean.Login;


public class MineFragment extends android.app.Fragment implements View.OnClickListener {

    private ImageView iv_set;
    private RelativeLayout mineOrderMybusiness;
    private RelativeLayout mineOrderMyactivitys;
    private RelativeLayout mineOrderMyHistory;
    private ImageView mineUserHeadportrait,mine_user_gender;
    private TextView mTextView,mlogin,mine_user_Name,mine_user_constellation,mine_user_autograph;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mineLayout = inflater.inflate(R.layout.fragment_mine, container, false);
        init(mineLayout);
        return mineLayout;
    }

    private void init(View mView) {
        iv_set = (ImageView) mView.findViewById(R.id.mine_iv_intent);
        iv_set.setOnClickListener(this);
        mineUserHeadportrait = (ImageView) mView.findViewById(R.id.mine_user_Headportrait);
        mine_user_gender = (ImageView) mView.findViewById(R.id.mine_user_gender);
        mineOrderMyHistory = (RelativeLayout) mView.findViewById(R.id.mine_Order_MyHistory);
        mineOrderMyHistory.setOnClickListener(this);
        mineOrderMybusiness = (RelativeLayout) mView.findViewById(R.id.mine_Order_Mybusiness);
        mineOrderMybusiness.setOnClickListener(this);
        mineOrderMyactivitys = (RelativeLayout) mView.findViewById(R.id.mine_Order_Myactivitys);
        mineOrderMyactivitys.setOnClickListener(this);
        mTextView = (TextView) mView.findViewById(R.id.mine_Order_detailed);
        mTextView.setOnClickListener(this);
        mine_user_Name = (TextView) mView.findViewById(R.id.mine_user_Name);
        mine_user_constellation = (TextView) mView.findViewById(R.id.mine_user_constellation);
        mine_user_autograph = (TextView) mView.findViewById(R.id.mine_user_autograph);
        mlogin = (TextView) mView.findViewById(R.id.mine_user_login);
        mlogin.setOnClickListener(this);
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i("dyy",App.KEY_LOGIN+"");
        if (App.KEY_LOGIN == 1){
            mineUserHeadportrait.setOnClickListener(null);
        }else if (App.KEY_LOGIN == 2){
            mineUserHeadportrait.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_iv_intent:
                Log.i("dyy", "设置个人中心");
                Intent i = new Intent(getActivity(), SetUpActivity.class);
                startActivity(i);
                break;
            case R.id.mine_Order_MyHistory:
                Log.i("dyy", "我的历史");
                Intent MyHistoryIntent = new Intent(getActivity(), MyHistoryActivity.class);
                startActivity(MyHistoryIntent);
                break;
            case R.id.mine_Order_Mybusiness:
                Log.i("dyy", "我的企业");
                Intent MyBusinessIntent = new Intent(getActivity(), MyBusinessActivity.class);
                startActivity(MyBusinessIntent);
                break;
            case R.id.mine_Order_Myactivitys:
                Log.i("dyy", "我的活动");
                Intent myActivitysIntent = new Intent(getActivity(), MyActivity.class);
                startActivity(myActivitysIntent);
                break;
            case R.id.mine_user_Headportrait:
                Log.i("dyy", "我的信息");
                Intent mineuserheadportraitIntent = new Intent(getActivity(), MyInformationActivity.class);
                startActivity(mineuserheadportraitIntent);
                break;
            case R.id.mine_user_login:
                Log.i("dyy", "登陆");
                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(loginIntent,0);
                break;
        }
    }
    //登陆返回的数据
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            if (resultCode == 1){

                mlogin.setVisibility(View.GONE);
                mine_user_Name.setVisibility(View.VISIBLE);
                mine_user_gender.setVisibility(View.VISIBLE);
                mine_user_constellation.setVisibility(View.VISIBLE);
                mine_user_autograph.setVisibility(View.VISIBLE);

                Bundle extras = data.getExtras();
                if (extras!=null){
                    Log.i("dyy","登陆返回："+extras.getString("username"));
                    Log.i("dyy","登陆返回："+extras.getString("companyName"));
                    Log.i("dyy","登陆返回："+extras.getString("headPortrait"));
                    Log.i("dyy","登陆返回："+extras.getString("realName"));
                    Log.i("dyy","登陆返回："+extras.getString("sex"));
                    Log.i("dyy","登陆返回："+extras.getString("spared1"));

                    mine_user_Name.setText(extras.getString("username"));
                    if (extras.getString("sex").equals("man")){
                        mine_user_gender.setImageResource(R.drawable.man_icon);
                    }else {
                        mine_user_gender.setImageResource(R.drawable.girl_icon);
                    }
                    mine_user_autograph.setText(extras.getString("spared1"));

                }
            }
        }



    }
}
