package com.kris.weather.rules.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kris.weather.model.WeatherModel;
import com.kris.weather.model.geography.Weatherforecast;
import com.kris.weather.model.oceanography.OceanoForecast;
import com.kris.weather.model.oceanography.Oceanography;
import com.kris.weather.rules.IWeatherRule;
import com.kris.weather.util.WeatherUtil;

public class OceanographyRules implements IWeatherRule {

	@Override
	public WeatherModel performRule(WeatherModel input) throws Exception {
		return getWeather(input);
	}

	private WeatherModel getWeather(WeatherModel model) throws Exception {
		Oceanography oceanography = WeatherUtil.getOceanographyJSON();
		double elevation = 0;
		double airPressure;
		double humidity = 50; // base humidity
		double temperature;

		// if the city is present, we will take the air pressure and other data,
		// else we will see the coordinates.
		for (OceanoForecast oceano : oceanography.getOceanoForecast()) {
			if (model.getCity().equalsIgnoreCase(oceano.getCity())) {
				elevation = oceano.getElevation();
			}
		}

		// get airPressure, humidty an temperature

		ElevationMap map = populatePressureData();
		WeatherParams weatherParams = (WeatherParams) map.getValueFor(elevation);
		airPressure = weatherParams.airPressure;
		humidity = humidity + weatherParams.getHumidity();
		temperature = model.getTemperature() + weatherParams.getTemperature();

		model.setPressure(airPressure);
		model.setTemperature(temperature);
		model.setHumidity(humidity);
		model.setElevation(elevation);

		return model;
	}

	private ElevationMap populatePressureData() {
		ElevationMap map = new ElevationMap();
		map.put(-200, 0, new WeatherParams(1010, 0.5, 30));
		map.put(0, 200, new WeatherParams(1012, 0, 15));
		map.put(200, 400, new WeatherParams(1014, -0.5, 10));
		map.put(400, 600, new WeatherParams(1016, -1, 5));
		map.put(600, 800, new WeatherParams(1018, -1.5, 0));
		map.put(800, 1000, new WeatherParams(1020, -2, 10));
		map.put(1000, 1200, new WeatherParams(1010, -2.5, 15));
		map.put(1200, 1400, new WeatherParams(1000, -3, 15));
		map.put(1400, 1600, new WeatherParams(990, -3.5, 20));
		map.put(1600, 1800, new WeatherParams(980, -4, 25));
		map.put(1800, 2000, new WeatherParams(970, -4.5, 30));
		map.put(2000, 10000, new WeatherParams(960, -5, 35));
		return map;
	}

}

class WeatherParams {
	double airPressure;
	double temperature;
	double humidity;

	public WeatherParams(double airPressure, double temperature, double humidity) {
		this.airPressure = airPressure;
		this.temperature = temperature;
		this.humidity = humidity;

	}

	public double getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(double airPressure) {
		this.airPressure = airPressure;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
}

class ElevationMap {
	static class RangeEntry {
		private final double lower;
		private final double upper;
		private final Object value;

		public RangeEntry(double lower, double upper, Object mappedValue) {
			this.lower = lower;
			this.upper = upper;
			this.value = mappedValue;
		}

		public boolean matches(double value) {
			return value >= lower && value <= upper;
		}

		public Object getValue() {
			return value;
		}
	}

	private final List<RangeEntry> entries = new ArrayList<RangeEntry>();

	public void put(double lower, double upper, Object mappedValue) {
		entries.add(new RangeEntry(lower, upper, mappedValue));
	}

	public Object getValueFor(double key) {
		for (RangeEntry entry : entries) {
			if (entry.matches(key))
				return entry.getValue();
		}
		return null;
	}
}
