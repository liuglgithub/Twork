package com.liugl.alltest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by liugl on 2017/3/31.
 */

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger
                .init("lgltag")                 // default PRETTYLOGGER or use just init()
                              // default 2
                       // default shown
                   // default LogLevel.FULL
                              // default 0
               ; //default AndroidLogAdapter
         Logger.e(
                 "当前Activity---->" + this.getClass().getSimpleName()
         );
    }
}
