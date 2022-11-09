package com.swietlicki.WeatherApp.exception.cityException;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String cityName) {
        super("Could not find city with name: " + cityName);
    }
}
