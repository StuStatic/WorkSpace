package com.ylg.workspace.workspace.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.view.SwipeRefreshView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpaceMarket_SocialFragment extends Fragment {

    //内容
    private SwipeRefreshView swipeRefresh;
    private List<String> datas;

    public SpaceMarket_SocialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spacemarket, container, false);
    }

}
