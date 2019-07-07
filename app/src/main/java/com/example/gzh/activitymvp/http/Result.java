package com.example.gzh.activitymvp.http;

public class Result {

    /**
     * reason : 查询成功
     * result : {"city_id":"1157","city_name":"苏州","weather_date":"2017-11-29","day_weather":"阴","night_weather":"阴","day_temp":"13℃","night_temp":"9℃","day_wind":"东北风","day_wind_comp":"3-4级","night_wind":"东北风","night_wind_comp":"3-4级","day_weather_id":"02","night_weather_id":"02"}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * city_id : 1157
         * city_name : 苏州
         * weather_date : 2017-11-29
         * day_weather : 阴
         * night_weather : 阴
         * day_temp : 13℃
         * night_temp : 9℃
         * day_wind : 东北风
         * day_wind_comp : 3-4级
         * night_wind : 东北风
         * night_wind_comp : 3-4级
         * day_weather_id : 02
         * night_weather_id : 02
         */

        private String city_id;
        private String city_name;
        private String weather_date;
        private String day_weather;
        private String night_weather;
        private String day_temp;
        private String night_temp;
        private String day_wind;
        private String day_wind_comp;
        private String night_wind;
        private String night_wind_comp;
        private String day_weather_id;
        private String night_weather_id;

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getWeather_date() {
            return weather_date;
        }

        public void setWeather_date(String weather_date) {
            this.weather_date = weather_date;
        }

        public String getDay_weather() {
            return day_weather;
        }

        public void setDay_weather(String day_weather) {
            this.day_weather = day_weather;
        }

        public String getNight_weather() {
            return night_weather;
        }

        public void setNight_weather(String night_weather) {
            this.night_weather = night_weather;
        }

        public String getDay_temp() {
            return day_temp;
        }

        public void setDay_temp(String day_temp) {
            this.day_temp = day_temp;
        }

        public String getNight_temp() {
            return night_temp;
        }

        public void setNight_temp(String night_temp) {
            this.night_temp = night_temp;
        }

        public String getDay_wind() {
            return day_wind;
        }

        public void setDay_wind(String day_wind) {
            this.day_wind = day_wind;
        }

        public String getDay_wind_comp() {
            return day_wind_comp;
        }

        public void setDay_wind_comp(String day_wind_comp) {
            this.day_wind_comp = day_wind_comp;
        }

        public String getNight_wind() {
            return night_wind;
        }

        public void setNight_wind(String night_wind) {
            this.night_wind = night_wind;
        }

        public String getNight_wind_comp() {
            return night_wind_comp;
        }

        public void setNight_wind_comp(String night_wind_comp) {
            this.night_wind_comp = night_wind_comp;
        }

        public String getDay_weather_id() {
            return day_weather_id;
        }

        public void setDay_weather_id(String day_weather_id) {
            this.day_weather_id = day_weather_id;
        }

        public String getNight_weather_id() {
            return night_weather_id;
        }

        public void setNight_weather_id(String night_weather_id) {
            this.night_weather_id = night_weather_id;
        }
    }
}
