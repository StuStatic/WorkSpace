package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.SlidePic;

import java.util.List;
import java.util.Map;

/**
 * Created by stu on 2017/6/28.
 */

public class ViewPagerAdater_Home01 extends PagerAdapter {
//    private List<SlidePic.MsgEntity> list;
    private List<Map<String, Object>> data;
    private Context context;
    public ViewPagerAdater_Home01(List<Map<String, Object>> data , Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = (ImageView) data.get(position).get("view");
        Log.e("data.get(i).get(url)",data.get(position).get("url").toString());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(context)
                .load(data.get(position).get("url").toString())
//                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.a4)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
        container.removeView(imageView);
        container.addView(imageView);


        return data.get(position).get("view");
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(list.get(position));
        ImageView x = (ImageView) data.get(position).get("view");
        x.setScaleType(ImageView.ScaleType.FIT_CENTER);
        container.removeView(x);
    }
}
