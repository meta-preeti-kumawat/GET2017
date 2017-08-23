package com.metacube.webservices;

import DefaultNamespace.Temperature;
import DefaultNamespace.TemperatureServiceLocator;

public class WSClient {
	
	public static void main(String[] args) {
		TemperatureServiceLocator temperatureServiceLocator = new TemperatureServiceLocator();
		temperatureServiceLocator.setTemperatureEndpointAddress("http://localhost:8080/WEB-SERVICE-SERVER/services/Temperature");
		
		try{
			Temperature temperature = temperatureServiceLocator.getTemperature();
			
			double fahrenheit = 34;
			System.out.println(temperature.convertFahrenheitToCelsius(fahrenheit));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
