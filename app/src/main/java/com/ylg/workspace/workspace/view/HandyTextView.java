package com.ylg.workspace.workspace.view;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class HandyTextView extends TextView{

    public HandyTextView(Context context) {
        super(context);
    }

    public HandyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HandyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public void setText(CharSequence text, BufferType type) {
        if (text == null) {
            text = "";
        }
        super.setText(text, type);
    }

}
