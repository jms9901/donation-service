package com.example.donationservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Getter
@AllArgsConstructor
public class EmailoverlapException extends RuntimeException {

    public ErrorCode errorCode;
 /*   private ErrorCode errorCode;
    private String message;

    @Override
    public String toString() {
        if (message == null) {
            return errorCode.getMessage();
        }
        return String.format("%s. %s",errorCode.getMessage(), message);
    } */
    public EmailoverlapException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
