package com.example.gzh.activitymvp.http;

import android.util.Log;

import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by Gzh on ${DATA}
 * Describe:
 */
public abstract class HttpSubscriber<T> extends DefaultSubscriber<HttpResult<T>> {

    @Override
    public void onNext(HttpResult<T> tHttpResult) {
//        tHttpResult.setError_code(1);
//        tHttpResult.setReason("没数据谢谢");
        if (tHttpResult.getError_code()==0){
            Log.e("errorcode==",tHttpResult.getError_code()+"");
            myNext(tHttpResult.getResults());
        }else{
//            myerror(ExceptionHandle.ServerException(tHttpResult.getError_code(),tHttpResult.getReason()));
//            myerror(ExceptionHandle.serverException(tHttpResult));
//            myerror(ExceptionHandle.ServerException(tHttpResult.getError_code(),tHttpResult.getReason()));
            myerror(ExceptionHandle.handleException(new ExceptionHandle.ServerException(tHttpResult.getError_code(),tHttpResult.getReason())));
    }
        Log.e("errorcode2==",tHttpResult.getError_code()+"");
    }

    @Override
    public void onError(Throwable t) {
        myerror(ExceptionHandle.handleException(t));
    }

    @Override
    public void onComplete() {

    }

    //成功
    public abstract void myNext(T t);

    /**
     * 失败
     */
    public abstract void myerror(ExceptionHandle.ResponeThrowable responeThrowable);

}
