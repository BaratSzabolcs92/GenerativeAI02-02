package com.example.GenerativeAI0202.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)   // Indicates that other fields, not bound in this class, will be ignored
public class WeatherData {

    private double lon;   // Example fields. Please adjust it as per actual response
    private double lat;
    private double temperature;
    private double feelsLike;
    private double tempMin;
    private double tempMax;

}
