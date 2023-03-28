package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoriesResponseBody (
        List<Category> categories,
        List<Category> promotedCategories
) {}
