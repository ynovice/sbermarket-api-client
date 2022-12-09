package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Location of the store.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Location {

    private Integer id;

    @JsonProperty("full_address")
    private String fullAddress;
    private String city;
    private String street;
    private String building;
    private String block;
    private String floor;
    private String apartment;
    private String entrance;
    private String elevator;
    private String region;
    private String comments;
    private String phone;
    private String area;
    private String settlement;

    private Double lat;
    private Double lon;

    @JsonProperty("city_kladr_id")
    private Integer cityKladrId;
    @JsonProperty("street_kladr_id")
    private Integer streetKladrId;

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("door_phone")
    private String doorPhone;
    private String kind;

    @JsonProperty("delivery_to_door")
    private Boolean deliveryToDoor;
}
