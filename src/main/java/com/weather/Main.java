package com.weather;

import com.weather.model.Forecast;
import com.weather.model.Parts;
import com.weather.model.WeatherResponse;
import com.weather.service.WeatherService;

import java.util.List;
import java.util.Map;

/**
 * Главное приложение для работы с API Яндекс.Погоды
 * Выполняет все требования задания:
 * 1. Отправляет GET запрос с заголовком X-Yandex-Weather-Key
 * 2. Выводит полный JSON ответ
 * 3. Извлекает и выводит fact.temp
 * 4. Вычисляет среднюю температуру по прогнозу
 */
public class Main {

    private static final String API_KEY = "3e21ee7d-4e4b-4111-89de-b379f91fde81";

    // Координаты для запроса (по умолчанию - Москва)
    private static final double LATITUDE = 55.75;
    private static final double LONGITUDE = 37.62;

    // Количество дней для прогноза (параметр limit)
    private static final int FORECAST_DAYS = 7;

    public static void main(String[] args) {
        System.out.println("=== Yandex Weather API Client ===\n");

        // Проверяем, установлен ли API ключ
        if (API_KEY.equals("your_api_key_here")) {
            System.err.println("❌ ОШИБКА: Не указан API ключ!");
            System.err.println("Пожалуйста, замените 'your_api_key_here' на ваш реальный ключ.");
            System.err.println("Получить ключ можно на: https://yandex.ru/pogoda/b2b/console/home");
            System.exit(1);
        }

        try {
            // Создаем сервис
            WeatherService weatherService = new WeatherService(API_KEY);

            System.out.println("1. ПОЛНЫЙ JSON ОТВЕТ ОТ API:");
            System.out.println("=".repeat(80));
            String jsonResponse = weatherService.getRawJsonResponse(
                    LATITUDE, LONGITUDE, FORECAST_DAYS
            );
            System.out.println(jsonResponse);
            System.out.println("=".repeat(80));
            System.out.println();

            WeatherResponse response = weatherService.getForecast(
                    LATITUDE, LONGITUDE, FORECAST_DAYS
            );

            System.out.println("2. ТЕКУЩАЯ ПОГОДА (fact.temp):");
            System.out.println("=".repeat(80));
            double currentTemp = response.getFact().getTemp();
            System.out.printf("🌡️  Текущая температура: %.1f°C%n", currentTemp);
            System.out.printf("🤔 Ощущается как: %.1f°C%n", response.getFact().getFeelsLike());
            System.out.printf("💧 Влажность: %d%%%n", response.getFact().getHumidity());
            System.out.printf("💨 Ветер: %.1f м/с (%s)%n",
                    response.getFact().getWindSpeed(),
                    response.getFact().getWindDir());
            System.out.printf("📊 Давление: %.1f мм рт.ст.%n", response.getFact().getPressureMm());
            System.out.printf("🌤️  Погодные условия: %s%n", response.getFact().getCondition());
            System.out.println("=".repeat(80));
            System.out.println();

            System.out.println("3. СРЕДНЯЯ ТЕМПЕРАТУРА ПО ПРОГНОЗУ:");
            System.out.println("=".repeat(80));

            List<Forecast> forecasts = response.getForecasts();
            double totalTempAvg = 0.0;
            int count = 0;

            System.out.printf("📅 Прогноз на %d дней:%n", Math.min(forecasts.size(), FORECAST_DAYS));
            System.out.println("-".repeat(80));
            System.out.printf("%-12s | %-10s | %-15s%n", "Дата", "Время суток", "Ср. темп. (°C)");
            System.out.println("-".repeat(80));

            int daysToProcess = Math.min(forecasts.size(), FORECAST_DAYS);

            for (int i = 0; i < daysToProcess; i++) {
                Forecast forecast = forecasts.get(i);
                Map<String, Parts> parts = forecast.getParts();

                if (parts != null && parts.containsKey("day")) {
                    Parts dayPart = parts.get("day");
                    if (dayPart.getTempAvg() != null) {
                        double tempAvg = dayPart.getTempAvg();
                        totalTempAvg += tempAvg;
                        count++;

                        System.out.printf("%-12s | %-10s | %15.1f%n",
                                forecast.getDate(), "day", tempAvg);
                    }
                }
            }

            System.out.println("-".repeat(80));

            if (count > 0) {
                double averageTemp = totalTempAvg / count;
                System.out.println();
                System.out.printf("📊 Средняя температура по прогнозу за %d дней: %.2f°C%n",
                        daysToProcess, averageTemp);
                System.out.printf("🌡️  Текущая температура (fact.temp): %.2f°C%n", currentTemp);
            } else {
                System.out.println("❌ Не удалось получить данные о средней температуре");
            }

            System.out.println("=".repeat(80));
            System.out.println("\n✅ Программа успешно завершена!");

        } catch (Exception e) {
            System.err.println("❌ Произошла ошибка при получении данных о погоде:");
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}