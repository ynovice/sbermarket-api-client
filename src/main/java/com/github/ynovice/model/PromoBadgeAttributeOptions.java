package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PromoBadgeAttributeOptions (
        AttributeOption active,
        AttributeOption inactive
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record AttributeOption (
            String title,
            String titleShort,
            String tooltip,
            String url,
            String buttonText,
            String imageUrl,
            Boolean positionTop
    ) {}
}