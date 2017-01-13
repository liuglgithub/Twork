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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
    @BindView(R.id.huancunvarybutton7)
    Button huancunvarybutton7;
    @BindView(R.id.huancunvary1)
    ImageView huancunvary1;
    @BindView(R.id.huancunvary2)
    ImageView huancunvary2;
    @BindView(R.id.allhuancbutton7)
    Button allhuancbutton7;
    @BindView(R.id.allhuanc1)
    ImageView allhuanc1;
    @BindView(R.id.allhuanc2)
    ImageView allhuanc2;

    private String urlone = "http://img0.imgtn.bdimg.com/it/u=4029398727,3284915473&fm=23&gp=0.jpg";
    private String urltwo = "http://img2.imgtn.bdimg.com/it/u=3340669505,3200190439&fm=23&gp=0.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_main2);
        ButterKnife.bind(this);
    }

    @OnClick({  R.id.allhuancbutton7,R.id.huancunvarybutton7,R.id.roundbutton7, R.id.button7})
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
            case R.id.huancunvarybutton7:
                Glide.with(GlideMain2Activity.this)
                        .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .into(huancunvary1);
                Glide.with(GlideMain2Activity.this)
                        .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .into(huancunvary2);
                break;
            case R.id.allhuancbutton7:
                /**
                 * Glide既缓存全尺寸又缓存其他尺寸
                 */
                Glide.with(GlideMain2Activity.this)
                        .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)  //Glide既缓存全尺寸又缓存其他尺寸
                        .into(allhuanc1);
                Glide.with(GlideMain2Activity.this)
                        .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .into(allhuanc2);
                break;
        }
    }
}
