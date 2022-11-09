
package com.swietlicki.WeatherApp.soap.model;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="forecastDTO" type="{http://swietlicki.com/soap2}forecastDTO"/&gt;
 *         &lt;element name="correlationId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "forecastDTO",
    "correlationId"
})
@XmlRootElement(name = "getForecastResponse", namespace = "http://swietlicki.com/soap2")
public class GetForecastResponse {

    @XmlElement(required = true)
    protected ForecastDTO forecastDTO;
    @XmlElement(required = true)
    protected String correlationId;

    /**
     * Gets the value of the forecastDTO property.
     * 
     * @return
     *     possible object is
     *     {@link ForecastDTO }
     *     
     */
    public ForecastDTO getForecastDTO() {
        return forecastDTO;
    }

    /**
     * Sets the value of the forecastDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastDTO }
     *     
     */
    public void setForecastDTO(ForecastDTO value) {
        this.forecastDTO = value;
    }

    /**
     * Gets the value of the correlationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets the value of the correlationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

}
