package com.ylg.workspace.workspace.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.service.FeedbackActivity;
import com.ylg.workspace.workspace.activity.service.InvestActivity;
import com.ylg.workspace.workspace.activity.service.OrderVisitorActivity;
import com.ylg.workspace.workspace.activity.service.QuestionActivity;
import com.ylg.workspace.workspace.activity.service.ServiceRegisterActivity;
import com.ylg.workspace.workspace.adapter.ViewPagerAdater_Home01;

import java.util.ArrayList;
import java.util.List;


public class ServiceFragment extends android.app.Fragment implements View.OnClickListener {

    private View serviceLayout;
    private ViewPager mViewPager;
    private List<ImageView> mImageViewList;
    private int[] images = {R.mipmap.a1, R.mipmap.a2, R.mipmap.a3, R.mipmap.a4, R.mipmap.a5};
    private int currentPosition = 1;
    private int dotPosition = 0;
    private int prePosition = 0;
    private LinearLayout mLinearLayoutDot;
    private List<ImageView> mImageViewDotList;
    private FrameLayout frameLayout;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mViewPager.setCurrentItem(currentPosition, false);
            }
        }
    };
    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private LinearLayout ll4;
    private LinearLayout ll5;
    private LinearLayout ll6;
    private LinearLayout ll7;
    private LinearLayout ll8;
    private LinearLayout ll9;
    private LinearLayout ll10;

    public ServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        serviceLayout = inflater.inflate(R.layout.fragment_service, container, false);

        mViewPager = (ViewPager) serviceLayout.findViewById(R.id.vp_service1);
        mLinearLayoutDot = (LinearLayout) serviceLayout.findViewById(R.id.ll_service1_dot);
        initView();

        initData(serviceLayout.getContext());
        //设置轮播图小圆点
        setDot(serviceLayout.getContext());

        setViewPager();
        //轮播图自动播放
        autoPlay();


        return serviceLayout;
    }

    private void initView() {
        ll1 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll1);
        ll2 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll2);
        ll3 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll3);
        ll4 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll4);
        ll5 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll5);
        ll6 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll6);
        ll7 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll7);
        ll8 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll8);
        ll9 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll9);
        ll10 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll10);
        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
        ll5.setOnClickListener(this);
        ll6.setOnClickListener(this);
        ll7.setOnClickListener(this);
        ll8.setOnClickListener(this);
        ll9.setOnClickListener(this);
        ll10.setOnClickListener(this);

    }

    private void initData(Context context) {
        mImageViewList = new ArrayList<>();
        mImageViewDotList = new ArrayList();
        ImageView imageView;
        for (int i = 0; i < images.length + 2; i++) {
            if (i == 0) {   //判断当i=0为该处的ImageView设置最后一张图片作为背景
                imageView = new ImageView(context);
                imageView.setBackgroundResource(images[images.length - 1]);
                mImageViewList.add(imageView);
            } else if (i == images.length + 1) {   //判断当i=images.length+1时为该处的ImageView设置第一张图片作为背景
                imageView = new ImageView(context);
                imageView.setBackgroundResource(images[0]);
                mImageViewList.add(imageView);
            } else {  //其他情况则为ImageView设置images[i-1]的图片作为背景
                imageView = new ImageView(context);
                imageView.setBackgroundResource(images[i - 1]);
                mImageViewList.add(imageView);
            }
        }
    }

    //设置轮播图小圆点
    private void setDot(Context context) {
        //  设置LinearLayout的子控件的宽高，这里单位是像素。
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
        params.rightMargin = 20;
        //  for循环创建images.length个ImageView（小圆点）
        for (int i = 0; i < images.length; i++) {
            ImageView imageViewDot = new ImageView(context);
            imageViewDot.setLayoutParams(params);
            //  设置小圆点的背景为暗红图片
            imageViewDot.setBackgroundResource(R.mipmap.red_dot_night);
            mLinearLayoutDot.addView(imageViewDot);
            mImageViewDotList.add(imageViewDot);
        }
        //设置第一个小圆点图片背景为红色
        mImageViewDotList.get(dotPosition).setBackgroundResource(R.mipmap.red_dot);
    }

    private void setViewPager() {
        ViewPagerAdater_Home01 adapter = new ViewPagerAdater_Home01(mImageViewList);

        mViewPager.setAdapter(adapter);

        mViewPager.setCurrentItem(currentPosition);
        //页面改变监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {    //判断当切换到第0个页面时把currentPosition设置为images.length,即倒数第二个位置，小圆点位置为length-1
                    currentPosition = images.length;
                    dotPosition = images.length - 1;
                } else if (position == images.length + 1) {    //当切换到最后一个页面时currentPosition设置为第一个位置，小圆点位置为0
                    currentPosition = 1;
                    dotPosition = 0;
                } else {
                    currentPosition = position;
                    dotPosition = position - 1;
                }
                //  把之前的小圆点设置背景为暗红，当前小圆点设置为红色
                mImageViewDotList.get(prePosition).setBackgroundResource(R.mipmap.red_dot_night);
                mImageViewDotList.get(dotPosition).setBackgroundResource(R.mipmap.red_dot);
                prePosition = dotPosition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //当state为SCROLL_STATE_IDLE即没有滑动的状态时切换页面
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    mViewPager.setCurrentItem(currentPosition, false);
                }
            }
        });



        //viewpager点击事件
        //viewpager点击事件
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            int flag = 0;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        flag = 0 ;
                        break ;
                    case MotionEvent.ACTION_MOVE:
                        flag = 1 ;
                        break ;
                    case  MotionEvent.ACTION_UP :
                        if (flag == 0) {
                            int item = mViewPager.getCurrentItem();
                            if (item == 0) {
//                                Intent intent = new Intent(sa, NoNetWork.class);
//                                sa.startActivity(intent);
                            } else if (item == 1) {
//                                Intent intent = new Intent(sa, NoNetWork.class);
//                                sa.startActivity(intent);
                            } else if (item == 2) {
//                                Intent intent = new Intent(sa, NoNetWork.class);
//                                sa.startActivity(intent);
                            }else if (item == 3) {
//                                Intent intent = new Intent(sa, NoNetWork.class);
//                                sa.startActivity(intent);
                            }
                            Toast.makeText(serviceLayout.getContext(), ""+item, Toast.LENGTH_SHORT).show();
                        }
                        break ;


                }
                return false;
            }
        });
    }

    private void autoPlay() {
        new Thread() {
            @Override
            public void run() {
                super.run();

                while (true) {
                    SystemClock.sleep(5000);
                    currentPosition++;
                    handler.sendEmptyMessage(1);
                }
            }
        }.start();
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(getActivity(), InvestActivity.class);
        switch (v.getId()) {
            case R.id.service_ll1:
                startActivity(new Intent(getActivity(), ServiceRegisterActivity.class));
                break;
            case R.id.service_ll2:
                i.putExtra("getTitle", "投融资");
                startActivity(i);
                break;
            case R.id.service_ll3:
                i.putExtra("getTitle", "人力资源");
                startActivity(i);
                break;
            case R.id.service_ll4:
                i.putExtra("getTitle", "法律");
                startActivity(i);
                break;
            case R.id.service_ll5:
                i.putExtra("getTitle", "IT");
                startActivity(i);
                break;
            case R.id.service_ll6:
                startActivity(new Intent(getActivity(), OrderVisitorActivity.class));
                break;
            case R.id.service_ll7:
                startActivity(new Intent(getActivity(), QuestionActivity.class));
                break;
            case R.id.service_ll8:
                Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.service_ll9:
                startActivity(new Intent(getActivity(), FeedbackActivity.class));
                break;
            case R.id.service_ll10:
                Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
