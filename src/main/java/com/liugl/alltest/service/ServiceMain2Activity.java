package com.liugl.alltest.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceMain2Activity extends AppCompatActivity {

    @BindView(R.id.localbutton6)
    Button localbutton6;
    @BindView(R.id.remotebutton6)
    Button remotebutton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.localbutton6,R.id.remotebutton6})
    public void onViewOncli(View view){
        switch (view.getId()){
            case R.id.localbutton6:
                Intent localIntent = new Intent(ServiceMain2Activity.this,LocalServiceMain2Activity.class);
                startActivity(localIntent);
                break;
            case R.id.remotebutton6:
                Intent remoteIntent = new Intent(ServiceMain2Activity.this,LocalServiceMain2Activity.class);
                startActivity(remoteIntent);
                break;
        }
    }

}
