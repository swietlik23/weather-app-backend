package com.swietlicki.WeatherApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class RestTemplateWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateWeatherApplication.class, args);
	}

}
