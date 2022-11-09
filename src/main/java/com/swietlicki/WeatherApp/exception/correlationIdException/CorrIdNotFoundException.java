package com.swietlicki.WeatherApp.exception.correlationIdException;

public class CorrIdNotFoundException extends RuntimeException {

    public CorrIdNotFoundException() {
        super("No correlation ID in the request");
    }
}
