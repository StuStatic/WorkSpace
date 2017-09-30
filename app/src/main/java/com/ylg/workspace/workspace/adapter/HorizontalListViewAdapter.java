package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.bean.MeetRoomOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HorizontalListViewAdapter extends BaseAdapter {

    private Context context;
    private MeetRoomOrder meetroomOrder;
    private int i1;
    private int i2;
    private List<Double> doubleList = new ArrayList<>();
    private List<String> tagTist = new ArrayList<>();
    private double startTime = 0.0;
    private double endTime = 0.0;
    private double total = 0.0;
    private SubClickListener subClickListener;
    private List<MeetRoomOrder.MsgBean> list;

    public void setSubClickListener(SubClickListener topicClickListener) {
        this.subClickListener = topicClickListener;
    }

    public interface SubClickListener {
        void OnTopicClickListener(double d1, double d2);

        void OnTopicClickListener1(double d1, double d2);
    }


    //自定义接口，用于回调按钮点击事件到Activity
    public interface MyClickListener {
        public void clickListener(View v);
    }

    public HorizontalListViewAdapter(Context context, MeetRoomOrder meetroomOrder, int i1, int i2) {
        this.context = context;
        this.meetroomOrder = meetroomOrder;
        this.i1 = i1;
        this.i2 = i2;
    }

    @Override
    public int getCount() {
        return i2 - i1;
    }


    @Override
    public Object getItem(int position) {
        return position;
    }


    private class ViewHolder {
        private TextView time;
        private ImageView iv1, iv2;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.horizontallistview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.iv1 = (ImageView) convertView.findViewById(R.id.iv_time1);
            viewHolder.iv2 = (ImageView) convertView.findViewById(R.id.iv_time2);
            viewHolder.time = (TextView) convertView.findViewById(R.id.tv_time);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final int hour = i1 + position;
        viewHolder.time.setText(hour + "时");

        viewHolder.iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("zp", "double: " + doubleList.toString());
                int i = (Integer) viewHolder.iv1.getTag(R.id.tag);
                Log.d("zp", "onClick: " + i);

                if (startTime == 0.0) {
                    //一个绿色没选

                    if (i == 3) {
                        startTime = hour + 0.0;
                        Log.d("zp", "startTime" + startTime);
                        viewHolder.iv1.setImageResource(R.drawable.order_greenstate);
                        //绿色设为2
                        viewHolder.iv1.setTag(R.id.tag, 2);
                        if (subClickListener != null) {
                            subClickListener.OnTopicClickListener1(startTime, startTime + 0.5);
                        }

                    }

                } else if (startTime != 0.0 && endTime == 0.0) {
                    Log.d("zp", "startTime" + startTime);
                    if (doubleList.size() > 0) {
                        endTime = hour + 0.0;
                        for (int j = 0; j < doubleList.size(); j++) {
                            if (doubleList.get(j) < endTime && startTime < doubleList.get(j)) {
                                tagTist.add("aaa");
                            }

                        }
                        if (i == 3 && startTime < hour + 0.0 && tagTist.size() == 0) {
                            Log.d("zp", "startTime" + startTime);
                            viewHolder.iv1.setImageResource(R.drawable.order_greenstate);
                            //绿色设为2
                            viewHolder.iv1.setTag(R.id.tag, 2);

                            if (subClickListener != null) {
                                subClickListener.OnTopicClickListener(startTime, endTime);
                            }
                            tagTist.clear();
                        }
                    } else {
                        if (i == 3 && startTime < hour + 0.0) {
                            Log.d("zp", "startTime" + startTime);
                            viewHolder.iv1.setImageResource(R.drawable.order_greenstate);
                            //绿色设为2
                            viewHolder.iv1.setTag(R.id.tag, 2);
                            endTime = hour + 0.0;
                            if (subClickListener != null) {
                                subClickListener.OnTopicClickListener(startTime, endTime);
                            }
                        }
                    }
                }

            }

        });
        viewHolder.iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = (Integer) viewHolder.iv2.getTag(R.id.tag);

                if (startTime == 0.0) {
                    //一个绿色没选

                    if (i == 3) {

                        startTime = hour + 0.5;
                        Log.d("zp", "startTime" + startTime);
                        viewHolder.iv2.setImageResource(R.drawable.order_greenstate);
                        //绿色设为2
                        viewHolder.iv2.setTag(R.id.tag, 2);
                        if (subClickListener != null) {
                            subClickListener.OnTopicClickListener1(startTime, startTime + 0.5);
                        }


                    }

                } else if (startTime != 0.0 && endTime == 0.0) {
                    Log.d("zp", "startTime" + startTime);
                    if (doubleList.size() > 0) {
                        endTime = hour + 0.5;
                        for (int j = 0; j < doubleList.size(); j++) {
                            if (doubleList.get(j) < endTime && startTime < doubleList.get(j)) {
                                tagTist.add("aaa");
                            }

                        }
                        if (i == 3 && startTime < hour + 0.5 && tagTist.size() == 0) {
                            viewHolder.iv2.setImageResource(R.drawable.order_greenstate);
                            //绿色设为2
                            viewHolder.iv2.setTag(R.id.tag, 2);

                            if (subClickListener != null) {
                                subClickListener.OnTopicClickListener(startTime, endTime);
                            }
                            tagTist.clear();
                        }
                    } else {
                        double d = hour + 0.5;

                        if (i == 3 && startTime < d) {

                            viewHolder.iv2.setImageResource(R.drawable.order_greenstate);
                            //绿色设为2
                            viewHolder.iv2.setTag(R.id.tag, 2);
                            endTime = hour + 0.5;
                            if (subClickListener != null) {
                                subClickListener.OnTopicClickListener(startTime, endTime);
                            }
                        }
                    }
                }
            }
        });
        viewHolder.iv1.setTag(hour + 0.0);
        viewHolder.iv2.setTag(hour + 0.5);
        viewHolder.iv2.setTag(R.id.tag, 3);
        viewHolder.iv1.setTag(R.id.tag, 3);
        viewHolder.iv1.setImageResource(R.drawable.item_emptystate);
        viewHolder.iv2.setImageResource(R.drawable.item_emptystate);

