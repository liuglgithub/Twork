package com.liugl.alltest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by liugl on 2016/12/27.
 *

 */

public class MyComplexService extends Service {
    private MyBinder myBinder;
    private double param;
    public static final String TAG = "LIGLSERVICE_complex";

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(TAG, "Service onStart");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service onStartCommand");
        //获取Context.startService设置的param初始值
        this.param = intent.getDoubleExtra("param", 1.0);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG,"Service onRebind");
        super.onRebind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "Service onBind");
        return this.myBinder;
    }

    /**
     * onBind(),onUnbind()方法只会在第一次启动绑定时被调用，如果在多次绑定时需要有不同的处理方式又该如何，
     *  还好Android为大家预备了一个备用方法void onRebind(intent)，Service服务中 boolean onUnbind(intent)的默认返回值为false,
     *  只要将此方法的返回值修改为true,则系统在第二次调用Context.bindService()开始，就会激活Service.onRebind（intent）方法。
     *  在此对上面的方法作出少量修改，就会看到下面的处理结果。
     *
     *  此使用方法只适用 startService()、bindServcie()同时被调用的情况下，如果只调用其中一个方法，无论onUnbind()返回值为何值都无法触发onRebind()方法
     *
     *
     * @param intent
     * @return
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "Service onUnbind");
        return super.onUnbind(intent);
//        return true;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service onCreate");
        myBinder = new MyBinder();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service onDestroy");
        super.onDestroy();
    }

    //获取处理后的值
    public double getValue(int value) {
        return value * param;
    }

    public class MyBinder extends Binder {
        public MyComplexService getService() {
            return MyComplexService.this;
        }
    }
}
