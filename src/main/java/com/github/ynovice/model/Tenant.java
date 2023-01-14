package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Tenant {

    private String id;
    private String name;
    private String hostname;
    @JsonProperty("preferred_card_payment_method")
    private PreferredCardPaymentMethod preferredCardPaymentMethod;


    @AllArgsConstructor
    @Getter
    public enum PreferredCardPaymentMethod {
        CLOUD_PAYMENTS("cloud_payments"),
        SBER("sber");

        @JsonValue
        private final String method;
    }
}