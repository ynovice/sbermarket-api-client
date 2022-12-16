package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class License {

    private String kind;
    private String number;
    @JsonProperty("issue_date")
    private LocalDate issueDate;
    @JsonProperty("end_date")
    private LocalDate endDate;
}
