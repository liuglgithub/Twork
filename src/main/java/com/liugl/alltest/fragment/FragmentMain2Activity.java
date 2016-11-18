package com.liugl.alltest.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentMain2Activity extends FragmentActivity {

    private static final String TAG = "FragmentMain2Activity";

    @BindView(R.id.content)
    ViewGroup vg;

    MyFragment mf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main2);
        Log.e(TAG,TAG + "   onCreate");
        ButterKnife.bind(this);
        initFragments();
    }

    private void initFragments(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mf = new MyFragment();

//        if (!mf.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
//            transaction.hide(mf)
//                    .add(R.id.content_layout, fragment).commit();
//        } else {
//            transaction.hide(currentFragment).show(fragment).commit();
//        }

        transaction.replace(R.id.content, mf);
        transaction.commitAllowingStateLoss();
    }

    @Override
    protected void onStart() {
        Log.e(TAG,TAG + "   onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG,TAG + "   onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG,TAG + "   onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG,TAG + "   onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG,TAG + "   onDestroy");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
