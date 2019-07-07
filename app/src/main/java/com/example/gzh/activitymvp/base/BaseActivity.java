package com.example.gzh.activitymvp.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.gzh.activitymvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    private FrameLayout frame;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvtitle)//toolbar标题
            TextView tv_title;
    @BindView(R.id.right_btn)
    ImageView right_btn;
    @BindView(R.id.left_btn)
    ImageView left_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_base, null);
        frame = view.findViewById(R.id.frame);
        inflater.inflate(getContentView(), frame);

        setContentView(view);
        //绑定初始化ButterKnife
        ButterKnife.bind(this);

        initView(savedInstanceState);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//不显示标题
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置返回按钮
    }

    /**
     * 初始化
     *
     * @param bundle
     */
    public abstract void initView(Bundle bundle);

    /**
     * 引用布局
     *
     * @return
     */
    public abstract int getContentView();

    public void setTitle(String title) {
        tv_title.setText(title);
    }

    public ImageView getLeftBtn() {
        return left_btn;
    }

    public ImageView getRightBtn() {
        return right_btn;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    ;

}
