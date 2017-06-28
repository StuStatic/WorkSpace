package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylg.workspace.workspace.R;


public class SocialFragment extends android.app.Fragment {


    public SocialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View socialLayout = inflater.inflate(R.layout.fragment_social, container, false);
        return socialLayout;
    }

}
