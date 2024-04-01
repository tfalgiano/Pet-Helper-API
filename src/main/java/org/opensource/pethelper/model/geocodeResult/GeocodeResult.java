package org.opensource.pethelper.model.geocodeResult;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeResult {
    @JsonProperty("formatted_address")
    private String formattedAddress;
    private Geometry geometry;
    private String place_id;
}
