package com.liugl.alltest.guanggao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;
import com.liugl.alltest.guanggao.paomadeng.PaoMaDengActivity;
import com.liugl.alltest.guanggao.taobao.TaoBaoADActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ADActivity extends BaseActivity {

    @BindView(R.id.taobao_tn)
    Button taobaoTn;
    @BindView(R.id.paomadeng_btn)
    Button paomadengBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.taobao_tn, R.id.paomadeng_btn,})
    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.paomadeng_btn:
                Intent paoma_appItent = new Intent(this, PaoMaDengActivity.class);
                startActivity(paoma_appItent);
                break;
            case R.id.taobao_tn:
                Intent ad_appItent = new Intent(this, TaoBaoADActivity.class);
                startActivity(ad_appItent);
                break;
        }
    }
}
