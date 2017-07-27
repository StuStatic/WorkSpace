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
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.moxun.tagcloudlib.view.TagCloudView;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.HtmlActivity;
import com.ylg.workspace.workspace.activity.ballgraph.ExerciseActivity;
import com.ylg.workspace.workspace.activity.ballgraph.InfoActivity;
import com.ylg.workspace.workspace.activity.ballgraph.MeetRoomOrderActivity;
import com.ylg.workspace.workspace.activity.ballgraph.NeiborActivity;
import com.ylg.workspace.workspace.activity.ballgraph.PlaceOrderActivity;
import com.ylg.workspace.workspace.activity.ballgraph.SpaceListActivity;
import com.ylg.workspace.workspace.activity.ballgraph.WorkplaceOrderActivity;
import com.ylg.workspace.workspace.activity.service.OrderVisitorActivity;
import com.ylg.workspace.workspace.adapter.HorizontalScrollViewAdapter_Home;
import com.ylg.workspace.workspace.adapter.ListViewAdapter_SpaceList;
import com.ylg.workspace.workspace.adapter.NeiborAdapter_Home;
import com.ylg.workspace.workspace.adapter.TagAdapter;
import com.ylg.workspace.workspace.adapter.ViewPagerAdater_Home01;
import com.ylg.workspace.workspace.bean.ExerciseRecommend;
import com.ylg.workspace.workspace.bean.Info;
import com.ylg.workspace.workspace.bean.NeiborCompany;
import com.ylg.workspace.workspace.bean.SlidePic;
import com.ylg.workspace.workspace.bean.SpaceList;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.util.SetHomeListViewItemHeight;
import com.ylg.workspace.workspace.util.SetSpaceListListViewItemHeight;
import com.ylg.workspace.workspace.view.MyHorizontalScrollView_Home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * writen by stu on 2017/7/17
 */

public class HomeFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemClickListener {

    /**
     * @author stu
     */
    //头部轮播图
    private static final String className = "HomeFragment";
    private View homeLayout;
    private ViewPager mViewPager1;
    private List<SlidePic.MsgEntity> mImageViewList1;
    private List<Map<String, Object>> data_slideURL;
    private int currentPosition1 = 1;
    private int dotPosition1 = 0;
    private int prePosition1 = 0;
    private LinearLayout mLinearLayoutDot1, mLinearLayoutDot2;
    private List<ImageView> mImageViewDotList1, mImageViewDotList2;
    private String htmlURL;

    //球形图
    private TagCloudView tcv;
    private List<String> mStrings;
    private List<Integer> mImages;

    //分类imageview
    private ImageView siteorder_img,visitor_img,placeorder_img,meetroom_img,opendoor_img,neibor_img,info_img,exercise_img;

    //HorizontalScrollView
    private HorizontalScrollView mHorizontalScrollView;
    private HorizontalScrollViewAdapter_Home mAdapter;
    private ImageView mImg;
//    private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(R.mipmap.a4, R.mipmap.a5, R.mipmap.a4));
    private List<SpaceList.MsgEntity> mDatas;

    //友邻企业列表
    private ListView listview;
    private List<NeiborCompany.MsgEntity> datas_neibor;
    private NeiborAdapter_Home adapter_neibor;
    private TextView neibor_tv;

    //活动推荐
    //索引
    private TextView recommend_tv;
    private RelativeLayout recommend_content,news_content;
    //n内容文字
    private TextView recommend_contenttv;
    private ImageView recommend_img;
    private TextView news_tv;

