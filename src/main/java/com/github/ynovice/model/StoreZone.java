package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.ynovice.deserializer.StoreZoneDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@JsonDeserialize(using = StoreZoneDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class StoreZone {

    private Integer id;
    private String name;
    private Set<Area> areas;

    public void addArea(Area area) {
        if(areas == null) areas = new HashSet<>();
        areas.add(area);
    }
}
