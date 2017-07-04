package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.moxun.tagcloudlib.view.TagsAdapter;
import com.ylg.workspace.workspace.Application.App;
import com.ylg.workspace.workspace.R;
import com.ylg.workspace.workspace.activity.ballgraph.ExerciseActivity;
import com.ylg.workspace.workspace.activity.ballgraph.InfoActivity;
import com.ylg.workspace.workspace.activity.ballgraph.WorkplaceOrderActivity;

import java.util.List;

public class TagAdapter  extends TagsAdapter {

    private List<String> mStrings;
    private Context context;

    public TagAdapter(Context context ,List<String> strings) {
        mStrings = strings;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mStrings.size();
    }

    @Override
    public View getView(final Context context, final int position, ViewGroup parent) {

        Drawable drawable = parent.getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0,0,150,150);

        TextView tv = new TextView(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(200, 200);
        tv.setLayoutParams(marginLayoutParams);
        tv.setText(mStrings.get(position));
        tv.setTextSize(16);
        tv.setGravity(Gravity.CENTER);
//        tv.setCompoundDrawables(null,drawable,null,null);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mStrings.get(position), Toast.LENGTH_SHORT).show();
                switch (mStrings.get(position)){
                    case "活动":
                        //跳转到活动 相应界面
                        Intent i_exer = new Intent(context, ExerciseActivity.class);
                        context.startActivity(i_exer);
                        break;
                    case "资讯":
                        //跳转到资讯 相应界面
                        Intent i_info = new Intent(context,InfoActivity.class);
                        context.startActivity(i_info);
                        break;
                    case "订工位":
                        //跳转到“订工位” 相应界面
                        Intent i_work = new Intent(context, WorkplaceOrderActivity.class);
                        context.startActivity(i_work);
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
        ((TextView)view).setTextColor(themeColor);
    }
}
