package com.example.xiufengwang.myapplication.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;

import com.example.xiufengwang.myapplication.R;

/**
 * Created by xiufengwang on 2015/11/11.
 */
public class ClearableEditText extends AppCompatEditText implements OnTouchListener, OnFocusChangeListener, TextWatcher {

    private Context mContext;
    private Drawable mDeleteIcon;
    private OnFocusChangeListener mFocusChangeListener;
    private OnTouchListener mToucheListener;

    public ClearableEditText(Context context) {
        super(context);
        init(context);
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ClearableEditText(Context context, AttributeSet attrs, int defStyleAttr, Context mContext) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public void setOnFocusChangeListener(OnFocusChangeListener listener) {
        this.mFocusChangeListener = listener;
    }

    public void setOnTouchListner(OnTouchListener listner) {
        this.mToucheListener = listner;
    }

    private void init(final Context context) {
        this.mContext = context;
        final Drawable drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher);
        final Drawable wrapDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(wrapDrawable, getCurrentHintTextColor());
        mDeleteIcon = wrapDrawable;
        mDeleteIcon.setBounds(0, 0, mDeleteIcon.getIntrinsicHeight(), mDeleteIcon.getIntrinsicHeight());
        setClearIconVisible(false);
        super.setOnFocusChangeListener(this);
        super.setOnTouchListener(this);
        addTextChangedListener(this);
    }


    private void setClearIconVisible(final boolean isVisible) {
        mDeleteIcon.setVisible(isVisible, false);
        final Drawable[] compundDrawables = getCompoundDrawables();
        setCompoundDrawables(compundDrawables[0], compundDrawables[1], isVisible ? mDeleteIcon : null, compundDrawables[3]);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
        if (mFocusChangeListener != null) {
            mFocusChangeListener.onFocusChange(v, hasFocus);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int x = (int) event.getX();
        if (mDeleteIcon.isVisible() && x > getWidth() - mDeleteIcon.getIntrinsicWidth() - getPaddingRight()) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                setError(null);
                setText("");
            }
            return true;
        }
        return mToucheListener != null && mToucheListener.onTouch(v, event);
    }


    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if (isFocused()) {
            setClearIconVisible(text.length() > 0);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
