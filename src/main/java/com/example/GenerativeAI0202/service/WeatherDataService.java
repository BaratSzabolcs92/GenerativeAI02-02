package com.example.GenerativeAI0202.service;

import com.example.GenerativeAI0202.domain.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataService {
    private final RestTemplate restTemplate;
    private final String apiKey = "your_API_key_here";  // Get this from OpenWeatherMap

    @Autowired
    public WeatherDataService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public WeatherData getWeatherData(String cityName) {
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", cityName, apiKey);
        return this.restTemplate.getForObject(url, WeatherData.class);
    }
}
