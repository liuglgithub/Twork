package com.liugl.alltest.chenjinshi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChenJinShiStatusBarMain2Activity extends BaseActivity {

    @BindView(R.id.btn1)
    Button btn1;

    @BindView(R.id.celue)
    Button celue;

    @BindView(R.id.btn2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chen_jin_shi_status_bar_main2);
        ButterKnife.bind(this);
    }

    @OnClick({ R.id.btn2,R.id.celue,R.id.btn1})
    public void viewClick(View view) {

        switch (view.getId()){
            case R.id.btn1:
                Intent chenjinshi = new Intent(this, FirstStyleActivity.class);
                startActivity(chenjinshi);
                break;
            case R.id.btn2:
                Intent dierge = new Intent(this, SecondeStyleActivity.class);
                startActivity(dierge);
                break;

            case R.id.celue:
                Intent celue = new Intent(this, CelueMain2Activity.class);
                startActivity(celue);
                break;
        }

    }


}
