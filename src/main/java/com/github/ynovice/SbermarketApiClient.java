package com.github.ynovice;

import com.github.ynovice.model.*;
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

    /**
     * Sends http request to Sbermarket API and returns the detailed information about a retailer by its id.
     * Does not require authorization or authentication.
     * @param retailerId The store id.
     * @return {@code RetailerDetailedInfo} instance corresponding to the retailer with the given id.
     * @throws IOException If an I/O error occurs when sending request or receiving response,
                           or if the body of http response from Sbermarket API can not be
                           mapped to the {@code RetailerDetailedInfo} instance.
     * @throws InterruptedException If the operation of sending http request or receiving http response is interrupted.
     */
    public abstract RetailerDetailedInfo getRetailerDetailedInfoById(int retailerId)
            throws IOException, InterruptedException;

    /**
     * Sends http request to Sbermarket API and returns an object containing lists of all the categories present in the
     * store with the given id.
     * Requires client authorization: "client-token" header must be present in a request.
     * @param storeId The store id;
     * @return {@code CategoriesResponseBody} instance containing the list of all the categories present in the
     *         store with the given id.
     * @throws IOException If an I/O error occurs when sending request or receiving response,
     *                     or if the body of http response from Sbermarket API can not be
     *                     mapped to the {@code CategoriesResponseBody} instance.
     * @throws InterruptedException If the operation of sending http request or receiving http response is interrupted.
     */
    public abstract CategoriesResponseBody getCategoriesByStoreId(int storeId) throws IOException, InterruptedException;

    /**
     * Sends http request to Sbermarket API and returns an object containing list of products present in the
     * store with the given id from the category with the given slug.
     * Requires client authorization: "client-token" header must be present in a request.
     * @param storeId The store id.
     * @param categorySlug The slug (tid) of the products' category.
     * @param page The number of the needed page.
     * @param perPage Amount of products per page.
     * @param sort The parameter by which sorting is performed and the sorting order.
     * @return {@code ProductsResponseBody} instance containing one page of products from the category with the given
     *         slug and meta information about pagination, products count, etc.
     * @throws IOException If an I/O error occurs when sending request or receiving response,
     *                     or if the body of http response from Sbermarket API can not be
     *                     mapped to the {@code ProductsResponseBody} instance.
     * @throws InterruptedException If the operation of sending http request or receiving http response is interrupted.
     */
    public abstract ProductsResponseBody getProductsByStoreIdAndCategorySlug(int storeId,
                                                                             String categorySlug,
                                                                             int page,
                                                                             int perPage,
                                                                             String sort)
        throws IOException, InterruptedException;
}
