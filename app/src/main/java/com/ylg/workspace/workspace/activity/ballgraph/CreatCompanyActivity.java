package com.ylg.workspace.workspace.activity.ballgraph;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.adapter.RVAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatCompanyActivity extends AppCompatActivity implements View.OnClickListener{
    /**
     * writen on 2017/8/1
     * @author stu
     */
    private TextView title;
    private ImageView back_img,save_img;
    private RecyclerView rv01,rv02,rv03,rv04,rv05,rv06,rv07;//从上至下01-07
    private RVAdapter adapter01,adapter02,adapter03,adapter04,adapter05,adapter06,adapter07;
    private List<Integer> datas_internet,datas_hardware,datas_culture,datas_finance,datas_business,datas_life,datas_others;//图片集合
    private List<String> words_internet,words_hardware,words_culture,words_finance,words_business,words_life,words_others;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatcompany);
        init();
    }

    private void init() {
        //初始化toolbar
        title = (TextView)findViewById(R.id.tv_title);
        title.setText("创建企业");
        back_img = (ImageView)findViewById(R.id.iv_back);
        back_img.setOnClickListener(this);
        save_img = (ImageView)findViewById(R.id.iv_intent);
        save_img.setImageResource(R.drawable.addpic);

        //初始化图片信息
        initDatas();

        //rv01绑定#互联网#
        bindrv01();

        //rv02绑定#智能硬件#
        bindrv02();

        //rv03绑定#文与传媒#
        bindrv03();

        //rv04绑定#金融#
        bindrv04();

        //rv05绑定#商务/企业服务#
        bindrv05();

        //rv06绑定#生活/个人服务#
        bindrv06();

        //rv07绑定#其它#
        bindrv07();




    }




    private void initDatas() {
        //初始化图片数据#互联网#
        datas_internet = new ArrayList<Integer>(Arrays.asList(R.drawable.dataservice,
                R.drawable.internetthings, R.drawable.oto, R.drawable.app, R.drawable.infoplatform,
                R.drawable.businessonline, R.drawable.softwaretec));
        words_internet = new ArrayList<String>(Arrays.asList("数据服务","物联网","OTO","APP","信息平台/网站","电商","软件技术"));
        //初始化#智能硬件#
        datas_hardware = new ArrayList<Integer>(Arrays.asList(R.drawable.hardtec,
                R.drawable.eleproduct, R.drawable.arvr, R.drawable.robot, R.drawable.furniture,
                R.drawable.plane));
        words_hardware = new ArrayList<String>(Arrays.asList("硬科技","电子产品","AR/VR","机器人","智能家居","无人机"));
        //初始化#文娱传媒#
        datas_culture = new ArrayList<Integer>(Arrays.asList(R.drawable.movie,
                R.drawable.music, R.drawable.magazine, R.drawable.sports, R.drawable.media,
                R.drawable.advertisement,R.drawable.designart));
        words_culture = new ArrayList<String>(Arrays.asList("影视","音乐","杂志","体育","新媒体","广告","设计/艺术"));
        //初始化#金融#
        datas_finance = new ArrayList<Integer>(Arrays.asList(R.drawable.credit,
                R.drawable.payment, R.drawable.begbelif, R.drawable.p2p, R.drawable.shares,
                R.drawable.foundation,R.drawable.investmanagement,R.drawable.insurance));
        words_finance = new ArrayList<String>(Arrays.asList("信贷","支付","征信","P2P","股票","基金会","投资管理","保险"));
        //初始化#商务/企业服务#
        datas_business = new ArrayList<Integer>(Arrays.asList(R.drawable.hr,
                R.drawable.law, R.drawable.publicrelation, R.drawable.finance, R.drawable.infoagency,
                R.drawable.consult));
        words_business = new ArrayList<String>(Arrays.asList("人力资源","法律/政策","宣传/公关","财务","信息中介/交易撮合","咨询/策划"));
        //初始化#生活/个人服务#
        datas_life = new ArrayList<Integer>(Arrays.asList(R.drawable.food,
                R.drawable.travel, R.drawable.live, R.drawable.makeup, R.drawable.swim,
                R.drawable.hospital,R.drawable.fit,R.drawable.education));
        words_life = new ArrayList<String>(Arrays.asList("美食","出行","住宿","美妆","娱乐/游泳","医疗","健身","教育"));
        //其他
        datas_others = new ArrayList<Integer>(Arrays.asList(R.drawable.work,
                R.drawable.ngo, R.drawable.produce, R.drawable.material, R.drawable.others));
        words_others = new ArrayList<String>(Arrays.asList("联合办公","NGO","制造业","原材料","其他"));
    }



    private void bindrv01() {
        //初始化recyclerview
        rv01 = (RecyclerView)findViewById(R.id.rv_internet);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv01.setLayoutManager(gridLayoutManager);
        //设置适配器
        adapter01 = new RVAdapter(this, datas_internet,words_internet);
        rv01.setAdapter(adapter01);
    }

    private void bindrv02() {
        //初始化recyclerview
        rv02 = (RecyclerView)findViewById(R.id.rv_hardware);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv02.setLayoutManager(gridLayoutManager);
        //设置适配器
        adapter02 = new RVAdapter(this, datas_hardware,words_hardware);
        rv02.setAdapter(adapter02);
    }

    private void bindrv03() {
        //初始化recyclerview
        rv03 = (RecyclerView)findViewById(R.id.rv_culture);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv03.setLayoutManager(gridLayoutManager);
        //设置适配器
        adapter03 = new RVAdapter(this, datas_culture,words_culture);
        rv03.setAdapter(adapter03);
    }

    private void bindrv04() {
        //初始化recyclerview
        rv04 = (RecyclerView)findViewById(R.id.rv_finance);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv04.setLayoutManager(gridLayoutManager);
        //设置适配器
        adapter04 = new RVAdapter(this, datas_finance,words_finance);
        rv04.setAdapter(adapter04);
    }

    private void bindrv05() {
        //初始化recyclerview
        rv05 = (RecyclerView)findViewById(R.id.rv_business);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv05.setLayoutManager(gridLayoutManager);
        //设置适配器
        adapter05 = new RVAdapter(this, datas_business,words_business);
        rv05.setAdapter(adapter05);
    }

    private void bindrv06() {
        //初始化recyclerview
        rv06 = (RecyclerView)findViewById(R.id.rv_life);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv06.setLayoutManager(gridLayoutManager);
        //设置适配器
        adapter06 = new RVAdapter(this, datas_life,words_life);
        rv06.setAdapter(adapter06);
    }

    private void bindrv07() {
        //初始化recyclerview
        rv07 = (RecyclerView)findViewById(R.id.rv_others);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv07.setLayoutManager(gridLayoutManager);
        //设置适配器
        adapter07 = new RVAdapter(this, datas_others,words_others);
        rv07.setAdapter(adapter07);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
