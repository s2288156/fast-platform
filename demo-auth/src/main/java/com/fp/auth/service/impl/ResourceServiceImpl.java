package com.fp.auth.service.impl;

import com.fp.tool.constant.AuthConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author wcy
 */
@Slf4j
@Service
public class ResourceServiceImpl {
    private Map<String, List<String>> resourceRolesMap;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void initResourceRolesMap() {
        log.info("init resource >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/demo-foo/admin/one", Arrays.asList("ADMIN", "ONE"));
        resourceRolesMap.put("/demo-foo/admin/two", Arrays.asList("TWO", "THREE"));
        redisTemplate.opsForHash().putAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRolesMap);
    }
}
