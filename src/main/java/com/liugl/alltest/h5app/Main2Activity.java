package com.liugl.alltest.h5app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;

/**
 * 在manifest.xml
 * 文件中，设置
 *         <intent-filter>
 <action android:name="android.intent.action.VIEW" />
 <category android:name="android.intent.category.DEFAULT" />
 <category android:name="android.intent.category.BROWSABLE" />
 <data
 android:host="host"
 android:scheme="scheme" />
 </intent-filter>

 host和scheme的值可以随便设置，但是不要与系统标识冲突

 在h5界面中使用
 “<a href="scheme://host/dhahahh”>启动我们的应用程序</a>”
调用原生应用

 */
public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        pathData();

    }

    /**
     *
     * 获取从网页传递的数据
     *
     */
    private void pathData(){
        Intent intent = getIntent();
        if (intent != null) {

            String data = intent.getDataString();

            if (data != null) {
                Toast.makeText(this, data, Toast.LENGTH_LONG).show();
            }
        }
    }
}
