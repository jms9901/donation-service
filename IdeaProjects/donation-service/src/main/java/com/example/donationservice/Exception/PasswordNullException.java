package com.example.donationservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PasswordNullException extends RuntimeException{

    public ErrorCode errorCode;

    public PasswordNullException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}