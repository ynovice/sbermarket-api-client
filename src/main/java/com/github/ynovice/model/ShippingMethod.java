package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ShippingMethod {

    private Integer id;
    private String name;
    private ShippingMethodKind kind;


    @AllArgsConstructor
    @Getter
    public enum ShippingMethodKind {

        BY_COURIER("by_courier"),
        BY_COURIER_FOR_COMPANIES("by_courier_for_companies"),
        PICKUP("pickup");

        @JsonValue
        private final String kind;
    }
}
