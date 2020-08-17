package com.fp.user.dao.repository;

import com.fp.user.dao.domain.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author wcy
 */
public interface UserRepository extends JpaRepository<UserDO, String> {

    boolean existsByUsername(String username);

    Optional<UserDO> findByUsername(String username);
}
