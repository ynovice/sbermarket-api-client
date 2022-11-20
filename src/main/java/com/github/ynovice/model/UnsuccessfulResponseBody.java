package com.github.ynovice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * A universal DTO, which provides all the necessary fields to contain the body data of any
 * failed http response (whose status is not 200)
 */
@Getter
@Setter
public class UnsuccessfulResponseBody {

    private Integer code;
    private String error;
    private List<ErrorData> errors;
}