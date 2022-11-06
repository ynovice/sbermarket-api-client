package com.github.ynovice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SbermarketApiClientBuilderTest {

    private SbermarketApiClientBuilder builder;

    private final double LAT = 25.23423;
    private final double LON = 27.129837;

    private final Map<String, String> validHeaders;
    {
        validHeaders = new HashMap<>();
        validHeaders.put("valid-header-1", "value-1");
        validHeaders.put("blank-value-header", "");
    }

    private final Map<String, String> invalidHeaders;
    {
        invalidHeaders = new HashMap<>();
        invalidHeaders.put("", "v");
        invalidHeaders.put("   ", "v");
        invalidHeaders.put(null, "v");
        invalidHeaders.put("header-with-invalid-value", null);
        invalidHeaders.put("Connection", "v");
        invalidHeaders.put("Content-Length", "v");
        invalidHeaders.put("Expect", "v");
        invalidHeaders.put("Host", "v");
        invalidHeaders.put("Upgrade", "v");
    }

    @BeforeEach
    public void initBuilder() {
        builder = new SbermarketApiClientBuilder(LAT, LON);
    }

    @Test
    public void testSetLatLon() {

        SbermarketApiClient client = builder.build();

        assertEquals(LAT, client.getLat());
        assertEquals(LON, client.getLon());
    }

    @Test
    public void testSetTimeout() {

        Duration timeout = Duration.of(333, ChronoUnit.SECONDS);

        // test null timeout
        assertThrows(NullPointerException.class, () -> builder.timeout(null));

        // test valid timeout
        assertDoesNotThrow(() -> builder.timeout(timeout));
        SbermarketApiClient client = builder.build();
        assertEquals(timeout, client.getTimeout());
    }

    @Test
    public void testSetInvalidHeader() {

        invalidHeaders.forEach((name, value) ->
                assertThrows(
                        IllegalArgumentException.class,
                        () -> builder.header(name, value),
                        String.format("Expected java.lang.IllegalArgumentException to be thrown, \n" +
                                "but nothing was thrown. Header name: '%s', header value: '%s'", name, value)
                )
        );

        SbermarketApiClient client = builder.build();

        for(int i = 0; i < client.getHeaders().length; i += 2) {
            assertFalse(invalidHeaders.containsKey(client.getHeaders()[i]));
        }
    }

    @Test
    public void testSetValidHeader() {

        validHeaders.forEach((name, value) -> assertDoesNotThrow(() -> builder.header(name, value)));

        SbermarketApiClient client = builder.build();

        List<String> headers = Arrays.asList(client.getHeaders());
        validHeaders.forEach((name, value) -> {
            int headerIndex = headers.indexOf(name);
            assertEquals(0, headerIndex % 2);
            assertEquals(value, headers.get(headerIndex + 1));
        });
    }

    @Test
    public void testSetValidHeaderWithOverride() {

        String headerName = validHeaders.entrySet().stream().findFirst().get().getKey();
        String newHeaderValue = "new-value-aaqqweoq[wepoq[";

        assertDoesNotThrow(() -> builder.header(headerName, "old-value"));
        assertDoesNotThrow(() -> builder.header(headerName, newHeaderValue));

        SbermarketApiClient client = builder.build();

        List<String> headers = Arrays.asList(client.getHeaders());
        int headerIndex = headers.indexOf(headerName);

        assertEquals(0, headerIndex % 2);
        assertEquals(newHeaderValue, headers.get(headerIndex + 1));
    }

    @Test
    public void testSetMultipleHeadersInvalid() {

        String validHeaderName = validHeaders.entrySet().stream().findFirst().get().getKey() + "ajsdai9d8j13d129e";

        Map<String, String> invalidHeadersButOneValid = new HashMap<>(invalidHeaders);
        invalidHeadersButOneValid.put(validHeaderName, "valid-value");

        assertThrows(IllegalArgumentException.class, () -> builder.headers(invalidHeadersButOneValid));

        SbermarketApiClient client = builder.build();

        List<String> headers = Arrays.asList(client.getHeaders());
        assertFalse(headers.contains(validHeaderName));
    }

    @Test
    public void testSetMultipleHeadersValid() {

        assertDoesNotThrow(() -> builder.headers(validHeaders));

        SbermarketApiClient client = builder.build();

        List<String> headers = Arrays.asList(client.getHeaders());
        validHeaders.forEach((name, value) -> {
            int headerIndex = headers.indexOf(name);
            assertEquals(0, headerIndex % 2);
            assertEquals(value, headers.get(headerIndex + 1));
        });
    }

    @Test
    public void testSetModelMapper() {


    }
}