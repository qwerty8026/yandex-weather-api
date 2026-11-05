package com.weather.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Класс представляет прогноз погоды на один день
 */
public class Forecast {

    @SerializedName("date")
    private String date;

    @SerializedName("date_ts")
    private long dateTs;

    @SerializedName("week")
    private int week;

    @SerializedName("sunrise")
    private String sunrise;

    @SerializedName("sunset")
    private String sunset;

    @SerializedName("moon_code")
    private int moonCode;

    @SerializedName("moon_text")
    private String moonText;

    @SerializedName("parts")
    private Map<String, Parts> parts;

    // Геттеры

    public String getDate() {
        return date;
    }

    public long getDateTs() {
        return dateTs;
    }

    public int getWeek() {
        return week;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public int getMoonCode() {
        return moonCode;
    }

    public String getMoonText() {
        return moonText;
    }

    public Map<String, Parts> getParts() {
        return parts;
    }
}