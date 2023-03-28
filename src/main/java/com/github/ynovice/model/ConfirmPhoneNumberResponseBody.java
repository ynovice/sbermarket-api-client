package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ConfirmPhoneNumberResponseBody (
        Boolean isRegistration,
        User user,
        String csrfToken
) {}
