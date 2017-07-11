package com.ylg.workspace.workspace.fragment;


import android.content.Context;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.moxun.tagcloudlib.view.TagCloudView;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.HorizontalScrollViewAdapter_Home;
import com.ylg.workspace.workspace.adapter.NeiborAdapter_Home;
import com.ylg.workspace.workspace.adapter.TagAdapter;
import com.ylg.workspace.workspace.adapter.ViewPagerAdater_Home01;
import com.ylg.workspace.workspace.util.SetHomeListViewItemHeight;
import com.ylg.workspace.workspace.view.MyHorizontalScrollView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends android.app.Fragment {

    private View homeLayout;
    private ViewPager mViewPager1;
    private List<ImageView> mImageViewList1;
    private int[] imagesURL1={R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,R.mipmap.a5};//头部轮播视图图片资源地址
    private int currentPosition1=1;
    private int dotPosition1=0;
    private int prePosition1=0;
    private LinearLayout mLinearLayoutDot1,mLinearLayoutDot2;
    private List<ImageView> mImageViewDotList1,mImageViewDotList2;
    private TagCloudView tcv;
    private List<String> mStrings;

    //HorizontalScrollView
    private MyHorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter_Home mAdapter;
    private ImageView mImg;
    private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(R.mipmap.a4,R.mipmap.a5,R.mipmap.a4,R.mipmap.a5,R.mipmap.a4,R.mipmap.a5,R.mipmap.a4,R.mipmap.a5,R.mipmap.a4,R.mipmap.a5));

    //友邻企业列表
    private ListView listview;
    private String[] title = {"北京物联港科技有限公司","上海宝马集团","中国石油有限公司"};
    private String[] summary = {"我只能说技术部功能很强大，什么都能做，谁也不好使","宝马集团听说过没有？地球人都知道我们也就不再多说了","中国石油，给你更坚实的后盾"};
    private ArrayList<Map<String,Object>> datas_neibor;
    private NeiborAdapter_Home adapter_neibor;


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                mViewPager1.setCurrentItem(currentPosition1,false);

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


        //头部轮播视图初始化
        mViewPager1= (ViewPager)homeLayout.findViewById(R.id.vp_home1);
        mLinearLayoutDot1= (LinearLayout)homeLayout.findViewById(R.id.ll_home1_dot);

        //horizontalScrollView初始化
        mHorizontalScrollView = (MyHorizontalScrollView) homeLayout.findViewById(R.id.id_hsv);
        mAdapter = new HorizontalScrollViewAdapter_Home(homeLayout.getContext(), mDatas);





        initView();

        initData(homeLayout.getContext());

        setDot(homeLayout.getContext());

        setViewPager();

        autoPlay();

        return homeLayout;
    }
    private void initView() {
        mStrings = new ArrayList<>();
        mStrings.add("集市");
        mStrings.add("活动");
        mStrings.add("资讯");
        mStrings.add("友邻");
        mStrings.add("集市");
        mStrings.add("集市");
        mStrings.add("集市");
        mStrings.add("集市");
        mStrings.add("订工位");
        mStrings.add("开门");
        mStrings.add("发集市");
        mStrings.add("访客预约");
        mStrings.add("预定场地");
        mStrings.add("精选");
        mStrings.add("订会议室");
        mStrings.add("一键报修");
        mStrings.add("企业介绍");
        mStrings.add("意见反馈");
        tcv = (TagCloudView) homeLayout.findViewById(R.id.tcv);
        TagAdapter tagsAdapter = new TagAdapter(homeLayout.getContext(),mStrings);
        tcv.setAdapter(tagsAdapter);





    }


    private void initData(final Context context) {
        //头部视图轮播数据初始化
        mImageViewList1=new ArrayList<>();
        mImageViewDotList1=new ArrayList();
        ImageView imageView1;
        for(int i=0;i<imagesURL1.length+2;i++){
            if(i==0){   //判断当i=0为该处的ImageView设置最后一张图片作为背景
                imageView1=new ImageView(context);
                imageView1.setBackgroundResource(imagesURL1[imagesURL1.length-1]);
                mImageViewList1.add(imageView1);
            }else if(i==imagesURL1.length+1){   //判断当i=images.length+1时为该处的ImageView设置第一张图片作为背景
                imageView1=new ImageView(context);
                imageView1.setBackgroundResource(imagesURL1[0]);
                mImageViewList1.add(imageView1);
            }else{  //其他情况则为ImageView设置images[i-1]的图片作为背景
                imageView1=new ImageView(context);
                imageView1.setBackgroundResource(imagesURL1[i-1]);
                mImageViewList1.add(imageView1);
            }
        }






        //添加HorizontalScrollView点击回调
        mHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView.OnItemClickListener()
        {

            @Override
            public void onClick(View view, int position)
            {
//                mImg.setImageResource(mDatas.get(position));
//                view.setBackgroundColor(Color.parseColor("#AA024DA4"));
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
        //设置适配器
        mHorizontalScrollView.initDatas(mAdapter);



    }

    //  设置轮播小圆点
    private void setDot(Context context) {
        /**
         * 头部轮播图
         */
        //  设置LinearLayout的子控件的宽高，这里单位是像素。
        LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(15,15);
        params1.rightMargin=20;
        //  for循环创建images.length个ImageView（小圆点）
        for(int i=0;i<imagesURL1.length;i++){
            ImageView  imageViewDot1=new ImageView(context);
            imageViewDot1.setLayoutParams(params1);
            //  设置小圆点的背景为暗红图片
            imageViewDot1.setBackgroundResource(R.mipmap.red_dot_night);
            mLinearLayoutDot1.addView(imageViewDot1);
            mImageViewDotList1.add(imageViewDot1);
        }
        //设置第一个小圆点图片背景为红色
        mImageViewDotList1.get(dotPosition1).setBackgroundResource(R.mipmap.red_dot);



        //友邻企业内容listview
        listview = (ListView)homeLayout.findViewById(R.id.neibor_contentlv);
        //初始化集合
        datas_neibor = new ArrayList<Map<String,Object>>();
        for(int i =0; i < title.length; i++) {
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("title", title[i]);
            item.put("summary", summary[i]);
            datas_neibor.add(item);
        }
        Log.e("datas.get(0).size():",datas_neibor.get(0).size()+"");
        Log.e("datas.get(1).title",datas_neibor.get(1).get("title")+"");
        //初始化适配器
        adapter_neibor = new NeiborAdapter_Home(homeLayout.getContext(),datas_neibor);
        //绑定适配器
        listview.setAdapter(adapter_neibor);
        //ScrollView中嵌套listview不手动设置高度出现只显示一行的情况
        SetHomeListViewItemHeight.setHeight(listview);

    }



    private void setViewPager() {
        /**
         * 头部轮播视图
         */
        ViewPagerAdater_Home01 adapter01=new ViewPagerAdater_Home01(mImageViewList1);

        mViewPager1.setAdapter(adapter01);

        mViewPager1.setCurrentItem(currentPosition1);
        //头部轮播视图页面改变监听
        mViewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){    //判断当切换到第0个页面时把currentPosition设置为images.length,即倒数第二个位置，小圆点位置为length-1
                    currentPosition1=imagesURL1.length;
                    dotPosition1=imagesURL1.length-1;
                }else if(position==imagesURL1.length+1){    //当切换到最后一个页面时currentPosition设置为第一个位置，小圆点位置为0
                    currentPosition1=1;
                    dotPosition1=0;
                }else{
                    currentPosition1=position;
                    dotPosition1=position-1;
                }
                //  把之前的小圆点设置背景为暗红，当前小圆点设置为红色
                mImageViewDotList1.get(prePosition1).setBackgroundResource(R.mipmap.red_dot_night);
                mImageViewDotList1.get(dotPosition1).setBackgroundResource(R.mipmap.red_dot);
                prePosition1=dotPosition1;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //当state为SCROLL_STATE_IDLE即没有滑动的状态时切换页面
                if(state==ViewPager.SCROLL_STATE_IDLE){
                    mViewPager1.setCurrentItem(currentPosition1,false);
                }
            }
        });


        //viewpager点击事件
        mViewPager1.setOnTouchListener(new View.OnTouchListener() {
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
                            int item = mViewPager1.getCurrentItem();
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
                            Toast.makeText(homeLayout.getContext(), ""+item, Toast.LENGTH_SHORT).show();
                        }
                        break ;


                }
                return false;
            }
        });


    }


    //  头部轮播视图设置自动播放
    private void autoPlay() {
        new Thread(){
            @Override
            public void run() {
                super.run();

                while(true){
                    SystemClock.sleep(5000);
                    currentPosition1++;
//                    currentPosition2++;
                    handler.sendEmptyMessage(1);
                }
            }
        }.start();
    }




}
