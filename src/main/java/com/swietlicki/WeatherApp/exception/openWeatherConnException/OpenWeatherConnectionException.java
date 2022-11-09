package com.swietlicki.WeatherApp.exception.openWeatherConnException;

public class OpenWeatherConnectionException extends RuntimeException {

    public OpenWeatherConnectionException() {
        super("Could not connect to OpenWeather Service");
    }
}
