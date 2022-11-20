package com.github.ynovice;

import com.github.ynovice.model.StoreDetailedInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public abstract class SbermarketApiClient {

    protected double lat;
    protected double lon;
    protected String[] headers;

    public SbermarketApiClient(double lat, double lon, String[] headers) {

        if(headers == null) headers = new String[0];

        this.lat = lat;
        this.lon = lon;
        this.headers = headers;
    }

    /**
     * Sends http request to Sbermarket API and returns the detailed information about a store by its id.
     * Does not require authorization or authentication.
     * @param storeId The store id.
     * @return {@code StoreDetailedInfo} instance corresponding to the store with the given id.
     * @throws IOException If an I/O error occurs when sending request or receiving response,
                           or if the body of http response from Sbermarket API can not be
                           mapped to the {@code StoreDetailedInfo} instance.
     * @throws InterruptedException If the operation of sending http request or receiving http response is interrupted.
     */
    public abstract StoreDetailedInfo getStoreDetailedInfoById(int storeId) throws IOException, InterruptedException;
}
