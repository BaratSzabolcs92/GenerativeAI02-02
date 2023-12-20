package com.example.GenerativeAI0202;

import com.example.GenerativeAI0202.domain.City;
import com.example.GenerativeAI0202.repository.CityRepository;
import com.example.GenerativeAI0202.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledTasks {

    private final WeatherService weatherService;
    private final CityRepository cityRepository;

    @Autowired
    public ScheduledTasks(WeatherService weatherService, CityRepository cityRepository) {
        this.weatherService = weatherService;
        this.cityRepository = cityRepository;
    }

    @Scheduled(fixedRate = 3600000)   // 1 hour in milliseconds
    public void updateWeatherData() {
        List<City> allCities = cityRepository.findAll();
        for(City city : allCities) {
            weatherService.addWeatherData(city.getName());
        }
    }
}
