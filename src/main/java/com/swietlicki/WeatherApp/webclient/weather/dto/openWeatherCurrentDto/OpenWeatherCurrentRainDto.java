package com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherCurrentDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OpenWeatherCurrentRainDto {
    @JsonProperty(value = "1h")
    private Double rain1h;
}
