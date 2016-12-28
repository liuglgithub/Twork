package com.liugl.alltest.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.util.Log;

/**
 *
 * Created by liugl on 2016/12/27.
 *
 *
 *
 */

public class MyIntentService extends IntentService{

    public static final String TAG = "LIGLSERVICE_INTENT";

    public MyIntentService( ) {
        super(null);
    }

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String msg=intent.getStringExtra("msg");
        Log.i(TAG,msg+"'s thread id is "+Thread.currentThread().getId());
    }

}
