package com.liugl.alltest.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.liugl.alltest.R;
import com.liugl.alltest.view.datapick.DatePickActivity;
import com.liugl.alltest.view.viewpagernetsgridview.ViewPagerNestGridViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UIMain3Activity extends AppCompatActivity {

    @BindView(R.id.datapic)
    Button datapic;
    @BindView(R.id.activity_uimain3)
    RelativeLayout activityUimain3;
    @BindView(R.id.vpgridview)
    Button vpgridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uimain3);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.vpgridview,R.id.datapic})
    public void onBtnClick(View view) {

        switch (view.getId()) {
            case R.id.datapic:
                Intent datapickItent = new Intent(this, DatePickActivity.class);
                startActivity(datapickItent);
                break;
            case R.id.vpgridview:
                Intent vpIntent = new Intent(this, ViewPagerNestGridViewActivity.class);
                startActivity(vpIntent);
                break;
        }

    }

}
