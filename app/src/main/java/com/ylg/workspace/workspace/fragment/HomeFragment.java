package com.ylg.workspace.workspace.fragment;


import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.moxun.tagcloudlib.view.TagCloudView;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.HtmlActivity;
import com.ylg.workspace.workspace.activity.ballgraph.ExerciseActivity;
import com.ylg.workspace.workspace.activity.ballgraph.InfoActivity;
import com.ylg.workspace.workspace.activity.ballgraph.NeiborActivity;
import com.ylg.workspace.workspace.activity.ballgraph.SpaceListActivity;
import com.ylg.workspace.workspace.adapter.HorizontalScrollViewAdapter_Home;
import com.ylg.workspace.workspace.adapter.NeiborAdapter_Home;
import com.ylg.workspace.workspace.adapter.TagAdapter;
import com.ylg.workspace.workspace.adapter.ViewPagerAdater_Home01;
import com.ylg.workspace.workspace.bean.ExerciseRecommend;
import com.ylg.workspace.workspace.bean.NeiborCompany;
import com.ylg.workspace.workspace.bean.SlidePic;
import com.ylg.workspace.workspace.http.Http;
import com.ylg.workspace.workspace.http.HttpAPI;
import com.ylg.workspace.workspace.util.SetHomeListViewItemHeight;
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

public class HomeFragment extends android.app.Fragment implements View.OnClickListener{

    /**
     * @author stu
     */
    //头部轮播图
    private static final String className = "HomeFragment";
    private View homeLayout;
    private ViewPager mViewPager1;
    private List<SlidePic.MsgEntity> mImageViewList1;
    private List<Map<String, Object>> data_slideURL;
    private int currentPosition1=1;
    private int dotPosition1=0;
    private int prePosition1=0;
    private LinearLayout mLinearLayoutDot1,mLinearLayoutDot2;
    private List<ImageView> mImageViewDotList1,mImageViewDotList2;
    private String htmlURL;

    //球形图
    private TagCloudView tcv;
    private List<String> mStrings;

