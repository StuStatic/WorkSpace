package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.http.Http;

import java.util.List;


public class CircleAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    public CircleAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_image, null);
            holder.image = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context)
                .load(Http.API_URL + list.get(position))
                .placeholder(R.mipmap.default_error)
                .error(R.mipmap.default_error)
                .centerCrop()
                .crossFade()
                .into(holder.image);
        return convertView;
    }

    class ViewHolder {
        ImageView image;
    }
}
