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
     *
     * 由于手机的RAM、内部资源有限，所以很多Service都会因为资源不足而被Kill掉，这时候返回值就决定了Service被Kill后的处理方式，一般 int onStartCommand（intent,flags,startId）的返回值分为以下几种：

     START_STICKY
     如果service进程被kill掉，系统会尝试重新创建Service，如果在此期间没有任何启动命令被传递到Service，那么参数intent将为null。

     START_NOT_STICKY
     使用这个返回值时，如果在执行完onStartCommand()后，服务被异常kill掉，系统不会自动重启该服务。

     START_REDELIVER_INTENT
     使用这个返回值时，如果在执行完onStartCommand()后，服务被异常kill掉，系统会自动重启该服务，并将intent的值传入。

     START_STICKY_COMPATIBILITY
     START_STICKY的兼容版本，但不保证服务被kill后一定能重启。
     而输入参数flags正是代表此次onStartCommand()方法的启动方式，正常启动时，flags默认为0，被kill后重新启动，参数分为以下两种：

     START_FLAG_RETRY
     代表service被kill后重新启动，由于上次返回值为START_STICKY，所以参数 intent 为null

     START_FLAG_REDELIVERY
     代表service被kill后重新启动，由于上次返回值为START_REDELIVER_INTENT，所以带输入参数intent
     *
     *
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
