package com.ylg.workspace.workspace.activity.personaldetails.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.bean.Business;

import java.util.ArrayList;
import java.util.List;


public class BusinessAdapter extends BaseAdapter {

    private Context mContext;
    private List<Business> mList =new ArrayList<>();

    public BusinessAdapter(Context context, List<Business> list) {
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
        if (convertView ==null){
            mViewHolder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.businesslistview_item,null);
            mViewHolder.mImageView = (ImageView) convertView.findViewById(R.id.business_item_lv_logo);
            mViewHolder.name = (TextView) convertView.findViewById(R.id.business_item_tv_name);
            mViewHolder.time = (TextView) convertView.findViewById(R.id.business_item_tv_time);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.name.setText(mList.get(position).getName());
        mViewHolder.time.setText(mList.get(position).getTime());
        mViewHolder.mImageView.setImageResource(R.drawable.logo_qu);
        return convertView;
    }
    class ViewHolder{
        ImageView mImageView;
        TextView name;
        TextView time;
    }


}
