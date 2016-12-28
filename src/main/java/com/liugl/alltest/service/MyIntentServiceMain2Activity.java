package com.liugl.alltest.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyIntentServiceMain2Activity extends AppCompatActivity {

    @BindView(R.id.intentbutton6)
    Button intentbutton6;

    public static final String TAG = "LIGLSERVICE_INTENT";
    @BindView(R.id.stopServiceintentbutton6)
    Button stopServiceintentbutton6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent_service_main2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.stopServiceintentbutton6,R.id.intentbutton6})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.intentbutton6:
                Log.i(TAG, "----------onClick startService--------------");
                Log.i(TAG, "Main thread id is " + Thread.currentThread().getId());

                Intent intent1 = new Intent(this, MyIntentService.class);
                intent1.putExtra("msg", "intentService1");
                startService(intent1);

                Intent intent2 = new Intent(this, MyIntentService.class);
                intent2.putExtra("msg", "intentService2");
                startService(intent2);

                Intent intent3 = new Intent(this, MyIntentService.class);
                intent3.putExtra("msg", "intentService3");
                startService(intent3);
                break;
            case R.id.stopServiceintentbutton6:
                Intent intent = new Intent(MyIntentServiceMain2Activity.this, MyIntentService.class);
                Log.i(TAG, "----------onClick stopService-------------");
                stopService(intent);
                break;
        }
    }
}
