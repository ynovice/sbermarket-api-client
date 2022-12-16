package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum OrdersApiIntegrationType {
    SHOPPER("shopper"),
    DELIVERY_BY_SBERMARKET("delivery_by_sbermarket"),
    DELIVERY_BY_RETAILER("delivery_by_retailer");

    @JsonValue
    private final String type;

    OrdersApiIntegrationType(String type) {
        this.type = type;
    }
}
