package com.liugl.alltest.nestedscroll.nestedapi;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;

/**
 * Created by liugl on 2016/11/29.
 */

public class ChiledLayout extends LinearLayout implements NestedScrollingChild{

    private String Tag = "MyNestedScrollChild";
    private NestedScrollingChildHelper mScrollingChildHelper;
    private int mTouchSlop;
    private int mLastTouchY;
    private int mLastTouchX;
    private int showHeight;
    private final int[] mScrollOffset = new int[2];
    private final int[] mScrollConsumed = new int[2];



    public ChiledLayout(Context context) {
        super(context);
        init(context);
    }

    public ChiledLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ChiledLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ChiledLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }
    public void init(Context context) {
        final ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = configuration.getScaledTouchSlop();
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        Log.i(Tag, "setNestedScrollingEnabled:" + enabled);
        getScrollingChildHelper().setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        Log.i(Tag, "isNestedScrollingEnabled");
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {

        return getScrollingChildHelper().startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        Log.i(Tag, "stopNestedScroll");
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        Log.i(Tag, "hasNestedScrollingParent");
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed,
                                        int dyUnconsumed, int[] offsetInWindow) {
        Log.i(Tag, "dispatchNestedScroll:dxConsumed:" + dxConsumed + "," +
                "dyConsumed:" + dyConsumed + ",dxUnconsumed:" + dxUnconsumed + ",dyUnconsumed:" +
                dyUnconsumed + ",offsetInWindow:" + offsetInWindow);
        return getScrollingChildHelper().dispatchNestedScroll(dxConsumed, dyConsumed,
                dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        Log.i(Tag, "dispatchNestedPreScroll:dx" + dx + ",dy:" + dy + ",consumed:" + consumed + ",offsetInWindow:" + offsetInWindow);
        return getScrollingChildHelper().dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        Log.i(Tag, "dispatchNestedFling:velocityX:" + velocityX + ",velocityY:" + velocityY + ",consumed:" + consumed);
        return getScrollingChildHelper().dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        Log.i(Tag, "dispatchNestedPreFling:velocityX:" + velocityX + ",velocityY:" + velocityY);
        return getScrollingChildHelper().dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:

            {

                mLastTouchY = (int) (e.getRawY() + 0.5f);
                int nestedScrollAxis = ViewCompat.SCROLL_AXIS_NONE;

                nestedScrollAxis |= ViewCompat.SCROLL_AXIS_HORIZONTAL;
                startNestedScroll(nestedScrollAxis);
            }
            break;
            case MotionEvent.ACTION_MOVE: {
                Log.i("aaa", "Child--getRawY:" + e.getRawY());

                int x = (int) (e.getX() + 0.5f);
                int y = (int) (e.getRawY() + 0.5f);
                int dx = mLastTouchX - x;
                int dy = mLastTouchY - y;
                Log.i(Tag, "child:dy:" + dy + ",mLastTouchY:" + mLastTouchY + ",y;" + y);
                Log.i(Tag, "xxx");
                mLastTouchY = y;
                mLastTouchX = x;
                if (dispatchNestedPreScroll(dx, dy, mScrollConsumed, mScrollOffset)) {

                    dy -= mScrollConsumed[1];
                    if (dy == 0) {
                        return true;
                    }

                } else {
                    scrollBy(0, dy);
                }
            }


        }

        return true;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (mScrollingChildHelper == null) {
            mScrollingChildHelper = new NestedScrollingChildHelper(this);
            mScrollingChildHelper.setNestedScrollingEnabled(true);
        }
        return mScrollingChildHelper;
    }

    @Override
    public void scrollTo(int x, int y) {

        int sy = getScrollY();
        int mh = getMeasuredHeight();
        int MaxY = getMeasuredHeight() - showHeight;
        if (y > MaxY) {
            y = MaxY;
        }
        if (y < 0) {
            y = 0;
        }
        super.scrollTo(x, y);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (showHeight <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            showHeight = getMeasuredHeight();
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(1000000, MeasureSpec.UNSPECIFIED);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
//    private void init(Context mContext){
//        final ViewConfiguration configuration = ViewConfiguration.get(mContext);
//        mTouchSlop = configuration.getScaledTouchSlop();
//    }
//
//
//    @Override
//    public void setNestedScrollingEnabled(boolean enabled) {
//        Log.i(Tag, "setNestedScrollingEnabled:" + enabled);
//        getScrollingChildHelper().setNestedScrollingEnabled(enabled);
//    }
//
//    @Override
//    public boolean isNestedScrollingEnabled() {
//        Log.i(Tag, "isNestedScrollingEnabled");
//        return getScrollingChildHelper().isNestedScrollingEnabled();
//    }
//
//    @Override
//    public boolean startNestedScroll(int axes) {
//
//        return getScrollingChildHelper().startNestedScroll(axes);
//    }
//
//    @Override
//    public void stopNestedScroll() {
//        Log.i(Tag, "stopNestedScroll");
//        getScrollingChildHelper().stopNestedScroll();
//    }
//
//    @Override
//    public boolean hasNestedScrollingParent() {
//        Log.i(Tag, "hasNestedScrollingParent");
//        return getScrollingChildHelper().hasNestedScrollingParent();
//    }
//
//    @Override
//    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed,
//                                        int dyUnconsumed, int[] offsetInWindow) {
//        Log.i(Tag, "dispatchNestedScroll:dxConsumed:" + dxConsumed + "," +
//                "dyConsumed:" + dyConsumed + ",dxUnconsumed:" + dxUnconsumed + ",dyUnconsumed:" +
//                dyUnconsumed + ",offsetInWindow:" + offsetInWindow);
//        return getScrollingChildHelper().dispatchNestedScroll(dxConsumed, dyConsumed,
//                dxUnconsumed, dyUnconsumed, offsetInWindow);
//    }
//
//    @Override
//    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
//        Log.i(Tag, "dispatchNestedPreScroll:dx" + dx + ",dy:" + dy + ",consumed:" + consumed + ",offsetInWindow:" + offsetInWindow);
//        return getScrollingChildHelper().dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
//    }
//
//    @Override
//    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
//        Log.i(Tag, "dispatchNestedFling:velocityX:" + velocityX + ",velocityY:" + velocityY + ",consumed:" + consumed);
//        return getScrollingChildHelper().dispatchNestedFling(velocityX, velocityY, consumed);
//    }
//
//    @Override
//    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
//        Log.i(Tag, "dispatchNestedPreFling:velocityX:" + velocityX + ",velocityY:" + velocityY);
//        return getScrollingChildHelper().dispatchNestedPreFling(velocityX, velocityY);
//    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                mLastTouchY = (int) (event.getRawY() + 0.5f);
//                int nestedScrollAxis = ViewCompat.SCROLL_AXIS_NONE;
//
//                nestedScrollAxis |= ViewCompat.SCROLL_AXIS_HORIZONTAL;
//                startNestedScroll(nestedScrollAxis);
//                break;
//            case MotionEvent.ACTION_MOVE: {
//                Log.i("aaa", "Child--getRawY:" + event.getRawY());
//
//                int x = (int) (event.getX() + 0.5f);
//                int y = (int) (event.getRawY() + 0.5f);
//                int dx = mLastTouchX - x;
//                int dy = mLastTouchY - y;
//                Log.i(Tag, "child:dy:" + dy + ",mLastTouchY:" + mLastTouchY + ",y;" + y);
//                Log.i(Tag, "xxx");
//                mLastTouchY = y;
//                mLastTouchX = x;
//                if (dispatchNestedPreScroll(dx, dy, mScrollConsumed, mScrollOffset)) {
//
//                    dy -= mScrollConsumed[1];
//                    if (dy == 0) {
//                        return true;
//                    }
//
//                } else {
//                    scrollBy(0, dy);
//                }
//            }
//        }
//        return true;
//    }
//
//    private NestedScrollingChildHelper getScrollingChildHelper() {
//        if (mScrollingChildHelper == null) {
//            mScrollingChildHelper = new NestedScrollingChildHelper(this);
//            mScrollingChildHelper.setNestedScrollingEnabled(true);
//        }
//        return mScrollingChildHelper;
//    }
//    @Override
//    public void scrollTo(int x, int y) {
//
//        int sy = getScrollY();
//        int mh = getMeasuredHeight();
//        int MaxY = getMeasuredHeight() - showHeight;
//        if (y > MaxY) {
//            y = MaxY;
//        }
//        if (y < 0) {
//            y = 0;
//        }
//        super.scrollTo(x, y);
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        if (showHeight <= 0) {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//            showHeight = getMeasuredHeight();
//        }
//        heightMeasureSpec = MeasureSpec.makeMeasureSpec(1000000, MeasureSpec.UNSPECIFIED);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }
}
