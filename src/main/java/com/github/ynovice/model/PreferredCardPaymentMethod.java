package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum PreferredCardPaymentMethod {
    CLOUD_PAYMENTS("cloud_payments"),
    SBER("sber");

    @JsonValue
    private final String method;

    PreferredCardPaymentMethod(String method) {
        this.method = method;
    }
}