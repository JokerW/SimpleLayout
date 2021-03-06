package com.example.xiufengwang.myapplication.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by xiufengwang on 2015/11/16.
 */
public class AutoHeightGridView extends GridView{


    public AutoHeightGridView(Context context) {
        super(context);
    }

    public AutoHeightGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoHeightGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
