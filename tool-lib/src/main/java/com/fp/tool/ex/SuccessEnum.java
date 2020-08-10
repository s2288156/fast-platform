package com.fp.tool.ex;

/**
 * @author wcy
 */
public enum SuccessEnum implements IEnum<SuccessEnum, String, String> {

    /**
     * 一切正常
     */
    EVERYTHING_OK("00000", "一切ok"),
    ;

    private String code;

    private String msg;

    SuccessEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public SuccessEnum get() {
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
