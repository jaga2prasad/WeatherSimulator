
package com.kris.weather.model.geography;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "hemisphere" })
public class Weatherforecast {

	@JsonProperty("hemisphere")
	private List<Hemisphere> hemisphere = null;

	@JsonProperty("hemisphere")
	public List<Hemisphere> getHemisphere() {
		return hemisphere;
	}

	@JsonProperty("hemisphere")
	public void setHemisphere(List<Hemisphere> hemisphere) {
		this.hemisphere = hemisphere;
	}

}
