package com.swietlicki.WeatherApp.service;

import com.swietlicki.WeatherApp.exception.cityException.CityNotFoundException;
import com.swietlicki.WeatherApp.model.City;
import com.swietlicki.WeatherApp.model.ForecastForCityDto;
import com.swietlicki.WeatherApp.model.SourceWeatherDto;
import com.swietlicki.WeatherApp.repisitory.WeatherRepository;
import com.swietlicki.WeatherApp.webclient.weather.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;
    private final WeatherRepository repository;
    @Value("${data.predictionTime}")
    private int PREDICTION_HOURLY_TIME;

    public List<City> getCities() {
        return repository.getCities();
    }
    public SourceWeatherDto getWeather(String cityName) {
        City city = getSingleCityByName(cityName.toLowerCase());
        return weatherClient.getSourceWeatherDtoForCity(city.getLatitude(), city.getLongitude());
    }

    public City getSingleCityByName(String cityName) {
        List<City> cities;
        cities = repository.getCities();
        return cities.stream()
                .filter(city -> city.getName().equals(cityName))
                .findFirst()
                .orElseThrow(()-> new CityNotFoundException(cityName));
    }

    public ForecastForCityDto getForecastForCity(String cityName) {
        City city = getSingleCityByName(cityName.toLowerCase());
        SourceWeatherDto sourceWeatherDto = weatherClient.getSourceWeatherDtoForCity(city.getLatitude(), city.getLongitude());
        log.info("getForecastForCity(): cityName: " + cityName);
        return ForecastForCityDto.builder()
                .cityName(cityName)
                .temperatureInCelsius(sourceWeatherDto.getCurrentTemperatureInCelsius())
                .weatherDescription(describeCurrentWeather(sourceWeatherDto))
                .build();
    }

    public List<ForecastForCityDto> getForecastForCities(String[] cityNames) {
        List<ForecastForCityDto> targetList = new ArrayList<>();
        for (String cityName : cityNames) {
            if (cityName != null) {
                ForecastForCityDto forecast = getForecastForCity(cityName);
                if (forecast != null) {
                    targetList.add(forecast);
                }
            }
        }
        return targetList;
    }

    private boolean checkIfWillRain(SourceWeatherDto sourceWeatherDto) {
        if (sourceWeatherDto.getCurrentConditions().getRain() != null) {
            for (int i = 0; i < PREDICTION_HOURLY_TIME; i++) {
                if (sourceWeatherDto.getHourlyConditions().get(i).getRain() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkIfWillSnow(SourceWeatherDto sourceWeatherDto) {
        if (sourceWeatherDto.getCurrentConditions().getSnow() != null) {
            for (int i = 0; i < PREDICTION_HOURLY_TIME; i++) {
                if (sourceWeatherDto.getHourlyConditions().get(i).getSnow() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private String describeCurrentWeather(SourceWeatherDto source) {
        if (checkIfWillSnow(source)) {
            return "snow";
        } else if (checkIfWillRain(source)) {
            return "rain";
        } else if (source.getCurrentConditions().getClouds() > 60) {
            return "clouds";
        } else if (source.getCurrentConditions().getClouds() > 10) {
            return "sunAndClouds";
        } else {
            return "sun";
        }
    }
}
