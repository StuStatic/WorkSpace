package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylg.workspace.workspace.R;

public class SelectionFragment extends android.app.Fragment{


    public SelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View selectionLayout = inflater.inflate(R.layout.fragment_selection, container, false);
        return selectionLayout;
    }

}
