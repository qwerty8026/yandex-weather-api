package com.weather.service;

import com.google.gson.Gson;
import com.weather.model.WeatherResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale; // <-- ДОБАВЛЕН ЭТОТ ИМПОРТ

/**
 * Сервис для получения данных о погоде из API Яндекс.Погоды
 */
public class WeatherService {

    private static final String API_URL = "https://api.weather.yandex.ru/v2/forecast";
    private static final String HEADER_KEY = "X-Yandex-Weather-Key";

    private final String apiKey;
    private final HttpClient httpClient;
    private final Gson gson;

    public WeatherService(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public WeatherResponse getForecast(double lat, double lon, int limit)
            throws IOException, InterruptedException {


        String url = String.format(Locale.US, "%s?lat=%f&lon=%f&limit=%d",
                API_URL, lat, lon, limit);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header(HEADER_KEY, apiKey)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException("Ошибка запроса к API. Код ответа: " +
                    response.statusCode() + "\nТело ответа: " + response.body());
        }

        return gson.fromJson(response.body(), WeatherResponse.class);
    }

    public String getRawJsonResponse(double lat, double lon, int limit)
            throws IOException, InterruptedException {


        String url = String.format(Locale.US, "%s?lat=%f&lon=%f&limit=%d",
                API_URL, lat, lon, limit);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header(HEADER_KEY, apiKey)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException("Ошибка запроса к API. Код ответа: " +
                    response.statusCode() + "\nТело ответа: " + response.body());
        }

        return response.body();
    }
}