package com.my.jpa.repository;

import com.my.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Wtq
 * @date 2019/9/9 - 16:27
 */
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User>{
}
