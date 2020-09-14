package com.fp.gateway.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fp.tool.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;

/**
 * @author wcy
 */
@Slf4j
public class WebConfigUtils {

    public static DataBuffer getDataBuffer(ServerHttpResponse response, RestResult<?> success) {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] dataBytes = {};
        try {
            dataBytes = objectMapper.writeValueAsBytes(success);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("convert to bytes ex", jsonProcessingException);
        }
        return response.bufferFactory().wrap(dataBytes);
    }
}
