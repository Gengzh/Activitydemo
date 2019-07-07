package com.example.gzh.activitymvp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gzh.activitymvp.eventbus.MessageEvent;
import com.example.gzh.activitymvp.ui.HomeFragment;
import com.example.gzh.activitymvp.ui.activity.NotificationActivity;
import com.example.gzh.activitymvp.ui.fragment.FindFragment;
import com.example.gzh.activitymvp.ui.fragment.MineFragment;
import com.example.gzh.activitymvp.ui.fragment.ProductFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;
    private TextView onefragment, twofragment, threefragment, fourfragment;

    private Fragment fragments[] = {new HomeFragment(), new FindFragment(), new ProductFragment(), new MineFragment()};

    private int currentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        defaultFragment();
        EventBus.getDefault().register(this);
    }

    private void init() {
        onefragment = findViewById(R.id.onefragment);
        twofragment = findViewById(R.id.twofragment);
        threefragment = findViewById(R.id.threefragment);
        fourfragment = findViewById(R.id.fourfragment);
        onefragment.setOnClickListener(this);
        twofragment.setOnClickListener(this);
        threefragment.setOnClickListener(this);
        fourfragment.setOnClickListener(this);
    }

    private void defaultFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_content, fragments[0]);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.onefragment:
                changeFragment(0);
                changeColor(0);
//                Toast.makeText(MainActivity.this,"点了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.twofragment:
                changeFragment(1);
                changeColor(1);
//                Toast.makeText(MainActivity.this,"点了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.threefragment:
                changeFragment(2);
                changeColor(2);
                break;
            case R.id.fourfragment:
                changeFragment(3);
                changeColor(3);
                break;
        }
    }

    /**
     * 点击tab切换fragment
     *
     * @param index
     */
    private void changeFragment(int index) {
        if (currentTab == index) {
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(fragments[currentTab]);
        if (!fragments[index].isAdded()) {
            ft.add(R.id.fragment_content, fragments[index]);
        }
        ft.show(fragments[index]);
        ft.commit();

        currentTab = index;

    }

    private void changeColor(int tab) {
        switch (tab) {
            case 0:
                onefragment.setTextColor(Color.parseColor("#D81B60"));
                twofragment.setTextColor(Color.parseColor("#000000"));
                threefragment.setTextColor(Color.parseColor("#000000"));
                fourfragment.setTextColor(Color.parseColor("#000000"));
                break;
            case 1:
                onefragment.setTextColor(Color.parseColor("#000000"));
                twofragment.setTextColor(Color.parseColor("#D81B60"));
                threefragment.setTextColor(Color.parseColor("#000000"));
                fourfragment.setTextColor(Color.parseColor("#000000"));
                break;
            case 2:
                onefragment.setTextColor(Color.parseColor("#000000"));
                twofragment.setTextColor(Color.parseColor("#000000"));
                threefragment.setTextColor(Color.parseColor("#D81B60"));
                fourfragment.setTextColor(Color.parseColor("#000000"));
                break;
            case 3:
                onefragment.setTextColor(Color.parseColor("#000000"));
                twofragment.setTextColor(Color.parseColor("#000000"));
                threefragment.setTextColor(Color.parseColor("#000000"));
                fourfragment.setTextColor(Color.parseColor("#D81B60"));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        Log.e("ondestroy----", "我退出了");
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            if (System.currentTimeMillis() - TOUCH_TIME > WAIT_TIME) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                TOUCH_TIME = System.currentTimeMillis();
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventmsg(MessageEvent messageEvent){
        if (messageEvent.getMessage().equals("back")){
            Toast.makeText(this,"收到",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,NotificationActivity.class));
        }

    }
}
