
package com.swietlicki.WeatherApp.soap.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for forecastDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="forecastDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cityName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="temperatureInCelsius" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="weatherDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "forecastDTO", namespace = "http://swietlicki.com/soap2", propOrder = {
    "cityName",
    "temperatureInCelsius",
    "weatherDescription"
})
public class ForecastDTO {

    @XmlElement(required = true)
    protected String cityName;
    protected double temperatureInCelsius;
    @XmlElement(required = true)
    protected String weatherDescription;

    /**
     * Gets the value of the cityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the temperatureInCelsius property.
     * 
     */
    public double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    /**
     * Sets the value of the temperatureInCelsius property.
     * 
     */
    public void setTemperatureInCelsius(double value) {
        this.temperatureInCelsius = value;
    }

    /**
     * Gets the value of the weatherDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeatherDescription() {
        return weatherDescription;
    }

    /**
     * Sets the value of the weatherDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeatherDescription(String value) {
        this.weatherDescription = value;
    }

}
