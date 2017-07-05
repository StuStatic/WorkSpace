package com.ylg.workspace.workspace.Application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.view.HandyTextView;

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

    /** 显示自定义Toast提示(来自res) **/
    protected void showCustomToast(int resId) {
        showCustomToast(getString(resId));
    }

    /** 显示自定义Toast提示(来自String) **/
    @SuppressLint("InflateParams")
    public void showCustomToast(String text) {
        View toastRoot = LayoutInflater.from(App.this).inflate(R.layout.common_toast, null);
        ((HandyTextView) toastRoot.findViewById(R.id.toast_text)).setText(text);
        Toast toast = new Toast(App.this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastRoot);
        toast.show();
    }
    /** Debug输出Log日志 **/
    protected static void showLogDebug(String tag, String msg) {
        Log.d(tag, msg);
    }

    /** Error输出Log日志 **/
    protected static void showLogError(String tag, String msg) {
        Log.e(tag, msg);
    }

    /** 通过Class跳转界面 **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /** 含有Bundle通过Class跳转界面 **/
    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /** 通过Action跳转界面 **/
    protected void startActivity(String action) {
        startActivity(action, null);
    }

    /** 含有Bundle通过Action跳转界面 **/
    protected void startActivity(String action, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    /** 含有标题和内容的对话框 **/
    protected AlertDialog showAlertDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message).show();
        return alertDialog;
    }

    /** 含有标题、内容、两个按钮的对话框 **/
    public AlertDialog showAlertDialog(String title, String message, String positiveText,
                                       DialogInterface.OnClickListener onPositiveClickListener, String negativeText,
                                       DialogInterface.OnClickListener onNegativeClickListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message)
                .setPositiveButton(positiveText, onPositiveClickListener)
                .setNegativeButton(negativeText, onNegativeClickListener).show();
        return alertDialog;
    }

    /** 含有标题、内容、一个按钮的对话框 **/
    protected AlertDialog showAlertDialog(String title, String message, String positiveText,
                                          DialogInterface.OnClickListener onPositiveClickListener) {
        if (onPositiveClickListener == null) {
            onPositiveClickListener = new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            };
        }
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message)
                .setPositiveButton(positiveText, onPositiveClickListener).show();
        return alertDialog;
    }

    /** 含有标题、内容、图标、两个按钮的对话框 **/
    protected AlertDialog showAlertDialog(String title, String message, int icon, String positiveText,
                                          DialogInterface.OnClickListener onPositiveClickListener, String negativeText,
                                          DialogInterface.OnClickListener onNegativeClickListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message).setIcon(icon)
                .setPositiveButton(positiveText, onPositiveClickListener)
                .setNegativeButton(negativeText, onNegativeClickListener).show();
        return alertDialog;
    }


}
