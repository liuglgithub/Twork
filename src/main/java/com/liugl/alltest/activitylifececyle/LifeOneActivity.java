package com.liugl.alltest.activitylifececyle;

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

public class LifeOneActivity extends AppCompatActivity {

    public static String TAG = "lifecyel";
    @BindView(R.id.jumpbtn)
    Button jumpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_one);
        ButterKnife.bind(this);

        Log.e(TAG, "1=onCreate");
    }


    @OnClick({R.id.jumpbtn})
    void submit(View view) {

        switch (view.getId()) {
            case R.id.jumpbtn:
                Intent lifececyl_appItent = new Intent(this, LifeTwoActivity.class);
                startActivity(lifececyl_appItent);
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "1=onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "1=onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "1=onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "1=onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "1=onDestroy");
    }
}
