package com.example.gzh.activitymvp.ui.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.gzh.activitymvp.MainActivity;
import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 通知栏
 */
public class NotificationActivity extends BaseActivity {

    @BindView(R.id.btn_notifi)
    Button btn_notifi;
    @BindView(R.id.btn_notifi2)
    Button btn_notifi2;
    @BindView(R.id.btn_notifi3)
    Button btn_notifi3;

    private RemoteViews remoteViews;

    @Override
    public void initView(Bundle bundle) {



    }

    @Override
    public int getContentView() {
        return R.layout.activity_notification;
    }

    @OnClick({R.id.btn_notifi, R.id.btn_notifi2, R.id.btn_notifi3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_notifi:
                showNotification();
                break;
            case R.id.btn_notifi2:
                show2();
                break;
            case R.id.btn_notifi3:
                break;
        }
    }

    private void showNotification() {
        Intent intent = new Intent(this, SettingActivity.class);

        PendingIntent mPendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)

                //设置小图标

                .setSmallIcon(R.mipmap.ic_launcher)

                //点击后自动清除

                .setAutoCancel(true)

                //设置通知标题

                .setContentTitle("最简单的通知")

                //设置通知内容

                .setContentText("真的很简单很简单很简单")

                //设置通知的动作

                .setContentIntent(mPendingIntent)

                //设置通知时间，默认为系统发出通知的时间

                .setWhen(System.currentTimeMillis());

        //第一个参数为Notification的id

        notificationManager.notify(2, builder.build());


    }

    private void show2() {
        Intent intent = new Intent(this, SettingActivity.class);

        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        remoteViews = new RemoteViews(getPackageName(), R.layout.layout_remote);
        remoteViews.setTextViewText(R.id.remote_title, "this is title");
        remoteViews.setOnClickPendingIntent(R.id.remote_content, pi);


        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //在 build()之前设置 .setFullScreenIntent()
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        Notification notify = builder.setSmallIcon(R.mipmap.ic_launcher_round)
        builder.setSmallIcon(R.mipmap.ic_launcher_round)
                .setPriority(Notification.PRIORITY_DEFAULT)  //通知的优先级
                .setCategory(Notification.CATEGORY_MESSAGE)  //通知的类型
//                .setContentTitle("通知")
                .setAutoCancel(true)
//                .setContentIntent(pi)
                .setContentText("Heads - Up Notification on Android 5.0")
                .setFullScreenIntent(pi, true)  //不设置此项不会悬挂,false 不会出现悬挂
                .setCustomContentView(remoteViews)
                .build();
        notificationManager.notify(3, builder.build());


    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
//            if (System.currentTimeMillis() - TOUCH_TIME > WAIT_TIME) {
//                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
//                TOUCH_TIME = System.currentTimeMillis();
//                return true;
//            } else {
//                finish();
//            }
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (getIntent().getType().equals("splash")){
                Log.e("tag",getIntent().getType());
                startActivity(new Intent(this,MainActivity.class));
//                finish();
                return false;
            }else
            {
                finish();
            }
        }
        return super.onKeyUp(keyCode, event);
    }
}
