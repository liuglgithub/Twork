package com.liugl.alltest.nestedscroll.coordinatorlayout.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.liugl.alltest.R;


public class EaseyBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easey_behavior);
        findViewById(R.id.btn_be).setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX()-v.getWidth()/2);
                        v.setY(event.getRawY()-v.getHeight()/2);
                        break;
                }
                return false;
            }
        });
    }
}
