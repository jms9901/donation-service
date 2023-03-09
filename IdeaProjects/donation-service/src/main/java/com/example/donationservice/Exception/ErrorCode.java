package com.example.donationservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /*409 중복된 데이터 존재 */
    EMAIL_DUPLICATION(409,  "아이디가 이미 존재합니다!") , ;

    private final int status;
    private final String message;
}
