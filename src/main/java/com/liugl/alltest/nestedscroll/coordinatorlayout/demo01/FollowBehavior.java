package com.liugl.alltest.nestedscroll.coordinatorlayout.demo01;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.liugl.alltest.R;

/**
 * Created by liugl on 2016/11/30.
 */

public class FollowBehavior extends CoordinatorLayout.Behavior{

    private int targetId;

   public FollowBehavior(Context context, AttributeSet attrs){
       super(context,attrs);
       TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Follow);
       for (int i = 0; i < a.getIndexCount(); i++) {
           int attr = a.getIndex(i);
           if(a.getIndex(i) == R.styleable.Follow_target){
               targetId = a.getResourceId(attr, -1);
           }
       }
       a.recycle();
   }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setY(dependency.getY()+dependency.getHeight());
        return true;
    }

    /**
     * 生成Behavior后第一件事就是确定依赖关系。重写Behavior的这个方法来确定你依赖哪些View。
     * child 是指应用behavior的View ，dependency 担任触发behavior的角色，并与child进行互动。
     确定你是否依赖于这个View。CoordinatorLayout会将自己所有View遍历判断。
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency.getId() == targetId ;
//        return dependency.getId() == R.id.first ;
    }




}
