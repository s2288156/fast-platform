package com.fp.auth.domain.form;

import com.fp.auth.domain.dataobject.RoleDO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class InsertRole implements Serializable {
    private static final long serialVersionUID = -5095354121605683437L;

    @NotBlank(message = "角色名称不能为空")
    private String name;

    /**
     * 详细说明
     **/
    private String description;

    public RoleDO convert2DO() {
        RoleDO roleDO = new RoleDO();
        BeanUtils.copyProperties(this, roleDO);
        return roleDO;
    }

}
