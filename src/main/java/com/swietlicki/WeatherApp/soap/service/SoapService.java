package com.swietlicki.WeatherApp.soap.service;

import com.swietlicki.WeatherApp.model.ForecastForCityDto;
import com.swietlicki.WeatherApp.service.WeatherService;
import com.swietlicki.WeatherApp.soap.CorrelationIdentifier;
import com.swietlicki.WeatherApp.soap.model.ForecastDTO;
import com.swietlicki.WeatherApp.soap.model.GetForecast;
import com.swietlicki.WeatherApp.soap.model.GetForecastResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoapService {

    private final WeatherService weatherService;

    public GetForecastResponse getForecast(GetForecast forecastRequest) {

        ForecastForCityDto forecastForCity = weatherService.getForecastForCity(forecastRequest.getCityName());
        String currentCorrelationId = CorrelationIdentifier.getCorrelationId(forecastRequest);

        ForecastDTO forecastDTO= ForecastDTO
                .builder()
                .cityName(forecastForCity.getCityName())
                .temperatureInCelsius(forecastForCity.getTemperatureInCelsius())
                .weatherDescription(forecastForCity.getWeatherDescription())
                .build();

        GetForecastResponse getResponse = new GetForecastResponse();
        getResponse.setForecastDTO(forecastDTO);
        getResponse.setCorrelationId(currentCorrelationId);

        return getResponse;
    }
}
