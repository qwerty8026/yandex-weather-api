package com.weather.model;

import com.google.gson.annotations.SerializedName;

/**
 * Класс представляет прогноз погоды для конкретного времени суток
 * (утро, день, вечер, ночь)
 */
public class Parts {

    @SerializedName("temp_avg")
    private Double tempAvg;

    @SerializedName("temp_min")
    private Double tempMin;

    @SerializedName("temp_max")
    private Double tempMax;

    @SerializedName("feels_like")
    private Double feelsLike;

    @SerializedName("icon")
    private String icon;

    @SerializedName("condition")
    private String condition;

    @SerializedName("daytime")
    private String daytime;

    @SerializedName("polar")
    private boolean polar;

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

    @SerializedName("prec_mm")
    private double precMm;

    @SerializedName("prec_period")
    private int precPeriod;

    @SerializedName("prec_prob")
    private int precProb;

    // Геттеры

    public Double getTempAvg() {
        return tempAvg;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public String getIcon() {
        return icon;
    }

    public String getCondition() {
        return condition;
    }

    public String getDaytime() {
        return daytime;
    }

    public boolean isPolar() {
        return polar;
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

    public double getPrecMm() {
        return precMm;
    }

    public int getPrecPeriod() {
        return precPeriod;
    }

    public int getPrecProb() {
        return precProb;
    }
}