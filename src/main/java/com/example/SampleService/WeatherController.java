package com.example.SampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Endpoint for getting weather by location
    @GetMapping("/location")
    public String getWeatherByLocation(@RequestParam String location) {
        return weatherService.getWeatherByLocation(location);
    }

    // Endpoint for getting weather for the whole week
    @GetMapping("/week")
    public String getWeatherByWeek(@RequestParam String startDate) {
        LocalDate parsedStartDate = LocalDate.parse(startDate); // assuming the format is YYYY-MM-DD
        return weatherService.getWeatherByWeek(parsedStartDate);
    }

    // Endpoint for getting weather for a specific date
    @GetMapping("/date")
    public String getWeatherByDate(@RequestParam String date) {
        LocalDate parsedDate = LocalDate.parse(date); // assuming the format is YYYY-MM-DD
        return weatherService.getWeatherByDate(parsedDate);
    }
}
