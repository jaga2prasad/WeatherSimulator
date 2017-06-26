
package com.kris.weather.model.geography;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "season" })
public class Season {

	@JsonProperty("season")
	private List<Season_> season = null;

	@JsonProperty("season")
	public List<Season_> getSeason() {
		return season;
	}

	@JsonProperty("season")
	public void setSeason(List<Season_> season) {
		this.season = season;
	}

}
