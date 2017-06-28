package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylg.workspace.workspace.R;


public class MineFragment extends android.app.Fragment {


    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mineLayout = inflater.inflate(R.layout.fragment_mine, container, false);
        return mineLayout;
    }

}
