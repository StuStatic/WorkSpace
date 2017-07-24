package com.ylg.workspace.workspace.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.HtmlActivity;
import com.ylg.workspace.workspace.activity.service.FeedbackActivity;
import com.ylg.workspace.workspace.activity.service.OrderVisitorActivity;
import com.ylg.workspace.workspace.activity.service.QuestionActivity;
import com.ylg.workspace.workspace.activity.service.RequirementActivity;
import com.ylg.workspace.workspace.activity.service.ServiceRegisterActivity;
import com.ylg.workspace.workspace.adapter.ViewPagerAdapter_Service01;
import com.ylg.workspace.workspace.bean.SlidePic;
import com.ylg.workspace.workspace.bean.SlideServicePic;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ServiceFragment extends Fragment implements View.OnClickListener {

    private View serviceLayout;
    private ViewPager mViewPager;
    private List<SlideServicePic.MsgEntity> mImageViewList1;
    private List<Map<String, Object>> data_slideURL;
    private String htmlURL;
//    private int[] images = {R.mipmap.a1, R.mipmap.a2, R.mipmap.a3, R.mipmap.a4, R.mipmap.a5};
    private int currentPosition = 1;
    private int dotPosition = 0;
    private int prePosition = 0;
    private LinearLayout mLinearLayoutDot;
    private List<ImageView> mImageViewDotList1;
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
    private LinearLayout ll11;

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
        ll11 = (LinearLayout) serviceLayout.findViewById(R.id.service_ll11);
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
        ll11.setOnClickListener(this);

    }
    //轮播图
    private void initData(final Context context) {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<SlideServicePic> call = api.getSlideServicePic();

        call.enqueue(new Callback<SlideServicePic>() {
            @Override
            public void onResponse(Call<SlideServicePic> call, Response<SlideServicePic> response) {
                Log.e("service_slide:",response.body().toString());
                if(response.body().getCode().equals("200")){

                    String slideURL= Http.API_URL+response.body().getMsg().get(0).getImage();
                    Log.e("image:",slideURL);
                    //头部视图轮播数据初始化
                    mImageViewList1=response.body().getMsg();
                    //html地址

                    Log.e("mImageViewList1.size",mImageViewList1.size()+"");
                    mImageViewDotList1=new ArrayList();

                    ImageView imageView1;
                    data_slideURL = new ArrayList<Map<String, Object>>();

                    for(int i=0;i<mImageViewList1.size()+2;i++){
                        if(i==0){   //判断当i=0为该处的ImageView设置最后一张图片作为背景
                            Map<String, Object> map = new HashMap<>();
                            map.put("url",Http.API_URL+mImageViewList1.get(mImageViewList1.size()-1).getImage());
                            Log.e("i=0_url",Http.API_URL+mImageViewList1.get(mImageViewList1.size()-1).getImage());
                            map.put("view", new ImageView(context));
                            data_slideURL.add(map);
                        }else if(i==mImageViewList1.size()+1){   //判断当i=images.length+1时为该处的ImageView设置第一张图片作为背景
                            Map<String, Object> map = new HashMap<>();
                            map.put("url",Http.API_URL+mImageViewList1.get(0).getImage());
                            map.put("view", new ImageView(context));
                            data_slideURL.add(map);
                        }else{  //其他情况则为ImageView设置images[i-1]的图片作为背景
                            Map<String, Object> map = new HashMap<>();
                            map.put("url",Http.API_URL+mImageViewList1.get(i-1).getImage());
                            map.put("view", new ImageView(context));
                            data_slideURL.add(map);

                        }
                    }
                    //遍历data_slideURL
//                    for(int m=0 ; m<data_slideURL.size();m++){
//                        Log.e("遍历data",data_slideURL.get(m).get("url").toString());
//                    }
                    Log.e("data_slideURL.size",data_slideURL.size()+"");
                    //设置其他
                    setDot(context,mImageViewList1);
                    setViewPager(context);
                    autoPlay();
                }else{//连接登录不成功
                    Log.e("轮播图请求不成功",response.body().getCode());
                }

            }


            @Override
            public void onFailure(Call<SlideServicePic> call, Throwable t) {

            }
        });
    }

    //设置轮播图小圆点
    private void setDot(Context context,List<SlideServicePic.MsgEntity> mImageViewList1) {
        //  设置LinearLayout的子控件的宽高，这里单位是像素。
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
        params.rightMargin = 20;
        //  for循环创建images.length个ImageView（小圆点）
        for (int i = 0; i < mImageViewList1.size(); i++) {
            ImageView imageViewDot = new ImageView(context);
            imageViewDot.setLayoutParams(params);
            //  设置小圆点的背景为暗红图片
            imageViewDot.setBackgroundResource(R.mipmap.red_dot_night);
            mLinearLayoutDot.addView(imageViewDot);
            mImageViewDotList1.add(imageViewDot);
        }
        //设置第一个小圆点图片背景为红色
        mImageViewDotList1.get(dotPosition).setBackgroundResource(R.mipmap.red_dot);
    }

    private void setViewPager(final Context context) {
//        ViewPagerAdater_Service01 adapter = new ViewPagerAdater_Service01(mImageViewList);
        ViewPagerAdapter_Service01 adapter = new ViewPagerAdapter_Service01(context,data_slideURL);

        mViewPager.setAdapter(adapter);

        mViewPager.setCurrentItem(currentPosition);
        //页面改变监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position ) {
                if (position == 0) {    //判断当切换到第0个页面时把currentPosition设置为images.length,即倒数第二个位置，小圆点位置为length-1
                    currentPosition = mImageViewList1.size();
                    dotPosition = mImageViewList1.size() - 1;
                } else if (position == mImageViewList1.size() + 1) {    //当切换到最后一个页面时currentPosition设置为第一个位置，小圆点位置为0
                    currentPosition = 1;
                    dotPosition = 0;
                } else {
                    currentPosition = position;
                    dotPosition = position - 1;
                }
                //  把之前的小圆点设置背景为暗红，当前小圆点设置为红色
                mImageViewDotList1.get(prePosition).setBackgroundResource(R.mipmap.red_dot_night);
                mImageViewDotList1.get(dotPosition).setBackgroundResource(R.mipmap.red_dot);
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
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        flag = 0;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        flag = 1;
                        break;
                    case MotionEvent.ACTION_UP:
                        if (flag == 0) {
                            int item = mViewPager.getCurrentItem();
                            if (item == 6 || item == 1) {
                                htmlURL = "http://"+mImageViewList1.get(0).getUrl();
                            } else {
                                htmlURL =  "http://"+mImageViewList1.get(item-1).getUrl();
                            }
                            Intent i = new Intent(context, HtmlActivity.class);
                            i.putExtra("htmlURL",htmlURL);
                            startActivity(i);
//                            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                        }
                        break;


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
       // Intent i = new Intent(getActivity(), InvestActivity.class);
        switch (v.getId()) {
            case R.id.service_ll1:
                startActivity(new Intent(getActivity(), ServiceRegisterActivity.class));
                break;
            case R.id.service_ll2:
//                i.putExtra("getTitle", "投融资");
//                startActivity(i);
                startActivity(new Intent(getActivity(), RequirementActivity.class));
                break;
            case R.id.service_ll3:
//                i.putExtra("getTitle", "人力资源");
//                startActivity(i);
                startActivity(new Intent(getActivity(), RequirementActivity.class));
                break;
            case R.id.service_ll4:
//                i.putExtra("getTitle", "法律");
//                startActivity(i);
                startActivity(new Intent(getActivity(), RequirementActivity.class));
                break;
            case R.id.service_ll5:
//                i.putExtra("getTitle", "IT");
//                startActivity(i);
                startActivity(new Intent(getActivity(), HtmlActivity.class));
                break;
            case R.id.service_ll6:
                startActivity(new Intent(getActivity(), OrderVisitorActivity.class));
                break;
            case R.id.service_ll7:
                startActivity(new Intent(getActivity(), QuestionActivity.class));
                break;
            case R.id.service_ll8:
                //Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), CaptureActivity.class));
                break;
            case R.id.service_ll9:
                startActivity(new Intent(getActivity(), FeedbackActivity.class));
                break;
            case R.id.service_ll10:
                Toast.makeText(getActivity(), "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.service_ll11:
                startActivity(new Intent(getActivity(), RequirementActivity.class));
                break;
        }
    }
}
