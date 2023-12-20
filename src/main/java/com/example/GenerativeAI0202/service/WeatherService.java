package com.example.GenerativeAI0202.service;

import com.example.GenerativeAI0202.domain.City;
import com.example.GenerativeAI0202.domain.Weather;
import com.example.GenerativeAI0202.domain.WeatherData;
import com.example.GenerativeAI0202.repository.CityRepository;
import com.example.GenerativeAI0202.repository.WeatherRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Data
@Service
public class WeatherService {
    private final CityRepository cityRepository;
    private final WeatherRepository weatherRepository;
    private final WeatherDataService weatherDataService;
    @Autowired
    public WeatherService(CityRepository cityRepository, WeatherRepository weatherRepository, WeatherDataService weatherDataService){
        this.cityRepository = cityRepository;
        this.weatherRepository = weatherRepository;
        this.weatherDataService = weatherDataService;
    }

    public Weather mapFromWeatherData(WeatherData weatherData) {
        Weather weather = new Weather();
        // mapping WeatherData to Weather model.
        // you need to adjust the attribute mapping according to the weatherData model that you receive from Weather API.
        // weather.setDescription(weatherData.getDescription());
        // and so on for other attributes...
        return weather;
    }

    public Weather addWeatherData(String cityName) {
        City city = cityRepository.findByName(cityName);
        WeatherData data = weatherDataService.getWeatherData(cityName);
        Weather weather = mapFromWeatherData(data);
        weather.setCity(city);
        return weatherRepository.save(weather);
    }

}
