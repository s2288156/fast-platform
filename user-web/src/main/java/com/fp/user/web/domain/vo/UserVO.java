package com.fp.user.web.domain.vo;

import com.fp.user.web.domain.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = -5898676128178450159L;

    private String username;
}
