package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ProductsResponseBody {

    private List<ProductShortInfo> products;
    private Meta meta;
    @JsonProperty("pagination_meta")
    private Meta paginationMeta;
    private List<Facet> facets;
    @JsonProperty("private_filters")
    private PrivateFilters privateFilters;
    private List<Sort> sort;
    @JsonProperty("root_categories")
    private RootCategories rootCategories;
    @JsonProperty("promo_badges")
    private List<PromoBadge> promoBadges;


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class Meta {

        @JsonProperty("current_page")
        private Integer currentPage;
        @JsonProperty("next_page")
        private Integer nextPage;
        @JsonProperty("previous_page")
        private Integer previousPage;
        @JsonProperty("total_pages")
        private Integer totalPages;
        @JsonProperty("per_page")
        private Integer perPage;
        @JsonProperty("total_count")
        private Integer totalCount;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class Facet {

        private String key;
        private String name;
        private String type;
        private List<Option> options;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class PrivateFilters {
        @JsonProperty("in_stock")
        private Boolean inStock;
        @JsonProperty("with_similar")
        private Boolean withSimilar;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class Sort {
        private String key;
        private String name;
        private String order;
        private Boolean active;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class RootCategories {
        private String key;
        private String name;
        private String type;
        private List<Option> options;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class Option {

        private Integer value;
        private Integer count;
        private Boolean active;
        private String name;
        private String permalink;
    }
}