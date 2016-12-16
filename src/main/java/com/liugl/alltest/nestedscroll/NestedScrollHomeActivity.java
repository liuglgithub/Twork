package com.liugl.alltest.nestedscroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;
import com.liugl.alltest.nestedscroll.coordinatorlayout.demo01.MyBehaviroTowTextviewActivity;
import com.liugl.alltest.nestedscroll.defapi.DefApiActivity;
import com.liugl.alltest.nestedscroll.nestedapi.NestedApiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NestedScrollHomeActivity extends AppCompatActivity {

    @BindView(R.id.def)
    Button defBtn;

    @BindView(R.id.nestedscrool)
    Button nestedBtn;

    @BindView(R.id.behavior_01)
    Button behavior_01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.behavior_01,R.id.def,R.id.nestedscrool})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.def:
                Intent qiantaohuadong = new Intent(this, DefApiActivity.class);
                startActivity(qiantaohuadong);
                break;
            case R.id.nestedscrool:
                Intent nestedscrool = new Intent(this, NestedApiActivity.class);
                startActivity(nestedscrool);
                break;
            case R.id.behavior_01:
                Intent behavior_01 = new Intent(this, MyBehaviroTowTextviewActivity.class);
                startActivity(behavior_01);
                break;
        }
    }
}
