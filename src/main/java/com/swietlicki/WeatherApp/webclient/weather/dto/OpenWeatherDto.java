package com.swietlicki.WeatherApp.webclient.weather.dto;

import com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherCurrentDto.OpenWeatherCurrentDto;
import com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherHourlyDto.OpenWeatherHourlyDto;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class OpenWeatherDto {
    private OpenWeatherCurrentDto current;
    private ArrayList<OpenWeatherHourlyDto> hourly;
}
