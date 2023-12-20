package com.example.GenerativeAI0202.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double temperature;
    private Double feelsLike;
    private Double windSpeed;
    @OneToOne
    @JoinColumn(name = "city_id")
    @MapsId
    private City city;

    // constructors, getters and setters...
}
