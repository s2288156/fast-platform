package com.fp.user.web.exception;

import com.fp.tool.RestResult;
import com.fp.tool.ex.BizException;
import com.fp.tool.ex.ResultCodeEnum;
import com.fp.tool.ex.SysException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wcy
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ResponseEntity<?> handleBizException(BizException ex) {
        log.warn("[BizException]: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestResult.error(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(SysException.class)
    public ResponseEntity<?> handleBizException(SysException ex) {
        log.error("[SysException]: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestResult.error(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        log.error("[UnknownException]: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(RestResult.error(ResultCodeEnum.SYS_EXECUTE_ERROR));
    }

}