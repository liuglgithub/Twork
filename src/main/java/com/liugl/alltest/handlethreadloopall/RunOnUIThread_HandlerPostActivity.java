package com.liugl.alltest.handlethreadloopall;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liugl.alltest.R;

public class RunOnUIThread_HandlerPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_on_uithread__handler_post);


    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private void mHandlerPost() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private void runonuiThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(200);
//                            MyToast.showShort("拨打电话授权被拒!");


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }).start();
    }

}
