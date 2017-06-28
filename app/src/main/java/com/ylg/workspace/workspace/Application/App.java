package com.ylg.workspace.workspace.Application;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;

public class App extends AppCompatActivity{
    private static LinkedList<Activity> mList = new LinkedList<>();
    @Override
    public void onCreate(Bundle savedInstanceState,PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
    //创建Activity时添加到集合中
    public static void addActivity(Activity mActivity){
        if (mList.contains(mActivity)){
            return;
        }
        mList.add(mActivity);
    }
    //销毁Activity时从集合中移除
    public static void removeActivity(Activity activity) {
        if (mList.contains(activity)) {
            mList.remove(activity);
        }
    }

    //一键退出
    public static void destoryAll() {
        for (Activity ac : mList) {
            ac.finish();
        }
        System.exit(0);
    }





}
