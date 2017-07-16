package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ylg.workspace.workspace.R;

import java.util.List;

/**
 * Created by stu on 2017/7/16.
 */

public class HSVAdapter_SpaceListActivity {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Integer> mDatas;

    public HSVAdapter_SpaceListActivity(Context context, List<Integer> mDatas)
    {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    public int getCount()
    {
        return mDatas.size();
    }

    public Object getItem(int position)
    {
        return mDatas.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        HSVAdapter_SpaceListActivity.ViewHolder viewHolder = null;
        if (convertView == null)
        {
            viewHolder = new HSVAdapter_SpaceListActivity.ViewHolder();
            convertView = mInflater.inflate(R.layout.item_spacelisthsv, parent, false);
            viewHolder.mImg = (ImageView) convertView.findViewById(R.id.spacelist_img);
//            viewHolder.mText = (TextView) convertView
//                    .findViewById(R.id.id_index_gallery_item_text);

            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (HSVAdapter_SpaceListActivity.ViewHolder) convertView.getTag();
        }
        viewHolder.mImg.setImageResource(mDatas.get(position));
//        viewHolder.mText.setText("some info ");

        return convertView;
    }

    private class ViewHolder
    {
        ImageView mImg;
//        TextView mText;
    }
}
