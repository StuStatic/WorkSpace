package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.Circle;
import com.ylg.workspace.workspace.http.Http;

import java.util.Arrays;
import java.util.List;

/**
 * Created by stu on 2017/7/20.
 */

public class ListViewAdapter_RecentCircle extends BaseAdapter {
    private Circle list;
    private Context context;

    public ListViewAdapter_RecentCircle(Circle list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.getMsg().size();
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
        ListViewAdapter_RecentCircle.ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(context, R.layout.item_recentcirclelv, null);
            viewHolder = new ListViewAdapter_RecentCircle.ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ListViewAdapter_RecentCircle.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_content.setText(list.getMsg().get(i).getTextWord());
        viewHolder.tv_name.setText(list.getMsg().get(i).getUserName());
        viewHolder.tv_time.setText(list.getMsg().get(i).getCreationTime());
        Glide.with(context).load(Http.API_URL + list.getMsg().get(i).getPicture()).diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.img);
        String str = list.getMsg().get(i).getSharePicture();
        String[] arr = str.split(",");
        List<String> l = Arrays.asList(arr);
        viewHolder.gv.setAdapter(new CircleAdapter(l, context));


        return view;
    }

    private class ViewHolder {
        TextView tv_content, tv_name, tv_time;
        ImageView img;
        GridView gv;

        public ViewHolder(View view) {
            gv = (GridView) view.findViewById(R.id.gv);
            //初始化TextView
            tv_name = (TextView) view.findViewById(R.id.name_recentcircle);
            tv_time = (TextView) view.findViewById(R.id.time_recentcircle);
            tv_content = (TextView) view.findViewById(R.id.content_recentcircle);
//            //初始化ImageView
            img = (ImageView) view.findViewById(R.id.head_recentcircle);

        }
    }
}
