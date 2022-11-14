package com.swietlicki.WeatherApp.soap.endpoint;

import com.swietlicki.WeatherApp.soap.model.GetForecast;
import com.swietlicki.WeatherApp.soap.model.GetForecastResponse;
import com.swietlicki.WeatherApp.soap.service.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ForecastEndpoint {

    @Autowired
    private final SoapService soapService;

    public ForecastEndpoint(SoapService soapService) {
        this.soapService = soapService;
    }

    @PayloadRoot(namespace = "http://swietlicki.com/soap2", localPart = "getForecast")
    @ResponsePayload
    public GetForecastResponse getForecastByCityName(@RequestPayload GetForecast getForecast) {
        return soapService.getForecast(getForecast);
    }
}
