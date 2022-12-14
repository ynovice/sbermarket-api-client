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
import java.util.Objects;

@Getter
@Setter
public class SbermarketApiClientV3 extends SbermarketApiClient {

    private final static String BASE_URL = "https://sbermarket.ru/api";

    private final ModelMapper modelMapper;

    /*
        Fields that are initialized inside the constructor
     */
    private final HttpClient httpClient;
    private final UnsuccessfulHttpResponseExceptionFactory<String> exceptionFactory;

    public SbermarketApiClientV3(double lat,
                                 double lon,
                                 String[] headers,
                                 ModelMapper modelMapper,
                                 HttpClient httpClient) {

        super(lat, lon, headers);

        Objects.requireNonNull(modelMapper, "ModelMapper cannot be null.");

        this.modelMapper = modelMapper;
        this.httpClient = httpClient;

        exceptionFactory = new UnsuccessfulHttpResponseExceptionFactoryImpl(modelMapper);
    }

    public StoreDetailedInfo getStoreDetailedInfoById(int storeId) throws IOException, InterruptedException {

        String finalUrl = BASE_URL + "/stores/" + storeId;

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(createUri(finalUrl))
                .headers(headers)
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if(httpResponse.statusCode() != 200) {
            throw exceptionFactory.nexException(httpResponse);
        }

        return modelMapper.map(httpResponse.body(), StoreDetailedInfo.class, "store");
    }

    private URI createUri(String url) {
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return uri;
    }
}