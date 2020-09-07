package com.fp.auth.controller;

import com.fp.tool.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/log_level")
    public RestResult<?> logLevel() {
        log.trace("================= trace ====================");
        log.debug("================= debug ====================");
        log.info("================= info ====================");
        log.warn("================= warn ====================");
        log.error("================= error ====================");
        return RestResult.success();
    }
}
