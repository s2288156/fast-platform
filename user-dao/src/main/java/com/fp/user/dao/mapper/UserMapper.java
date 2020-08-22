package com.fp.user.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fp.user.dao.domain.dataobject.UserDO;
import com.fp.user.dao.domain.dto.UserRolesDTO;

/**
 * @author wcy
 */
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * @param userId
     * @return
     */
    UserRolesDTO selectUserRoles(String userId);
}
