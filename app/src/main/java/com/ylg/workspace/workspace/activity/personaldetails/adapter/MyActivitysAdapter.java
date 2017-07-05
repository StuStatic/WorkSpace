package com.ylg.workspace.workspace.activity.personaldetails.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.bean.Activity;

import java.util.ArrayList;
import java.util.List;

public class MyActivitysAdapter extends BaseAdapter {
    private Context mContext;
    private List<Activity> mList = new ArrayList<>();

    public MyActivitysAdapter(Context context, List<Activity> list) {
        mContext = context;
        mList = list;
        Log.i("dyy", list.size() + "");
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = null;

        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.myactivitylistview_item, null);
            mViewHolder.name = (TextView) convertView.findViewById(R.id.myactivity_item_name);
            mViewHolder.time = (TextView) convertView.findViewById(R.id.myactivity_item_time);
            mViewHolder.address = (TextView) convertView.findViewById(R.id.myactivity_item_address);
            mViewHolder.state = (Button) convertView.findViewById(R.id.myactivity_item_state);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.name.setText(mList.get(position).getName());
        mViewHolder.time.setText("时间：" + mList.get(position).getTime());
        mViewHolder.address.setText("地点：" + mList.get(position).getAddress());
        mViewHolder.state.setText(mList.get(position).getState());

        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView time;
        TextView address;
        Button state;
    }
}
