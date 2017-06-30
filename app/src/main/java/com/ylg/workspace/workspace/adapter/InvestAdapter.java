package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;

import java.util.List;

/**
 * Created by Administrator on 2017/6/30.
 */

public class InvestAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public InvestAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lv_invest, null);
            holder = new ViewHolder();

            convertView.setTag(holder);

            holder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
            holder.tv2 = (TextView) convertView.findViewById(R.id.tv2);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv1.setText(list.get(position));
        holder.tv2.setText(list.get(position));

        return convertView;
    }

    static class ViewHolder {
        TextView tv1;
        TextView tv2;
    }
}
