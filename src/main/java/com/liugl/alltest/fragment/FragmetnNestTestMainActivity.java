package com.liugl.alltest.fragment;


import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liugl.alltest.R;

/**
 * 主Activity
 *
 * @author wwj_748
 */
public class FragmetnNestTestMainActivity extends FragmentActivity implements OnClickListener {

    private String TAG = "FRAGMET";

    // 三个tab布局
    private RelativeLayout knowLayout, iWantKnowLayout, meLayout;

    // 底部标签切换的Fragment
    private Fragment knowFragment, iWantKnowFragment, meFragment,
            currentFragment;
    // 底部标签图片
    private ImageView knowImg, iWantKnowImg, meImg;
    // 底部标签的文本
    private TextView knowTv, iWantKnowTv, meTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_main);


        if (savedInstanceState != null)

        {
//	            String FRAGMENTS_TAG = "Android:support:fragments";
//	            savedInstanceState.remove(FRAGMENTS_TAG);

            ArrayList<Fragment> list = (ArrayList<Fragment>) getSupportFragmentManager().getFragments();
            for (int i = 0; i < list.size(); i++) {

//	      	  if (knowFragment == null && knowFragment instanceof ZhidaoFragment) {  
//				  knowFragment = (ZhidaoFragment)list.get(i);  
//				  
//		        }else if (iWantKnowFragment == null && iWantKnowFragment instanceof IWantKnowFragment) {  
//		        	iWantKnowFragment = (IWantKnowFragment)list.get(i);  
//		        }else if (meFragment == null && meFragment instanceof MeFragment) {  
//		        	meFragment = (MeFragment)list.get(i);  
//		        } 


                Log.e(TAG, "list.get(" + i + ") = " + list.get(i));
            }
            Log.e(TAG, "listsize = " + list.size() );
        }
//		 
//		 getSupportFragmentManager().getFragments();

        if (savedInstanceState != null) {
            knowFragment = getSupportFragmentManager().findFragmentByTag(ZhidaoFragment.class.getSimpleName());
            iWantKnowFragment = getSupportFragmentManager().findFragmentByTag(IWantKnowFragment.class.getSimpleName());
            meFragment = getSupportFragmentManager().findFragmentByTag(MeFragment.class.getSimpleName());
            currentFragment = knowFragment;
            // 解决重叠问题
            getSupportFragmentManager().beginTransaction()
                    .show(knowFragment)
                    .hide(iWantKnowFragment)
                    .hide(meFragment)
                    .commit();
        }


        initUI();
        initTab();
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        knowLayout = (RelativeLayout) findViewById(R.id.rl_know);
        iWantKnowLayout = (RelativeLayout) findViewById(R.id.rl_want_know);
        meLayout = (RelativeLayout) findViewById(R.id.rl_me);
        knowLayout.setOnClickListener(this);
        iWantKnowLayout.setOnClickListener(this);
        meLayout.setOnClickListener(this);

        knowImg = (ImageView) findViewById(R.id.iv_know);
        iWantKnowImg = (ImageView) findViewById(R.id.iv_i_want_know);
        meImg = (ImageView) findViewById(R.id.iv_me);
        knowTv = (TextView) findViewById(R.id.tv_know);
        iWantKnowTv = (TextView) findViewById(R.id.tv_i_want_know);
        meTv = (TextView) findViewById(R.id.tv_me);

    }


    /**
     * 初始化底部标签
     */
    private void initTab() {
        if (knowFragment == null) {
            knowFragment = ZhidaoFragment.getInstance();
        }

        if (!knowFragment.isAdded()) {
            // 提交事务
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_layout, knowFragment, ZhidaoFragment.class.getSimpleName()).commit();

            // 记录当前Fragment
            currentFragment = knowFragment;
            Log.e(TAG, "记录当前Fragment");
            // 设置图片文本的变化
            knowImg.setImageResource(R.drawable.btn_know_pre);
            knowTv.setTextColor(getResources()
                    .getColor(R.color.bottomtab_press));
            iWantKnowImg.setImageResource(R.drawable.btn_wantknow_nor);
            iWantKnowTv.setTextColor(getResources().getColor(
                    R.color.bottomtab_normal));
            meImg.setImageResource(R.drawable.btn_my_nor);
            meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_know: // 知道
                Log.e(TAG, "rl_know");
                clickTab1Layout();
                break;
            case R.id.rl_want_know: // 我想知道

                Log.e(TAG, "rl_want_know");
                clickTab2Layout();

                break;
            case R.id.rl_me: // 我的
                Log.e(TAG, "rl_me");
                clickTab3Layout();
                break;
            default:
                break;
        }
    }

    /**
     * 点击第一个tab
     */
    private void clickTab1Layout() {
        if (knowFragment == null) {
            Log.e(TAG, "knowFragment == null");
            knowFragment = ZhidaoFragment.getInstance();
        }


        addOrShowFragment(getSupportFragmentManager().beginTransaction(), knowFragment);

        // 设置底部tab变化
        knowImg.setImageResource(R.drawable.btn_know_pre);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_press));
        iWantKnowImg.setImageResource(R.drawable.btn_wantknow_nor);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.drawable.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
    }

    /**
     * 点击第二个tab
     */
    private void clickTab2Layout() {
        if (iWantKnowFragment == null) {
            Log.e(TAG, "iWantKnowFragment == null");
            iWantKnowFragment = IWantKnowFragment.getInstance();
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), iWantKnowFragment);

        knowImg.setImageResource(R.drawable.btn_know_nor);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        iWantKnowImg.setImageResource(R.drawable.btn_wantknow_pre);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_press));
        meImg.setImageResource(R.drawable.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

    }

    /**
     * 点击第三个tab
     */
    private void clickTab3Layout() {
        if (meFragment == null) {
            meFragment = MeFragment.getInstance();
            Log.e(TAG, "meFragment == null");
        }
        addOrShowFragment(getSupportFragmentManager().beginTransaction(), meFragment);
        knowImg.setImageResource(R.drawable.btn_know_nor);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        iWantKnowImg.setImageResource(R.drawable.btn_wantknow_nor);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.drawable.btn_my_pre);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_press));

    }

    /**
     * 添加或者显示碎片
     *
     * @param transaction
     * @param fragment
     */
    private void addOrShowFragment(FragmentTransaction transaction,
                                   Fragment fragment) {
        if (currentFragment == fragment) {
            Log.e(TAG, "currentFragment == fragment");
            return;
        }


        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
            Log.e(TAG, "!fragment.isAdded()");


            transaction.hide(currentFragment)
                    .add(R.id.content_layout, fragment, fragment.getClass().getSimpleName()).commit();

        } else {
            Log.e(TAG, "hide(currentFragment).show");
            transaction.hide(currentFragment).show(fragment).commit();
//			transaction. show(fragment).commit();
        }


        currentFragment = fragment;
        Log.e(TAG, "addOrShowFragment currentFragment = fragment");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null)

        {
            String FRAGMENTS_TAG = "Android:support:fragments";
            savedInstanceState.remove(FRAGMENTS_TAG);

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
        if (outState != null)

        {
            String FRAGMENTS_TAG = "Android:support:fragments";
            outState.remove(FRAGMENTS_TAG);

        }
    }

}
