package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String preferredCardPaymentMethod;
}