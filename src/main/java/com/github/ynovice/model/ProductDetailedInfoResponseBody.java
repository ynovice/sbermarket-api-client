package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductDetailedInfoResponseBody {

    private ProductDetailedInfo product;
    @JsonProperty("promo_badges")
    private List<PromoBadge> promoBadges;
}
