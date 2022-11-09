package com.swietlicki.WeatherApp.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ForecastForCityDto {

    private String cityName;
    private double temperatureInCelsius;
    private String weatherDescription;
}
