package com.kris.weather.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.kris.weather.model.WeatherModel;
import com.kris.weather.rules.IWeatherRule;
import com.kris.weather.rules.WeatherRules;
import com.kris.weather.util.WeatherUtil;

public class WeatherRunner {
	
	public static void main(String[] args) {

		WeatherModel weatherModel = null;
		String data[]; 
		WeatherUtil.Inputvalidator validator = new WeatherUtil.Inputvalidator();
		List<String> inputs = null;
		StringBuffer errorInputs = new StringBuffer();
		StringBuffer sbfWeatherData = new StringBuffer();

		
		try {
		 inputs = Files.readAllLines(Paths.get("./resource/input.txt"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		for (String s: inputs) {
			try {
			s = s.replace(",", "|");
			data = s.split("\\|");
			// validate and set city, latitude, longitude and time 
			weatherModel = validator.validate(data);
			if (weatherModel == null) {
				errorInputs.append(s).append("\n");
				continue;
			}
			
			callRules(weatherModel);
			
			sbfWeatherData.append(weatherModel.toString()).append("\n");
			
		} catch (Exception e) {
			errorInputs.append(s).append("\n");	
			e.printStackTrace();
		}
		}
		
		try {
			Files.write(Paths.get("./resource/output.txt"), sbfWeatherData.toString().getBytes());
			Files.write(Paths.get("./resource/weathersimulator.bad"), errorInputs.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		System.out.println("Processed! Check the resource Directory");
		
	}
	
    public static void callRules(WeatherModel wft) throws Exception{
    	  for (IWeatherRule rule : WeatherRules.values()) {
    		  rule.performRule(wft);
          }
    }
}
