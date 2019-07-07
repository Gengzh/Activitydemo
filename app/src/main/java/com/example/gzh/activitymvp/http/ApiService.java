package com.example.gzh.activitymvp.http;

import com.google.gson.JsonObject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 000406 on 2018/7/25.
 */

public interface ApiService {
    /**
     *查询历史天气
     * @param key
     * @param city_id
     * @param date
     * @return
     */
    @GET("weather")
    Observable<Result> getHistroy2(@Query("key") String key,
                                   @Query("city_id") String city_id,
                                   @Query("weather_date") String date);

//    @POST("usersMessage/listMessageInfo")
//    Flowable<HttpResult<List<MessageResult>>> getMsgList(@Query("params") String json);

    @GET("book/search")
    Call<JsonObject> getSearchBooks(@Query("q") String name, @Query("tag") String tag, @Query("start") int start,
                                    @Query("count") int count);

    @GET("book/search")
    Call<ResponseBody> getSearchBooks2(@Query("q") String name, @Query("tag") String tag, @Query("start") int start,
                                       @Query("count") int count);
//    @GET("province")
//    Call<Province> getProvince(@Query("key") String key);

    /**
     * 历史天气
     * @param
     * @return
     */
    @GET("weather")
    Flowable<HttpResult<HistroyResult>> getHistroy(@Query("key") String key,
                                                   @Query("city_id") String city_id,
                                                   @Query("weather_date") String date);


}
