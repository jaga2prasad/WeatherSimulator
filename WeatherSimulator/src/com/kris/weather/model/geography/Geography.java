
package com.kris.weather.model.geography;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "weatherforecast" })
public class Geography {

	@JsonProperty("weatherforecast")
	private List<Weatherforecast> weatherforecast = null;

	@JsonProperty("weatherforecast")
	public List<Weatherforecast> getWeatherforecast() {
		return weatherforecast;
	}

	@JsonProperty("weatherforecast")
	public void setWeatherforecast(List<Weatherforecast> weatherforecast) {
		this.weatherforecast = weatherforecast;
	}

	/*
	 * @Override public String toString() { return
	 * ToStringBuilder.reflectionToString(this); }
	 */

}
