package com.kris.weather.rules.impl;

import java.util.Random;

import com.kris.weather.model.WeatherModel;
import com.kris.weather.rules.IWeatherRule;

public class TopographyRules implements IWeatherRule {

	@Override
	public WeatherModel performRule(WeatherModel input) {
		// TODO Auto-generated method stub

		// Humidity based on topography
		double humidity = input.getHumidity();
		String condition = "SUNNY";
		String topography = getRandomTopography();
		if (topography.equals("plains"))
			humidity += 0;
		if (topography.equals("mountains"))
			humidity += 15;
		if (topography.equals("oceans"))
			humidity += 25;

		input.setHumidity(humidity);

		// Set condition
		if (humidity <= 60)
			condition = "SUNNY";
		else if (humidity > 60 && humidity <= 80)
			condition = "CLOUDY";
		else if (humidity > 80)
			condition = "RAINY";

		input.setCondition(condition);
		return input;

	}

	private String getRandomTopography() {
		final String[] topography = { "plains", "mountains", "waterbodies" };
		int idx = new Random().nextInt(topography.length);
		String random = (topography[idx]);

		return random;
	}
}
