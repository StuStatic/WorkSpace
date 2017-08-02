package com.ylg.workspace.workspace.activity.personaldetails;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.ballgraph.CreatCompanyActivity;

public class CreateEnterpriseActivity extends App implements View.OnClickListener {
    private ImageView iv_back;
    private TextView tv_title;
    private RelativeLayout mName;
    private RelativeLayout mLogo;
    private RelativeLayout mType;
    private RelativeLayout mContacts;
    private Dialog dialog;
    private View inflate;
    private TextView choosePhoto;
    private TextView takePhoto, fins;
    private Button dialog_yes,dialog_no;
    private EditText dialog_name,dialog_phone,dialog_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_create_enterprise);
        initView();

    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("创建企业");
        mLogo = (RelativeLayout) findViewById(R.id.createEnterprise_logo);
        mName = (RelativeLayout) findViewById(R.id.createEnterprise_name);
        mType = (RelativeLayout) findViewById(R.id.createEnterprise_type);
        mContacts = (RelativeLayout) findViewById(R.id.createEnterprise_contacts);
        mLogo.setOnClickListener(this);
        mName.setOnClickListener(this);
        mType.setOnClickListener(this);
        mContacts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back://退出
                finish();
                break;
            case R.id.createEnterprise_logo://LOGO的选择
                showDialogLogo();
                break;
            case R.id.createEnterprise_name://企业名称

                break;
            case R.id.createEnterprise_type://企业类型
                Intent i_stu = new Intent(this, CreatCompanyActivity.class);
                startActivity(i_stu);
                break;
            case R.id.createEnterprise_contacts://联系人
                showDialogContacts();
                break;
            case R.id.choosePhoto://企业LOGO的确定拍照
                
                break;
            case R.id.takePhoto://相册选择

                break;
            case R.id.fins://取消
            case R.id.dialog_bt_no:
                dialog.dismiss();
                break;
        }
    }

    private void showDialogLogo() {
        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.dialog2, null);
        //初始化控件
        choosePhoto = (TextView) inflate.findViewById(R.id.choosePhoto);
        takePhoto = (TextView) inflate.findViewById(R.id.takePhoto);
        fins = (TextView) inflate.findViewById(R.id.fins);
        choosePhoto.setOnClickListener(this);
        takePhoto.setOnClickListener(this);
        fins.setOnClickListener(this);
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 0;//设置Dialog距离底部的距离
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }

    private void showDialogContacts(){
        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.dialog3, null);
        dialog_yes = (Button) inflate.findViewById(R.id.dialog_bt_yes);
        dialog_no = (Button) inflate.findViewById(R.id.dialog_bt_no);
        dialog_yes.setOnClickListener(this);
        dialog_no.setOnClickListener(this);
        dialog_name = (EditText) inflate.findViewById(R.id.dialog_et_name);
        dialog_phone = (EditText) inflate.findViewById(R.id.dialog_et_phone);
        dialog_contacts = (EditText) inflate.findViewById(R.id.dialog_et_mailbox);

        //初始化控件
        inflate.findViewById(R.id.dialog_et_name);
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.CENTER);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 0;//设置Dialog距离底部的距离
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }
}
