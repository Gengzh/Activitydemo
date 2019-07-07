package com.example.gzh.activitymvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_setting);
    }

    @BindView(R.id.txt)
    TextView txt;

    @Override
    public void initView(Bundle bundle) {
        setTitle("title");

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this, "das", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getContentView() {
        return R.layout.activity_setting;
    }


}
