package com.liugl.alltest.annotation.defindbutterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

public class DefindButterKinfeActivity extends AppCompatActivity {

    @ViewBinder(id = R.id.one_btn)
    public Button btn1;

    @ViewBinder(id = R.id.three_btn)
    public Button btntwo;

    @OnClick(id = R.id.three_btn)
    public void btnOnclick(){
        Log.i("lgl", "这是一个测试的例子/n 注解实现onclick方法");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defind_butter_kinfe);
        ViewBinderParser.inject(this,"");
        findViewById(R.id.two_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewBinderParser.inject(DefindButterKinfeActivity.this);

                Log.i("lgl_", btn1.getText() + " ####");
            }
        });

    }
}
