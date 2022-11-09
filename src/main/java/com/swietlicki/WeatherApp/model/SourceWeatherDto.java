package com.swietlicki.WeatherApp.model;

import com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherCurrentDto.OpenWeatherCurrentDto;
import com.swietlicki.WeatherApp.webclient.weather.dto.openWeatherHourlyDto.OpenWeatherHourlyDto;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class SourceWeatherDto {

    private double currentTemperatureInCelsius;
    private OpenWeatherCurrentDto currentConditions;
    private List<OpenWeatherHourlyDto> hourlyConditions;

    public static double changeKelvinsToCelsius(double tempInKelvins) {
        return Math.round((tempInKelvins - 273.15) * 10D) / 10D;
    }

    public static List<OpenWeatherHourlyDto> changeKelvinsToCelsius(ArrayList<OpenWeatherHourlyDto> dtos) {
        ArrayList<OpenWeatherHourlyDto> targetList = new ArrayList<>();
        for (OpenWeatherHourlyDto element : dtos) {
            OpenWeatherHourlyDto targetElement = new OpenWeatherHourlyDto();
            targetElement.setDt(element.getDt());
            targetElement.setTemp(changeKelvinsToCelsius(element.getTemp()));
            targetElement.setRain(element.getRain());
            targetElement.setSnow(element.getSnow());
            targetList.add(targetElement);
        }
        return targetList;
    }
}
