package com.ylg.workspace.workspace.activity.personaldetails.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.personaldetails.bean.MakeAnAppointFrag;

import java.util.ArrayList;
import java.util.List;


public class FragmentMakeAnAppinntmentAdapter extends BaseAdapter {

    private Context mContext;
    private List<MakeAnAppointFrag.MsgBean> mList =new ArrayList<>();

    public FragmentMakeAnAppinntmentAdapter(Context context, List<MakeAnAppointFrag.MsgBean> list) {
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
            convertView = View.inflate(mContext, R.layout.makeanappointmentfragmentistview_item,null);
            mViewHolder.address = (TextView) convertView.findViewById(R.id.make_fragment_an_appointment_item_address);
            mViewHolder.name = (TextView) convertView.findViewById(R.id.make_fragment_an_appointment_item_name);
            mViewHolder.time = (TextView) convertView.findViewById(R.id.make_fragment_an_appointment_item_time);
            mViewHolder.reason = (TextView) convertView.findViewById(R.id.make_fragment_an_appointment_item_reason);
            mViewHolder.type = (Button) convertView.findViewById(R.id.make_fragment_an_appointment_item_type);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.name.setText("受访对象："+mList.get(position).getUserName());
        mViewHolder.time.setText("预约时间："+mList.get(position).getVisitTime());
        mViewHolder.address.setText("访问社区："+mList.get(position).getSpared1());
        mViewHolder.reason.setText("来访事由："+mList.get(position).getVisitInfo());
//        mViewHolder.type.setText(mList.get(position).getType());
        return convertView;
    }
    class ViewHolder{
        TextView name;
        TextView time;
        TextView address;
        TextView reason;
        Button type;
    }


}
