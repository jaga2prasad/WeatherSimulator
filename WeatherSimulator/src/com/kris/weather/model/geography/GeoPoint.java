
package com.kris.weather.model.geography;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "degrees", "geoPoint", "seasons" })
public class GeoPoint {

	@JsonProperty("degrees")
	private Double degrees;
	@JsonProperty("geoPoint")
	private String geoPoint;
	@JsonProperty("seasons")
	private List<Season> seasons = null;

	@JsonProperty("degrees")
	public Double getDegrees() {
		return degrees;
	}

	@JsonProperty("degrees")
	public void setDegrees(Double degrees) {
		this.degrees = degrees;
	}

	@JsonProperty("geoPoint")
	public String getGeoPoint() {
		return geoPoint;
	}

	@JsonProperty("geoPoint")
	public void setGeoPoint(String geoPoint) {
		this.geoPoint = geoPoint;
	}

	@JsonProperty("seasons")
	public List<Season> getSeasons() {
		return seasons;
	}

	@JsonProperty("seasons")
	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}

	/*
	 * @Override public String toString() { return
	 * ToStringBuilder.reflectionToString(this); }
	 */

}
