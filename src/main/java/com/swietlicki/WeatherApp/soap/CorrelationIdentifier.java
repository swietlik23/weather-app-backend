package com.swietlicki.WeatherApp.soap;

import com.swietlicki.WeatherApp.exception.correlationIdException.CorrIdNotFoundException;
import com.swietlicki.WeatherApp.soap.model.GetForecast;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CorrelationIdentifier {

    public static final String CORRELATION_ID = "CorrelationId";

    public static String getCorrelationId(GetForecast getForecast) {
        String currentCorrelationId = getForecast.getCorrelationId();
        if (ifCorrelationIdExists(currentCorrelationId)) {
            return currentCorrelationId;
        } else {
            throw new CorrIdNotFoundException();
        }
    }

    private static boolean ifCorrelationIdExists(String currentCorrelationId) {
        if (currentCorrelationId == null || currentCorrelationId.isEmpty()) {
            log.info("No correlationId found in Body");
            return false;
        } else {
            log.info("Found correlationId in Body. Correlation ID: " + currentCorrelationId);
            return true;
        }
    }
}
