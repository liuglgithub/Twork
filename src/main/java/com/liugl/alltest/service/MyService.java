package com.liugl.alltest.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by liugl on 2016/12/26.
 */

public class MyService extends Service {

    private MyBinder myBinder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(LocalServiceMain2Activity.TAG, "Service onBind");
        return this.myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(LocalServiceMain2Activity.TAG, "Service onUnbind");
        return super.onUnbind(intent);
    }

    /**
     * 一般用于对Service的运行条件作初始化处理，且在Service的生命周期内只会被触发一次
     */
    @Override
    public void onCreate() {
        Log.i(LocalServiceMain2Activity.TAG, "Service onCreate");
        super.onCreate();
        myBinder = new MyBinder();
    }

    @Override
    public void onDestroy() {
        Log.i(LocalServiceMain2Activity.TAG, "Service onDestroy");
        super.onDestroy();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(LocalServiceMain2Activity.TAG, "Service onStart");
        super.onStart(intent, startId);
    }

    /**
     * onstart 方法会在onStartCommand方法中被调用
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(LocalServiceMain2Activity.TAG, "Service onStartCommand");
        String name = intent.getStringExtra("Name");
        Log.i(LocalServiceMain2Activity.TAG, "His name is " + name);
        return super.onStartCommand(intent, flags, startId);
    }

    public String getDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().toString();
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}
