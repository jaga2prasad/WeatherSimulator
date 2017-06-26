package com.kris.weather.model;

import java.time.ZonedDateTime;

public class WeatherModel {

	private String city;
	private double latitude;
	private double longitude;
	private double elevation;
	private ZonedDateTime time;
	private String condition;
	private double temperature;
	private double pressure;
	private double humidity;

	private String location;

	public WeatherModel() {
	}

	public WeatherModel(String city, double latitude, double longitude, ZonedDateTime time) {
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.time = time;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getElevation() {
		return elevation;
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;
	}

	public ZonedDateTime getTime() {
		return time;
	}

	public void setTime(ZonedDateTime time) {
		this.time = time;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		StringBuffer sbf = new StringBuffer();
		String delimiter = "|";

		sbf.append(this.city).append(delimiter).append(this.latitude).append(",").append(this.longitude).append(",")
				.append(this.elevation).append(delimiter).append(this.time).append(delimiter).append(this.condition)
				.append(delimiter).append(this.temperature).append(delimiter).append(this.pressure).append(delimiter)
				.append(this.humidity);
		return sbf.toString();
	}
}
