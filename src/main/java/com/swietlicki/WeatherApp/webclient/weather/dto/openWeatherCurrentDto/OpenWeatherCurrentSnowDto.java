package com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherCurrentDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OpenWeatherCurrentSnowDto {
    @JsonProperty(value = "1h")
    private Double snow1h;
}

