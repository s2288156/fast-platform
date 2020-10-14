package com.fp.auth.exception;

import com.fp.tool.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wcy
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<?> handleBizException(InvalidTokenException ex) {
        log.warn("[BizException]: {}", ex.getMessage());
        return ResponseEntity.status(
                HttpStatus.INTERNAL_SERVER_ERROR)
                .body(RestResult.error(String.valueOf(ex.getHttpErrorCode()), "refresh_token失效")
                );
    }
}
