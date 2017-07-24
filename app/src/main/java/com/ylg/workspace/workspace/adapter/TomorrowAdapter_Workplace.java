package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.WorkPlace;
import com.ylg.workspace.workspace.http.Http;

import java.util.List;

import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * Created by stu on 2017/7/10.
 */

public class TomorrowAdapter_Workplace extends BaseAdapter{
    private List<WorkPlace.MsgEntity> datas;
    private LayoutInflater inflater;
    private Context context;
    //构造方法
    public TomorrowAdapter_Workplace(Context context , List<WorkPlace.MsgEntity> datas){
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TomorrowAdapter_Workplace.ViewHolder viewHolder;
        if(view==null){
            view=inflater.inflate(R.layout.item_workplacetomorrowlv,viewGroup ,false);
            viewHolder=new TomorrowAdapter_Workplace.ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder=(TomorrowAdapter_Workplace.ViewHolder) view.getTag();

        }
        //设置文字
        viewHolder.tv_title.setText(datas.get(i).getSpared1());
        viewHolder.tv_address.setText(datas.get(i).getLocation());
        viewHolder.tv_number.setText(datas.get(i).getStationType()+"");
        viewHolder.tv_price.setText(datas.get(i).getStationPrice()+"");
        //日期和图片暂时不设置
        Glide.with(context).load(Http.API_URL+datas.get(i).getStationPicture()).into(viewHolder.img_title);


        return view;
    }
    private class ViewHolder{
        TextView tv_title,tv_address,tv_number,tv_price;
        ImageView img_title,img_order;
        public ViewHolder(View view){
            //初始化TextView
            tv_title=(TextView)view.findViewById(R.id.workplace_title_tomorrow);
            tv_address=(TextView)view.findViewById(R.id.workplace_address_tomorrow);
            tv_number=(TextView)view.findViewById(R.id.workplace_number_tomorrow);
            tv_price=(TextView)view.findViewById(R.id.workplace_price_tomorrow);
            //初始化ImageView
            img_title=(ImageView)view.findViewById(R.id.workplace_img_tomorrow);
            img_order=(ImageView)view.findViewById(R.id.workplace_order_tomorrow);
        }
    }
}
