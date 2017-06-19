package com.liugl.alltest.activitylifececyle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.liugl.alltest.R;

public class LifeTwoActivity extends AppCompatActivity {
    public static String TAG = "lifecyel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_two);
        Log.e(TAG, "2=onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "2=onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "2=onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "2=onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "2=onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "2=onDestroy");
    }
}
