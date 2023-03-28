package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeographicCoordinate (
        Double lon,
        Double lat
) {}
