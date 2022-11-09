package com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherHourlyDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenWeatherHourlyDto {
    private int dt;
    private double temp;
    private OpenWeatherHourlyRainDto rain;
    private OpenWeatherHourlySnowDto snow;
}
