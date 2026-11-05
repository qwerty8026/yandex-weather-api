package com.weather.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Класс представляет полный ответ от API Яндекс.Погоды
 */
public class WeatherResponse {

    @SerializedName("now")
    private long now;

    @SerializedName("now_dt")
    private String nowDt;

    @SerializedName("info")
    private Info info;

    @SerializedName("fact")
    private Fact fact;

    @SerializedName("forecasts")
    private List<Forecast> forecasts;

    // Вложенный класс для объекта "info"
    public static class Info {
        @SerializedName("lat")
        private double lat;

        @SerializedName("lon")
        private double lon;

        @SerializedName("url")
        private String url;

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }

        public String getUrl() {
            return url;
        }
    }

    // Геттеры

    public long getNow() {
        return now;
    }

    public String getNowDt() {
        return nowDt;
    }

    public Info getInfo() {
        return info;
    }

    public Fact getFact() {
        return fact;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }
}