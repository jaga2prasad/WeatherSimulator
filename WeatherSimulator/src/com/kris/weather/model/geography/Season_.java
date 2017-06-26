
package com.kris.weather.model.geography;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "month", "temperature" })
public class Season_ {

	@JsonProperty("month")
	private String month;
	@JsonProperty("temperature")
	private Double temperature;

	@JsonProperty("month")
	public String getMonth() {
		return month;
	}

	@JsonProperty("month")
	public void setMonth(String month) {
		this.month = month;
	}

	@JsonProperty("temperature")
	public Double getTemperature() {
		return temperature;
	}

	@JsonProperty("temperature")
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	/*
	 * @Override public String toString() { return
	 * ToStringBuilder.reflectionToString(this); }
	 */

}
