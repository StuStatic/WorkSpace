package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.NeiborCompany;
import com.ylg.workspace.workspace.http.Http;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by stu on 2017/7/11.
 */

public class NeiborAdapter_Home extends BaseAdapter {
//    ArrayList<Map<String,Object>> datas;
    private List<NeiborCompany.MsgEntity> datas;
    private LayoutInflater inflater;
    private Context context;
    //构造方法
    public NeiborAdapter_Home(Context context ,List<NeiborCompany.MsgEntity> datas){
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        NeiborAdapter_Home.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_neiborlv,viewGroup ,false);
            viewHolder=new NeiborAdapter_Home.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(NeiborAdapter_Home.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_name.setText(datas.get(i).getCompanyName());
        viewHolder.tv_summary.setText(datas.get(i).getCompanyProfile());

        //图片设置
        String picURL = Http.API_URL+datas.get(i).getCompanyPicture();
        Glide.with(context).load(picURL).into(viewHolder.img);

        return view;
    }
    private class ViewHolder{
        TextView tv_name,tv_summary;
        ImageView img;
        public ViewHolder(View view){
            //初始化TextView
            tv_name=(TextView)view.findViewById(R.id.neibor_title);
            tv_summary=(TextView)view.findViewById(R.id.neibor_summary02);
            //初始化ImageView
            img=(ImageView)view.findViewById(R.id.neibor_img);

        }
    }
}
