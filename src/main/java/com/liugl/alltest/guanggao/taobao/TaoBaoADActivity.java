package com.liugl.alltest.guanggao.taobao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaoBaoADActivity extends AppCompatActivity {

    @BindView(R.id.vf)
    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_bao_ad);
        ButterKnife.bind(this);
        vf.addView(View.inflate(this, R.layout.view_advertisement01, null));
        vf.addView(View.inflate(this, R.layout.view_advertisement02, null));
        vf.addView(View.inflate(this, R.layout.view_advertisement03, null));
    }
}
