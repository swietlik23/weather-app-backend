package com.swietlicki.WeatherApp.rest.controller;

import com.swietlicki.WeatherApp.model.City;
import com.swietlicki.WeatherApp.model.ForecastForCityDto;
import com.swietlicki.WeatherApp.service.WeatherService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/cities")
    @ApiOperation(value = "Get all cities")
    public List<City> getCities() {
        log.info("Request to /cities");
        return weatherService.getCities();
    }

    @GetMapping("/forecasts")
    @ApiOperation(value = "Get forecasts for cities")
    public List<ForecastForCityDto> getForecastForManyCities(@RequestParam(name = "city") String[] cityNames) {
        log.info("Request to /forecasts/" + Arrays.toString(cityNames));
        return weatherService.getForecastForCities(cityNames);
    }
}
