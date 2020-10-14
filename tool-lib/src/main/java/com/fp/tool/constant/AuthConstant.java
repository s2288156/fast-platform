package com.fp.tool.constant;

/**
 * @author wcy
 */
public class AuthConstant {

    /**
     * Redis缓存权限规则key
     */
    public static final String RESOURCE_ROLES_MAP_KEY = "auth:resourceRolesMap";

    /**
     * 测试demo-foo接口路径匹配
     */
    public static final String DEMO_FOO_URL_PATTERN = "/demo-foo/**";

    /**
     * JWT存储权限前缀
     */
    public static final String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    public static final String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * JWT令牌前缀
     */
    public static final String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * 用户信息Http请求头
     */
    public static final String USER_TOKEN_HEADER = "user";
}
