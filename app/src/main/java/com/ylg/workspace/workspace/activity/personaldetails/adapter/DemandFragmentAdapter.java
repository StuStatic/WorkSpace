package com.ylg.workspace.workspace.activity.personaldetails.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.bean.DemandFrag;
import com.ylg.workspace.workspace.activity.personaldetails.bean.FeedBackFrag.MsgBean;
import com.ylg.workspace.workspace.view.tag.Tag;
import com.ylg.workspace.workspace.view.tag.TagListView;

import java.util.ArrayList;
import java.util.List;

public class DemandFragmentAdapter extends BaseAdapter {

    private Context mContext;
    private List<DemandFrag.MsgBean> mFeedBackFrags;
    private final List<Tag> mTags = new ArrayList<Tag>();
    public DemandFragmentAdapter(Context context, List<DemandFrag.MsgBean> feedBackFrags) {
        mContext = context;
        mFeedBackFrags = feedBackFrags;
    }

    @Override
    public int getCount() {
        return mFeedBackFrags.size();
    }

    @Override
    public Object getItem(int position) {
        return mFeedBackFrags.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder1 mViewHolder = null;
        if (convertView == null){
            mViewHolder = new ViewHoder1();
            convertView = View.inflate(mContext, R.layout.item_demand,null);
            mViewHolder.time = (TextView) convertView.findViewById(R.id.demand_item_tv_time);
            mViewHolder.content = (TextView) convertView.findViewById(R.id.demand_item_tv_content);
            mViewHolder.state = (TagListView) convertView.findViewById(R.id.demand_item_tag_interest);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHoder1) convertView.getTag();
        }
        mViewHolder.time.setText(mFeedBackFrags.get(position).getTime());
        mViewHolder.content.setText(mFeedBackFrags.get(position).getDescribe());
        setUpDataInterest(mFeedBackFrags.get(position).getFacilitatorLabel());
        mViewHolder.state.setTags(mTags);
        return convertView;
    }
    class ViewHoder1 {
        TextView time;
        TextView content;
        TagListView state;
    }
    private void setUpDataInterest(List<String> facilitatorLabel) {
        for (int i = 0; i < facilitatorLabel.size(); i++) {
            Tag tag = new Tag();
            tag.setId(i);
            tag.setChecked(true);
            tag.setTitle(facilitatorLabel.get(i));
            mTags.add(tag);
        }
    }
}

