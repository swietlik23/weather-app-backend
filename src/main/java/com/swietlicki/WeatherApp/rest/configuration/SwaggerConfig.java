package com.swietlicki.WeatherApp.rest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swaggerDescription.description}")
    private String SWAGGER_APP_DESCRIPTION;

    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors. regex ( "^(?!/(error).*$).*$"))
                .apis(RequestHandlerSelectors.basePackage("com.swietlicki.RestTemplateWeather"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("YourWeatherApp")
                .description(SWAGGER_APP_DESCRIPTION)
                .version("")
                .contact(new Contact("Krzysztof Swietlicki", "https://github.com/swietlik23",""))
                .build();
    }
}
