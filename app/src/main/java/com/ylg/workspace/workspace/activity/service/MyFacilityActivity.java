package com.ylg.workspace.workspace.activity.service;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.util.DensityUtil;
import com.ylg.workspace.workspace.view.SlideButton;
import com.ylg.workspace.workspace.view.TextMoveLayout;

public class MyFacilityActivity extends App implements View.OnClickListener {

    private TextView tvtitle;
    private ImageView iv_back;
    private SlideButton sbt1;
    private SlideButton sbt2;
    private SlideButton sbt3;
    private LinearLayout ll_kongtiao;
    private LinearLayout ll_chuanglian;
    private LinearLayout ll_light;
    private LinearLayout ll_parent;
    private TextMoveLayout tv_wendu;
    private SeekBar seekBar2;
    private static double wenduNum = 21.0;
    private boolean flag = true;
    private TextPaint mPaint;
    private int screenWidth;//屏幕宽度
    private int mLeftMargin;
    private TextView moveText;
    private ViewGroup.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_facility);
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tvtitle = (TextView) findViewById(R.id.tv_title);
        tvtitle.setText("我的设备");
        iv_back.setOnClickListener(this);
        sbt1 = (SlideButton) findViewById(R.id.sbt1);
        sbt2 = (SlideButton) findViewById(R.id.sbt2);
        sbt3 = (SlideButton) findViewById(R.id.sbt3);
        tv_wendu = (TextMoveLayout) findViewById(R.id.tvWendu);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        ll_kongtiao = (LinearLayout) findViewById(R.id.ll_kongtiao);
        ll_chuanglian = (LinearLayout) findViewById(R.id.ll_chuanglian);
        ll_light = (LinearLayout) findViewById(R.id.ll_light);
        ll_parent = (LinearLayout) findViewById(R.id.ll_parent);

        sbt1.setOnSlideButtonClickListener(new SlideButton.OnSlideButtonClickListener() {
            @Override
            public void onClicked(boolean isChecked) {
                if (isChecked) {
                    ll_kongtiao.setVisibility(View.VISIBLE);
                } else {
                    ll_kongtiao.setVisibility(View.GONE);
                }
            }
        });
        sbt2.setOnSlideButtonClickListener(new SlideButton.OnSlideButtonClickListener() {
            @Override
            public void onClicked(boolean isChecked) {
                if (isChecked) {
                    ll_chuanglian.setVisibility(View.VISIBLE);
                } else {
                    ll_chuanglian.setVisibility(View.GONE);
                }
            }
        });
        sbt3.setOnSlideButtonClickListener(new SlideButton.OnSlideButtonClickListener() {
            @Override
            public void onClicked(boolean isChecked) {
                if (isChecked) {
                    ll_light.setVisibility(View.VISIBLE);
                } else {
                    ll_light.setVisibility(View.GONE);
                }
            }
        });
        screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        setMoveTextView();
        getChildrenLayoutParams();
        setSeekBarValues();
    }

    /**
     * 获取子view的marginLayoutParams
     */
    private void getChildrenLayoutParams() {
        View childAt = ll_parent.getChildAt(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        mLeftMargin = marginLayoutParams.leftMargin;
        seekBar2.setOnSeekBarChangeListener(new OnSeekBarChangeListenerImp());
    }


    /**
     * 设置moveTextView的基础参数
     */
    private void setMoveTextView() {

        moveText = new TextView(this);
        moveText.setText(21 + "");
        moveText.setTextColor(0xff52d666);
        moveText.setTextSize(16);

        layoutParams = new ViewGroup.LayoutParams(screenWidth, 50);
        //textMoveLayout = (TextMoveLayout) findViewById(R.id.tvWendu);
        tv_wendu.addView(moveText, layoutParams);
        moveText.layout(5, 20, screenWidth, 80);
    }


    /**
     * 设置seekbar的基础参数
     */
    public void setSeekBarValues() {

        //mTvMax.setText("500");
        seekBar2.setEnabled(true);
        seekBar2.setMax(9);
        seekBar2.setProgress(0);
    }

    /**
     * seekbar滑动监听
     */
    private class OnSeekBarChangeListenerImp implements
            SeekBar.OnSeekBarChangeListener {

        // 触发操作，拖动
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setMoveTextLayout();
        }

        // 开始拖动时候触发的操作
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        // 停止拖动时候
        public void onStopTrackingTouch(SeekBar seekBar) {
            double d = seekBar.getProgress() + wenduNum;
//            HashMap<String, Object> hs = new HashMap<>();
//            if (flag) {
//                hs.put("temp_heat", "c" + d);
//                sendAction(connection4, "海林温控器1.测试", "setTempHeat", hs);
//            } else {
//                hs.put("temp_cool", "c" + d);
//                sendAction(connection4, "海林温控器1.测试", "setTempCool", hs);
//            }
//        }
        }

        /**
         * seekbar滑动过程中改变moveTextView的位置
         */
        private void setMoveTextLayout() {
            if (mPaint == null) {
                mPaint = new TextPaint();
            }

            float measureText = mPaint.measureText(moveText.getText().toString().trim());
            Rect bounds = seekBar2.getProgressDrawable().getBounds();
            int xFloat = (int) (bounds.width() * seekBar2.getProgress() / seekBar2.getMax() - measureText / 2 + DensityUtil.px2dip(MyFacilityActivity.this, mLeftMargin));
            moveText.layout(xFloat, 20, screenWidth, 80);
            moveText.setText(seekBar2.getProgress() + 21 + "℃");
        }
    }
}
