package com.ylg.workspace.workspace.activity.ballgraph;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.HSVAdapter_SpaceListActivity;
import com.ylg.workspace.workspace.adapter.TabAdapter_SpaceListActivity;
import com.ylg.workspace.workspace.view.MyHorizontalScrollView_SpaceList;
import com.ylg.workspace.workspace.view.tag.ViewPagerForScrollView_SpaceList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @write by stu on 2017/7/16
 */

public class SpaceListActivity extends App implements View.OnClickListener{
    /**
     *
     * @author stu
     * @param savedInstanceState
     */

    //toobar
    private ImageView img_back,img_share;
    private TextView title;
    //horizontalscrollview
    private MyHorizontalScrollView_SpaceList hsv;
    private HSVAdapter_SpaceListActivity adapter_hsv;
    private ImageView img_hsv;
    private List<Integer> mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.beijing,R.drawable.shenzhen,R.drawable.tianjin,R.drawable.shanghai));

    //tablayout
    private TabLayout tb_layout;
    private ViewPagerForScrollView_SpaceList viewPager;
    private TabAdapter_SpaceListActivity tabAdapter;
    private String[] titles = {"全部","上海","北京","南京","成都","天津","深圳","广州","杭州"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_spacelist);
        init();
    }

    private void init() {

        //初始toolbar
        InitBar();

        //初始化horizontalscrollview
        InitHorizontalscrollview();

        //初始化tab
        InitTab();

    }



    //配置horizontalscrollview
    private void InitHorizontalscrollview() {
        hsv = (MyHorizontalScrollView_SpaceList)findViewById(R.id.spacelist_hsv);
        //初始化adapter
        adapter_hsv = new HSVAdapter_SpaceListActivity(this, mDatas);
        //添加HorizontalScrollView点击回调
        hsv.setOnItemClickListener(new MyHorizontalScrollView_SpaceList.OnItemClickListener()
        {

            @Override
            public void onClick(View view, int position)
            {
                Log.i("dyy",position+"");
//                mImg.setImageResource(mDatas.get(position));
//                view.setBackgroundColor(Color.parseColor("#AA024DA4"));
//                Toast.makeText(SpaceListActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });

        //设置适配器
        hsv.initDatas(adapter_hsv);
    }

    //初始化tablayout和viewpager
    private void InitTab() {
        tabAdapter = new TabAdapter_SpaceListActivity(getSupportFragmentManager(), titles,this);
        tb_layout = (TabLayout) findViewById(R.id.spacelist_tablayout);

        viewPager = (ViewPagerForScrollView_SpaceList) findViewById(R.id.spacelist_viewpager);
        viewPager.setAdapter(tabAdapter);

        final int currentSelectedPosition = viewPager.getCurrentItem();
        //注：scrollview+viewpager+listview解决冲突办法：1.重写listview 2.viewpager高度写死（400dp）3.重写viewpager4.viewpager添加setOnPagerChangeListener
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                View view = viewPager.getChildAt(currentSelectedPosition);
                int height = view.getMeasuredHeight();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewPager.getLayoutParams();
                layoutParams.height = height;
                viewPager.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tb_layout.setupWithViewPager(viewPager);
        tb_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    //配置toolbar
    private void InitBar() {
        //初始化toolbar中的控件view
        img_back = (ImageView)findViewById(R.id.iv_back);
        img_share = (ImageView)findViewById(R.id.iv_intent);
        title = (TextView)findViewById(R.id.tv_title);
        //赋值
        img_share.setImageResource(R.drawable.share_spacelist);
        title.setText("空间列表");
        //绑定监听
        img_back.setOnClickListener(this);
        img_share.setOnClickListener(this);
    }

    //控件的点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_intent:
                Toast.makeText(this, "开始分享", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        removeActivity(this);
        super.onDestroy();
    }
}