    //众创空间
    private TextView workspace_tv;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mViewPager1.setCurrentItem(currentPosition1, false);

            }
        }
    };
    private TextView tv1;
    private TextView tv2;
    private ImageView imageView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeLayout = inflater.inflate(R.layout.fragment_home, container, false);

        initView(homeLayout.getContext());

        initData(homeLayout.getContext());

        return homeLayout;
    }

    private void initView(Context context) {
        //初始化球形图
//        InitBallGraph();

        //初始化顶部分类图
        siteorder_img=(ImageView)homeLayout.findViewById(R.id.siteorder_home);
        siteorder_img.setOnClickListener(this);
        visitor_img=(ImageView)homeLayout.findViewById(R.id.visitor_home);
        visitor_img.setOnClickListener(this);
        placeorder_img=(ImageView)homeLayout.findViewById(R.id.placeorder_home);
        placeorder_img.setOnClickListener(this);
        meetroom_img=(ImageView)homeLayout.findViewById(R.id.meetroomorder_home);
        meetroom_img.setOnClickListener(this);
        opendoor_img=(ImageView)homeLayout.findViewById(R.id.opendoor_home);
        opendoor_img.setOnClickListener(this);
        neibor_img=(ImageView)homeLayout.findViewById(R.id.neibor_home);
        neibor_img.setOnClickListener(this);
        info_img=(ImageView)homeLayout.findViewById(R.id.infoorder_home);
        info_img.setOnClickListener(this);
        exercise_img=(ImageView)homeLayout.findViewById(R.id.exercise_home);
        exercise_img.setOnClickListener(this);

        //头部轮播视图初始化
        mViewPager1 = (ViewPager) homeLayout.findViewById(R.id.vp_home1);
        mLinearLayoutDot1 = (LinearLayout) homeLayout.findViewById(R.id.ll_home1_dot);

        //horizontalScrollView初始化
        mHorizontalScrollView = (HorizontalScrollView) homeLayout.findViewById(R.id.id_hsv);


        //活动推荐初始化 图片+文字
        recommend_tv = (TextView) homeLayout.findViewById(R.id.recommend_tv);
        recommend_contenttv = (TextView) homeLayout.findViewById(R.id.recommend_contenttv);
        recommend_content = (RelativeLayout) homeLayout.findViewById(R.id.recommend_content);
        recommend_content.setOnClickListener(this);

        //绑定监听
        recommend_tv.setOnClickListener(HomeFragment.this);
        recommend_img = (ImageView) homeLayout.findViewById(R.id.recommend_contentimg);
        //绑定监听
        recommend_img.setOnClickListener(HomeFragment.this);

        //友邻企业文字初始化
        neibor_tv = (TextView) homeLayout.findViewById(R.id.neibor_tv);
        //绑定监听
        neibor_tv.setOnClickListener(HomeFragment.this);

        //最新资讯初始化
        news_tv = (TextView) homeLayout.findViewById(R.id.news_tv);
        tv1 = (TextView) homeLayout.findViewById(R.id.news_contenttv);
        tv2 = (TextView) homeLayout.findViewById(R.id.news_contentdate);
        imageView = (ImageView) homeLayout.findViewById(R.id.news_contentimg);
        news_content = (RelativeLayout) homeLayout.findViewById(R.id.news_content);
        news_content.setOnClickListener(this);

        //绑定监听点击事件
        news_tv.setOnClickListener(HomeFragment.this);

        //众创空间
        workspace_tv = (TextView) homeLayout.findViewById(R.id.workspace_tv);
        //绑定监听
        workspace_tv.setOnClickListener(this);

        //友邻企业内容listview
        listview = (ListView) homeLayout.findViewById(R.id.neibor_contentlv);
        listview.setOnItemClickListener(this);

    }


    private void initData(final Context context) {
        //请求数据(头部轮播视图)
        startRequestSlidePicDatas(context);

        //请求数据（众创空间）
        startRequestWorkSpaceDatas(context);

        //开始请求数据(友邻企业)
        startRequestNeiborDatas();

        //请求数据(活动推荐)
         startRequestRecommendDatas();
        //最新资讯
        startRequestInfoDatas();
    }



    //数据请求（众创空间）
    private void startRequestWorkSpaceDatas(final Context context) {
        //开始请求空间列表数据
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<SpaceList> call = api.getSpaceListData();
        call.enqueue(new Callback<SpaceList>() {
            @Override
            public void onResponse(Call<SpaceList> call, Response<SpaceList> response) {
                if(!response.equals(null) && !response.equals("")){
                    if(response.body().getCode().equals("200")){
                        Log.e("请求数据成功","请求数据成功");
                        mDatas =response.body().getMsg();
                        LinearLayout mLinearLayout=(LinearLayout)homeLayout.findViewById(R.id.id_gallary);
                        for (int i = 0; i < mDatas.size(); i++) {// 1、使用本地图片时，使用IMGS数组；2、使用网络图片时，使用IMG_URLS数组
                            View view = LayoutInflater.from(context).inflate(R.layout.item_horizontalscrollview, null);
                            ImageView iv = (ImageView) view.findViewById(R.id.hsv_img);
                            // 设置本地图片
                            // iv.setImageResource(IMGS[i]);
                            //设置网络图片
                            String[] url = mDatas.get(i).getSpacePicture().split(",");
                            String img_URL=Http.API_URL+url[0];
                            Log.e("水平视图图片地址：",img_URL);
                            Glide.with(context).load(img_URL).into(iv);
                            // 为item设置id
//                        view.setId(i);
                            // 为item绑定数据
                            view.setTag(i);
                            // 为item设置点击事件
                            view.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    int position=(Integer) view.getTag();
                                    for(int j=0;j<mDatas.size();j++){
                                        if(j==position){
                                            Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
                                            Intent i_news_content = new Intent(getActivity(), HtmlActivity.class);
                                            if (position==0){
                                                i_news_content.putExtra("htmlURL","http://"+mDatas.get(j).getSpared3());
                                            }else if (position==1){
                                                i_news_content.putExtra("htmlURL","http://"+mDatas.get(j).getSpared3());
                                            }else if (position==2){
                                                i_news_content.putExtra("htmlURL","http://"+mDatas.get(j).getSpared3());
                                            }
                                            startActivity(i_news_content);
                                        }
                                    }
                                }
                            });
                            // 把item添加到父view中
                            mLinearLayout.addView(view);
                        }

                    }else{
                        Toast.makeText(getContext(), "暂无数据", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<SpaceList> call, Throwable t) {

            }
        });

    }

    //数据请求（顶部轮播图）
    private void startRequestSlidePicDatas(final Context context) {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<SlidePic> call = api.getSlidePic();

        call.enqueue(new Callback<SlidePic>() {
            @Override
            public void onResponse(Call<SlidePic> call, Response<SlidePic> response) {
                if(!response.equals(null) && !response.equals("")){
                    if (response.body().getCode().equals("200")) {

                        String slideURL = Http.API_URL + response.body().getMsg().get(0).getImage();
                        Log.e("image:", slideURL);
                        //头部视图轮播数据初始化
                        mImageViewList1 = response.body().getMsg();
                        //code

                        Log.e("mImageViewList1.size", mImageViewList1.size() + "");
                        mImageViewDotList1 = new ArrayList();
                        ImageView imageView1;
                        data_slideURL = new ArrayList<Map<String, Object>>();

                        for (int i = 0; i < mImageViewList1.size() + 2; i++) {
                            if (i == 0) {   //判断当i=0为该处的ImageView设置最后一张图片作为背景
                                Map<String, Object> map = new HashMap<>();
                                map.put("url", Http.API_URL + mImageViewList1.get(mImageViewList1.size() - 1).getImage());
                                Log.e("i=0_url", Http.API_URL + mImageViewList1.get(mImageViewList1.size() - 1).getImage());
                                map.put("view", new ImageView(context));
                                data_slideURL.add(map);
                            } else if (i == mImageViewList1.size() + 1) {   //判断当i=images.length+1时为该处的ImageView设置第一张图片作为背景
                                Map<String, Object> map = new HashMap<>();
                                map.put("url", Http.API_URL + mImageViewList1.get(0).getImage());
                                map.put("view", new ImageView(context));
                                data_slideURL.add(map);
                            } else {  //其他情况则为ImageView设置images[i-1]的图片作为背景
                                Map<String, Object> map = new HashMap<>();
                                map.put("url", Http.API_URL + mImageViewList1.get(i - 1).getImage());
                                map.put("view", new ImageView(context));
                                data_slideURL.add(map);

                            }
                        }
                        //遍历data_slideURL
//                    for(int m=0 ; m<data_slideURL.size();m++){
//                        Log.e("遍历data",data_slideURL.get(m).get("url").toString());
//                    }
                        Log.e("data_slideURL.size", data_slideURL.size() + "");
                        //设置其他
                        setDot(context, mImageViewList1);
                        setViewPager(context);
                        autoPlay();
                    } else {//连接登录不成功
                        Log.e("轮播图请求不成功", response.body().getCode());
                    }
                }


            }

            @Override
            public void onFailure(Call<SlidePic> call, Throwable t) {

            }
        });
    }

    //活动推荐数据请求
    private void startRequestRecommendDatas() {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<ExerciseRecommend> call = api.exerciseRecommend(1);

        call.enqueue(new Callback<ExerciseRecommend>() {
            @Override
            public void onResponse(Call<ExerciseRecommend> call, Response<ExerciseRecommend> response) {
                if(!response.equals("") && !response.equals(null)){
                    if (response.body().getCode().equals("200")) {

                        //设置文字
                        String text = response.body().getMsg().get(0).getActivityDescribe();//此处只展示一个数据
                        recommend_contenttv.setText(text);
                        //设置图片(先将地址按都好分开)
                        String[] s = response.body().getMsg().get(0).getPictureSite().split(",");
                        String img_URL = Http.API_URL + s[0];
                        Log.e("recommen_img:", img_URL);
                        Glide.with(getActivity()).load(img_URL).into(recommend_img);
                    }
                }

            }

            @Override
            public void onFailure(Call<ExerciseRecommend> call, Throwable t) {

            }
        });

    }

    //友邻企业的数据请求
    private void startRequestNeiborDatas() {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<NeiborCompany> call = api.neiborCompany(App.SPACE_ID);

        call.enqueue(new Callback<NeiborCompany>() {
            @Override
            public void onResponse(Call<NeiborCompany> call, Response<NeiborCompany> response) {
                if(!response.equals("") && !response.equals(null)){
                    if (response.body().getCode().equals("200")) {
                        datas_neibor = response.body().getMsg();
                        Log.e("datas-neibor",response.body().toString());
                        //初始化适配器
                        adapter_neibor = new NeiborAdapter_Home(homeLayout.getContext(), datas_neibor);
                        //绑定适配器
                        listview.setAdapter(adapter_neibor);
                        //ScrollView中嵌套listview不手动设置高度出现只显示一行的情况
                        SetHomeListViewItemHeight.setHeight(listview);
                    }else{
                        Log.e("33333333333333333333333","333333333333");
                    }
                }

            }

            @Override
            public void onFailure(Call<NeiborCompany> call, Throwable t) {
                Log.e("t_neibor",t.getMessage());
            }
        });


    }


    //最新资讯
    private void startRequestInfoDatas() {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<Info> call = api.getInfo();

        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                if(!response.equals(null) && !response.equals("")){
                    Info i = response.body();
                    if (i != null) {
                        String s = i.getCode();
                        if (s.equals("200")) {

                            Glide.with(getContext()).load(Http.API_URL + i.getMsg().getSpace().get(0).getPictureSite()).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
                            tv1.setText(i.getMsg().getSpace().get(0).getTitle());
                            tv2.setText(i.getMsg().getSpace().get(0).getIssueTime());
                        }
                    }
                }


            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });
    }


    //球形图初始化
    private void InitBallGraph() {
        mStrings = new ArrayList<>();
        for (int i = 0 ;i<10;i++){
        mStrings.add("");
    }
        //图片
        mImages = new ArrayList<>();
        mImages.add(R.drawable.fixed_position);
        mImages.add(R.drawable.conference_room);
        mImages.add(R.drawable.visitor_reservation);
        mImages.add(R.drawable.acitivity);
        mImages.add(R.drawable.market1);
        mImages.add(R.drawable.one_button_repair);
        mImages.add(R.drawable.open_door);
        mImages.add(R.drawable.feedback);
        mImages.add(R.drawable.reservation_site);
        mImages.add(R.drawable.consultation);

//        tcv = (TagCloudView) homeLayout.findViewById(R.id.tcv);
//        TagAdapter tagsAdapter = new TagAdapter(homeLayout.getContext(), mStrings, mImages);
//        tcv.setAdapter(tagsAdapter);
    }

    //  设置轮播小圆点
    private void setDot(Context context, List<SlidePic.MsgEntity> mImageViewList1) {
        /**
         * 头部轮播图
         */
        //  设置LinearLayout的子控件的宽高，这里单位是像素。
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(15, 15);
        params1.rightMargin = 20;
        //  for循环创建images.length个ImageView（小圆点）
        for (int i = 0; i < mImageViewList1.size(); i++) {
            ImageView imageViewDot1 = new ImageView(context);
            imageViewDot1.setLayoutParams(params1);
            //  设置小圆点的背景为暗红图片
            imageViewDot1.setBackgroundResource(R.mipmap.red_dot_night);
            mLinearLayoutDot1.addView(imageViewDot1);
            mImageViewDotList1.add(imageViewDot1);
        }
        //设置第一个小圆点图片背景为红色
        mImageViewDotList1.get(dotPosition1).setBackgroundResource(R.mipmap.red_dot);
    }

    //设置轮播图viewpager
    private void setViewPager(final Context context) {
        /**
         * 头部轮播视图
         */
        ViewPagerAdater_Home01 adapter01 = new ViewPagerAdater_Home01(data_slideURL, context);

        mViewPager1.setAdapter(adapter01);

        mViewPager1.setCurrentItem(currentPosition1);
        //头部轮播视图页面改变监听
        mViewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {    //判断当切换到第0个页面时把currentPosition设置为images.length,即倒数第二个位置，小圆点位置为length-1
                    currentPosition1 = mImageViewList1.size();
                    dotPosition1 = mImageViewList1.size() - 1;
                } else if (position == mImageViewList1.size() + 1) {    //当切换到最后一个页面时currentPosition设置为第一个位置，小圆点位置为0
                    currentPosition1 = 1;
                    dotPosition1 = 0;
                } else {
                    currentPosition1 = position;
                    dotPosition1 = position - 1;
                }
                //  把之前的小圆点设置背景为暗红，当前小圆点设置为红色
                mImageViewDotList1.get(prePosition1).setBackgroundResource(R.mipmap.red_dot_night);
                mImageViewDotList1.get(dotPosition1).setBackgroundResource(R.mipmap.red_dot);
                prePosition1 = dotPosition1;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //当state为SCROLL_STATE_IDLE即没有滑动的状态时切换页面
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    mViewPager1.setCurrentItem(currentPosition1, false);
                }
            }
        });
        //viewpager点击事件
        mViewPager1.setOnTouchListener(new View.OnTouchListener() {
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
                            int item = mViewPager1.getCurrentItem();
                            if (item == 6 || item == 1) {
                                htmlURL = "http://" + mImageViewList1.get(0).getUrl();
                            } else {
                                htmlURL = "http://" + mImageViewList1.get(item - 1).getUrl();
                            }
                            Intent i = new Intent(context, HtmlActivity.class);
                            i.putExtra("htmlURL", htmlURL);
                            startActivity(i);
//                            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                        }
                        break;


                }
                return false;
            }
        });


    }


    //  头部轮播视图设置自动播放
    private void autoPlay() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    SystemClock.sleep(5000);
                    currentPosition1++;
