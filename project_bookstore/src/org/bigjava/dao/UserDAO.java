package org.bigjava.dao;

import org.bigjava.pojo.User;

/**
 * @ProjectName: JavaWeb
 * @ClassName: UserDAO
 * @Description: 提供BaseDAO的具体接口
 * @Author: 洛笙
 * @Date: 2020-05-25 22:24
 * @Version v1.0
 */

public interface UserDAO {
    /**
     * @data: 2020-05-25-22:26
     * @User: 洛笙
     * @method: queryByUsername
     * @params: [name]
     * @return: org.bigjava.pojo.User
     * @Description: 根据用户名查询用户信息
     */
    public User queryByUsername(String username);

    /**
     * @data: 2020-05-25-22:30
     * @User: 洛笙
     * @method: queryByUsernameAndPassword
     * @params: [username, password]
     * @return: org.bigjava.pojo.User
     * @Description: 通过密码和用户名查询用户信息
     */
    public User queryByUsernameAndPassword(String username,String password);



    /**
     * @data: 2020-05-25-22:28
     * @User: 洛笙
     * @method: saveUser
     * @params: [user]
     * @return: int
     * @Description: 保存用户信息
     */
    public int saveUser(User user);


}
