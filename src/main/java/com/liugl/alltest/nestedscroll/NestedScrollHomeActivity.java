package com.liugl.alltest.nestedscroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;
import com.liugl.alltest.nestedscroll.coordinatorlayout.demo01.MyBehaviroTowTextviewActivity;
import com.liugl.alltest.nestedscroll.coordinatorlayout.demo2.EaseyBehaviorActivity;
import com.liugl.alltest.nestedscroll.coordinatorlayout.uc.UCBehavieMain3Activity;
import com.liugl.alltest.nestedscroll.defapi.DefApiActivity;
import com.liugl.alltest.nestedscroll.nestedapi.NestedApiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NestedScrollHomeActivity extends BaseActivity {

    @BindView(R.id.def)
    Button defBtn;

    @BindView(R.id.nestedscrool)
    Button nestedBtn;

    @BindView(R.id.behavior_01)
    Button behavior_01;
    @BindView(R.id.btn_txt)
    Button btnTxt;
    @BindView(R.id.activity_nested_scroll_home)
    RelativeLayout activityNestedScrollHome;
    @BindView(R.id.ucbtn_txt)
    Button ucbtnTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ucbtn_txt,R.id.btn_txt, R.id.behavior_01, R.id.def, R.id.nestedscrool})
    public void onViewClick(View view) {
        switch (view.getId()) {
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
            case R.id.btn_txt:
                Intent behavior_btn = new Intent(this, EaseyBehaviorActivity.class);
                startActivity(behavior_btn);
                break;
            case R.id.ucbtn_txt:
                Intent uc = new Intent(this, UCBehavieMain3Activity.class);
                startActivity(uc);
                break;
        }
    }
}
