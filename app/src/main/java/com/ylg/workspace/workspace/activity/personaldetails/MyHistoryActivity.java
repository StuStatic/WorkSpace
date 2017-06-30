package com.ylg.workspace.workspace.activity.personaldetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;

public class MyHistoryActivity extends App {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.addActivity(this);
        setContentView(R.layout.activity_my_history);
    }

    @Override
    protected void onDestroy() {
        App.removeActivity(this);
        super.onDestroy();
    }
}
