package com.fp.auth.domain.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;


/**
 * @author wcy-auto
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(autoResultMap = true, value = "t_permission")
public class PermissionDO extends BaseEntity {

    private String name;

    private String description;

}
