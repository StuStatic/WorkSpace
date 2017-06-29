package com.ylg.workspace.workspace.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.fragment.HomeFragment;
import com.ylg.workspace.workspace.fragment.MineFragment;
import com.ylg.workspace.workspace.fragment.SelectionFragment;
import com.ylg.workspace.workspace.fragment.ServiceFragment;
import com.ylg.workspace.workspace.fragment.SocialFragment;

public class MainActivity extends App implements View.OnClickListener {
    //Fragment
    private HomeFragment homeFragment;
    private MineFragment mineFragment;
//    private SelectionFragment selectionFragment;
    private ServiceFragment serviceFragment;
    private SocialFragment socialFragment;
    //主界面下面的tab
    private View homeLayout, mineLayout, serviceLayout, socialLayout;
    //fragmentManager
    private FragmentManager fragmentManager;
    private long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        initView();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    private void initView() {
        //初始化视图
        homeLayout = findViewById(R.id.home_layout);
        mineLayout = findViewById(R.id.mine_layout);
//        selectionLayout = findViewById(R.id.selection_layout);
        serviceLayout = findViewById(R.id.service_layout);
        socialLayout = findViewById(R.id.social_layout);

        //绑定适配器
        homeLayout.setOnClickListener(this);
        mineLayout.setOnClickListener(this);
//        selectionLayout.setOnClickListener(this);
        serviceLayout.setOnClickListener(this);
        socialLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_layout:
                // 当点击了首页tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.social_layout:
                //当点击了社交tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.service_layout:
                // 当点击了服务tab时，选中第3个tab
                setTabSelection(2);
                break;
//            case R.id.selection_layout:
//                // 当点击了精选tab时，选中第4个tab
//                setTabSelection(3);
//                break;
            case R.id.mine_layout:
                // 当点击了我的tab时，选中第5个tab
                setTabSelection(4);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index 每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了tab时，改变控件的图片和文字颜色
//                messageImage.setImageResource(R.drawable.message_selected);
//                messageText.setTextColor(Color.WHITE);
                homeLayout.setBackgroundColor(Color.GRAY);

                if (homeFragment == null) {
                    // 如果HomeFragment为空，则创建一个并添加到界面上
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    // 如果HomeFragment不为空，则直接将它显示出来
                    transaction.show(homeFragment);

                }
                break;
            case 1:
                // 当点击了tab时，改变控件的图片和文字颜色
//                contactsImage.setImageResource(R.drawable.contacts_selected);
//                contactsText.setTextColor(Color.WHITE);
                socialLayout.setBackgroundColor(Color.GRAY);

                if (socialFragment == null) {
                    // 如果SocialFragment为空，则创建一个并添加到界面上
                    socialFragment = new SocialFragment();
                    transaction.add(R.id.content, socialFragment);

                } else {
                    // 如果socialFragment不为空，则直接将它显示出来
                    transaction.show(socialFragment);
                }
                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色
//                newsImage.setImageResource(R.drawable.news_selected);
//                newsText.setTextColor(Color.WHITE);
//                serviceLayout.setBackgroundColor(Color.GRAY);

                serviceLayout.setBackgroundColor(Color.GRAY);

                if (serviceFragment == null) {
                    // 如果ServiceFragment为空，则创建一个并添加到界面上
                    serviceFragment = new ServiceFragment();
                    transaction.add(R.id.content, serviceFragment);
                } else {
                    // 如果ServiceFragment不为空，则直接将它显示出来
                    transaction.show(serviceFragment);
                }
                break;
//            case 3:
//                // 当点击了tab时，改变控件的图片和文字颜色
////                settingImage.setImageResource(R.drawable.setting_selected);
////                settingText.setTextColor(Color.WHITE);
////                selectionLayout.setBackgroundColor(Color.GRAY);
//
//                selectionLayout.setBackgroundColor(Color.GRAY);
//
//                if (selectionFragment == null) {
//                    // 如果SelectionFragment为空，则创建一个并添加到界面上
//                    selectionFragment = new SelectionFragment();
//                    transaction.add(R.id.content, selectionFragment);
//                } else {
//                    // 如果SelectionFragment不为空，则直接将它显示出来
//                    transaction.show(selectionFragment);
//                }
//                break;
            case 4:
                // 当点击了tab时，改变控件的图片和文字颜色
//                settingImage.setImageResource(R.drawable.setting_selected);
//                settingText.setTextColor(Color.WHITE);
//                mineLayout.setBackgroundColor(Color.GRAY);

                mineLayout.setBackgroundColor(Color.GRAY);
                if (mineFragment == null) {
                    // 如果mineFragment为空，则创建一个并添加到界面上
                    mineFragment = new MineFragment();
                    transaction.add(R.id.content, mineFragment);
                } else {
                    // 如果mineFragment不为空，则直接将它显示出来
                    transaction.show(mineFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }


    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
//        messageImage.setImageResource(R.drawable.message_unselected);
//        messageText.setTextColor(Color.parseColor("#82858b"));
//        contactsImage.setImageResource(R.drawable.contacts_unselected);
//        contactsText.setTextColor(Color.parseColor("#82858b"));
//        newsImage.setImageResource(R.drawable.news_unselected);
//        newsText.setTextColor(Color.parseColor("#82858b"));
//        settingImage.setImageResource(R.drawable.setting_unselected);
//        settingText.setTextColor(Color.parseColor("#82858b"));
        homeLayout.setBackgroundColor(Color.WHITE);
        socialLayout.setBackgroundColor(Color.WHITE);
        serviceLayout.setBackgroundColor(Color.WHITE);
//        selectionLayout.setBackgroundColor(Color.WHITE);
        mineLayout.setBackgroundColor(Color.WHITE);
    }


    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (socialFragment != null) {
            transaction.hide(socialFragment);
        }
        if (serviceFragment != null) {
            transaction.hide(serviceFragment);
        }
//        if (selectionFragment != null) {
//            transaction.hide(selectionFragment);
//        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exitTime) > 1000) {
                exitTime = System.currentTimeMillis();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("确定要退出吗？");
                builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 一键退出
                        App.destoryAll();
                    }
                });
                builder.setNegativeButton("再看看", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
