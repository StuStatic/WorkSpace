package com.ylg.workspace.workspace.fragment;


import android.content.Context;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.moxun.tagcloudlib.view.TagCloudView;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.TagAdapter;
import com.ylg.workspace.workspace.adapter.ViewPagerAdater_Home01;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends android.app.Fragment {

    //
    private View homeLayout;
    private ViewPager mViewPager;
    private List<ImageView> mImageViewList;
    private int[] images={R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,R.mipmap.a5};
    private int currentPosition=1;
    private int dotPosition=0;
    private int prePosition=0;
    private LinearLayout mLinearLayoutDot;
    private List<ImageView> mImageViewDotList;
    private FrameLayout frameLayout;
    private TagCloudView tcv;
    private List<String> mStrings;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                mViewPager.setCurrentItem(currentPosition,false);
            }
        }
    };


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeLayout = inflater.inflate(R.layout.fragment_home, container, false);
        mViewPager= (ViewPager)homeLayout.findViewById(R.id.vp_home1);
        mLinearLayoutDot= (LinearLayout)homeLayout.findViewById(R.id.ll_home1_dot);
        initView();

        initData(homeLayout.getContext());

        setDot(homeLayout.getContext());

        setViewPager();

        autoPlay();

        return homeLayout;
    }
    private void initView() {
        mStrings = new ArrayList<>();
        mStrings.add("张雨不要脸");
        mStrings.add("张雨是山炮");
        mStrings.add("赵亮亮不要脸");
        mStrings.add("赵亮亮是山炮");
        mStrings.add("赵亮亮没有买票");
        mStrings.add("张雨没有买票");
        mStrings.add("哈哈哈");
        mStrings.add("非常好");
        mStrings.add("我赞成");
        mStrings.add("我们都赞成");
        tcv = (TagCloudView) homeLayout.findViewById(R.id.tcv);
        TagAdapter tagsAdapter = new TagAdapter(mStrings);
        tcv.setAdapter(tagsAdapter);

    }


    private void initData(Context context) {
        mImageViewList=new ArrayList<>();
        mImageViewDotList=new ArrayList();
        ImageView imageView;
        for(int i=0;i<images.length+2;i++){
            if(i==0){   //判断当i=0为该处的ImageView设置最后一张图片作为背景
                imageView=new ImageView(context);
                imageView.setBackgroundResource(images[images.length-1]);
                mImageViewList.add(imageView);
            }else if(i==images.length+1){   //判断当i=images.length+1时为该处的ImageView设置第一张图片作为背景
                imageView=new ImageView(context);
                imageView.setBackgroundResource(images[0]);
                mImageViewList.add(imageView);
            }else{  //其他情况则为ImageView设置images[i-1]的图片作为背景
                imageView=new ImageView(context);
                imageView.setBackgroundResource(images[i-1]);
                mImageViewList.add(imageView);
            }
        }
    }

    //  设置轮播小圆点//
    private void setDot(Context context) {
        //  设置LinearLayout的子控件的宽高，这里单位是像素。
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(15,15);
        params.rightMargin=20;
        //  for循环创建images.length个ImageView（小圆点）
        for(int i=0;i<images.length;i++){
            ImageView  imageViewDot=new ImageView(context);
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
        ViewPagerAdater_Home01 adapter=new ViewPagerAdater_Home01(mImageViewList);

        mViewPager.setAdapter(adapter);

        mViewPager.setCurrentItem(currentPosition);
        //页面改变监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){    //判断当切换到第0个页面时把currentPosition设置为images.length,即倒数第二个位置，小圆点位置为length-1
                    currentPosition=images.length;
                    dotPosition=images.length-1;
                }else if(position==images.length+1){    //当切换到最后一个页面时currentPosition设置为第一个位置，小圆点位置为0
                    currentPosition=1;
                    dotPosition=0;
                }else{
                    currentPosition=position;
                    dotPosition=position-1;
                }
                //  把之前的小圆点设置背景为暗红，当前小圆点设置为红色
                mImageViewDotList.get(prePosition).setBackgroundResource(R.mipmap.red_dot_night);
                mImageViewDotList.get(dotPosition).setBackgroundResource(R.mipmap.red_dot);
                prePosition=dotPosition;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //当state为SCROLL_STATE_IDLE即没有滑动的状态时切换页面
                if(state==ViewPager.SCROLL_STATE_IDLE){
                    mViewPager.setCurrentItem(currentPosition,false);
                }
            }
        });
    }
    //  设置自动播放
    private void autoPlay() {
        new Thread(){
            @Override
            public void run() {
                super.run();

                while(true){
                    SystemClock.sleep(5000);
                    currentPosition++;
                    handler.sendEmptyMessage(1);
                }
            }
        }.start();
    }




}
