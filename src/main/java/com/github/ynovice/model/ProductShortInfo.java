package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductShortInfo {

    private Integer id;
    private String sku;
    private Boolean available;
    @JsonProperty("retailer_sku")
    private String retailerSku;
    private String name;
    private Double price;
    @JsonProperty("original_price")
    private Double originalPrice;
    private Double discount;
    @JsonProperty("human_volume")
    private String humanVolume;
    private Double volume;
    @JsonProperty("volume_type")
    private String volumeType;
    @JsonProperty("items_per_pack")
    private Integer itemsPerPack;
    @JsonProperty("discount_ends_at")
    private ZonedDateTime discountEndsAt;
    @JsonProperty("price_type")
    private String priceType;
    @JsonProperty("grams_per_unit")
    private Double gramsPerUnit;
    @JsonProperty("unit_price")
    private Double unitPrice;
    @JsonProperty("original_unit_price")
    private Double originalUnitPrice;
    @JsonProperty("promo_badge_ids")
    private List<Integer> promoBadgeIds;
    private Double score;
    @JsonProperty("image_urls")
    private List<String> imageUrls;
    private List<String> labels;
    private List<Requirement> requirements;
    @JsonProperty("canonical_url")
    private String canonicalUrl;
    @JsonProperty("legacy_offer_id")
    private Long legacyOfferId;
    @JsonProperty("legacy_product_id")
    private Long legacyProductId;
    private String slug;
    @JsonProperty("max_select_quantity")
    private Integer maxSelectQuantity;

    @JsonProperty("score_details")
    private ScoreDetails scoreDetails;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class ScoreDetails {

        @JsonProperty("comment_count")
        private Integer commentCount;
    }
}
