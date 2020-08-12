package com.fp.tool.ex;

import lombok.Getter;

/**
 * @author wcy
 */
@Getter
public class SysException extends RuntimeException {
    private static final long serialVersionUID = -5496308092178328679L;

    private final String code;

    public SysException(IResultCode<String, String> errorEnum) {
        super(errorEnum.msg());
        this.code = errorEnum.code();
    }

    public SysException(IResultCode<String, String> errorEnum, String msg) {
        super(msg);
        this.code = errorEnum.code();
    }
}
