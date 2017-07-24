package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.Info;
import com.ylg.workspace.workspace.http.Http;

import java.util.List;

/**
 * Created by stu on 2017/7/3.
 */

public class ListViewAdapter01_InfoActivity extends BaseAdapter {
    private List<Info.MsgBean.SpaceBean> datas;
    private LayoutInflater inflater;

    //构造方法
    public ListViewAdapter01_InfoActivity(Context context, List<Info.MsgBean.SpaceBean> datas) {
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
        ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.item_infolistview, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_content.setText(datas.get(i).getTitle());
        //日期和图片暂时不设置
        viewHolder.tv_date.setText(datas.get(i).getIssueTime());
        String s = datas.get(i).getPictureSite();
        String img_URL = Http.API_URL + s;
        Glide.with(inflater.getContext()).load(img_URL).diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.listview_img);

        return view;
    }

    private class ViewHolder {
        TextView tv_content, tv_date;
        ImageView listview_img;

        public ViewHolder(View view) {
            //初始化TextView
            tv_content = (TextView) view.findViewById(R.id.listview_content);
            tv_date = (TextView) view.findViewById(R.id.listview_date);
            //初始化ImageView
            listview_img = (ImageView) view.findViewById(R.id.listview_img);
        }
    }
}
