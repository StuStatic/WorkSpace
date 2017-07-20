package com.ylg.workspace.workspace.activity.personaldetails.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.bean.NotMyActivity;

import java.util.ArrayList;
import java.util.List;

public class MyActivitysEndAdapter extends BaseAdapter {
    private Context mContext;
    private List<NotMyActivity.MsgBean> mList = new ArrayList<>();

    public MyActivitysEndAdapter(Context context, List<NotMyActivity.MsgBean> list) {
        mContext = context;
        mList = list;
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
        mViewHolder.name.setText(mList.get(position).getTitle());
        mViewHolder.time.setText("时间：" + mList.get(position).getStarTime() + " - " + mList.get(position).getEndTime());
        mViewHolder.address.setText("地点：" + mList.get(position).getSpared1());
        mViewHolder.state.setText("已结束");
        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView time;
        TextView address;
        Button state;
    }
}
