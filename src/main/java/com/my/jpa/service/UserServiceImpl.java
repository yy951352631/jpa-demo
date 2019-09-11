package com.my.jpa.service;

import com.my.jpa.model.User;
import com.my.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Wtq
 * @date 2019/9/9 - 16:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll(User user) {
        return userRepository.findAll(toSpecification(user));
    }

    @Override
    public Page<User> findAll(User user, Pageable pageable) {
        return userRepository.findAll(toSpecification(user), pageable);
    }

    private Specification<User> toSpecification(User user) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            Optional.ofNullable(user).ifPresent(
                    userValue -> {
                        predicates.add(criteriaBuilder.equal(root.get("userId"), userValue.getUserId()));
                        predicates.add(criteriaBuilder.like(root.get("userName").as(String.class), userValue.getUserName()));
                    }
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }


}


/**
 * return (root, query, criteriaBuilder) -> {
 * List<Predicate> predicates = new ArrayList<Predicate>();
 * Optional.ofNullable(order).ifPresent(
 * value -> predicates.add(criteriaBuilder.equal(root.get("userId"), value.getUserId())));
 * return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
 * };
 */
