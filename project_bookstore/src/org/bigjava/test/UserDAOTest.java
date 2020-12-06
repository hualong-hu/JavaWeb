package org.bigjava.test;

import org.bigjava.dao.impl.UserDAOImpl;
import org.bigjava.pojo.User;
import org.junit.Test;


/**
 * @ProjectName: JavaWeb
 * @ClassName: UserDAOTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-25 22:45
 * @Version v1.0
 */
public class UserDAOTest {
    UserDAOImpl userDao = new UserDAOImpl();
    @Test
    public void queryByUsername() {

        User user = userDao.queryByUsername("admin");
        if (user == null) {
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryByUsernameAndPassword() {
        User user = userDao.queryByUsernameAndPassword("admin", "admin");
        if (user == null) {
            System.out.println("用户名或密码错误，登录失败！");
        }else {
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        User user = new User(null,"刘雯静","123456","liuwenjing@126.com");
        int i = userDao.saveUser(user);
        if (i < 0) {
            System.out.println("用户名已存在，插入失败！");
        }else {
            System.out.println("插入成功！");
        }
    }
}