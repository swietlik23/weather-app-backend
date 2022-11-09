package com.swietlicki.WeatherApp.soap.endpoint;

import com.swietlicki.WeatherApp.soap.model.GetForecast;
import com.swietlicki.WeatherApp.soap.model.GetForecastResponse;
import com.swietlicki.WeatherApp.soap.service.SoapService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ForecastEndpoint {
    private final SoapService soapService;

    @PayloadRoot(namespace = "http://swietlicki.com/soap2", localPart = "getForecast")
    @ResponsePayload
    public GetForecastResponse getForecastByCityName(@RequestPayload GetForecast getForecast) {
        return soapService.getForecast(getForecast);
    }
}
