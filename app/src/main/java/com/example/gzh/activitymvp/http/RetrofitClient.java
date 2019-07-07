package com.example.gzh.activitymvp.http;

import android.util.Log;

import org.reactivestreams.Publisher;

import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 000406 on 2018/7/25.
 */
public class RetrofitClient {

    private static Retrofit retrofit;

    /**
     * 创建Retrofit对象
     * @return
     */
    public static Retrofit getService() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(HttpUtils.BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client())
                    .build();
        }
        return retrofit;
    }

    /**
     * okhttp过滤器
     * @return
     */
    public static OkHttpClient client(){
        OkHttpClient client = new OkHttpClient.Builder()//okhttp设置部分，此处还可再设置网络参数
                .addInterceptor(logInterceptor())//添加日志拦截
                .build();
        return client;
    }

    /**
     * 打印log日志
     * @return
     */
    public static HttpLoggingInterceptor logInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                Log.e("RetrofitLog", "retrofitBack = " + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
    }

    /**
     * 对返回值转化成bean
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<HttpResult<T>, T> handleResult() {
        return upstream -> upstream.flatMap(new Function<HttpResult<T>, Publisher<T>>() {
            @Override
            public Publisher<T> apply(@NonNull HttpResult<T> tHttpResult) throws Exception {
                return subscriber -> {
                    if (tHttpResult.getError_code() == 0) {//成功返回 有数据
                        subscriber.onNext((T) tHttpResult.getResults());
                    } else {
//                        subscriber.onError(new Exception(tHttpResult.getReason()));
                    }

                };
            }

        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

//    /**
//     * bean返回
//     *
//     * @param <T>
//     * @return
//     */
//    public static <T> FlowableTransformer<HttpResult<T>, T> handledResult() {
//
//        return upstream -> upstream.flatMap(new Function<HttpResult<T>, Publisher<T>>() {
//            @Override
//            public Publisher<T> apply(@NonNull HttpResult<T> tHttpResult) throws Exception {
//                return subscriber -> {
//                    if (tHttpResult.getCode() == 200) {//成功返回
//                        if (tHttpResult.getObj() == null) {
//                            tHttpResult.setMsg("Empty");
//                            subscriber.onError(new Exception(tHttpResult.getMsg()));
//                        } else {
//                            subscriber.onNext((T) tHttpResult.getObj());
//                        }
//                    } else {
//                        subscriber.onError(new Exception(tHttpResult.getMsg()));
//                    }
//
//                };
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//    }

//    /**
//     * bean返回
//     *
//     * @param <T>
//     * @return
//     */
//    public static <T> FlowableTransformer<HttpProvince<T>, T> weahterResult() {
//
//        return upstream -> upstream.flatMap(new Function<HttpProvince<T>, Publisher<T>>() {
//            @Override
//            public Publisher<T> apply(@NonNull HttpProvince<T> tHttpResult) throws Exception {
//                return subscriber -> {
//                    if (tHttpResult.getReason().equals("查询成功")) {//成功返回
////                        if (tHttpResult.getObj() == null) {
////                            tHttpResult.setMsg("Empty");
////                            subscriber.onError(new Exception(tHttpResult.getMsg()));
////                        } else {
//                            subscriber.onNext((T) tHttpResult.getObj());
////                        }
//                    } else {
//                        subscriber.onError(new Exception(tHttpResult.getReason()));
//                    }
//
//                };
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//    }


    //        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                //打印retrofit日志
//                Log.e("RetrofitLog", "retrofitBack = " + message);
//            }
//        }).setLevel(HttpLoggingInterceptor.Level.BODY);


}
