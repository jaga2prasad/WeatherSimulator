package com.kris.weather.rules.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.kris.weather.model.WeatherModel;
import com.kris.weather.model.geography.GeoPoint;
import com.kris.weather.model.geography.Geography;
import com.kris.weather.model.geography.Hemisphere;
import com.kris.weather.model.geography.Season;
import com.kris.weather.model.geography.Season_;
import com.kris.weather.model.geography.Weatherforecast;
import com.kris.weather.rules.IWeatherRule;
import com.kris.weather.util.WeatherConstants;
import com.kris.weather.util.WeatherUtil;

public class GeographyRules implements IWeatherRule {

	public WeatherModel performRule(WeatherModel input) throws Exception {

		return getTemperature(input);
	}

	private WeatherModel getTemperature(WeatherModel input) throws Exception {

		Geography geography = WeatherUtil.getGeographyJSON();
		double latitude = input.getLatitude();
		Hemisphere hemisphere = null;
		String month;
		GeoPoint geoPoint;
		double temperature = 0;

		Map<String, Hemisphere> HemisphereMap = new HashMap<String, Hemisphere>();

		for (Weatherforecast forecast : geography.getWeatherforecast()) {
			for (Hemisphere hemisphereItr : forecast.getHemisphere()) {
				HemisphereMap.put(hemisphereItr.getName(), hemisphereItr);
			}
		}
		// get Hemisphere
		hemisphere = HemisphereMap
				.get(latitude >= 0 ? WeatherConstants.NORTHERNHEMISPHERE : WeatherConstants.SOUTHERNHEMISPHERE);

		// get Month
		month = input.getTime().getMonth().name();

		// get GeoPoints
		List<GeoPoint> lstGP = hemisphere.getGeoPoints();
		GeoPoint nextGeoPoint = new GeoPoint();
		geoPoint = new GeoPoint();
		List<Season> lstSeason = new ArrayList<Season>();
		boolean flag = false;
		for (int i = 0; i <= lstGP.size(); i++) {

			GeoPoint gp = lstGP.get(i);
			nextGeoPoint = gp;
			if (flag)
				break;
			if (latitude < gp.getDegrees()) {
				geoPoint = gp;
				flag = true;
			}

		}

		// Get Closest GeoPoint
		geoPoint = closestDegree(geoPoint, nextGeoPoint, latitude);

		// Get Season and temperature
		lstSeason = geoPoint.getSeasons();
		for (Season seasons : lstSeason) {
			for (Season_ season : seasons.getSeason()) {
				if (month.equalsIgnoreCase(season.getMonth())) {
					temperature = season.getTemperature();
				}

			}
		}

		// Temperature adjustments
		Random random = new Random();
		double randomNumber = random.nextInt(5);
		temperature += randomNumber;

		// AM PM

		// if(input.getTime().get(Calendar.AM_PM) ==
		// Calendar.PM)temperature+=-1;

		input.setTemperature(temperature);

		return input;
	}

	private GeoPoint closestDegree(GeoPoint g1, GeoPoint g2, double latitude) {
		return (Math.abs(g1.getDegrees() - latitude) <= Math.abs(g2.getDegrees() - latitude)) ? g1 : g2;

	}
}
