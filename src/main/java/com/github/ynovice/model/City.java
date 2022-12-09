package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class City {

    private Integer id;
    private String name;
    @JsonProperty("name_in")
    private String nameIn;
    @JsonProperty("name_from")
    private String nameFrom;
    @JsonProperty("name_to")
    private String nameTo;
    private String slug;
}
