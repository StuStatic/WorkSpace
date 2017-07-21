package com.ylg.workspace.workspace.activity.service;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.PhotoPreviewActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.intent.PhotoPreviewIntent;
import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.Application.Constants;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.http.FileUploadManager;
import com.ylg.workspace.workspace.view.IphoneDialog;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Date;

import static com.ylg.workspace.workspace.activity.service.QuestionActivity.getTime;

public class OrderVisitorActivity extends App implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private ImageView iv;
    private Button button;
    private static final int REQUEST_CAMERA_CODE = 10;
    private static final int REQUEST_PREVIEW_CODE = 20;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private IphoneDialog iphoneDialog;
    private RadioGroup rg;
    private RadioGroup rg1;
    private RadioButton rb1;
    private RadioButton rb;
    TimePickerView pvTime;
    View vMasker;
    private TextView tvTime;
    private RadioButton rb3;
    private RadioButton rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_visitor);
        isPermissionsAllGranted(Constants.permArray, Constants.QUEST_CODE_ALL);
        initView();
    }

    private void initView() {
        imagePaths.add("000000");
        iphoneDialog = new IphoneDialog(this);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);

        tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("访客预约");
        tv.setOnClickListener(this);
        iv = (ImageView) findViewById(R.id.iv_photo);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        button = (Button) findViewById(R.id.button);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        tvTime = (TextView) findViewById(R.id.tv_time);
        rb = (RadioButton) rg.findViewById(rg.getCheckedRadioButtonId());
        iv.setOnClickListener(this);
        button.setOnClickListener(this);
        rb3 = (RadioButton) findViewById(R.id.rb1);
        rb4 = (RadioButton) findViewById(R.id.rb2);
        rb3.setChecked(true);
        rb4.setChecked(true);

        tvTime.setOnClickListener(this);
        //时间选择器
        pvTime = new TimePickerView(this, TimePickerView.Type.ALL);
        pvTime.setTime(new Date());
        pvTime.setCyclic(false);
        pvTime.setCancelable(true);
        //时间选择后回调
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                tvTime.setText(getTime(date));
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_photo:
                if (imagePaths.size() > 1) {
                    PhotoPreviewIntent intent = new PhotoPreviewIntent(OrderVisitorActivity.this);
                    intent.setCurrentItem(0);
                    intent.setPhotoPaths(imagePaths);
                    startActivityForResult(intent, REQUEST_PREVIEW_CODE);
                } else {
                    PhotoPickerIntent intent = new PhotoPickerIntent(OrderVisitorActivity.this);
                    intent.setSelectModel(SelectModel.MULTI);
                    intent.setShowCarema(true); // 是否显示拍照
                    intent.setMaxTotal(1); // 最多选择照片数量
                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                    startActivityForResult(intent, REQUEST_CAMERA_CODE);
                }
                break;
            case R.id.button:

                final String s2 = et2.getText().toString().trim();
                final String s3 = et3.getText().toString().trim();
                final String s4 = et4.getText().toString().trim();
                final String s5 = et5.getText().toString().trim();
                final String s6 = et6.getText().toString().trim();
                final String s7 = et7.getText().toString().trim();
                final int i7 = Integer.parseInt(s7);
                rb1 = (RadioButton) rg1.findViewById(rg1.getCheckedRadioButtonId());
                rb = (RadioButton) rg.findViewById(rg.getCheckedRadioButtonId());
                final int type;
                //性别
                final String s9 = (String) rb1.getText();
                //访问类型
                final String s10 = (String) rb.getText();
                if (s10.equals("访问个人")) {
                    type = 1;
                } else {
                    type = 0;
                }
                final String time = (String) tvTime.getText();
                Log.d("zp", s9 + " onClick: " + i7);
                Log.d("zp", time);
                if (imagePaths.size() < 2) {
                    showShortMsg("请选择照片");
                    return;
                }
                if (s9.equals("")) {
                    showShortMsg("请选择性别");
                    return;
                }
                if (s10.equals("")) {
                    showShortMsg("请选择访问类型");
                    return;
                }
                if (s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("") || s7.equals("")) {
                    showShortMsg("还有未填写信息");
                    return;
                }
                iphoneDialog.setMessage("请稍候...");
                iphoneDialog.show();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        imagePaths.remove(1);
                        Log.i("zp", "bbbbbbb" + imagePaths.toString());
                        //imagePaths.clear();
                        //FileUploadManager.registerService("1", s2, s3, s4, s5, s6, imagePaths.get(0), 0, ServiceRegisterActivity.this);
                        FileUploadManager.order("1", s2, s3, s4, s5, s6, i7, time + ":00", s9, imagePaths, type, OrderVisitorActivity.this, iphoneDialog);
                        imagePaths.add(1, "000000");
                    }
                }.start();

                break;
            case R.id.tv_time:
                pvTime.show();
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                // 选择照片
                case REQUEST_CAMERA_CODE:
                    ArrayList<String> list = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                    Log.d("zp", "list: " + "list = [" + list.size());
                    loadAdpater(list);
                    break;
                // 预览
                case REQUEST_PREVIEW_CODE:
                    ArrayList<String> ListExtra = data.getStringArrayListExtra(PhotoPreviewActivity.EXTRA_RESULT);
                    Log.d("zp", "ListExtra: " + "ListExtra = [" + ListExtra.size());
                    loadAdpater(ListExtra);
                    break;
            }
        }
    }

    private void loadAdpater(ArrayList<String> paths) {
        if (imagePaths != null && imagePaths.size() > 0) {
            imagePaths.clear();
        }
        if (paths.contains("000000")) {
            paths.remove("000000");
        }
        paths.add("000000");
        imagePaths.addAll(paths);
        Log.i("zp", "aaaaaa" + imagePaths.toString());
        if (imagePaths.size() > 1) {
            Glide.with(OrderVisitorActivity.this)
                    .load(imagePaths.get(0))
                    .placeholder(R.mipmap.default_error)
                    .error(R.mipmap.default_error)
                    .centerCrop()
                    .crossFade()
                    .into(iv);
        } else {
            iv.setImageResource(R.mipmap.carmer);
        }

        try {
            JSONArray obj = new JSONArray(imagePaths);
            Log.e("zp", obj.toString());
            Log.e("zp", imagePaths.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
