package com.ylg.workspace.workspace.Application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class App extends AppCompatActivity {
    private static LinkedList<Activity> mList = new LinkedList<>();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    //创建Activity时添加到集合中
    public static void addActivity(Activity mActivity) {
        if (mList.contains(mActivity)) {
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

    /**
     * 显示自定义Toast提示(来自res)
     **/
    protected void showCustomToast(int resId) {
        showCustomToast(getString(resId));
    }

    /**
     * 显示自定义Toast提示(来自String)
     **/
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

    /**
     * Debug输出Log日志
     **/
    protected static void showLogDebug(String tag, String msg) {
        Log.d(tag, msg);
    }

    /**
     * Error输出Log日志
     **/
    protected static void showLogError(String tag, String msg) {
        Log.e(tag, msg);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 通过Action跳转界面
     **/
    protected void startActivity(String action) {
        startActivity(action, null);
    }

    /**
     * 含有Bundle通过Action跳转界面
     **/
    protected void startActivity(String action, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 含有标题和内容的对话框
     **/
    protected AlertDialog showAlertDialog(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message).show();
        return alertDialog;
    }

    /**
     * 含有标题、内容、两个按钮的对话框
     **/
    public AlertDialog showAlertDialog(String title, String message, String positiveText,
                                       DialogInterface.OnClickListener onPositiveClickListener, String negativeText,
                                       DialogInterface.OnClickListener onNegativeClickListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message)
                .setPositiveButton(positiveText, onPositiveClickListener)
                .setNegativeButton(negativeText, onNegativeClickListener).show();
        return alertDialog;
    }

    /**
     * 含有标题、内容、一个按钮的对话框
     **/
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

    /**
     * 含有标题、内容、图标、两个按钮的对话框
     **/
    protected AlertDialog showAlertDialog(String title, String message, int icon, String positiveText,
                                          DialogInterface.OnClickListener onPositiveClickListener, String negativeText,
                                          DialogInterface.OnClickListener onNegativeClickListener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message).setIcon(icon)
                .setPositiveButton(positiveText, onPositiveClickListener)
                .setNegativeButton(negativeText, onNegativeClickListener).show();
        return alertDialog;
    }

    //单个权限
    protected boolean isPermissionGranted(String permissionName, int questCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        //判断是否需要请求允许权限
        int hasPermision = checkSelfPermission(permissionName);
        if (hasPermision != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{permissionName}, questCode);
            return false;
        }
        return true;
    }

    //批量权限
    protected boolean isPermissionsAllGranted(String[] permArray, int questCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        //获得批量请求但被禁止的权限列表
        List<String> deniedPerms = new ArrayList<String>();
        for (int i = 0; permArray != null && i < permArray.length; i++) {
            if (PackageManager.PERMISSION_GRANTED != checkSelfPermission(permArray[i])) {
                deniedPerms.add(permArray[i]);
            }
        }
        //进行批量请求
        int denyPermNum = deniedPerms.size();
        if (denyPermNum != 0) {
            requestPermissions(deniedPerms.toArray(new String[denyPermNum]), questCode);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        if (grantResults.length == 0) {
            return;
        }
        switch (requestCode) {
            case Constants.QUEST_CODE_LOCTION:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    popAlterDialog("位置", "位置信息权限被禁止，将导致定位失败。。是否开启该权限？(步骤：应用信息->权限->'勾选'位置)");
                } else {
                    //showShortMsg("恭喜，用户已经授予位置权限");
                }
                break;
            case Constants.QUEST_CODE_CAMERA:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    popAlterDialog("相机", "摄像头使用权限被禁止，手电筒无法正常使用。是否开启该权限？(步骤：应用信息->权限->'勾选'相机)");
                } else {
                    //showShortMsg("恭喜，用户已经授予相机权限");
                }
                break;
            case Constants.QUEST_CODE_SEND_SMS:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    popAlterDialog("短信", "发送短信权限被禁止，无法使用反馈/建议功能。是否开启该权限？(步骤：应用信息->权限->'勾选'短信)");
                } else {
                    //showShortMsg("恭喜，用户已经授予短信权限");
                }
                break;
            case Constants.QUEST_CODE_ALL:
                doPermissionAll(Constants.permArray, grantResults);
                break;
            case Constants.QUEST_CODE_CALL_PHONE:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    popAlterDialog("拨打电话", "拨打电话权限被禁止，无法使用拨打电话功能。是否开启该权限？(步骤：应用信息->权限->'勾选'电话)");
                } else {
                    //showShortMsg("恭喜，用户已经授予所有权限");
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions,
                        grantResults);
                break;
        }
    }

    private void doPermissionAll(String[] permissions, int[] grantResults) {
        int grantedPermNum = 0;
        int totalPermissons = permissions.length;
        int totalResults = grantResults.length;
        if (totalPermissons == 0 || totalResults == 0) {
            return;
        }
        Map<String, Integer> permResults = new HashMap<String, Integer>();
        //初始化Map容器，用于判断哪些权限被授予
        for (String perm : Constants.permArray) {
            permResults.put(perm, PackageManager.PERMISSION_DENIED);
        }
        //根据授权的数目和请求授权的数目是否相等来判断是否全部授予权限
        for (int i = 0; i < totalResults; i++) {
            permResults.put(permissions[i], grantResults[i]);
            if (permResults.get(permissions[i]) == PackageManager.PERMISSION_GRANTED) {
                grantedPermNum++;
            }
            Log.d("Debug", "权限：" + permissions[i] + "-->" + grantResults[i]);
        }
        if (grantedPermNum == totalPermissons) {
            //用于授予全部权限
        } else {
            showShortMsg("批量申请权限失败，将会影响正常使用！");
        }
    }

    protected void showShortMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void popAlterDialog(final String msgFlg, String msgInfo) {
        new AlertDialog.Builder(App.this)
                .setTitle("使用警告")
                .setMessage(msgInfo)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //前往应用详情界面
                        try {
                            Uri packUri = Uri.parse("package:" + getPackageName());
                            Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packUri);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            App.this.startActivity(intent);
                        } catch (Exception e) {
                            showShortMsg("跳转失败");
                        }
                        dialog.dismiss();
                    }
                }).create().show();
    }

}
