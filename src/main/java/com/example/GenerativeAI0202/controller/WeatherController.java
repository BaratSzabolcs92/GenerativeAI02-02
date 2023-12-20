package com.example.GenerativeAI0202.controller;

import com.example.GenerativeAI0202.domain.Weather;
import com.example.GenerativeAI0202.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<Weather> getWeatherData(@PathVariable String cityName) {
        Weather weatherData = weatherService.addWeatherData(cityName);
        return new ResponseEntity<>(weatherData, HttpStatus.OK);
    }

}
