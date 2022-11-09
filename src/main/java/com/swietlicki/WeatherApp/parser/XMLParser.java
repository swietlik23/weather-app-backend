package com.swietlicki.WeatherApp.parser;

import com.swietlicki.WeatherApp.model.City;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    private final static String fileName = "data.xml";

    public static List<City> parseXMLToList() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        List<City> cities = new ArrayList<>();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            NodeList citiesList = doc.getElementsByTagName("City");
            for (int i = 0; i < citiesList.getLength(); i++) {
                Node currentNode = citiesList.item(i);
                if (currentNode.getNodeType() == Node.ELEMENT_NODE && currentNode.hasAttributes()) {
                    Element cityElement = (Element) currentNode;
                    String cityName = cityElement.getAttribute("name");
                    double latitude = Double.parseDouble(cityElement.getAttribute("latitude"));
                    double longitude = Double.parseDouble(cityElement.getAttribute("longitude"));
                    City city = new City(cityName, latitude,longitude);
                    cities.add(city);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }
}
