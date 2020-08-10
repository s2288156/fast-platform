package com.fp.tool.ex;

/**
 * @author wcy
 */
public enum SysErrorEnum implements IEnum<SysErrorEnum, String, String> {

    /**
     * B: 错误来源于当前系统，如业务逻辑错误、健壮性不够等
     */
    // 一级宏观错误码
    B0001("B0001", "系统执行出错"),
    // 二级宏观错误码
    B0100("B0100", "系统执行超时")
    ;

    private String code;

    private String msg;

    SysErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public SysErrorEnum get() {
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
