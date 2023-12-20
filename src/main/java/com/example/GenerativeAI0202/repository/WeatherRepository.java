package com.example.GenerativeAI0202.repository;

import com.example.GenerativeAI0202.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> findByCityId(Long cityId);
}
