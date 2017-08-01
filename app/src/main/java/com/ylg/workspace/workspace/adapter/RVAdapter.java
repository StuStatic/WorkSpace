package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;

import java.util.List;

/**
 * Created by stu on 2017/8/1.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<Integer> mDatas;
    private List<String> mWords;
    public RVAdapter(Context context, List<Integer> datats , List<String> mWords) {
        mInflater = LayoutInflater.from(context);
        mDatas = datats;
        this.mWords = mWords;

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        ImageView mImg;
        TextView mTxt;
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = mInflater.inflate(R.layout.item_creatcompanyrv,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view.findViewById(R.id.creatcompany_img);
        viewHolder.mTxt = (TextView) view.findViewById(R.id.creatcompany_name);
        return viewHolder;
    }
    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImg.setImageResource(mDatas.get(position));
        holder.mTxt.setText(mWords.get(position));
    }

}
