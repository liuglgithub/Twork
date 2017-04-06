package com.liugl.alltest.annotation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;
import com.liugl.alltest.annotation.defindbutterknife.DefindButterKinfeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnotationMain3Activity extends BaseActivity {

    @BindView(R.id.one_btn)
    Button oneBtn;
    @BindView(R.id.activity_anotation_main3)
    LinearLayout activityAnotationMain3;
    @BindView(R.id.bt_btn)
    Button btBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotation_main3);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_btn,R.id.one_btn})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.one_btn:
                Intent annotation_appItent = new Intent(AnotationMain3Activity.this, OneDefindeActivity.class);
                startActivity(annotation_appItent);
                break;
            case R.id.bt_btn:
                Intent bt_Itent = new Intent(AnotationMain3Activity.this, DefindButterKinfeActivity.class);
                startActivity(bt_Itent);
                break;
        }
    }

}
