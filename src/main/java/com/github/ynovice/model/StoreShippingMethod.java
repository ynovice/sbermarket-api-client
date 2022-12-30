package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class StoreShippingMethod {

    private Integer id;
    @JsonProperty("store_id")
    private Integer storeId;
    @JsonProperty("tenant_id")
    private String tenantId;
    @JsonProperty("available_on")
    private ZonedDateTime availableOn;
    @JsonProperty("shipping_method")
    private ShippingMethod shippingMethod;
}
