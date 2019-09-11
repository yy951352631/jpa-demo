package com.my.jpa.service;

import com.my.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wtq
 * @date 2019/9/9 - 16:38
 */
public interface UserService {
    User findById(Long id);

    List<User> findAll(User user);

    User create(User user);

    Page<User> findAll(User user, Pageable pageable);
}
