package com.liugl.alltest.chenjinshi;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.liugl.alltest.R;

public class FirstStyleActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//            initState();
            initMuliteState();
            hindsystembar();
            setContentView(R.layout.activity_first_style);
        }


    /**
     * 处理4.4 -5.0以及5.0以上沉浸式状态栏
     */
    private void initState() {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

//            Window window = getWindow();
//            // Translucent status bar
//            window.setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }


   /**
         * 处理4.4 -5.0以及5.0以上沉浸式状态栏
         */
        private void initMuliteState() {
            if   (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上){
                View decorView = getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                //设置状态栏是否透明
//                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }else  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

//            Window window = getWindow();
//            // Translucent status bar
//            window.setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

                //透明状态栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                //透明导航栏
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        }

    private void hindsystembar(){
        /**
         * 可以控制布局是否延展到状态栏下面
         *  mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
         */
        View mDecorView = getWindow().getDecorView();
        mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
//        ActionBar actionBar=this.getSupportActionBar();
//        actionBar.hide();
    }

}
