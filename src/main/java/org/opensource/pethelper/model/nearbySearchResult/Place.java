package org.opensource.pethelper.model.nearbySearchResult;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {
    private String name;
    private String vicinity;
    private Geometry geometry;
    @JsonProperty("opening_hours")
    private OpeningHours openingHours; 
    private Float rating;
    @JsonProperty("user_ratings_total")
    private String userRatingsTotal;
    @JsonProperty("place_id")
    private String placeId;
}
