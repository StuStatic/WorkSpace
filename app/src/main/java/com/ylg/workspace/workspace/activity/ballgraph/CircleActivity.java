package com.ylg.workspace.workspace.activity.ballgraph;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

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

public class CircleActivity extends App implements View.OnClickListener {

    private ImageView iv_back;
    private TextView tv;
    private EditText et;
    private IphoneDialog iphoneDialog;
    private GridView gridView;
    private static final int REQUEST_CAMERA_CODE = 10;
    private static final int REQUEST_PREVIEW_CODE = 20;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private GridAdapter gridAdapter;
    private ArrayList<String> infoList;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        isPermissionsAllGranted(Constants.permArray, Constants.QUEST_CODE_ALL);
        initView();
    }

    private void initView() {
        iphoneDialog = new IphoneDialog(this);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv_title);
        tv.setText("发朋友圈");
        et = (EditText) findViewById(R.id.et);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this);
        gridView = (GridView) findViewById(R.id.gv);
        infoList = new ArrayList<String>();
        int cols = getResources().getDisplayMetrics().widthPixels / getResources().getDisplayMetrics().densityDpi;
        cols = cols < 3 ? 3 : cols;
        gridView.setNumColumns(cols);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String imgs = (String) parent.getItemAtPosition(position);
                Log.d("zp", "onItemClick: " + imgs);
                if ("000000".equals(imgs)) {
                    PhotoPickerIntent intent = new PhotoPickerIntent(CircleActivity.this);
                    intent.setSelectModel(SelectModel.MULTI);
                    intent.setShowCarema(true); // 是否显示拍照
                    intent.setMaxTotal(9); // 最多选择照片数量
                    intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                    startActivityForResult(intent, REQUEST_CAMERA_CODE);
                } else {
                    PhotoPreviewIntent intent = new PhotoPreviewIntent(CircleActivity.this);
                    intent.setCurrentItem(position);
                    intent.setPhotoPaths(imagePaths);
                    startActivityForResult(intent, REQUEST_PREVIEW_CODE);
                }
            }
        });
        imagePaths.add("000000");
        gridAdapter = new GridAdapter(imagePaths);
        gridView.setAdapter(gridAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.button:
                final int index = imagePaths.size();
                final String s = et.getText().toString().trim();

                if (App.KEY_LOGIN == 1) {
                    showShortMsg("您还未登录...");
                    return;
                }
                if (s.equals("")) {
                    showShortMsg("还有未填写信息");
                    return;
                }
                if (imagePaths.size() < 2) {
                    showShortMsg("还未选择照片");
                    return;
                }
                iphoneDialog.setMessage("请稍候...");
                iphoneDialog.show();

                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        imagePaths.remove(index - 1);
                        Log.i("zp", "bbbbbbb" + imagePaths.toString());
                        Log.i("zp", "aaaa" + s);
                        FileUploadManager.addShare(Integer.parseInt(String.valueOf(App.USER_ID)), s, imagePaths, CircleActivity.this, iphoneDialog);
                    }
                }.start();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
//        if (requestCode == 0 && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
//            finish();
//        }
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
        if (requestCode == 30) {
            infoList.clear();
            Log.e("zp", "onActivityResult: ");
            if (data != null) {
                infoList.addAll(data.getStringArrayListExtra("infoList"));
                tv.setText("已选定" + infoList.size() + "台设备");
            } else {
                tv.setText("选择设备");
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
        gridAdapter = new GridAdapter(imagePaths);
        gridView.setAdapter(gridAdapter);
        try {
            JSONArray obj = new JSONArray(imagePaths);
            Log.e("zp", obj.toString());
            Log.e("zp", imagePaths.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class GridAdapter extends BaseAdapter {
        private ArrayList<String> listUrls;
        private LayoutInflater inflater;

        public GridAdapter(ArrayList<String> listUrls) {
            this.listUrls = listUrls;
            if (listUrls.size() == 10) {
                listUrls.remove(listUrls.size() - 1);
            }
            inflater = LayoutInflater.from(CircleActivity.this);
        }

        public int getCount() {
            return listUrls.size();
        }

        @Override
        public String getItem(int position) {
            return listUrls.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.item_image, parent, false);
                holder.image = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Log.i("zp", "getView: " + listUrls.toString());
            final String path = listUrls.get(position);
            if (path.equals("000000")) {
                holder.image.setImageResource(R.mipmap.add);
            } else {
                Glide.with(CircleActivity.this)
                        .load(path)
                        .placeholder(R.mipmap.default_error)
                        .error(R.mipmap.default_error)
                        .centerCrop()
                        .crossFade()
                        .into(holder.image);
            }
            return convertView;
        }

        class ViewHolder {
            ImageView image;
        }
    }
}