//                    currentPosition2++;
                    handler.sendEmptyMessage(1);
                }
            }
        }.start();
    }


    //视图的点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //头部分类图片点击事件
            case R.id.siteorder_home://预订场地
                Intent i_place = new Intent(getActivity(), PlaceOrderActivity.class);
                startActivity(i_place);
                break;
            case R.id.visitor_home://访客
                Intent i_visit = new Intent(getActivity(), OrderVisitorActivity.class);
                startActivity(i_visit);
                break;
            case R.id.placeorder_home://订工位
                Intent i_work = new Intent(getActivity(), WorkplaceOrderActivity.class);
                startActivity(i_work);
                break;
            case R.id.meetroomorder_home://定会议室
                Intent i_meet = new Intent(getActivity(), MeetRoomOrderActivity.class);
                startActivity(i_meet);
                break;
            case R.id.opendoor_home://一键开门
                Intent i_captureActivity = new Intent(getActivity(), CaptureActivity.class);
                startActivity(i_captureActivity);
                break;
            case R.id.neibor_home://友邻
                Intent i_neibor02 = new Intent(getActivity(), NeiborActivity.class);
//                i_neibor.putExtra("datas",datas_neibor);
                startActivity(i_neibor02);
                break;
            case R.id.infoorder_home://资讯
                Intent i_info = new Intent(getActivity(), InfoActivity.class);
                startActivity(i_info);
                break;
            case R.id.exercise_home://活动
                Intent i_exer = new Intent(getActivity(), ExerciseActivity.class);
                startActivity(i_exer);
                break;
            //活动推荐文字索引点击事件
            case R.id.recommend_tv:
                Intent i_exer02 = new Intent(getActivity(), ExerciseActivity.class);
                startActivity(i_exer02);
                break;
            //活动推荐图片点击事件
