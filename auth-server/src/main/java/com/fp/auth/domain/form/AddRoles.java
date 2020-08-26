package com.fp.auth.domain.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author wcy
 */
@Data
public class AddRoles implements Serializable {

    @NotNull(message = "请选择角色")
    private List<String> roleIds;

    @NotBlank(message = "请选择授权用户")
    private String userId;
}
