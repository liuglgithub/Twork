package com.liugl.alltest.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationCustomActivity extends BaseActivity {

    @BindView(R.id.moren)
    Button morenBnt;
    @BindView(R.id.custion_notification)
    Button customBtn;
    @BindView(R.id.shipei)
    Button shipeicustomBtn;



    @BindView(R.id.bigremoteview_smallremoteview)
    Button bigremoteview_smallremoteview;


    private final int NOTIFICATION_ID = 0xa01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bigremoteview_smallremoteview,R.id.moren,R.id.custion_notification,R.id.shipei})
    public void clickl(View view){

        switch (view.getId()){
            case R.id.moren:
                defaultNofiaction();
                break;
            case R.id.custion_notification:
                customLayoutNofication();
                break;
            case R.id.shipei:
//                customLayoutNofication();
                compatDevNotification();
                break;
            case R.id.bigremoteview_smallremoteview:
                bigRemoteview();
                break;
            default:
                break;
        }
    }


    private void bigRemoteview(){
        Intent mIntent = new Intent(this,BigRemoteView_Activity.class);
        startActivity(mIntent);
    }

    private void compatDevNotification(){
        Intent mIntent = new Intent(this,CompatCustomNotifiCationActivity.class);
        startActivity(mIntent);
    }

    private void defaultNofiaction(){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentText("这是内容");
        builder.setContentTitle("这是标题");
        builder.setSmallIcon(R.drawable.zhidao_logo);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);

        mNotificationManager.notify(100, builder.build());

    }

    private void customLayoutNofication(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.zhidao_logo);
        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.custom_notification_layout);
        builder.setContent(remoteViews);
        Intent mIntent = new Intent(NotificationCustomActivity.this,CustomNotifiCationDetailActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,mIntent,0);
        builder.setContentIntent(pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.huifu,pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101,builder.build());
    }

    private void shipeicustomLayoutNofication(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder.build();

    }

    private int getNotificationColor(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder.build();
        ViewGroup vg = (ViewGroup) notification.contentView.apply(this,new LinearLayout(this));
        TextView title = (TextView) vg.findViewById(android.R.id.title);
        return title.getCurrentTextColor();
    }

    private String DUMMY_TITLE = "DUMMY_TITLE";
    private int titleColor;

//    private int getNotificationColorInternal(Context context){
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        builder.setContentTitle(DUMMY_TITLE);
//        Notification notification = builder.build();
//        ViewGroup vg = (ViewGroup) notification.contentView.apply(this,new LinearLayout(this));
//        TextView title = (TextView) vg.findViewById(android.R.id.title);
//        if (title == null){
//
//        }
//
//    }

    private void iteratorVeiw (View view, Filter filter) {
        if (view == null || filter == null){
            return;
        }

        filter.filter(view);
        if (view instanceof ViewGroup){
            ViewGroup container = (ViewGroup) view;
            for (int i=0,j=container.getChildCount();i<j;i++){
                View child = container.getChildAt(i);
            }
        }
    }

    private interface Filter{
        void filter(View view);
    }



    private static final double COLOR_THRESHOLD = 180.0;
    /** 判断  颜色是近似*/
    public static boolean isColorSimilar(int baseColor,int color){

        int simpleBaseColor = baseColor | 0xff000000;
        int simpleColor = color | 0xff000000;
        int baseRed = Color.red(simpleBaseColor) - Color.red(simpleColor);
        int baseGreen = Color.green(simpleBaseColor) - Color.green(simpleColor);
        int blueBlue = Color.blue(simpleBaseColor) - Color.blue(simpleColor);
        double value = Math.sqrt(baseRed*baseRed + baseGreen*baseGreen +  blueBlue * blueBlue);
        if (value<COLOR_THRESHOLD){
            return true;
        }
        return false;
    }






}
