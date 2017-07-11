package com.ylg.workspace.workspace.activity.service;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.PhotoPreviewActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.intent.PhotoPreviewIntent;
import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.http.FileUploadManager;
import com.ylg.workspace.workspace.view.IphoneDialog;

import org.json.JSONArray;

import java.util.ArrayList;

public class ServiceRegisterActivity extends App implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv;
    private ImageView iv;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private Button button;
    private static final int REQUEST_CAMERA_CODE = 10;
    private static final int REQUEST_PREVIEW_CODE = 20;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private IphoneDialog iphoneDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_register);
        initView();
    }

    private void initView() {
        iphoneDialog = new IphoneDialog(this);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("注册服务商");
        iv = (ImageView) findViewById(R.id.iv_logo);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        button = (Button) findViewById(R.id.button);
        iv.setOnClickListener(this);
        button.setOnClickListener(this);
        imagePaths.add("000000");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_logo:
                if (imagePaths.size() > 1) {
                    PhotoPreviewIntent intent = new PhotoPreviewIntent(ServiceRegisterActivity.this);
                    intent.setCurrentItem(0);
                    intent.setPhotoPaths(imagePaths);
                    startActivityForResult(intent, REQUEST_PREVIEW_CODE);
                } else {
                    PhotoPickerIntent intent = new PhotoPickerIntent(ServiceRegisterActivity.this);
                    intent.setSelectModel(SelectModel.MULTI);
                    intent.setShowCarema(true); // 是否显示拍照
                    intent.setMaxTotal(1); // 最多选择照片数量
                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                    startActivityForResult(intent, REQUEST_CAMERA_CODE);
                }
                break;
            case R.id.button:
                if (imagePaths.size() > 1) {
                    final String s2 = et2.getText().toString().trim();
                    final String s3 = et3.getText().toString().trim();
                    final String s4 = et4.getText().toString().trim();
                    final String s5 = et5.getText().toString().trim();
                    final String s6 = et6.getText().toString().trim();
                    iphoneDialog.setMessage("请稍候...");
                    iphoneDialog.show();
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            imagePaths.remove(1);
                            //FileUploadManager.registerService("1", s2, s3, s4, s5, s6, imagePaths.get(0), 0, ServiceRegisterActivity.this);
                            FileUploadManager.uploadMany("1", s2, s3, s4, s5, s6,imagePaths, 0, ServiceRegisterActivity.this, iphoneDialog);
                        }
                    }.start();
                }
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
            Glide.with(ServiceRegisterActivity.this)
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
