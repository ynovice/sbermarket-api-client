package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PharmacyLegalInfo {

    private String name;
    private String license;
    private String address;
    private String inn;
    private String ogrn;
    @JsonProperty("work_schedule")
    private String workSchedule;
    private String phone;
    private String email;
    @JsonProperty("link_text")
    private String linkText;
}
