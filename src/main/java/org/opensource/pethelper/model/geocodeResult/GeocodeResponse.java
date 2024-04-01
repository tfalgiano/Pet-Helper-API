package org.opensource.pethelper.model.geocodeResult;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeocodeResponse {
    private List<GeocodeResult> results;
    private String status;
}
