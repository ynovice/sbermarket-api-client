package com.github.ynovice;

import com.github.ynovice.model.StoreDetailedInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.Objects;

@Getter
@Setter
public abstract class SbermarketApiClient {

    protected double lat;
    protected double lon;
    protected String[] headers;

    protected final Duration timeout;

    public SbermarketApiClient(double lat, double lon, String[] headers, Duration timeout) {

        if(headers == null) headers = new String[0];
        Objects.requireNonNull(timeout, "Timeout cannot be null.");

        this.lat = lat;
        this.lon = lon;
        this.headers = headers;
        this.timeout = timeout;
    }

    public abstract StoreDetailedInfo getStoreDetailedInfoById(int storeId);
}
