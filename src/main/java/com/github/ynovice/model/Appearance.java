package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * An appearance of the retailer.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Appearance {

    @JsonProperty("background_color")
    private String backgroundColor;
    @JsonProperty("image_color")
    private String imageColor;

    @JsonProperty("black_theme")
    private Boolean blackTheme;

    @JsonProperty("logo_image")
    private String logoImage;
    @JsonProperty("side_image")
    private String sideImage;
    @JsonProperty("mini_logo_image")
    private String miniLogoImage;
}
