
package com.kris.weather.model.geography;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "geoPoints",
    "name:"
})
public class Hemisphere {

    @JsonProperty("geoPoints")
    private List<GeoPoint> geoPoints = null;
    @JsonProperty("name:")
    private String name;

    @JsonProperty("geoPoints")
    public List<GeoPoint> getGeoPoints() {
        return geoPoints;
    }

    @JsonProperty("geoPoints")
    public void setGeoPoints(List<GeoPoint> geoPoints) {
        this.geoPoints = geoPoints;
    }

    @JsonProperty("name:")
    public String getName() {
        return name;
    }

    @JsonProperty("name:")
    public void setName(String name) {
        this.name = name;
    }

/*    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }*/

}
