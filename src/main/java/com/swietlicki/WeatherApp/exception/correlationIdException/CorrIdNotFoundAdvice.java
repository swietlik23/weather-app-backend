package com.swietlicki.WeatherApp.exception.correlationIdException;

import com.swietlicki.WeatherApp.exception.cityException.CityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class CorrIdNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CorrIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String cityNotFoundHandler(CityNotFoundException ex) {
        return ex.getMessage();
    }
}
