package com.example.GenerativeAI0202.repository;

import com.example.GenerativeAI0202.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);
    City findByZipCode(String zipCode);
}
