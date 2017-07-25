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
import com.ylg.workspace.workspace.bean.SpaceList;
import com.ylg.workspace.workspace.http.Http;

import java.util.List;

/**
 * Created by stu on 2017/6/30.
 */

public class HorizontalScrollViewAdapter_Home {
    private Context context;
    private LayoutInflater mInflater;
    private List<SpaceList.MsgEntity> mDatas;

    public HorizontalScrollViewAdapter_Home(Context context, List<SpaceList.MsgEntity> mDatas)
    {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    public int getCount()
    {
        return mDatas.size();
    }

    public Object getItem(int position)
    {
        return mDatas.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(
                    R.layout.item_horizontalscrollview, parent, false);
            viewHolder.mImg = (ImageView) convertView
                    .findViewById(R.id.hsv_img);


            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        viewHolder.mImg.setImageResource(mDatas.get(position));
        String[] url = mDatas.get(position).getSpacePicture().split(",");
        String img_URL=Http.API_URL+url[0];
        Log.e("水平视图图片地址：",img_URL);
        Glide.with(context).load(img_URL).into(viewHolder.mImg);
        return convertView;
    }

    private class ViewHolder
    {
        ImageView mImg;
        TextView mText;
    }
}
