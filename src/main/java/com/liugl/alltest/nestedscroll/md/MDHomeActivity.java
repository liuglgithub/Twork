package com.liugl.alltest.nestedscroll.md;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.liugl.alltest.R;

import butterknife.ButterKnife;

public class MDHomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mdhome2);
        ButterKnife.bind(this);

    }
}
