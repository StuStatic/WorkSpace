package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylg.workspace.workspace.R;


public class ServiceFragment extends android.app.Fragment {


    public ServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View serviceLayout = inflater.inflate(R.layout.fragment_service, container, false);
        return serviceLayout;
    }

}
