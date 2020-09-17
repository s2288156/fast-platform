package com.fp.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wcy
 */
@Component
public class ResourceConfig {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void initResource() {
        Map<String, List<String>> resourceMap = new TreeMap<>();
        resourceMap.put("/test/log_level", CollectionUtils.arrayToList("ADMIN"));
        redisTemplate.opsForHash().putAll("RESOURCE_ROLES_MAP", resourceMap);
    }
}
