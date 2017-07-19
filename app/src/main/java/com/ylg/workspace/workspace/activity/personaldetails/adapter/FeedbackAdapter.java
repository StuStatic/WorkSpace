package com.ylg.workspace.workspace.activity.personaldetails.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.bean.FeedBackFrag.MsgBean;

import java.util.List;

public class FeedbackAdapter extends BaseAdapter {

    private Context mContext;
    private List<MsgBean> mFeedBackFrags;

    public FeedbackAdapter(Context context, List<MsgBean> feedBackFrags) {
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
            convertView = View.inflate(mContext, R.layout.item_feedback,null);
            mViewHolder.time = (TextView) convertView.findViewById(R.id.feedback_item_tv_time);
            mViewHolder.content = (TextView) convertView.findViewById(R.id.feedback_item_tv_content);
            mViewHolder.state = (Button) convertView.findViewById(R.id.feedback_item_state);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHoder1) convertView.getTag();
        }
        mViewHolder.time.setText(mFeedBackFrags.get(position).getTime());
        mViewHolder.content.setText(mFeedBackFrags.get(position).getOpinionContent());
        if (mFeedBackFrags.get(position).getOpinionState()==1){
            mViewHolder.state.setText("已读取");
        }else if (mFeedBackFrags.get(position).getOpinionState()==0){
            mViewHolder.state.setText("未读取");
        }



        return convertView;
    }
    class ViewHoder1 {
        TextView time;
        TextView content;
        Button state;
    }

}

