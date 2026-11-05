package com.weather.model;

import com.google.gson.annotations.SerializedName;

/**
 * Класс представляет текущую погоду (объект "fact" в JSON ответе)
 */
public class Fact {

    @SerializedName("temp")
    private double temp;

    @SerializedName("feels_like")
    private double feelsLike;

    @SerializedName("icon")
    private String icon;

    @SerializedName("condition")
    private String condition;

    @SerializedName("wind_speed")
    private double windSpeed;

    @SerializedName("wind_gust")
    private double windGust;

    @SerializedName("wind_dir")
    private String windDir;

    @SerializedName("pressure_mm")
    private double pressureMm;

    @SerializedName("pressure_pa")
    private double pressurePa;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("daytime")
    private String daytime;

    @SerializedName("polar")
    private boolean polar;

    @SerializedName("season")
    private String season;

    @SerializedName("obs_time")
    private long obsTime;

    // Геттеры (методы для получения значений полей)

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public String getIcon() {
        return icon;
    }

    public String getCondition() {
        return condition;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public String getWindDir() {
        return windDir;
    }

    public double getPressureMm() {
        return pressureMm;
    }

    public double getPressurePa() {
        return pressurePa;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDaytime() {
        return daytime;
    }

    public boolean isPolar() {
        return polar;
    }

    public String getSeason() {
        return season;
    }

    public long getObsTime() {
        return obsTime;
    }
}