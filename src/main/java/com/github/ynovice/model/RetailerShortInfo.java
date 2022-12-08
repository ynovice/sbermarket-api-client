package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Short information about the retailer.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class RetailerShortInfo {

    private Integer id;
    private String name;
    private String slug;
    private String description;

    private String color;
    @JsonProperty("secondary_color")
    private String secondaryColor;
    @JsonProperty("logo_background_color")
    private String logoBackgroundColor;

    private String logo;
    private String icon;

    @JsonProperty("is_alcohol")
    private Boolean isAlcohol;
    @JsonProperty("is_agent_contract_types")
    private Boolean isAgentContractTypes;

    @JsonProperty("home_page_departments_depth")
    private Integer homePageDepartmentsDepth;

    private Appearance appearance;
}
