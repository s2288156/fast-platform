package com.fp.security.exception;

import com.fp.tool.RestResult;
import com.fp.tool.ex.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wcy
 */
@Slf4j
@RestControllerAdvice
public class SecurityExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException ex) {
        log.warn("[AccessDeniedException]: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(RestResult.error(ResultCodeEnum.PERMISSION_ERROR));
    }

}
