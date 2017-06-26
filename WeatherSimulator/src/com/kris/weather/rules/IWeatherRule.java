package com.kris.weather.rules;

import com.kris.weather.model.WeatherModel;

public interface IWeatherRule {
	WeatherModel performRule(WeatherModel input) throws Exception;

}
