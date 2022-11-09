package com.swietlicki.WeatherApp.exception.openWeatherConnException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OpenWeatherConnectionAdvice {

    @ResponseBody
    @ExceptionHandler(OpenWeatherConnectionException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String cityNotFoundHandler(OpenWeatherConnectionException ex) {
        return ex.getMessage();
    }
}
