package com.fp.user.dao.domain.dataobject;

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
@EqualsAndHashCode(callSuper = true)
@TableName(autoResultMap = true, value = "t_user_role")
public class UserRoleDO extends BaseEntity {

    private String userId;

    private String roleId;

}
