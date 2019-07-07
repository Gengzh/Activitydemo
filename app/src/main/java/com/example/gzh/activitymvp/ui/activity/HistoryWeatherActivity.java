package com.example.gzh.activitymvp.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseActivity;
import com.example.gzh.activitymvp.http.ApiService;
import com.example.gzh.activitymvp.http.ExceptionHandle;
import com.example.gzh.activitymvp.http.HistroyResult;
import com.example.gzh.activitymvp.http.HttpCodeSubscriber;
import com.example.gzh.activitymvp.http.HttpResult;
import com.example.gzh.activitymvp.http.HttpSubscriber;
import com.example.gzh.activitymvp.http.Result;
import com.example.gzh.activitymvp.http.RetrofitClient;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * 历史天气
 */
public class HistoryWeatherActivity extends BaseActivity {

    @BindView(R.id.night_temp)
    TextView nightTemp;
    @BindView(R.id.day_temp)
    TextView dayTemp;
    @BindView(R.id.req)
    TextView req;
    private HistroyResult histroyResultsss = new HistroyResult();

    @Override
    public void initView(Bundle bundle) {
        setTitle("wode历史");
        getHistroy();
        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HistoryWeatherActivity.this, "req", Toast.LENGTH_SHORT).show();
                getHistroy();
            }
        });



    }

    @Override
    public int getContentView() {
        return R.layout.activity_history_weather;
    }

    private void getHistroy() {
//
//        RetrofitClient.getService().create(ApiService.class)
//                .getHistroy("1b3186d6b6f79395ff8bd299e6012a10", "1157", "2017-11-29")
//                .compose(RetrofitClient.handleResult())
//                .subscribe(new Subscriber<HistroyResult>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//
//                    }
//
//                    @Override
//                    public void onNext(HistroyResult histroyResult) {
//                        dayTemp.setText(histroyResult.getCity_name());
//                        Log.e("走这里了么", "zoule ");
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        //这个好使 有返回
//        RetrofitClient.getService().create(ApiService.class)
//                .getHistroy2("1b3186d6b6f79395ff8bd299e6012a10", "1157", "2017-11-29")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Result>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Result histroyResultHttpResult) {
//
//                        dayTemp.setText(histroyResultHttpResult.getResult().getCity_name());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
////                });

//        RetrofitClient.getService().create(ApiService.class)
//                .getHistroy2("1b3186d6b6f79395ff8bd299e6012a10", "1157", "2017-11-29")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Result>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Result histroyResultHttpResult) {
//
//                        dayTemp.setText(histroyResultHttpResult.getResult().getCity_name());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//        RetrofitClient.getService().create(ApiService.class)
//                .getHistroy("1b3186d6b6f79395ff8bd299e6012a10", "1157", "2017-11-29")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new DefaultSubscriber<HttpResult<HistroyResult>>() {
//
//                    @Override
//                    public void onNext(HttpResult<HistroyResult> histroyResultHttpResult) {
//
//                        Log.e("dsadsadsa====",histroyResultHttpResult.getResults().getCity_name());
//                        dayTemp.setText(histroyResultHttpResult.getResults().getCity_name());
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//        RetrofitClient.getService().create(ApiService.class)
//                .getHistroy("1b3186d6b6f79395ff8bd299e6012a10", "1157", "2017-11-29")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new HttpCodeSubscriber<HistroyResult>() {
//                    @Override
//                    public void _onNext(HistroyResult histroyResult) {
//                        dayTemp.setText(histroyResult.getCity_name());
//                    }
//
//                    @Override
//                    public void _onError(Throwable e) {
//
//                    }
//                });
        RetrofitClient.getService().create(ApiService.class)
                .getHistroy("1b3186d6b6f79395ff8bd299e6012a10", "1157", "2017-11-29")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpSubscriber<HistroyResult>() {
                    @Override
                    public void myNext(HistroyResult histroyResult) {
                        dayTemp.setText(histroyResult.getCity_name());
                    }

                    @Override
                    public void myerror(ExceptionHandle.ResponeThrowable responeThrowable) {
                        Log.e("activity里面", responeThrowable.code + ""+responeThrowable.message);
//                        Log.e("messagge===",  responeThrowable.getMessage());
//                        Toast.makeText(HistoryWeatherActivity.this,"勿忘",Toast.LENGTH_SHORT).show();
                        Log.e("","");


                    }
                });


    }

    @Override
    protected void onResume() {
        super.onResume();
//        dayTemp.setText(histroyResultsss.getDay_temp());

    }
}
