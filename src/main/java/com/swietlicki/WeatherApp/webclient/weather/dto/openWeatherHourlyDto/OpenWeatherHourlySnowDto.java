package com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherHourlyDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OpenWeatherHourlySnowDto {
    @JsonProperty(value = "1h")
    private double snow1h;
}
