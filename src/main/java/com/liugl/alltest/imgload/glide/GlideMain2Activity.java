package com.liugl.alltest.imgload.glide;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideMain2Activity extends AppCompatActivity {

    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.oneimg)
    ImageView oneimg;
    @BindView(R.id.roundbutton7)
    Button roundbutton7;
    @BindView(R.id.roundoneimg)
    ImageView roundoneimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_main2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.roundbutton7, R.id.button7})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.button7:
                Glide.with(GlideMain2Activity.this)
                        .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .into(oneimg);
                break;
            case R.id.roundbutton7:
                Glide.with(GlideMain2Activity.this)
                        .load("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg")
                        .asBitmap()
                        .placeholder(R.mipmap.ic_launcher)
                        .centerCrop()
                        .into(new BitmapImageViewTarget(roundoneimg) {
                            @Override
                            protected void setResource(Bitmap resource) {
                                RoundedBitmapDrawable circularBitmapDrawable =
                                        RoundedBitmapDrawableFactory.create(GlideMain2Activity.this.getResources(), resource);
                                circularBitmapDrawable.setCircular(true);
                                roundoneimg.setImageDrawable(circularBitmapDrawable);
                            }
                        });
                break;

        }
    }
}
