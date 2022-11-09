package com.swietlicki.WeatherApp.repisitory;

import com.swietlicki.WeatherApp.model.City;
import com.swietlicki.WeatherApp.parser.XMLParser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WeatherRepository {

    private List<City> cities;

    public WeatherRepository() {
        this.cities = XMLParser.parseXMLToList();
    }

    public List<City> getCities() {
        return cities;
    }
}
