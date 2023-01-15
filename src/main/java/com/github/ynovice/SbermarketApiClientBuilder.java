package com.github.ynovice;

import com.github.ynovice.util.HttpUtils;

import java.net.http.HttpClient;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class SbermarketApiClientBuilder {

    private final static Duration DEFAULT_TIMEOUT = Duration.of(10, ChronoUnit.SECONDS);
    private final static HttpUtils httpUtils = new HttpUtils();

    private final double lat;
    private final double lon;

    private ModelMapper modelMapper;
    private HttpClient httpClient;

    private final HashMap<String, String> headers = new HashMap<>();

    {
        modelMapper = new ModelMapperJackson();
        httpClient = HttpClient
                .newBuilder()
                .connectTimeout(DEFAULT_TIMEOUT)
                .version(HttpClient.Version.HTTP_2)
                .build();

        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Accept-Encoding", "UTF-8");
        headers.put("api-version", "3.0");
        headers.put("client-token", "7ba97b6f4049436dab90c789f946ee2f");
    }

    public SbermarketApiClientBuilder(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public SbermarketApiClientBuilder header(String name, String value) {
        validateHeader(name, value);
        this.headers.put(name, value);
        return this;
    }

    public SbermarketApiClientBuilder headers(Map<String, String> headers) {

        if(headers != null) {
            headers.forEach(this::validateHeader);
            this.headers.putAll(headers);
        }

        return this;
    }

    public SbermarketApiClientBuilder modelMapper(ModelMapper modelMapper) {
        Objects.requireNonNull(modelMapper, "ModelMapper cannot be null.");
        this.modelMapper = modelMapper;
        return this;
    }

    public SbermarketApiClientBuilder httpClient(HttpClient httpClient) {
        Objects.requireNonNull(httpClient, "HttpClient cannot be null.");
        this.httpClient = httpClient;
        return this;
    }

    public SbermarketApiClient build() {

        String[] headersArray = headers.entrySet()
                .stream()
                .flatMap(entry -> Stream.of(entry.getKey(), entry.getValue()))
                .toList()
                .toArray(new String[0]);

        return new SbermarketApiClientV3(lat, lon, headersArray, modelMapper, httpClient);
    }


    private void validateHeader(String name, String value) {

        if(name == null || !httpUtils.isValidHeaderName(name))
            throw new IllegalArgumentException("Invalid header name: " + name);

        if(!httpUtils.isHeaderAllowed(name))
            throw new IllegalArgumentException("Restricted header name: " + name);

        if(value == null || !httpUtils.isValidHeaderValue(value))
            throw new IllegalArgumentException(String.format("Invalid value of header %s: %s", name, value));
    }
}
