package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductDetailedInfo {

    private String id;
    @JsonProperty("legacy_offer_id")
    private Long legacyOfferId;
    @JsonProperty("legacy_product_id")
    private Long legacyProductId;

    private String description;
    private Boolean available;
    @JsonProperty("promo_badge_ids")
    private List<Integer> promoBadgeIds;
    private List<Property> properties;
    @JsonProperty("related_products")
    private List<ProductShortInfo> relatedProducts;


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class Property {
        private String name;
        private String presentation;
        private String value;
    }
}
