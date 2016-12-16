package com.liugl.alltest.nestedscroll.defapi;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by KyoWang on 2016/06/03 .
 */
public class BottomScrollView extends ScrollView {

    private OnScrollToBottomListener mOnScrollToBottomListener;

    public BottomScrollView(Context context) {
        super(context);
    }

    public BottomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BottomScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt){
        super.onScrollChanged(l,t,oldl,oldt);
        // 滑动的距离加上本身的高度与子View的高度对比

        Log.e("scroll","t = " + t);
        Log.e("scroll","getHeight() = " + getHeight());
        Log.e("scroll","getChildAt(0).getMeasuredHeight() = " +getChildAt(0).getMeasuredHeight());

        if(t + getHeight() >=  getChildAt(0).getMeasuredHeight()){
            Log.e("nested","ScrollView滑动到底部");
            // ScrollView滑动到底部
            if(mOnScrollToBottomListener != null) {
                mOnScrollToBottomListener.onScrollToBottom();
            }
        } else {
            Log.e("nested","ScrollView尚未滑动到底部");
            if(mOnScrollToBottomListener != null) {
                mOnScrollToBottomListener.onNotScrollToBottom();
            }
        }

//        if(t  >=  getChildAt(0).getMeasuredHeight()){
//            Log.e("nested","ScrollView滑动到底部");
//            // ScrollView滑动到底部
//            if(mOnScrollToBottomListener != null) {
//                mOnScrollToBottomListener.onScrollToBottom();
//            }
//        } else {
//            Log.e("nested","ScrollView尚未滑动到底部");
//            if(mOnScrollToBottomListener != null) {
//                mOnScrollToBottomListener.onNotScrollToBottom();
//            }
//        }

    }

    public void setScrollToBottomListener(OnScrollToBottomListener listener) {
        this.mOnScrollToBottomListener = listener;
    }

    public interface OnScrollToBottomListener {
        void onScrollToBottom();
        void onNotScrollToBottom();
    }
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//
//        int height = 0;
//        View childView = getChildAt(0);
//        if (childView != null) {
//            childView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//            int h = childView.getHeight();
//            if (h > height) {
//                height = h;
//            }
//            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
//        }
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

}
