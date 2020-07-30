package com.fp.user.dao.repository;

import com.fp.user.dao.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wcy
 */
public interface UserRepository extends JpaRepository<UserDO, String> {
}
