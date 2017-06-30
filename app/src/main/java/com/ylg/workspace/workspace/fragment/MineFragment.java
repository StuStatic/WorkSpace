package com.ylg.workspace.workspace.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.SetUpActivity;


public class MineFragment extends android.app.Fragment implements View.OnClickListener{
    private ImageView iv_set;

    public MineFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mineLayout = inflater.inflate(R.layout.fragment_mine, container, false);
        init(mineLayout);
        return mineLayout;
    }

    private void init(View mView) {
        iv_set = (ImageView) mView.findViewById(R.id.mine_iv_intent);
        iv_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_iv_intent:
                Log.i("dyy","设置个人中心");
                Intent i = new Intent(getActivity(),SetUpActivity.class);
                startActivity(i);
                break;
        }
    }
}
