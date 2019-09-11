package com.my.jpa;

import com.my.jpa.model.User;
import com.my.jpa.repository.UserRepository;
import com.my.jpa.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpaDemoApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd() {
        User user = new User();
        user.setUserName("球球");
        user.setUserAddress("地球");
        userService.create(user);
    }

    /**
     * 查询一个
     */
    @Test
    public void testFindById() {
        User user = userService.findById(4L);
        System.out.println("*** user *** : " + user);
    }

    /**
     * 查询所有User
     */
    @Test
    public void testFindAll() {
        User u = userService.findById(5L);
        List<User> list = userService.findAll(u);
        for (User user : list) {
            System.out.println("++ user ++ :" + user);
        }
    }

}
