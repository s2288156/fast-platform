package com.fp.tool.ex;

/**
 * @author wcy
 */
public interface IResultCode<E extends Enum<?>, C, M> {

    /**
     * 获取枚举对象
     *
     * @return enum
     */
    E get();


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
