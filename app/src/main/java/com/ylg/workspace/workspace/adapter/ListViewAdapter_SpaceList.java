package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.SpaceList;
import com.ylg.workspace.workspace.http.Http;

import java.util.List;

/**
 * Created by stu on 2017/7/16.
 */

public class ListViewAdapter_SpaceList extends BaseAdapter {
    private List<SpaceList.MsgEntity> datas;
    private LayoutInflater inflater;
    private Context context;
    //构造方法
    public ListViewAdapter_SpaceList(Context context , List<SpaceList.MsgEntity> datas){
        this.datas =datas;
        this.context=context;
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
        ListViewAdapter_SpaceList.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_spacelistlv,viewGroup ,false);
            viewHolder=new ListViewAdapter_SpaceList.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ListViewAdapter_SpaceList.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_title.setText(datas.get(i).getSpaceName());
        viewHolder.tv_location.setText(datas.get(i).getSpaceSite());
        viewHolder.tv_num.setText(datas.get(i).getSpaceDescribe());
        //图片与星级
        String[] url = datas.get(i).getSpacePicture().split(",");
        String img_URL=Http.API_URL+url[0];
        Glide.with(context).load(img_URL).into(viewHolder.listview_img);
        String starNum=datas.get(i).getSpaceStar();
        if(starNum.equals(null) || starNum.equals("")){
            //星级都显示空心，即默认情况
        }else if(starNum.equals("1")){
            viewHolder.img_star01.setImageResource(R.drawable.star_full);
        }else if(starNum.equals("2")){
            viewHolder.img_star01.setImageResource(R.drawable.star_full);
            viewHolder.img_star02.setImageResource(R.drawable.star_full);
        }else if(starNum.equals("3")){
            viewHolder.img_star01.setImageResource(R.drawable.star_full);
            viewHolder.img_star02.setImageResource(R.drawable.star_full);
            viewHolder.img_star03.setImageResource(R.drawable.star_full);
        }else if(starNum.equals("4")){
            viewHolder.img_star01.setImageResource(R.drawable.star_full);
            viewHolder.img_star02.setImageResource(R.drawable.star_full);
            viewHolder.img_star03.setImageResource(R.drawable.star_full);
            viewHolder.img_star04.setImageResource(R.drawable.star_full);
        }else if(starNum.equals("5")){
            viewHolder.img_star01.setImageResource(R.drawable.star_full);
            viewHolder.img_star02.setImageResource(R.drawable.star_full);
            viewHolder.img_star03.setImageResource(R.drawable.star_full);
            viewHolder.img_star04.setImageResource(R.drawable.star_full);
            viewHolder.img_star05.setImageResource(R.drawable.star_full);
        }else{
            //显示默认情况
        }


        return view;
    }
    private class ViewHolder{
        TextView tv_title , tv_location ,tv_num;
        ImageView listview_img ,img_star01,img_star02,img_star03,img_star04,img_star05;
        public ViewHolder(View view){
            //初始化TextView
            tv_title=(TextView)view.findViewById(R.id.spacelist_itemtv);
            tv_location =(TextView)view.findViewById(R.id.spacelist_itemlocation);
            tv_num =(TextView)view.findViewById(R.id.spacelist_num);
            //初始化ImageView
            listview_img=(ImageView)view.findViewById(R.id.spacelist_itemimg);
            img_star01=(ImageView)view.findViewById(R.id.spacelist_star01);
            img_star02=(ImageView)view.findViewById(R.id.spacelist_star02);
            img_star03=(ImageView)view.findViewById(R.id.spacelist_star03);
            img_star04=(ImageView)view.findViewById(R.id.spacelist_star04);
            img_star05=(ImageView)view.findViewById(R.id.spacelist_star05);

        }
    }
}
