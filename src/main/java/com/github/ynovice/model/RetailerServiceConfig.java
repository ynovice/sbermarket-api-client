package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class RetailerServiceConfig {

    private Integer id;
    @JsonProperty("base_url")
    private String baseUrl;
    @JsonProperty("basic_auth")
    private String basicAuth;
    @JsonProperty("polling_interval")
    private Integer pollingInterval;
}
