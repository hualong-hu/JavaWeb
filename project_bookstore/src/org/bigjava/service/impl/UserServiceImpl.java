package org.bigjava.service.impl;

import org.bigjava.dao.impl.UserDAOImpl;
import org.bigjava.pojo.User;
import org.bigjava.service.UserService;

/**
 * @ProjectName: JavaWeb
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-25 23:17
 * @Version v1.0
 */
public class UserServiceImpl implements UserService {
    UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public void register(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        User user = userDAO.queryByUsername(username);
        if (user == null) {
            return false;
        }
        return true;
    }
}
