package com.fp.tool.ex;

/**
 * @author wcy
 */
public interface IResultCode<C, M> {

    /**
     * 获取枚举code
     *
     * @return code
     */
    C code();

    /**
     * 获取枚举msg
     *
     * @return msg
     */
    M msg();
}
