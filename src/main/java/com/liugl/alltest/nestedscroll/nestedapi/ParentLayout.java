package com.liugl.alltest.nestedscroll.nestedapi;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by liugl on 2016/11/29.
 */

public class ParentLayout extends LinearLayout implements NestedScrollingParent{

    private String Tag = "MyNestedScrollParent";
    private ImageView img ;
    private TextView tv;
    private NestedScrollingParentHelper mParentHelper;
    private ChiledLayout nsc;
    private int imgHeight;
    private int tvHeight;


    public ParentLayout(Context context) {
        super(context);
        init();
    }

    public ParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ParentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ParentLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        mParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        img = (ImageView) getChildAt(0);
        tv = (TextView) getChildAt(1);
        nsc = (ChiledLayout) getChildAt(2);
        img.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(imgHeight<=0){
                    imgHeight =  img.getMeasuredHeight();
                    Log.i(Tag,"imgHeight:"+imgHeight+",tvHeight:"+tvHeight);
                }
            }
        });
        tv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(tvHeight<=0){
                    tvHeight =  tv.getMeasuredHeight();
                    Log.i(Tag,"imgHeight:"+imgHeight+",tvHeight:"+tvHeight);
                }
            }
        });

    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        Log.i(Tag,"onStartNestedScroll--"+"child:"+child+",target:"+target+",nestedScrollAxes:"+nestedScrollAxes);
        return true;
    }
    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        Log.i(Tag,"onNestedScrollAccepted"+"child:"+child+",target:"+target+",nestedScrollAxes:"+nestedScrollAxes);
        mParentHelper.onNestedScrollAccepted(child, target, nestedScrollAxes);
    }

    @Override
    public void onStopNestedScroll(View target) {
        Log.i(Tag,"onStopNestedScroll--target:"+target);
        mParentHelper.onStopNestedScroll(target);
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.i(Tag,"onNestedScroll--"+"target:"+target+",dxConsumed"+dxConsumed+",dyConsumed:"+dyConsumed
                +",dxUnconsumed:"+dxUnconsumed+",dyUnconsumed:"+dyUnconsumed);
    }
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {

        if(showImg(dy)||hideImg(dy)){//如果父亲自己要滑动，则拦截  //
            //showImg(dy)此处表示，如果向上滑动的时候，如果图片还能显示出来的时候，则父类处理滑动，
            //hideImg(dy)此处表示，如果向下滑动的时候，图片还没有完全显示出来的时候，则父类处理滑动
            consumed[1]=dy;  // 表示父布局完全消费滑动
            scrollBy(0,dy);
            Log.i("onNestedPreScroll","Parent滑动："+dy);
        }
        Log.i(Tag,"onNestedPreScroll--getScrollY():"+getScrollY()+",dx:"+dx+",dy:"+dy+",consumed:"+consumed);

    }


    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        Log.i(Tag,"onNestedFling--target:"+target);
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        Log.i(Tag,"onNestedPreFling--target:"+target);
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        Log.i(Tag,"getNestedScrollAxes");
        return 0;
    }

    @Override
    public void scrollTo(int x, int y) {
        if(y<0){
            y=0;
        }
        if(y>imgHeight){
            y=imgHeight;
        }

        super.scrollTo(x, y);
    }

    /**
     下拉的时候是否要向下滑动显示图片
     */
    public boolean showImg(int dy){
        if(dy<0){
            if(getScrollY()>0&&nsc.getScrollY()==0){//如果parent外框，还可以往上滑动
                return true;
            }
        }
        return false;
    }

    /**
     * 上拉的时候，是否要向上滑动，隐藏图片
     * @return
     */
    public boolean hideImg(int dy){
        if(dy>0){
            if(getScrollY()<imgHeight){//如果parent外框，还可以往下滑动
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("aaa","getY():getRawY:"+event.getRawY());
        return super.dispatchTouchEvent(event);
    }
}
