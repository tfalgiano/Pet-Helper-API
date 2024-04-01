package org.opensource.pethelper.services;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.opensource.pethelper.enums.Pets;
import org.opensource.pethelper.enums.Services;
import org.opensource.pethelper.model.geocodeResult.GeocodeResponse;
import org.opensource.pethelper.model.nearbySearchResult.NearbySearchResponse;
import org.opensource.pethelper.utility.Utility;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LocationService {
    private static final String API_KEY = "AIzaSyAcfgs-rUM9pgRWjrZQOem7Gs0v-1-lwjI";

    public GeocodeResponse getGeocodeFromZip(String zipCode) {
        GeocodeResponse geocodeResponse = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                            String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s",
                                    zipCode, API_KEY)))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            geocodeResponse = new ObjectMapper().readValue(response.body(), GeocodeResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return geocodeResponse;
    }

    public NearbySearchResponse getGeocodeData(String zipCode, Services service, Pets pet) {
        GeocodeResponse geocodeResponse = getGeocodeFromZip(zipCode);
        String encodedKeywords = URLEncoder.encode(buildKeywordString(service, pet), StandardCharsets.UTF_8);

        HttpClient client = HttpClient.newHttpClient();
        String uri = String.format(
                "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s,%s&radius=%d&keyword=%s&key=%s",
                geocodeResponse.getResults().get(0).getGeometry().getLocation().getLat(),
                geocodeResponse.getResults().get(0).getGeometry().getLocation().getLng(),
                5000,
                encodedKeywords,
                API_KEY);

        if (service.equals(Services.STORE)) {
            uri += "&type=pet_store";
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        NearbySearchResponse nearbySearchResponse = null;
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            nearbySearchResponse = new ObjectMapper().readValue(response.body(), NearbySearchResponse.class);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return nearbySearchResponse;
    }

    private String buildKeywordString(Services service, Pets pet) {
        StringBuilder keywordsBuilder = new StringBuilder();
        if (service != null) {
            keywordsBuilder.append(Utility.formatEnumName(service));
        }
        if (pet != null) {
            if (keywordsBuilder.length() > 0) {
                keywordsBuilder.append(" ");
            }
            keywordsBuilder.append(Utility.formatEnumName(pet));
        }
        return keywordsBuilder.toString();
    }
}
