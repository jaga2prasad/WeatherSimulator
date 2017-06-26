package com.kris.weather.util;

import com.kris.weather.model.WeatherModel;

public interface IValidator {
	WeatherModel validate(String[] data);
}
