package com.fd.mall.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author wcy
 */
public class Demo {

    private Demo() {
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }
}
