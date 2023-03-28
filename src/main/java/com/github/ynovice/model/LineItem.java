package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LineItem (
        Long id,
        String name,
        Image image,
        Integer quantity,
        Integer retailerId
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Image (
            String miniUrl,
            String smallUrl,
            String productUrl,
            Boolean isPlaceholder
    ) {}
}