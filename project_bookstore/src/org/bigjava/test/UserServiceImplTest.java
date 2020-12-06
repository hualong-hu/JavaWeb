package org.bigjava.test;

import org.bigjava.pojo.User;
import org.bigjava.service.UserService;
import org.bigjava.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ProjectName: JavaWeb
 * @ClassName: UserServiceImplTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-25 23:23
 * @Version v1.0
 */
public class UserServiceImplTest {
    UserServiceImpl userService = new UserServiceImpl();
    @Test
    public void register() {
        User user = new User(null, "胡华龙", "666666", "huhualong@126.com");
        userService.register(user);
    }

    @Test
    public void login() {
        User user = new User(null, "胡华龙", "666666", "huhualong@126.com");
        User user1 = userService.login(user);
        System.out.println(user1);
    }

    @Test
    public void existsUsername() {
        boolean existsUsername = userService.existsUsername("刘雯静");
        if (!existsUsername){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在！");
        }
    }
}