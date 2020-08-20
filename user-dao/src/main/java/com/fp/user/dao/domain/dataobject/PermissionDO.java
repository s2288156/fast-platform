package com.fp.user.dao.domain.dataobject;

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
public class PermissionDO extends BaseEntity {

    private String name;

    private String description;

}
