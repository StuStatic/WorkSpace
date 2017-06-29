package com.ylg.workspace.workspace.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.moxun.tagcloudlib.view.TagsAdapter;
import com.ylg.workspace.workspace.R;

import java.util.List;

public class TagAdapter  extends TagsAdapter {

    private List<String> mStrings;


    public TagAdapter(List<String> strings) {
        mStrings = strings;
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
