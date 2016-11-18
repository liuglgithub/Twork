package com.liugl.alltest.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.liugl.alltest.R;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

public class PermissionMain2Activity extends  Activity {

    private static final String TAG = "perpp";
//    @BindView(R.id.phone_permission)
    Button ppBtn;

    private RxPermissions rxPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_main2);
        ppBtn = (Button) this.findViewById(R.id.phone_permission);
//        ButterKnife.bind(this);
        rxPermissions = RxPermissions.getInstance(this);
        requestPP();

//        ppBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i(TAG,"viewClick  ----1111");
//                requestPP();
//                Log.i(TAG,"viewClick");
//            }
//        });
    }

//    @OnClick({R.id.phone_permission})
//    public void viewClick(View view) {
//        switch (view.getId()) {
//            case R.id.phone_permission:
//                Log.i(TAG,"viewClick  ----1111");
//                requestPP();
//                Log.i(TAG,"viewClick");
//                break;
//        }
//    }

    private void requestPP() {
//           RxPermissions.getInstance(PermissionMain2Activity.this)
//                   .request(Manifest.permission.CALL_PHONE)
//                    .subscribe(new Observer<Boolean>() {
//                        @Override
//                        public void onCompleted() {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//
//                        }
//
//                        @Override
//                        public void onNext(Boolean aBoolean) {
//
//                        }
//                    })
//           ;


        RxView.clicks(ppBtn)
                // Ask for permissions when button is clicked
                .compose(rxPermissions.ensureEach(Manifest.permission.CALL_PHONE))
                .subscribe(new Action1<Permission>() {
                               @Override
                               public void call(Permission permission) {
                                   Log.i(TAG, "Permission result " + permission);
                                   if (permission.granted) {


                                       Intent intent = new Intent(Intent.ACTION_CALL);
                                       Uri data = Uri.parse("tel:" + "10010");
                                       intent.setData(data);
                                       if (ActivityCompat.checkSelfPermission(PermissionMain2Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                           // TODO: Consider calling
                                           //    ActivityCompat#requestPermissions
                                           // here to request the missing permissions, and then overriding
                                           //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           //                                          int[] grantResults)
                                           // to handle the case where the user grants the permission. See the documentation
                                           // for ActivityCompat#requestPermissions for more details.
                                           return;
                                       }
                                       startActivity(intent);

                                   } else if (permission.shouldShowRequestPermissionRationale) {
                                       // Denied permission without ask never again
                                       Toast.makeText(PermissionMain2Activity.this,
                                               "Denied permission without ask never again",
                                               Toast.LENGTH_SHORT).show();
                                   } else {
                                       // Denied permission with ask never again
                                       // Need to go to the settings
                                       Toast.makeText(PermissionMain2Activity.this,
                                               "Permission denied, can't enable the camera",
                                               Toast.LENGTH_SHORT).show();
                                   }
                               }
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable t) {
                                Log.e(TAG, "onError", t);
                            }
                        },
                        new Action0() {
                            @Override
                            public void call() {
                                Log.i(TAG, "OnComplete");
                            }
                        });

    }

}
