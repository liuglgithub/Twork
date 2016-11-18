package com.liugl.alltest.chenjinshi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CelueMain2Activity extends AppCompatActivity {
//    button2

    @BindView(R.id.button2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celue_main2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button2})
    public void onMViewClick(View view){

        switch (view.getId()){
            case R.id.button2:
                Intent celue = new Intent(this, Celue1Activity.class);
                startActivity(celue);
                break;
        }
    }

}
