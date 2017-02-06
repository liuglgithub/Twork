package com.liugl.alltest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.liugl.alltest.annotation.AnotationMain3Activity;
import com.liugl.alltest.chenjinshi.ChenJinShiStatusBarMain2Activity;
import com.liugl.alltest.fragment.FragmentMain2Activity;
import com.liugl.alltest.fragment.FragmetnNestTestMainActivity;
import com.liugl.alltest.guanggao.ADActivity;
import com.liugl.alltest.h5app.Main2Activity;
import com.liugl.alltest.https.HttpsMain2Activity;
import com.liugl.alltest.imgload.ImageLoaderMain2Activity;
import com.liugl.alltest.materialdesign.MDHOmeActivity;
import com.liugl.alltest.nestedscroll.NestedScrollHomeActivity;
import com.liugl.alltest.notification.NotificationCustomActivity;
import com.liugl.alltest.permission.PermissionRequestHomeActivity;
import com.liugl.alltest.rsa.RSAMain2Activity;
import com.liugl.alltest.service.ServiceMain2Activity;
import com.liugl.alltest.suoluetu.SuoleuMain3Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FragmentMain2Activity";
    private static final String TAG1 = "MainActivity";

    @BindView(R.id.fragment_bug)
    Button fragmentBtn;

    @BindView(R.id.fragment_qiantao)
    Button qiantaofragmentBtn;

    @BindView(R.id.suolue_pic)
    Button suolue_pic;

    @BindView(R.id.notification_test)
    Button notification_test;

    @BindView(R.id.permission)
    Button permission_test;

    @BindView(R.id.chenjinshi)
    Button chenjinshi;

    @BindView(R.id.qiantaohuadong)
    Button qiantaohuadong;

    @BindView(R.id.md)
    Button md;

    @BindView(R.id.rececyview_jiazai)
    Button rececyview_jiazai;
    @BindView(R.id.image_jiazai)
    Button imageJiazai;
    @BindView(R.id.baocunweizhi)
    Button baocunweizhi;
    @BindView(R.id.servicedetail)
    Button servicedetail;
    @BindView(R.id.https_test)
    Button httpsTest;
    @BindView(R.id.rsa_test)
    Button rsaTest;
    @BindView(R.id.imgload_test)
    Button imgloadTest;
    @BindView(R.id.h5_app)
    Button h5App;
    @BindView(R.id.ad_app)
    Button adApp;
    @BindView(R.id.annotation_app)
    Button annotationApp;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, TAG1 + "   onCreate");
        ButterKnife.bind(this);
    }

    @OnClick({R.id.annotation_app,R.id.ad_app, R.id.h5_app, R.id.imgload_test, R.id.rsa_test, R.id.https_test, R.id.servicedetail, R.id.md, R.id.qiantaohuadong, R.id.fragment_bug, R.id.fragment_qiantao,
            R.id.suolue_pic, R.id.notification_test, R.id.permission, R.id.chenjinshi})
    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_bug:
                Intent mIntent = new Intent(this, FragmentMain2Activity.class);
                startActivity(mIntent);
                break;
            case R.id.fragment_qiantao:
                Intent mqiantoaIntent = new Intent(this, FragmetnNestTestMainActivity.class);
                startActivity(mqiantoaIntent);
                break;
            case R.id.suolue_pic:
                Intent suolue_picIntent = new Intent(this, SuoleuMain3Activity.class);
                startActivity(suolue_picIntent);
                break;
            case R.id.notification_test:
                Intent notification_test_picIntent = new Intent(this, NotificationCustomActivity.class);
                startActivity(notification_test_picIntent);
                break;
            case R.id.permission:
                Intent permissionIntent = new Intent(this, PermissionRequestHomeActivity.class);
                startActivity(permissionIntent);
                break;
            case R.id.chenjinshi:
                Intent chenjinshi = new Intent(this, ChenJinShiStatusBarMain2Activity.class);
                startActivity(chenjinshi);
                break;
            case R.id.qiantaohuadong:
                Intent qiantaohuadong = new Intent(this, NestedScrollHomeActivity.class);
                startActivity(qiantaohuadong);
                break;
            case R.id.md:
                Intent md = new Intent(this, MDHOmeActivity.class);
                startActivity(md);
                break;
            case R.id.servicedetail:
                Intent servicedetail = new Intent(this, ServiceMain2Activity.class);
                startActivity(servicedetail);
                break;
            case R.id.https_test:
                Intent httpsItent = new Intent(this, HttpsMain2Activity.class);
                startActivity(httpsItent);
                break;
            case R.id.rsa_test:
                Intent rsaItent = new Intent(this, RSAMain2Activity.class);
                startActivity(rsaItent);
                break;
            case R.id.imgload_test:
                Intent imgItent = new Intent(this, ImageLoaderMain2Activity.class);
                startActivity(imgItent);
                break;
            case R.id.h5_app:
                Intent h5_appItent = new Intent(this, Main2Activity.class);
                startActivity(h5_appItent);
                break;
            case R.id.ad_app:
                Intent ad_appItent = new Intent(this, ADActivity.class);
                startActivity(ad_appItent);
                break;
            case R.id.annotation_app:
                Intent annotation_appItent = new Intent(this, AnotationMain3Activity.class);
                startActivity(annotation_appItent);
                break;
        }

    }


    @Override
    protected void onStart() {
        Log.e(TAG, TAG1 + "   onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, TAG1 + "   onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, TAG1 + "   onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, TAG1 + "   onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, TAG1 + "   onDestroy");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
