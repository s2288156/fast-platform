package com.fp.tool.ex;

/**
 * @author wcy
 */
public class BizException extends RuntimeException{
    private static final long serialVersionUID = -5496308092178328679L;

    private final String code;

    public BizException(String code) {
        this.code = code;
    }
}
