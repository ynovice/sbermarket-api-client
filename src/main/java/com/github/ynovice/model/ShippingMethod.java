package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ShippingMethod {

    private Integer id;
    private String name;
    private ShippingMethodKind kind;
}
