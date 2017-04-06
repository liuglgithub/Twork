package com.liugl.alltest.suoluetu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;
import com.liugl.alltest.suoluetu.wandoujia.WandoujiaMain3Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuoleuMain3Activity extends BaseActivity {

    @BindView(R.id.wandoujia)
    Button wandoujia;
    @BindView(R.id.animation_appcomat)
    Button animationAppcomat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suoleu_main3);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.wandoujia,R.id.animation_appcomat})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.wandoujia:
                Intent wandoujia_picIntent = new Intent(this, WandoujiaMain3Activity.class);
                startActivity(wandoujia_picIntent);
                break;
            case R.id.animation_appcomat:
                Intent suolue_picIntent = new Intent(this, SuolueActivity.class);
                startActivity(suolue_picIntent);
                break;
        }
    }

}
