package com.ylg.workspace.workspace.activity.personaldetails.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.bean.Business;
import com.ylg.workspace.workspace.http.Http;

import java.util.ArrayList;
import java.util.List;


public class BusinessAdapter extends BaseAdapter {

    private Context mContext;
    private List<Business.MsgBean> mList =new ArrayList<>();

    public BusinessAdapter(Context context, List<Business.MsgBean> list) {
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
        mViewHolder.name.setText(mList.get(position).getCompanyName());
        mViewHolder.time.setText(mList.get(position).getSpared1());

        if (mList.get(position).getCompanyPicture().length() != 0) {
            Glide.with(mContext)
                    .load(Http.API_URL + mList.get(position).getCompanyPicture())
                    .placeholder(R.drawable.logo_qu)
                    .error(R.drawable.logo_qu)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .crossFade()
                    .into(mViewHolder.mImageView);
        } else {
            mViewHolder.mImageView.setImageResource(R.drawable.logo_qu);
        }
        return convertView;
    }
    class ViewHolder{
        ImageView mImageView;
        TextView name;
        TextView time;
    }


}
