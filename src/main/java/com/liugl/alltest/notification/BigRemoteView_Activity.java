package com.liugl.alltest.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BigRemoteView_Activity extends AppCompatActivity {
    @BindView(R.id.button5)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_remote_view_);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button5})
    public void onViewClick(View view){
        switch (view.getId()){

            case R.id.button5:



                break;

            default:
                break;
        }
    }


}
