package com.fp.user.web.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public abstract class BaseVO implements Serializable {
    private static final long serialVersionUID = 6405640927458360329L;

    private String returnCode;

    private String returnMsg;

    public BaseVO() {
        this.returnCode = "00000";
    }
}
