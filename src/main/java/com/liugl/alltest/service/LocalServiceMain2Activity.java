package com.liugl.alltest.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LocalServiceMain2Activity extends AppCompatActivity {

    public static final String TAG = "LIGLSERVICE";

    @BindView(R.id.startservicebtn)
    Button startservicebtn;
    @BindView(R.id.bindser)
    Button bindser;
    @BindView(R.id.stopService)
    Button stopService;
    @BindView(R.id.unbindser)
    Button unbindser;

    private MyServiceConnection serviceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_service_main2);
        ButterKnife.bind(this);
        serviceConnection = new MyServiceConnection();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i=0;
//                while (true){
//
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//
//                Log.e(TAG,"i= " + ++ i);
//                }
//            }
//        }).start();


    }

    @OnClick({  R.id.unbindser, R.id.stopService, R.id.startservicebtn, R.id.bindser})
    public void onViewClick(View view) {

        switch (view.getId()) {
            case R.id.startservicebtn:
                //通过Intent绑定MyService,加入输入参数
                Intent intent = new Intent(LocalServiceMain2Activity.this, MyService.class);
                intent.putExtra("Name", "Leslie");
                Log.i(TAG, "----------onClick startService-----------");
                //启动MyService
                startService(intent);
                break;
            case R.id.stopService:
                Intent stopntent = new Intent(LocalServiceMain2Activity.this, MyService.class);
                Log.i(TAG, "----------onClick stopService------------");
                //停止MyService
                stopService(stopntent);
                break;
            case R.id.bindser:

                //绑定 MyService
                Intent bindserintent = new Intent(this, MyService.class);

                Log.i(TAG, "----------onClick bindService-----------");
                //通过bindService（intent,serviceConnection,int）方式启动Service
                bindService(bindserintent, this.serviceConnection, Context.BIND_AUTO_CREATE);

                break;
            case R.id.unbindser:

                Log.i(TAG, "----------onClick unbindService----------");
                unbindService(this.serviceConnection);

                break;
        }

    }

    public class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "Service Connected");
            String data = null;
            //通过IBinder获取Service句柄
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            MyService myService = myBinder.getService();
            data = myService.getDate();

            Log.i(TAG, data);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "Service Disconnected");
        }
    }
}
