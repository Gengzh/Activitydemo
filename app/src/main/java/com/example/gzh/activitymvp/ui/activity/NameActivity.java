package com.example.gzh.activitymvp.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gzh.activitymvp.MainActivity;
import com.example.gzh.activitymvp.R;

public class NameActivity extends AppCompatActivity {

    private TextView tomain2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        tomain2 = findViewById(R.id.tomain2);
        tomain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NameActivity.this,MainActivity.class));
            }
        });

    }

    private void ints(){

        Intent intent = new Intent();

    }

    public class CustomDialog extends Dialog{
        public CustomDialog(Context context) {
            super(context);
        }

        public CustomDialog(Context context, int theme) {
            super(context, theme);
        }

//        public static class Builder{
//
//            private Context context;
//            public Builder(Context context) {
//            }
//        }


    }
}