//            case R.id.recommend_contentimg:
//                break;
            //最新资讯索引点击事件
            case R.id.news_tv:
                Intent i_news = new Intent(getActivity(), InfoActivity.class);
                startActivity(i_news);
                break;
            //友邻企业文字点击事件
            case R.id.neibor_tv:
                Intent i_neibor = new Intent(getActivity(), NeiborActivity.class);
//                i_neibor.putExtra("datas",datas_neibor);
                startActivity(i_neibor);
                break;
            //众创空间文字索引
            case R.id.workspace_tv:
                Intent i_space = new Intent(getActivity(), SpaceListActivity.class);
                startActivity(i_space);
                break;
            case R.id.recommend_content://活动推荐（H5）
                Intent i_recommend_content = new Intent(getActivity(), HtmlActivity.class);
                i_recommend_content.putExtra("htmlURL","http://www.yiliangang.net:8012/makerSpace/activity.html");
                startActivity(i_recommend_content);
                break;
            case R.id.news_content://最新资讯（H5）
                Intent i_news_content = new Intent(getActivity(), HtmlActivity.class);
                i_news_content.putExtra("htmlURL","http://www.yiliangang.net:8012/makerSpace/news1.html");
                startActivity(i_news_content);
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i_news_content = new Intent(getActivity(), HtmlActivity.class);
        i_news_content.putExtra("htmlURL","http://www.yiliangang.net:8012/makerSpace/companyInfo.html");
        startActivity(i_news_content);
    }
}
