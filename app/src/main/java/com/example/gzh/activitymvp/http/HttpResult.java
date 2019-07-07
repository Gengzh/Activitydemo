package com.example.gzh.activitymvp.http;

import java.io.Serializable;

public class HttpResult<T> implements Serializable {

    /**
     * reason : 查询成功
     * result : {"city_id":"1157","city_name":"苏州","weather_date":"2017-07-15","day_weather":"多云","night_weather":"晴","day_temp":"33℃","night_temp":"25℃","day_wind":"无持续风向","day_wind_comp":"≤3级","night_wind":"无持续风向","night_wind_comp":"≤3级","day_weather_id":"01","night_weather_id":"00"}
     * error_code : 0
     */
    private String reason;
    private int error_code;
    private T result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public T getResults() {
        return result;
    }

    public void setResults(T results) {
        this.result = results;
    }
}
