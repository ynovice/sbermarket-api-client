package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PromoShield {

    @JsonProperty("gradient_start_color")
    private String gradientStartColor;
    @JsonProperty("gradient_end_color")
    private String gradientEndColor;
    @JsonProperty("text_color")
    private String textColor;
    private String text;
}
