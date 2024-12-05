package com.example.SampleService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    // Mock weather data storage (in a real-world scenario, this could be an external API call or database query)
    private static final Map<String, String> mockWeatherData = new HashMap<>();

    static {
        mockWeatherData.put("2024-12-05", "Sunny, 22°C");
        mockWeatherData.put("2024-12-06", "Cloudy, 20°C");
        mockWeatherData.put("2024-12-07", "Rainy, 18°C");
        mockWeatherData.put("2024-12-08", "Sunny, 24°C");
        mockWeatherData.put("2024-12-09", "Partly Cloudy, 19°C");
        // Add more mock data for the week if needed
    }

    public String getWeatherByLocation(String location) {
        // In a real scenario, use location to call a weather API like OpenWeatherMap or AccuWeather
        return "Weather at " + location + ": Sunny, 22°C"; // Mocked response
    }

    public String getWeatherByWeek(LocalDate startDate) {
        // Return weather data for the week starting from startDate
        StringBuilder weeklyWeather = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            LocalDate currentDate = startDate.plusDays(i);
            String date = currentDate.toString();
            String weather = mockWeatherData.getOrDefault(date, "No data available");
            weeklyWeather.append(date).append(": ").append(weather).append("\n");
        }
        return weeklyWeather.toString();
    }

    public String getWeatherByDate(LocalDate date) {
        return mockWeatherData.getOrDefault(date.toString(), "No weather data available for this date.");
    }
}
