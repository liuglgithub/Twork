package com.liugl.alltest.suoluetu.wandoujia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.liugl.alltest.R;
import com.liugl.alltest.suoluetu.wandoujia.adapter.MyAdapter;
import com.liugl.alltest.suoluetu.wandoujia.util.DisplayUtils;
import com.liugl.alltest.suoluetu.wandoujia.wegit.DividerItemDecoration;

public class WandoujiaMain3Activity extends AppCompatActivity {


    private MyAdapter mMyAdapter;
    private RecyclerView mRecyclerView;

    private Object[][] mImageTextArray = new Object[][] {{R.drawable.ic_aqy, "爱奇艺"}, {R.drawable.ic_bb, "哔哩哔哩"},
            {R.drawable.ic_cz, "赤足"}, {R.drawable.ic_kk, "快看"},
            {R.drawable.ic_kr, "kingRoot"}, {R.drawable.ic_sg, "搜狗"},
            {R.drawable.ic_xl, "迅雷"}, {R.drawable.ic_yk, "优酷"},
            {R.drawable.ic_yyy, "网易云音乐"}, {R.drawable.ic_qq, "QQ"}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wandoujia_main3);

        DisplayUtils.hideActionBar(getWindow());
        initView();
        fillData();


    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void fillData() {
        mMyAdapter = new MyAdapter(this, mImageTextArray);
        mRecyclerView.setAdapter(mMyAdapter);
        mMyAdapter.setOnItemClickLitener(new MyAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Object[] array = mImageTextArray[position];
                int viewMarginTop = view.getTop() + getResources().getDimensionPixelOffset(R.dimen.bar_view_height);
                Intent intent = new Intent(WandoujiaMain3Activity.this, DetailWanDouJiaActivity.class);
                intent.putExtra("viewMarginTop", viewMarginTop);
                intent.putExtra("imageId", (int) array[0]);
                intent.putExtra("appName", (String) array[1]);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }


}
