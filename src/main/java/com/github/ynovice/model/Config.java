package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Config {

    @JsonProperty("lifepay_identifier")
    private String lifepayIdentifier;
    @JsonProperty("import_key_postfix")
    private String importKeyPostfix;
    @JsonProperty("seconds_for_assembly_item")
    private Integer secondsForAssemblyItem;
    @JsonProperty("additional_seconds_for_assembly")
    private Integer additionalSecondsForAssembly;
}
