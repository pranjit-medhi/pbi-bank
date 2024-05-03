package com.main.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
public class ErrorInfo {
    private String errorMessage;
    private Integer errorCode;
    private LocalDateTime localDateTime;

}
