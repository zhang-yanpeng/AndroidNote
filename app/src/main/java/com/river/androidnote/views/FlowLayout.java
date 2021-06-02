package com.river.androidnote.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 自定义流式布局
 */
public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        //先测量子view
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams chileParams = child.getLayoutParams();
            //测量子view 的宽度 高度
            int childMeasureWidth = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, chileParams.width);
            int childMeasureHeight = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, chileParams.height);
            child.measure(childMeasureWidth, childMeasureHeight);
        }


        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
