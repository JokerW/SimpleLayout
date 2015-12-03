package com.example.xiufengwang.myapplication.view.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.xiufengwang.myapplication.MyApplication;
import com.example.xiufengwang.myapplication.utils.LogUtils;

/**
 * Created by xiufengwang on 2015/11/19.
 */
public class TopPhotoShowLayout extends HorizontalScrollView {

    private static int mMaxHeight = MyApplication.getInstance().getScreenHeight() / 2;
    private static int mMinHeight = MyApplication.getInstance().getScreenHeight() / 4;
    private int mMiddleMinToMax = 0;
    /**
     * 当前展示的状态，如果为false表示目前的状态是小框子，如果为true则表示为大框
     */
    private boolean mLayoutStatus;
    private int target = 100;
    private int mViewHeight = MyApplication.getInstance().getScreenHeight() / 4;


    public TopPhotoShowLayout(Context context) {
        super(context);
    }

    public TopPhotoShowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TopPhotoShowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, mViewHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }

    private void init() {
//        mMaxHeight = 1200;
//        mMaxHeight = MyApplication.getInstance().getScreenHeight() / 2;
//        mMinHeight = 600;
//        mMinHeight = MyApplication.getInstance().getScreenHeight() / 4;
        mMiddleMinToMax = (mMaxHeight - mMinHeight) / 2;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    private float startX = 0;
    private float startY = 0;
    private float currentX = 0;
    private float currentY = 0;
    private float endX = 0;
    private float endY = 0;
    private float preX = 0;
    private float preY = 0;


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int targetY = 0;


        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
//                LogUtils.i("startX : " + startX + "==startY : " + startY);
                break;
            case MotionEvent.ACTION_MOVE:
                //只处理纵向扩大，不处理横向滑动（目前）
                currentX = ev.getX();
                currentY = ev.getY();

//                if ((Math.abs(currentY - startY)) > (Math.abs(currentX - startX))) {
                //当纵向移动的速率大于横向移动速率的时候，即为扩大或者缩小该界面高度
//                LogUtils.i("----currentY: " + currentY + "---startY: " + startY);
                if (mLayoutStatus) {
                    //当前为大框
                    if (currentY < startY) {
                        targetY = (int) (preY - currentY);
                        mViewHeight = mViewHeight - targetY > mMinHeight ? mViewHeight - targetY : mMinHeight;
//                        LogUtils.i("large");
                        layoutView();
                    }
                } else {
                    //当前为小框
                    if (currentY > startY) {
                        targetY = (int) (currentY - preY);
                        mViewHeight = mViewHeight + targetY < mMaxHeight ? mViewHeight + targetY : mMaxHeight;


//                        LogUtils.i("small");
                        layoutView();
                    }
                }
                preX = currentX;
                preY = currentY;
//                }
                break;
            case MotionEvent.ACTION_UP:
                //校验，并且做动画来扩大缩小。
                LogUtils.i("ACTION_UP");
                currentY = ev.getY();
                if (mLayoutStatus) {
                    if (startY - currentY > mMiddleMinToMax) {
                        LogUtils.i("ACTION_UP---true");
                        layoutAnim(mMinHeight);
                        mLayoutStatus = !mLayoutStatus;
                    }
                } else {

                    LogUtils.i("currentY : " + currentY + "--startY : " + startY + "---middle : " + mMiddleMinToMax);


                    if (currentY - startY > mMiddleMinToMax) {
                        LogUtils.i("ACTION_UP---false");
                        layoutAnim(mMaxHeight);
                        mLayoutStatus = !mLayoutStatus;
                    }
                }
                initMoveData();
                break;
        }

        return true;
//        return super.dispatchTouchEvent(ev);
    }


    private void initMoveData() {
        startX = 0;
        startY = 0;
        currentX = 0;
        currentY = 0;
        endX = 0;
        endY = 0;
        preX = 0;
        preY = 0;
    }


    private void layoutAnim(int targetY) {
        ObjectAnimator.ofInt(this, "height", targetY).setDuration(5000).start();
    }

    private void layoutView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
    }


}
