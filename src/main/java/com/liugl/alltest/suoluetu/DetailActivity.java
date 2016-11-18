package com.liugl.alltest.suoluetu;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static String tv1 = "tv1";
    public static String tv2 = "tv2";
    public static String tv3 = "tv3";


    @BindView(R.id.textView1)
    TextView title;

    @BindView(R.id.textView4)
    TextView textView2;

    @BindView(R.id.textView5)
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        ViewCompat.setTransitionName(title, tv1);
        ViewCompat.setTransitionName(textView2, tv2);
        ViewCompat.setTransitionName(textView3, tv3);
    }
}
