package com.fp.tool.ex;

/**
 * 错误码列表，共5位：错误产生来源 + 四位数字编号，四位数字从0001~9999，大类之间步长100<br>
 * 错误产生来源(A/B/C)：
 * <p>- A表示来源于用户，比如参数错误；</p>
 * <p>- B表示来源于当前系统，比如业务逻辑错误、代码健壮性不足；</p>
 * <p>- C表示错误来源于第三方，比如CDN服务出错，超时等</p>
 *
 * @author wcy
 */
public interface IEnum<E extends Enum<?>, C, M> {

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
