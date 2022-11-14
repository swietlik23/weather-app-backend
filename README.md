
# Weather App Backend

This is an application that, for a given cities, will download data containing the current weather situation from the service [https://openweathermap.org](https://openweathermap.org/current), and returns data (city name, temperature in celsius degrees, and a brief summary of weather conditions).


## Data source

The application retrieves city data (name, geographical coordinates) from the "data.xml" file located in the main directory.

Below you will find how a sample 'data.xml' file looks like.

![dataXml](https://github.com/swietlik23/weather-app-backend/blob/master/imagesToReadme/dataXml.PNG)

## OpenWeather Service

Based on the data from the "data.xml" file, the application sends a request to the OpenWeather.org service and retrieves weather data for a specific city.


## Endpoints

The application provides 3 endpoints. Two of them are based on REST and one is based on SOAP.

* __REST__
  -> "/cities"

Allows you to retrieve all available cities (contained in the data.xml file).

![getCities](https://github.com/swietlik23/weather-app-backend/blob/master/imagesToReadme/getCities.PNG)

-> "/forecasts"

Allows you to download weather conditions for one or more cities.

![forecast](https://github.com/swietlik23/weather-app-backend/blob/master/imagesToReadme/forecast.PNG)

* __SOAP__

"/soap"

Allows to download weather conditions for one city according to SOAP protocol. Your request body should contain fields "cityName" and "correlationId".

![soap](https://github.com/swietlik23/weather-app-backend/blob/master/imagesToReadme/soap.PNG)

## Swagger

For the REST service a Swagger documentation is created. It is available under the endpoint "/swagger-ui.html#".

![swagger](https://github.com/swietlik23/weather-app-backend/blob/master/imagesToReadme/swagger.PNG)


## Heroku

The application has been posted on Heroku.

You can test the above functionality in real time.

Click on the link below to check it out!

https://weather-service-backend.herokuapp.com/swagger-ui.html#/