package com.fp.tool.ex;

/**
 * @author wcy
 */
public enum UserErrorEnum implements IEnum<UserErrorEnum, String, String> {
    /**
     * A: 错误来源于用户，如参数错误、版本过低等
     */
    // 一级宏观错误码
    A0001("A0001", "用户端错误"),
    ;

    private String code;

    private String msg;

    UserErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public UserErrorEnum get() {
        return this;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String msg() {
        return this.msg;
    }
}
