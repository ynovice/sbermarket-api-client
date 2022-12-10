package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class StoreSchedule {

    private Integer id;
    @JsonProperty("store_id")
    private Integer storeId;

    private StoreScheduleTemplate template;
}
