package com.kris.weather.rules;

import com.kris.weather.model.WeatherModel;
import com.kris.weather.rules.impl.GeographyRules;
import com.kris.weather.rules.impl.OceanographyRules;

public enum WeatherRules implements IWeatherRule {

	GEOGRAPHY {
		@Override
		public WeatherModel performRule(WeatherModel input) throws Exception {
			return new GeographyRules().performRule(input);
		}
	},
	OCEANOGRAPHY {
		@Override
		public WeatherModel performRule(WeatherModel input) throws Exception {
			return new OceanographyRules().performRule(input);
		}
	}
}
