package com.liugl.alltest.WindowManager;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.liugl.alltest.R;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.lang.reflect.Method;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

public class WindowManagerSystemActivity extends AppCompatActivity implements View.OnTouchListener {

    @BindView(R.id.wandowmanagebutton6)
    Button wandowmanagebutton6;
    @BindView(R.id.activity_window_manager_system)
    RelativeLayout activityWindowManagerSystem;


    private static final String TAG = "TestActivity";
    @BindView(R.id.toastn6)
    Button toastn6;
    @BindView(R.id.offoastn6)
    Button offoastn6;


    private ImageView mImageView;
    private WindowManager.LayoutParams mLayoutParams;
    private WindowManager mWindowManager;
    ExToast exToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_manager_system);
        ButterKnife.bind(this);
        initVeiws();
    }

    private void initVeiws() {
        mWindowManager = (WindowManager) WindowManagerSystemActivity.this.getSystemService(WindowManagerSystemActivity.this.WINDOW_SERVICE);
    }

    @OnClick({R.id.offoastn6,R.id.toastn6, R.id.wandowmanagebutton6})
    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.wandowmanagebutton6:
                dealWithSystem();
//                if (Build.VERSION.SDK_INT >= 23) {
//                    open();
//                }
                break;
            case R.id.toastn6:
                mToast();
                break;
            case R.id.offoastn6:
                //使用LENGTH_ALWAYS注意在合适的时候调用hide()
                exToast.hide();
                break;
        }
    }

    private void mToast() {
        exToast = ExToast.makeText(WindowManagerSystemActivity.this,"message",ExToast.LENGTH_ALWAYS);
        exToast.setAnimations(R.style.anim_view);
        exToast.show();
    }


    private void dealWithSystem() {

        //开启悬浮窗前先请求权限
        if ("Xiaomi".equals(Build.MANUFACTURER)) {//小米手机
            requestPermission();
        } else if ("Meizu".equals(Build.MANUFACTURER)) {//魅族手机
            requestPermission();
        } else {  //其他手机
            if (Build.VERSION.SDK_INT >= 23) {
                if (!Settings.canDrawOverlays(this)) {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    startActivityForResult(intent, 12);
                } else {
                    show();
                }
            } else {
                show();
            }
        }

    }

    /**
     * 请求用户给予悬浮窗的权限
     */
    public void requestPermission() {
        if (isFloatWindowOpAllowed(this)) {//已经开启
            show();
        } else {
            openSetting();
        }
    }

    /**
     * 打开权限设置界面
     */
    public void openSetting() {
        try {
            Intent localIntent = new Intent(
                    "miui.intent.action.APP_PERM_EDITOR");
            localIntent.setClassName("com.miui.securitycenter",
                    "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            localIntent.putExtra("extra_pkgname", getPackageName());
            startActivityForResult(localIntent, 11);
//            LogUtil.E("启动小米悬浮窗设置界面");
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            Intent intent1 = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent1.setData(uri);
            startActivityForResult(intent1, 11);
//            LogUtil.E("启动悬浮窗界面");
        }

    }

    private void requeper() {
        RxPermissions.getInstance(this)
//                .request(Manifest.permission.SYSTEM_ALERT_WINDOW)
                .request(Manifest.permission.CAMERA)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean granted) {
                        if (granted) {
                            mImageView = new ImageView(WindowManagerSystemActivity.this);
                            mImageView.setBackgroundResource(R.drawable.ic_launcher);
                            mLayoutParams = new WindowManager.LayoutParams(
                                    WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0,
                                    PixelFormat.TRANSPARENT);
//                            mLayoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_TOAST);
                            mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                                    | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
//                            WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
                            mLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
                            mLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
                            mLayoutParams.x = 100;
                            mLayoutParams.y = 300;
                            mImageView.setOnTouchListener(WindowManagerSystemActivity.this);
                            mWindowManager.addView(mImageView, mLayoutParams);
                        }
                    }
                });

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void open() {
        if (!Settings.canDrawOverlays(WindowManagerSystemActivity.this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            startActivityForResult(intent, 12);
        } else {
            show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) {
            if (isFloatWindowOpAllowed(this)) {//已经开启
//                switchActivity();
                show();
            } else {
//                ToastUtil.show(this, "开启悬浮窗失败");
            }
        } else if (requestCode == 12) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (!Settings.canDrawOverlays(WindowManagerSystemActivity.this)) {
//                    Toast.show(this, "权限授予失败,无法开启悬浮窗");
                } else {
                    show();
                }
            }
        }
    }

    /**
     * 判断悬浮窗权限
     *
     * @param context
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean isFloatWindowOpAllowed(Context context) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            return checkOp(context, 24);  // AppOpsManager.OP_SYSTEM_ALERT_WINDOW
        } else {
            if ((context.getApplicationInfo().flags & 1 << 27) == 1 << 27) {
                return true;
            } else {
                return false;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean checkOp(Context context, int op) {
        final int version = Build.VERSION.SDK_INT;

        if (version >= 19) {
            AppOpsManager manager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
            try {
                Class<?> spClazz = Class.forName(manager.getClass().getName());
                Method method = manager.getClass().getDeclaredMethod("checkOp", int.class, int.class, String.class);
                int property = (Integer) method.invoke(manager, op,
                        Binder.getCallingUid(), context.getPackageName());
                Log.e("399", " property: " + property);

                if (AppOpsManager.MODE_ALLOWED == property) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.e("399", "Below API 19 cannot invoke!");
        }
        return false;
    }


    private void show() {

        mImageView = new ImageView(WindowManagerSystemActivity.this);
        mImageView.setBackgroundResource(R.drawable.ic_launcher);
        mLayoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0,
                PixelFormat.TRANSPARENT);
//                            mLayoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_TOAST);
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
//        mLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
//        mLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        mLayoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        mLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
        mLayoutParams.x = 100;
        mLayoutParams.y = 300;
        mImageView.setOnTouchListener(WindowManagerSystemActivity.this);
        mWindowManager.addView(mImageView, mLayoutParams);
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                Log.d(TAG, "onTouch: rawX " + rawX);
                Log.d(TAG, "onTouch: rawY " + rawY);
                mLayoutParams.x = rawX;
                mLayoutParams.y = rawY;
                mWindowManager.updateViewLayout(mImageView, mLayoutParams);
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        try {
            mWindowManager.removeView(mImageView);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

}
