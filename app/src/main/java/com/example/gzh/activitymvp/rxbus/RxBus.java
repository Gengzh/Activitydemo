package com.example.gzh.activitymvp.rxbus;

/**
 * Created by Gzh on ${DATA}
 * Describe:
 */
public class RxBus {

    private static volatile RxBus rxBus;


    public static RxBus getRxBus(){

        if (rxBus ==null){
            synchronized (RxBus.class){
//                if (){
//
//                }
            }
        }
        return rxBus;
    }



}
