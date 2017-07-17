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
 * Created by stu on 2017/6/29.
 */

public class ViewPagerAdapter_Service01 extends PagerAdapter{
    private List<Map<String, Object>> list;
    private Context context;

    public ViewPagerAdapter_Service01(Context context,List<Map<String, Object>> list){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = (ImageView) list.get(position).get("view");
//        Log.e("data.get(i).get(url)",list.get(position).get("url").toString());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(context)
                .load(list.get(position).get("url").toString())
//                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.a4)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageView);
        container.removeView(imageView);
        container.addView(imageView);


        return list.get(position).get("view");
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView x = (ImageView) list.get(position).get("view");
        x.setScaleType(ImageView.ScaleType.FIT_CENTER);
        container.removeView(x);
    }
}
