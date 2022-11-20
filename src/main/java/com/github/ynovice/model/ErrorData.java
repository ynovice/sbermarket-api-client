package com.github.ynovice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorData {

    private ErrorType type;
    private String field;
    private String message;
}
