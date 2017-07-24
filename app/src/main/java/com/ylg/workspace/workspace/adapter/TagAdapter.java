package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moxun.tagcloudlib.view.TagsAdapter;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.ballgraph.ExerciseActivity;
import com.ylg.workspace.workspace.activity.ballgraph.InfoActivity;
import com.ylg.workspace.workspace.activity.ballgraph.MeetRoomOrderActivity;
import com.ylg.workspace.workspace.activity.ballgraph.PlaceOrderActivity;
import com.ylg.workspace.workspace.activity.ballgraph.WorkplaceOrderActivity;
import com.ylg.workspace.workspace.activity.service.FeedbackActivity;
import com.ylg.workspace.workspace.activity.service.OrderVisitorActivity;
import com.ylg.workspace.workspace.activity.service.QuestionActivity;
import com.ylg.workspace.workspace.activity.service.RequirementActivity;

import java.util.List;

public class TagAdapter extends TagsAdapter {
    List<Integer> mImages;
    private List<String> mStrings;
    private Context context;
    ViewGroup group;

    public TagAdapter(Context context, List<String> strings, List<Integer> mImages) {
        mStrings = strings;
        this.context = context;
        this.mImages = mImages;
    }

    @Override
    public int getCount() {
        return mStrings.size();
    }

    @Override
    public View getView(final Context context, final int position, ViewGroup parent) {

        Drawable drawable = parent.getResources().getDrawable(mImages.get(position));
        drawable.setBounds(0, 0, 10, 10);
        TextView tv = new TextView(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(100, 100);
        tv.setLayoutParams(marginLayoutParams);
        tv.setText(mStrings.get(position));
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(10);
        tv.setGravity(Gravity.CENTER);
        tv.setBackground(drawable);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, mStrings.get(position), Toast.LENGTH_SHORT).show();
                switch (mImages.get(position)) {
                    case R.drawable.acitivity:
                        //跳转到活动 相应界面
                        Intent i_exer = new Intent(context, ExerciseActivity.class);
                        context.startActivity(i_exer);
                        break;
                    case R.drawable.consultation:
                        //跳转到资讯 相应界面
                        Intent i_info = new Intent(context, InfoActivity.class);
                        context.startActivity(i_info);
                        break;
                    case R.drawable.fixed_position:
                        //跳转到“订工位” 相应界面
                        Intent i_work = new Intent(context, WorkplaceOrderActivity.class);
                        context.startActivity(i_work);
                        break;
                    case R.drawable.conference_room:
                        //跳转到 “订会议室”相应界面
                        Intent i_meet = new Intent(context, MeetRoomOrderActivity.class);
                        context.startActivity(i_meet);
                        break;
                    case R.drawable.reservation_site:
                        //跳转到 “预定场地” 相应界面
                        Intent i_place = new Intent(context, PlaceOrderActivity.class);
                        context.startActivity(i_place);
                        break;
                    case R.drawable.visitor_reservation:
                        //跳转到 “访客预约（张鹏）”相应界面
                        Intent i_visit = new Intent(context, OrderVisitorActivity.class);
                        context.startActivity(i_visit);
                        break;
                    case R.drawable.feedback:
                        //跳转到“意见反馈（张鹏）”相应界面
                        Intent i_feedback = new Intent(context, FeedbackActivity.class);
                        context.startActivity(i_feedback);
                        break;
                    case R.drawable.open_door:
                        //跳转到“开门（张鹏）”相应界面
                        Intent i_captureActivity = new Intent(context, CaptureActivity.class);
                        context.startActivity(i_captureActivity);
                        break;
                    case R.drawable.one_button_repair:
                        //跳转到“问题报修（张鹏）”相应界面
                        Intent i_QuestionActivity = new Intent(context, QuestionActivity.class);
                        context.startActivity(i_QuestionActivity);
                        break;
                    case R.drawable.market1://集市
                        //跳转到“发布需求（张鹏）”相应界面
                        Intent i_RequirementActivity = new Intent(context, RequirementActivity.class);
                        context.startActivity(i_RequirementActivity);
                        break;
                    default:
                        break;

                }
            }
        });
        return tv;
    }

    @Override
    public Object getItem(int position) {
        return mStrings.get(position);
    }

    @Override
    public int getPopularity(int position) {
        return position % 5;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor) {
        ((TextView) view).setTextColor(themeColor);
    }
}
