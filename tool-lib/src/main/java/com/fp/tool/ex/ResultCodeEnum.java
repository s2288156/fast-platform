package com.fp.tool.ex;

/**
 * @author wcy
 */
public enum ResultCodeEnum implements IResultCode<ResultCodeEnum, String, String> {
    /**
     * 错误码列表，共5位：错误产生来源 + 四位数字编号，四位数字从0001~9999，大类之间步长100<br>
     * 错误产生来源(A/B/C)：
     * <p>- A表示来源于用户，比如参数错误；</p>
     * <p>- B表示来源于当前系统，比如业务逻辑错误、代码健壮性不足；</p>
     * <p>- C表示错误来源于第三方，比如CDN服务出错，超时等</p>
     */
    EVERYTHING_OK("00000", "一切ok"),
    // 一级宏观错误码
    A0001("A0001", "用户端错误"),
    A0100("A0100", "用户注册错误"),
    // 一级宏观错误码
    B0001("B0001", "系统执行出错"),
    // 二级宏观错误码
    B0100("B0100", "系统执行超时");

    private String code;

    private String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public ResultCodeEnum get() {
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
