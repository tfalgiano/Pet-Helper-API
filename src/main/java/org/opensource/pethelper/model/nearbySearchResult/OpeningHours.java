package org.opensource.pethelper.model.nearbySearchResult;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpeningHours {
    @JsonProperty("open_now")
    private boolean openNow;
}
