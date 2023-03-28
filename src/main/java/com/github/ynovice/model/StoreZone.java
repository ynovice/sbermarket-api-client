package com.github.ynovice.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.ynovice.deserializer.StoreZoneDeserializer;

import java.util.Set;

@JsonDeserialize(using = StoreZoneDeserializer.class)
public record StoreZone (
        Integer id,
        String name,
        Set<Area> areas
) {}