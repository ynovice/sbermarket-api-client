package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Category {

    private Integer id;
    @JsonProperty("parent_id")
    private Integer parentId;
    private String type;
    private String name;
    private String slug;
    @JsonProperty("products_count")
    private Integer productsCount;
    @JsonProperty("icon_url")
    private String iconUrl;
    @JsonProperty("canonical_url")
    private String canonicalUrl;
    private Integer position;
    private Integer depth;
    private Appearance appearance;
    @JsonProperty("is_promo")
    private Boolean isPromo;
    @JsonProperty("alt_icon")
    private String altIcon;
    private List<Category> children;
}
