package com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherHourlyDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OpenWeatherHourlyRainDto {
    @JsonProperty(value = "1h")
    private double rain1h;
}
