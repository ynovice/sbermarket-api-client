package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Option (
        Integer value,
        Integer count,
        Boolean active,
        String name,
        String permalink
) {}