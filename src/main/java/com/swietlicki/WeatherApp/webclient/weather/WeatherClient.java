package com.swietlicki.WeatherApp.webclient.weather;

import com.swietlicki.WeatherApp.model.SourceWeatherDto;
import com.swietlicki.WeatherApp.webclient.weather.dto.OpenWeatherDto;
import com.swietlicki.WeatherApp.exception.openWeatherConnException.OpenWeatherConnectionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.swietlicki.WeatherApp.model.SourceWeatherDto.changeKelvinsToCelsius;
@Slf4j
@Component
public class WeatherClient {
    @Value("${openWeather.weatherUrl}")
    private String WEATHER_URL;
    @Value("${openWeather.apiKey}")
    private String API_KEY;
    private RestTemplate restTemplate = new RestTemplate();
    public SourceWeatherDto getSourceWeatherDtoForCity(double latitude, double longitude) {

        OpenWeatherDto openWeatherDto = getOpenWeatherDtoForCity(latitude, longitude);

        return SourceWeatherDto.builder()
                .currentTemperatureInCelsius(changeKelvinsToCelsius(openWeatherDto.getCurrent().getTemp()))
                .currentConditions(openWeatherDto.getCurrent())
                .hourlyConditions(changeKelvinsToCelsius(openWeatherDto.getHourly()))
                .build();
    }

    private OpenWeatherDto getOpenWeatherDtoForCity(double latitude, double longitude) {
        OpenWeatherDto openWeatherDto;
        try {
            openWeatherDto = restTemplate.getForObject(WEATHER_URL,
                    OpenWeatherDto.class, latitude, longitude, API_KEY);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new OpenWeatherConnectionException();
        }
        return openWeatherDto;
    }
}
