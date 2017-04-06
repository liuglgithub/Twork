package com.liugl.alltest.permission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 使用系统api申请权限
 */
public class PermissionRequestHomeActivity extends BaseActivity {

    @BindView(R.id.systemapipersion)
    public Button defaultbtn;

    @BindView(R.id.rxsystemapipersion)
    Button rxBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_permission_request);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.systemapipersion, R.id.rxsystemapipersion})
    public void onViewsClick(View view) {

        switch (view.getId()) {
            case R.id.systemapipersion:
                toSystemDefaultPermissionAPI();
                break;
            case R.id.rxsystemapipersion:
                Intent  permissionIntent = new Intent(this, PermissionMain2Activity.class);
                startActivity(permissionIntent);
                break;
        }
    }

    private void toSystemDefaultPermissionAPI(){
        Intent mIntent = new Intent(this,SystemDefaultAPIPerssionActivity.class);
        mIntent.putExtra("sd","d");
        startActivity(mIntent);
    }
}
