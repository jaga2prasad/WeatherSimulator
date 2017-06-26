package com.kris.weather.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kris.weather.model.WeatherModel;
import com.kris.weather.model.geography.Geography;
import com.kris.weather.model.geography.Weatherforecast;

public class WeatherUtil {
//String to iso
	
	public static String toISO8601UTC(ZonedDateTime date) throws Exception{
	
		return DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(date);
		
		}

	public static ZonedDateTime fromISO8601UTC(String dateStr) throws Exception{
		
		ZonedDateTime date = null;

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		
		Date input = format.parse(dateStr);
		 date = input.toInstant().atZone(ZoneId.systemDefault());
		
	
		// DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd'T' hh:mm:ssz");		    
		 
		// date = ZonedDateTime.parse(dateStr, timeFormatter);
	
		  return date;
		}
	
	public static class Inputvalidator implements IValidator {

		@Override
		public WeatherModel validate(String[] data) {
			WeatherModel model = null;
			boolean valid = false;
			String city = null;
			double latitude;
			double longitude;
			ZonedDateTime date = null;
			
			try {
			for(int i=0; i<=3; i++){ 
				  if(data[i]!=null){
					  valid = true;
				  }
				  }
			
			if (valid) {
				city = data[0];
				latitude = Double.parseDouble(data[1]);
				longitude = Double.parseDouble(data[2]);
				if ((latitude >=-90  && latitude <=90) && (longitude >=-180 && longitude <=180)) {
					date = fromISO8601UTC(data[3]);
					valid = (date!=null);
				} else valid = false;
				
				if (valid) {
					model = new WeatherModel();
					model.setCity(city);
					model.setLatitude(latitude);
					model.setLongitude(longitude);
					model.setTime(date);
				}
			}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		return model;

		}
		
	}
	
	public static Geography getGeographyJSON() throws JsonParseException, JsonMappingException, MalformedURLException, IOException{
		  ObjectMapper mapper = new ObjectMapper();
	      mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	     
	      
	      File file = getResourceFile("./resource/geography.json");
	      Geography geo = mapper.readValue(file,Geography.class);
	      Weatherforecast datasets = geo.getWeatherforecast().get(0);
	 return geo;
	}
	
	public static File readInputs(String strFile) throws Exception {
		File file = getResourceFile(strFile);
		return file;
	}
	private static File getResourceFile(String fileName) {
		return Paths.get(fileName).toFile();
		/*ClassLoader classLoader = new WeatherUtil().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		 return file;*/
	}
	public static final String NORTHERNHEMISPHERE = "northernhemisphere";
	public static final String SOUTHERNHEMISPHERE = "southernhemisphere";

}
