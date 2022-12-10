package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum DeliveryKind {
    COURIER("courier"),
    PICKUP("pickup"),
    EXPRESS_DELIVERY("express_delivery");

    @JsonValue
    private final String kind;

    DeliveryKind(String kind) {
        this.kind = kind;
    }
}
