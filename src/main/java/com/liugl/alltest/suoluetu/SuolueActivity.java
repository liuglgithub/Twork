package com.liugl.alltest.suoluetu;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.liugl.alltest.R;
import com.liugl.alltest.fragment.FragmentMain2Activity;
import com.liugl.alltest.fragment.FragmetnNestTestMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuolueActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button startBtn;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.textView2)
    TextView textView2;

    @BindView(R.id.textView3)
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suolue);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button })
    public void btnClick(View view){
        switch (view.getId()){
            case R.id.button:
                toDetail();
                break;

        }

    }

    private void toDetail(){
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair(title, DetailActivity.tv1),
                new Pair(textView2, DetailActivity.tv2),
                new Pair(textView3, DetailActivity.tv3)
        );
        Intent intent = new Intent(this, DetailActivity.class);
//        intent.putExtra(DetailActivity.EXTRA_IMAGE_URL, imageUrl);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }

}
