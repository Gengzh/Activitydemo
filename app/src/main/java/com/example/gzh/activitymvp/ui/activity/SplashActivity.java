package com.example.gzh.activitymvp.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gzh.activitymvp.MainActivity;
import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.eventbus.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this,NotificationActivity.class);
                intent.setType("splash");
                startActivity(intent);
//                EventBus.getDefault().post(new MessageEvent("back"));
                finish();
            }
        },3000);

    }
}
