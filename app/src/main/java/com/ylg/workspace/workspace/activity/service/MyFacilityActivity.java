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
    private SlideButton sbt4;
    private LinearLayout ll_kongtiao;
    private LinearLayout ll_chuanglian;
    private LinearLayout ll_light1;
    private LinearLayout ll_light2;
    private LinearLayout ll_parent;
    private TextMoveLayout tv_wendu;
    private SeekBar seekBar2;
    private SeekBar seekBar1;
    private static double wenduNum = 21.0;
    private boolean flag = true;
    private TextPaint mPaint;
    private int screenWidth;//屏幕宽度
    private int mLeftMargin;
    private TextView moveText;
    private ViewGroup.LayoutParams layoutParams;
    private TextView kt_tv_di;
    private TextView kt_tv_zhong;
    private TextView kt_tv_gao;
    private TextView kt_tv_auto;
    private ImageView kt_iv_auto;
    private ImageView kt_iv_zhileng;
    private ImageView kt_iv_zhire;
    private ImageView kt_iv_tongfeng;
    private LinearLayout kt_ll_zhileng;
    private LinearLayout kt_ll_zhire;
    private LinearLayout kt_ll_tongfeng;
    private TextView kt_tv_zhileng;
    private TextView kt_tv_zhire;
    private TextView kt_tv_tongfeng;
    private LinearLayout ll_cl_off;
    private LinearLayout ll_cl_pause;
    private LinearLayout ll_cl_on;
    private ImageView iv_cl_off;
    private ImageView iv_cl_pause;
    private ImageView iv_cl_on;
    private TextView tv_cl_off;
    private TextView tv_cl_pause;
    private TextView tv_cl_on;

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
            case R.id.kt_ll_zhileng:
                kt_iv_zhileng.setImageResource(R.mipmap.zhileng2);
                kt_iv_zhire.setImageResource(R.mipmap.zhire1);
                kt_iv_tongfeng.setImageResource(R.mipmap.tongfeng1);
                kt_tv_zhileng.setTextColor(0xff52d666);
                kt_tv_zhire.setTextColor(0xff888888);
                kt_tv_tongfeng.setTextColor(0xff888888);
                break;
            case R.id.kt_ll_zhire:
                kt_iv_zhileng.setImageResource(R.mipmap.zhileng1);
                kt_iv_zhire.setImageResource(R.mipmap.zhire2);
                kt_iv_tongfeng.setImageResource(R.mipmap.tongfeng1);
                kt_tv_zhileng.setTextColor(0xff888888);
                kt_tv_zhire.setTextColor(0xff52d666);
                kt_tv_tongfeng.setTextColor(0xff888888);
                break;
            case R.id.kt_ll_tongfeng:
                kt_iv_zhileng.setImageResource(R.mipmap.zhileng1);
                kt_iv_zhire.setImageResource(R.mipmap.zhire1);
                kt_iv_tongfeng.setImageResource(R.mipmap.tongfeng2);
                kt_tv_zhileng.setTextColor(0xff888888);
                kt_tv_zhire.setTextColor(0xff888888);
                kt_tv_tongfeng.setTextColor(0xff52d666);
                break;
            case R.id.kt_iv_auto:
                kt_iv_auto.setImageResource(R.mipmap.auto2);
                kt_tv_auto.setTextColor(0xff52d666);
                kt_tv_di.setTextColor(0xff888888);
                kt_tv_zhong.setTextColor(0xff888888);
                kt_tv_gao.setTextColor(0xff888888);
                break;
            case R.id.ll_cl_off:
                iv_cl_off.setImageResource(R.mipmap.cl_off2);
                iv_cl_pause.setImageResource(R.mipmap.cl_pause1);
                iv_cl_on.setImageResource(R.mipmap.cl_on1);
                tv_cl_off.setTextColor(0xff52d666);
                tv_cl_pause.setTextColor(0xff888888);
                tv_cl_on.setTextColor(0xff888888);
                break;
            case R.id.ll_cl_pause:
                iv_cl_off.setImageResource(R.mipmap.cl_off1);
                iv_cl_pause.setImageResource(R.mipmap.cl_pause2);
                iv_cl_on.setImageResource(R.mipmap.cl_on1);
                tv_cl_off.setTextColor(0xff888888);
                tv_cl_pause.setTextColor(0xff52d666);
                tv_cl_on.setTextColor(0xff888888);
                break;
            case R.id.ll_cl_on:
                iv_cl_off.setImageResource(R.mipmap.cl_off1);
                iv_cl_pause.setImageResource(R.mipmap.cl_pause1);
                iv_cl_on.setImageResource(R.mipmap.cl_on2);
                tv_cl_off.setTextColor(0xff888888);
                tv_cl_pause.setTextColor(0xff888888);
                tv_cl_on.setTextColor(0xff52d666);
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
        sbt4 = (SlideButton) findViewById(R.id.sbt4);
        tv_wendu = (TextMoveLayout) findViewById(R.id.tvWendu);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        ll_kongtiao = (LinearLayout) findViewById(R.id.ll_kongtiao);
        ll_chuanglian = (LinearLayout) findViewById(R.id.ll_chuanglian);
        ll_light1 = (LinearLayout) findViewById(R.id.ll_light1);
        ll_light2 = (LinearLayout) findViewById(R.id.ll_light2);
        ll_parent = (LinearLayout) findViewById(R.id.ll_parent);
        kt_tv_di = (TextView) findViewById(R.id.kt_tv_di);
        kt_tv_zhong = (TextView) findViewById(R.id.kt_tv_zhong);
        kt_tv_gao = (TextView) findViewById(R.id.kt_tv_gao);
        kt_tv_auto = (TextView) findViewById(R.id.kt_tv_auto);
        kt_iv_auto = (ImageView) findViewById(R.id.kt_iv_auto);
        kt_iv_zhileng = (ImageView) findViewById(R.id.iv_zhileng);
        kt_iv_zhire = (ImageView) findViewById(R.id.iv_zhire);
        kt_iv_tongfeng = (ImageView) findViewById(R.id.iv_tongfeng);
        kt_ll_zhileng = (LinearLayout) findViewById(R.id.kt_ll_zhileng);
        kt_ll_zhire = (LinearLayout) findViewById(R.id.kt_ll_zhire);
        kt_ll_tongfeng = (LinearLayout) findViewById(R.id.kt_ll_tongfeng);
        kt_tv_zhileng = (TextView) findViewById(R.id.kt_tv_zhileng);
        kt_tv_zhire = (TextView) findViewById(R.id.kt_tv_zhire);
        kt_tv_tongfeng = (TextView) findViewById(R.id.kt_tv_tongfeng);
        ll_cl_off = (LinearLayout) findViewById(R.id.ll_cl_off);
        ll_cl_pause = (LinearLayout) findViewById(R.id.ll_cl_pause);
        ll_cl_on = (LinearLayout) findViewById(R.id.ll_cl_on);
        iv_cl_off = (ImageView) findViewById(R.id.iv_cl_off);
        iv_cl_pause = (ImageView) findViewById(R.id.iv_cl_pause);
        iv_cl_on = (ImageView) findViewById(R.id.iv_cl_on);
        tv_cl_off = (TextView) findViewById(R.id.tv_cl_off);
        tv_cl_pause = (TextView) findViewById(R.id.tv_cl_pause);
        tv_cl_on = (TextView) findViewById(R.id.tv_cl_on);
        ll_cl_off.setOnClickListener(this);
        ll_cl_pause.setOnClickListener(this);
        ll_cl_on.setOnClickListener(this);
        kt_iv_auto.setOnClickListener(this);
        kt_ll_zhire.setOnClickListener(this);
        kt_ll_zhileng.setOnClickListener(this);
        kt_ll_tongfeng.setOnClickListener(this);

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
                    ll_light1.setVisibility(View.VISIBLE);
                } else {
                    ll_light1.setVisibility(View.GONE);
                }
            }
        });
        sbt4.setOnSlideButtonClickListener(new SlideButton.OnSlideButtonClickListener() {
            @Override
            public void onClicked(boolean isChecked) {
                if (isChecked) {
                    ll_light2.setVisibility(View.VISIBLE);
                } else {
                    ll_light2.setVisibility(View.GONE);
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
        seekBar1.setOnSeekBarChangeListener(new OnSeekBarChangeListener1());
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
        seekBar1.setEnabled(true);
        seekBar2.setMax(9);
        seekBar1.setMax(2);
        seekBar2.setProgress(0);
        seekBar1.setProgress(0);
    }

    /**
     * seekbar2滑动监听
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
    }

    /**
     * seekbar1滑动监听
     */
    private class OnSeekBarChangeListener1 implements
            SeekBar.OnSeekBarChangeListener {

        // 触发操作，拖动
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (progress) {
                case 0:
                    kt_tv_di.setTextColor(0xff52d666);
                    kt_tv_zhong.setTextColor(0xff888888);
                    kt_tv_gao.setTextColor(0xff888888);
                    kt_tv_auto.setTextColor(0xff888888);
                    kt_iv_auto.setImageResource(R.mipmap.auto1);
                    break;
                case 1:
                    kt_tv_di.setTextColor(0xff888888);
                    kt_tv_zhong.setTextColor(0xff52d666);
                    kt_tv_gao.setTextColor(0xff888888);
                    kt_tv_auto.setTextColor(0xff888888);
                    kt_iv_auto.setImageResource(R.mipmap.auto1);
                    break;
                case 2:
                    kt_tv_di.setTextColor(0xff888888);
                    kt_tv_zhong.setTextColor(0xff888888);
                    kt_tv_gao.setTextColor(0xff52d666);
                    kt_tv_auto.setTextColor(0xff888888);
                    kt_iv_auto.setImageResource(R.mipmap.auto1);
                    break;
            }
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
