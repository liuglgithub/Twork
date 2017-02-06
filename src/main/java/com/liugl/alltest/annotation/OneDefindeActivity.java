package com.liugl.alltest.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OneDefindeActivity extends AppCompatActivity {

    @BindView(R.id.cesetbutton6)
    Button cesetbutton6;
    @BindView(R.id.activity_one_definde)
    LinearLayout activityOneDefinde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_definde);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.cesetbutton6})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.cesetbutton6:
                CustomUtils.getInfo(Person.class);
                break;
        }
    }

}
