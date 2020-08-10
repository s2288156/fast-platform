package com.fp.tool.ex;

/**
 * @author wcy
 */
public enum OutErrorEnum implements IEnum<OutErrorEnum, String, String> {
    /**
     * C: 错误来源第三方，如CDN服务出错、请求超时等
     */
    A0001("A0001", "用户端错误"),
    A0100("A0100", "用户注册错误"),
    ;

    private String code;

    private String msg;

    OutErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public OutErrorEnum get() {
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
