package com.fp.user.api.domain.query;

import com.fp.user.api.domain.bo.UserBO;
import lombok.Data;

/**
 * @author wcy
 */
@Data
public class UserQuery {

    private String username;

    private String password;

}
