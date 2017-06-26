
package com.kris.weather.model.oceanography;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "OceanoForecast" })
public class Oceanography {

	@JsonProperty("OceanoForecast")
	private List<OceanoForecast> oceanoForecast = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("OceanoForecast")
	public List<OceanoForecast> getOceanoForecast() {
		return oceanoForecast;
	}

	@JsonProperty("OceanoForecast")
	public void setOceanoForecast(List<OceanoForecast> oceanoForecast) {
		this.oceanoForecast = oceanoForecast;
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
