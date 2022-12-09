package com.github.ynovice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Area {

    private List<GeographicCoordinate> dots;

    public void addDot(GeographicCoordinate dot) {
        if(dots == null) dots = new ArrayList<>();
        this.dots.add(dot);
    }
}
