
package com.kris.weather.model.oceanography;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "city", "country", "elevation", "latitude", "longitude" })
public class OceanoForecast {

	@JsonProperty("city")
	private String city;
	@JsonProperty("country")
	private String country;
	@JsonProperty("elevation")
	private Integer elevation;
	@JsonProperty("latitude")
	private Double latitude;
	@JsonProperty("longitude")
	private Double longitude;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("elevation")
	public Integer getElevation() {
		return elevation;
	}

	@JsonProperty("elevation")
	public void setElevation(Integer elevation) {
		this.elevation = elevation;
	}

	@JsonProperty("latitude")
	public Double getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longitude")
	public Double getLongitude() {
		return longitude;
	}

	@JsonProperty("longitude")
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
