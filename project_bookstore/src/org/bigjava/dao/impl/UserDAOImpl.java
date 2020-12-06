package org.bigjava.dao.impl;
import	java.lang.instrument.ClassFileTransformer;

import org.bigjava.dao.BaseDAO;
import org.bigjava.dao.UserDAO;
import org.bigjava.pojo.User;

import javax.jws.soap.SOAPBinding;

/**
 * @ProjectName: JavaWeb
 * @ClassName: UserDAOImpl
 * @Description: 实现UserDAO
 * @Author: 洛笙
 * @Date: 2020-05-25 22:32
 * @Version v1.0
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public User queryByUsername(String username) {
        String sql = "select id ,username,password,email from t_user where username=?";
        return query(User.class, sql, username);
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql = "select id , username,password,email from t_user where username = ? and password = ?";
        return query(User.class, sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email)values(?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail());
    }
}