    //HorizontalScrollView
    private MyHorizontalScrollView_Home mHorizontalScrollView;
    private HorizontalScrollViewAdapter_Home mAdapter;
    private ImageView mImg;
    private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(R.mipmap.a4,R.mipmap.a5,R.mipmap.a4,R.mipmap.a5,R.mipmap.a4,R.mipmap.a5,R.mipmap.a4,R.mipmap.a5,R.mipmap.a4,R.mipmap.a5));

    //友邻企业列表
    private ListView listview;
    private List<NeiborCompany.MsgEntity> datas_neibor;
    private NeiborAdapter_Home adapter_neibor;
    private TextView neibor_tv;

    //活动推荐
    private TextView recommend_tv;
    private ImageView recommend_img;
    private TextView news_tv;

    //众创空间
    private TextView  workspace_tv;




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

        initView(homeLayout.getContext());

        initData(homeLayout.getContext());

        return homeLayout;
    }

    private void initView(Context context) {
        //初始化球形图
        InitBallGraph();

        //头部轮播视图初始化
        mViewPager1= (ViewPager)homeLayout.findViewById(R.id.vp_home1);
        mLinearLayoutDot1= (LinearLayout)homeLayout.findViewById(R.id.ll_home1_dot);

        //horizontalScrollView初始化
        mHorizontalScrollView = (MyHorizontalScrollView_Home) homeLayout.findViewById(R.id.id_hsv);
        mAdapter = new HorizontalScrollViewAdapter_Home(homeLayout.getContext(), mDatas);

        //活动推荐初始化 图片+文字
        recommend_tv = (TextView)homeLayout.findViewById(R.id.recommend_tv);
        //绑定监听
        recommend_tv.setOnClickListener(HomeFragment.this);
        recommend_img = (ImageView)homeLayout.findViewById(R.id.recommend_contentimg);
        //绑定监听
        recommend_img.setOnClickListener(HomeFragment.this);

        //友邻企业文字初始化
        neibor_tv = (TextView)homeLayout.findViewById(R.id.neibor_tv);
        //绑定监听
        neibor_tv.setOnClickListener(HomeFragment.this);

        //最新资讯初始化
        news_tv = (TextView)homeLayout.findViewById(R.id.news_tv);
        //绑定监听点击事件
        news_tv.setOnClickListener(HomeFragment.this);

        //众创空间
        workspace_tv = (TextView)homeLayout.findViewById(R.id.workspace_tv);
        //绑定监听
        workspace_tv.setOnClickListener(this);

        //友邻企业内容listview
        listview = (ListView)homeLayout.findViewById(R.id.neibor_contentlv);


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
    }


    //数据请求（众创空间）
    private void startRequestWorkSpaceDatas(final Context context) {
        //添加HorizontalScrollView点击回调
        mHorizontalScrollView.setOnItemClickListener(new MyHorizontalScrollView_Home.OnItemClickListener()
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
    //数据请求（顶部轮播图）
    private void startRequestSlidePicDatas(final Context context) {
        HttpAPI api = Http.getInstance().create(HttpAPI.class);
        //调用接口
        Call<SlidePic> call = api.getSlidePic();

        call.enqueue(new Callback<SlidePic>() {
            @Override
            public void onResponse(Call<SlidePic> call, Response<SlidePic> response) {
                Log.e("response_slide:",response.body().toString());
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
                if(response.body().getCode().equals("200")){

                    //设置文字
                    String text = response.body().getMsg().get(0).getActivityDescribe();//此处只展示一个数据
                    recommend_tv.setText(text);
                    //设置图片(先将地址按都好分开)
                    String[] s=response.body().getMsg().get(3).getPictureSite().split(",");
                    String img_URL = Http.API_URL+s[0];
                    Log.e("recommen_img:",img_URL);
                    Glide.with(getActivity()).load(img_URL).into(recommend_img);
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
        Call<NeiborCompany> call = api.neiborCompany(55);

        call.enqueue(new Callback<NeiborCompany>() {
            @Override
            public void onResponse(Call<NeiborCompany> call, Response<NeiborCompany> response) {
                if(response.body().getCode().equals("200")){
                    datas_neibor = response.body().getMsg();
                    //初始化适配器
                    adapter_neibor = new NeiborAdapter_Home(homeLayout.getContext(),datas_neibor);
                    //绑定适配器
                    listview.setAdapter(adapter_neibor);
                    //ScrollView中嵌套listview不手动设置高度出现只显示一行的情况
                    SetHomeListViewItemHeight.setHeight(listview);
                }
            }

            @Override
            public void onFailure(Call<NeiborCompany> call, Throwable t) {

            }
        });


    }



    //球形图初始化
    private void InitBallGraph() {
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
    //  设置轮播小圆点
    private void setDot(Context context,List<SlidePic.MsgEntity> mImageViewList1) {
        /**
         * 头部轮播图
         */
        //  设置LinearLayout的子控件的宽高，这里单位是像素。
        LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(15,15);
        params1.rightMargin=20;
        //  for循环创建images.length个ImageView（小圆点）
        for(int i=0;i<mImageViewList1.size();i++){
            ImageView  imageViewDot1=new ImageView(context);
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
        ViewPagerAdater_Home01 adapter01=new ViewPagerAdater_Home01(data_slideURL,context);

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
                    currentPosition1=mImageViewList1.size();
                    dotPosition1=mImageViewList1.size()-1;
                }else if(position==mImageViewList1.size()+1){    //当切换到最后一个页面时currentPosition设置为第一个位置，小圆点位置为0
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




    //视图的点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //活动推荐文字索引点击事件
            case R.id.recommend_tv :
                Intent i_exer02 = new Intent(getActivity(),ExerciseActivity.class);
                startActivity(i_exer02);
                break;
            //活动推荐图片点击事件
//            case R.id.recommend_contentimg:
//                break;
            //最新资讯索引点击事件
            case R.id.news_tv:
                Intent i_info = new Intent(getActivity(), InfoActivity.class);
                startActivity(i_info);
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
            default:
                break;
        }
    }
}
