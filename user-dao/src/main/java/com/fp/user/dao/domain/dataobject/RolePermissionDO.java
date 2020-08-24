package com.fp.user.dao.domain.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * @author wcy-auto
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@TableName(autoResultMap = true, value = "t_role_permission")
public class RolePermissionDO {

    @TableId
    private String id;

    private String roleId;

    private String permissionId;

}
