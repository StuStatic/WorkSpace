package com.ylg.workspace.workspace.activity.service.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<String> foods;
    int last_item;
    private int selectedPosition = -1;

    public MyAdapter(Context context, List<String> foods) {
        this.context = context;
        this.foods = foods;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return foods.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.sublist_item, null);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textview1);
            holder.layout = (LinearLayout) convertView.findViewById(R.id.colorlayout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // 设置选中效果
        if (selectedPosition == position) {
            holder.textView.setTextColor(Color.BLUE);


            holder.layout.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.textView.setTextColor(Color.WHITE);
            holder.layout.setBackgroundColor(Color.TRANSPARENT);
        }


        holder.textView.setText(foods.get(position));
        holder.textView.setTextColor(Color.BLACK);

        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
        public LinearLayout layout;
    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
    }

}
