package com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherCurrentDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenWeatherCurrentDto {
    private double temp;
    private int clouds;
    private OpenWeatherCurrentRainDto rain;
    private OpenWeatherCurrentSnowDto snow;
}
