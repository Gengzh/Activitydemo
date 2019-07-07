package com.example.gzh.activitymvp.ui.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimActivity extends BaseActivity {

    @BindView(R.id.animtv)
    TextView animtv;
    @BindView(R.id.start1)
    Button start1;
    @BindView(R.id.animtv2)
    TextView animtv2;
    @BindView(R.id.start2)
    Button start2;
    private ObjectAnimator animator;

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initView(Bundle bundle) {
        setTitle("动画");
//        Path path = new Path();
//        path.moveTo(0f, 0f);
//        path.lineTo(1f, 0.5f);
//        path.lineTo(1f, 1f);
//
//         animator = ObjectAnimator.ofFloat(animtv, View.X, View.Y, path);
//        animator.setDuration(3000);
//        animator.setRepeatCount(1);
//        animator.setRepeatMode(ValueAnimator.INFINITE);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(animtv, "fraction", 0, 1);
//        animator.setDuration(2000);
//        animator.start();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_anim;
    }


    @OnClick({R.id.start1, R.id.start2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start1:
                animator.start();
                break;
            case R.id.start2:
                break;

        }


    }
}
