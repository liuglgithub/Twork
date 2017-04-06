package com.liugl.alltest.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;
import com.liugl.alltest.materialdesign.toolbar.ToolBarMDActivity;
import com.liugl.alltest.nestedscroll.NestedScrollHomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MDHOmeActivity extends BaseActivity {

    @BindView(R.id.tb)
    Button tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdhome);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tb})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.tb:

                Intent md = new Intent(this, ToolBarMDActivity.class);
                startActivity(md);

                break;
        }
    }

}
