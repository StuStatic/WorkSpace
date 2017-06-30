package com.ylg.workspace.workspace.activity.personaldetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;

public class SetUpActivity extends App implements View.OnClickListener{
    private TextView mTitle;
    private ImageView iv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.addActivity(this);
        setContentView(R.layout.activity_set_up);
        init();
    }

    private void init() {
        mTitle = (TextView) findViewById(R.id.tv_title);
        mTitle.setText(R.string.set_up_title);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
