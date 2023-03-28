package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShipmentsPage (
        List<Shipment> shipments,
        Meta meta
) {}
