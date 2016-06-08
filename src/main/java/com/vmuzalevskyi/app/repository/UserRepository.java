package com.vmuzalevskyi.app.repository;

import com.vmuzalevskyi.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by root on 5/22/16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