//        Log.d("zp", "getView: " + list.toString());
        if (meetroomOrder.getCode().equals("200")) {
            list = meetroomOrder.getMsg();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            for (int i = 0; i < list.size(); i++) {
                int tag1 = (Integer) viewHolder.iv1.getTag(R.id.tag);
                int tag2 = (Integer) viewHolder.iv2.getTag(R.id.tag);
                try {
                    Date date1 = sdf.parse(list.get(i).getStartTime());
                    Date date2 = sdf.parse(list.get(i).getEndTime());
                    int i1 = date1.getHours();
                    int i3 = date2.getHours();
                    int i2 = date1.getMinutes();
                    int i4 = date2.getMinutes();
                    double d1 = (double) viewHolder.iv1.getTag();
                    double d2 = (double) viewHolder.iv2.getTag();


                    if (i1 == hour && hour < i3) {
                        if (i2 == 30 && d2 == hour + 0.5) {
                            viewHolder.iv2.setImageResource(R.drawable.order_graystate);
                            if (!doubleList.contains(hour + 0.5)) {
                                doubleList.add(hour + 0.5);
                            }
                            viewHolder.iv2.setTag(R.id.tag, 1);
                            if (tag1 != 1) {
                                viewHolder.iv1.setTag(R.id.tag, 3);
                            }

                        } else if (d2 == hour + 0.5 && d1 == hour) {
                            viewHolder.iv2.setImageResource(R.drawable.order_graystate);
                            viewHolder.iv1.setImageResource(R.drawable.order_graystate);
                            //灰色设为1
                            viewHolder.iv2.setTag(R.id.tag, 1);
                            viewHolder.iv1.setTag(R.id.tag, 1);
                            if (!doubleList.contains(hour + 0.5)) {
                                doubleList.add(hour + 0.5);
                            }
                            if (!doubleList.contains(hour + 0.0)) {
                                doubleList.add(hour + 0.0);
                            }
                        } else {
                            if (tag1 != 1) {
                                viewHolder.iv1.setTag(R.id.tag, 3);
                            }
                            if (tag2 != 1) {
                                viewHolder.iv2.setTag(R.id.tag, 3);
                            }
                        }

                    } else if (i1 < hour && i3 > hour && d2 == hour + 0.5 && d1 == hour) {
                        viewHolder.iv2.setImageResource(R.drawable.order_graystate);
                        viewHolder.iv1.setImageResource(R.drawable.order_graystate);
                        viewHolder.iv2.setTag(R.id.tag, 1);
                        viewHolder.iv1.setTag(R.id.tag, 1);
                        if (!doubleList.contains(hour + 0.5)) {
                            doubleList.add(hour + 0.5);
                        }
                        if (!doubleList.contains(hour + 0.0)) {
                            doubleList.add(hour + 0.0);
                        }
                    } else if (i1 < hour && i3 == hour) {
                        if (i4 == 30 && d1 == hour) {
                            viewHolder.iv1.setImageResource(R.drawable.order_graystate);
                            if (!doubleList.contains(hour + 0.0)) {
                                doubleList.add(hour + 0.0);
                            }

                            viewHolder.iv1.setTag(R.id.tag, 1);
                            if (tag2 != 1) {
                                viewHolder.iv2.setTag(R.id.tag, 3);
                            }
                        } else {
                            if (tag1 != 1) {
                                viewHolder.iv1.setTag(R.id.tag, 3);
                            }
                            if (tag2 != 1) {
                                viewHolder.iv2.setTag(R.id.tag, 3);
                            }
                        }

                    } else if (i1 == hour && i3 == hour) {

                        viewHolder.iv1.setImageResource(R.drawable.order_graystate);
                        if (!doubleList.contains(hour + 0.0)) {
                            doubleList.add(hour + 0.0);
                        }

                        viewHolder.iv1.setTag(R.id.tag, 1);
                        if (tag2 != 1) {
                            viewHolder.iv2.setTag(R.id.tag, 3);
                        }


                    } else {
                        if (tag1 != 1) {
                            viewHolder.iv1.setTag(R.id.tag, 3);
                        }
                        if (tag2 != 1) {
                            viewHolder.iv2.setTag(R.id.tag, 3);
                        }
                    }
                    Log.d("zp", "getView: " + i1 + "==" + i2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        } else {

        }

        return convertView;
    }
}