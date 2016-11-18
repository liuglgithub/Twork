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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.liugl.alltest.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CompatCustomNotifiCationActivity extends AppCompatActivity {

    @BindView(R.id.button4)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compat_custom_notifi_cation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button4})
    public void click(View view){
        switch (view.getId()){
            case R.id.button4:
                sendCustomNotification();
                break;
        }
    }

    private void sendCustomNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.zhidao_logo);
        RemoteViews remoteViews;

        if (isDarkNotificationBar()){
            remoteViews = new RemoteViews(getPackageName(),R.layout.dark_notification_layout);
        }else{
            remoteViews = new RemoteViews(getPackageName(),R.layout.white_notification_layout);
        }
        builder.setContent(remoteViews);
        Intent mIntent = new Intent( this,CustomNotifiCationDetailActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,mIntent,0);
        builder.setContentIntent(pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.huifu,pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(102,builder.build());
    }

    private boolean isDarkNotificationBar(){
        return  !isColorSimilar(Color.BLACK,getNotificationColor(this));
    }

    private int getNotificationColor(Context context){
        if (context instanceof  AppCompatActivity){
            return getNotificationColorCompat(context);
        }else{
            return getNotificationColorInternal(context);
        }
    }

    private int getNotificationColorCompat(Context mContext) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder.build();
        int layoutId = notification.contentView.getLayoutId();

        ViewGroup notificationRoot = (ViewGroup) LayoutInflater.from(mContext).inflate(layoutId, null);
        TextView title = (TextView) notificationRoot.findViewById(android.R.id.title);

        if (title == null) {

            final ArrayList<TextView> textViews = new ArrayList<TextView>();
            iteratorVeiw(notificationRoot, new Filter() {
                @Override
                public void filter(View view) {
                    if (view instanceof TextView) {
                        textViews.add((TextView) view);
                    }
                }
            });

            float mixTextSize = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0, j = textViews.size(); i < j; i++) {
                float currentSize = textViews.get(i).getTextSize();
                if (currentSize > mixTextSize) {
                    mixTextSize = currentSize;
                    index = i;
                }
            }
            return textViews.get(index).getCurrentTextColor();

        } else {
            return title.getCurrentTextColor();
        }
    }


    private String DUMMY_TITLE = "DUMMY_TITLE";
    private int titleColor;

    /**
     * 获取当前类为非AppCompatActivity的状态栏颜色
     *
     * @param context
     * @return
     */
    private int getNotificationColorInternal(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(DUMMY_TITLE);
        Notification notification = builder.build();
        ViewGroup notificationRoot = (ViewGroup) notification.contentView.apply(this, new FrameLayout(this));
        TextView title = (TextView) notificationRoot.findViewById(android.R.id.title);
        //如果ROM厂商修改了默认的title的id。则找到text为"DUMMY_TITLE"的textivew并获取颜色
        if (title == null) {

            iteratorVeiw(notificationRoot, new Filter() {
                @Override
                public void filter(View view) {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        if (DUMMY_TITLE.equalsIgnoreCase(textView.getText().toString().trim())) {
                            titleColor = textView.getCurrentTextColor();
                        }
                    }
                }
            });
            return titleColor;
        } else {
            return title.getCurrentTextColor();
        }
    }

    private void iteratorVeiw(View view, Filter filter) {
        if (view == null || filter == null) {
            return;
        }

        filter.filter(view);
        if (view instanceof ViewGroup) {
            ViewGroup container = (ViewGroup) view;
            for (int i = 0, j = container.getChildCount(); i < j; i++) {
                View child = container.getChildAt(i);
            }
        }
    }

    private interface Filter {
        void filter(View view);
    }


    private static final double COLOR_THRESHOLD = 180.0;

    /**
     * 判断  颜色是近似
     */
    public static boolean isColorSimilar(int baseColor, int color) {

        int simpleBaseColor = baseColor | 0xff000000;
        int simpleColor = color | 0xff000000;
        int baseRed = Color.red(simpleBaseColor) - Color.red(simpleColor);
        int baseGreen = Color.green(simpleBaseColor) - Color.green(simpleColor);
        int blueBlue = Color.blue(simpleBaseColor) - Color.blue(simpleColor);
        double value = Math.sqrt(baseRed * baseRed + baseGreen * baseGreen + blueBlue * blueBlue);
        if (value < COLOR_THRESHOLD) {
            return true;
        }
        return false;
    }


    private void customLayoutNofication() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.zhidao_logo);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification_layout);
        builder.setContent(remoteViews);
        Intent mIntent = new Intent(CompatCustomNotifiCationActivity.this, CustomNotifiCationDetailActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.huifu, pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101, builder.build());
    }

    private void shipeicustomLayoutNofication() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder.build();

    }

    private int getNotificationColor() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder.build();
        ViewGroup vg = (ViewGroup) notification.contentView.apply(this, new LinearLayout(this));
        TextView title = (TextView) vg.findViewById(android.R.id.title);
        return title.getCurrentTextColor();
    }

}
