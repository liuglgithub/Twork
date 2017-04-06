package com.liugl.alltest.imgload;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;
import com.liugl.alltest.imgload.glide.GlideMain2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageLoaderMain2Activity extends BaseActivity {

    @BindView(R.id.glidebutton6)
    Button glidebutton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_main2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.glidebutton6})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.glidebutton6:
                Intent imgItent = new Intent(this, GlideMain2Activity.class);
                startActivity(imgItent);
                break;
        }
    }

}
