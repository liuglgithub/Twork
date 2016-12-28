package com.liugl.alltest.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 在前两节只是从初级阶段介绍了Service服务的使用原理，无论是使用startService()或者bindService()启动服务，Service服务的运行都是阶段性，
 * 当使用stopService()、unbindService()后，Service服务就会结束。然而从现实应用层面上看，Service 服务很多时候是长驻后台的，它会记录程序运行的流程，
 * 当今的状态等重要信息。此时，更多的使用方式就是结合startService()、bindService()两种方式调用Service服务，startService()负责管理Service服务的启动，
 * 输入初始化参数，bindService()负责定时对Service服务进行检测。而且流程是有规律性，以startService()启动服务后，
 * 每使用bindService()绑定服务，就通过serviceConnection对服务进行检测，然后以unbindService()结束绑定。
 * 注意，此时服务并未结束，而是长期运行于后台，直到系统以stopService()方法结束服务后，Service才会最终完结
 *
 *
 *
 */
public class ServiceComplexMain2Activity extends AppCompatActivity {

    @BindView(R.id.startsv)
    Button startsv;
    @BindView(R.id.stopsv)
    Button stopsv;
    @BindView(R.id.bindpsv)
    Button bindpsv;
    @BindView(R.id.unbindpsv)
    Button unbindpsv;

    public static final String TAG = "LIGLSERVICE_complex";
    MyServiceConnection  serviceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_complex_main2);
        ButterKnife.bind(this);
        serviceConnection = new MyServiceConnection();

    }

    @OnClick({R.id.startsv, R.id.stopsv, R.id.bindpsv, R.id.unbindpsv})
    public void onViewClick(View view) {

        switch (view.getId()) {
            case R.id.startsv:
                //通过Intent绑定MyService,加入输入参数
                Intent intent = new Intent(ServiceComplexMain2Activity.this, MyComplexService.class);
                intent.putExtra("Name", "Leslie");
                Log.i(TAG, "----------onClick startService-----------");
                //启动MyService
                startService(intent);
                break;
            case R.id.stopsv:
                Intent stopntent = new Intent(ServiceComplexMain2Activity.this, MyComplexService.class);
                Log.i(TAG, "----------onClick stopService------------");
                //停止MyService
                stopService(stopntent);
                break;
            case R.id.bindpsv:

                //绑定 MyService
                Intent bindserintent = new Intent(this, MyComplexService.class);

                Log.i(TAG, "----------onClick bindService-----------");
                //通过bindService（intent,serviceConnection,int）方式启动Service
                bindService(bindserintent, this.serviceConnection, Context.BIND_AUTO_CREATE);

                break;
            case R.id.unbindpsv:

                Log.i(TAG, "----------onClick unbindService----------");
                unbindService(this.serviceConnection);

                break;
        }

    }


    public class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(TAG, "Service Connected");
            //通过IBinder获取Service句柄
            MyComplexService.MyBinder myBinder = (MyComplexService.MyBinder) iBinder;
            MyComplexService myService = myBinder.getService();

            //生成随机数输入
            Random random = new Random();
            double value = myService.getValue(random.nextInt(10) * 1000);
            //显示计算结果
            Log.i(TAG, String.valueOf(value));
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(TAG, "Service Disconnected");
        }
    }


}
