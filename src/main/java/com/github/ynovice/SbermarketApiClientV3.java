package com.github.ynovice;

import com.github.ynovice.model.StoreDetailedInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Objects;

@Getter
@Setter
public class SbermarketApiClientV3 extends SbermarketApiClient {

    private final static String BASE_URL = "https://sbermarket.ru/api";

    private final HttpClient httpClient;
    private final ModelMapper modelMapper;

    public SbermarketApiClientV3(double lat, double lon, Duration timeout, String[] headers, ModelMapper modelMapper) {

        super(lat, lon, headers, timeout);

        Objects.requireNonNull(modelMapper, "ModelMapper cannot be null.");

        this.modelMapper = modelMapper;

        httpClient = HttpClient
                .newBuilder()
                .connectTimeout(timeout)
                .version(HttpClient.Version.HTTP_2)
                .build();
    }

    public StoreDetailedInfo getStoreDetailedInfoById(int storeId) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL + "/stores/" + storeId))
                    .headers(headers)
                    .GET()
                    .build();

            try {
                HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                String storeJson = httpResponse.body();

                return modelMapper.map(storeJson, StoreDetailedInfo.class, "store");

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}