package com.example.gzh.activitymvp.http;


import io.reactivex.subscribers.DefaultSubscriber;


public abstract class HttpCodeSubscriber<T> extends DefaultSubscriber<HttpResult<T>> {

    public abstract void _onNext(T t);

    public abstract void _onError(Throwable e);

    public void _cancel() {
        cancel();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        _onError(e);
    }


    @Override
    public void onNext(HttpResult<T> t) {
        _onNext(t.getResults());
    }
}
