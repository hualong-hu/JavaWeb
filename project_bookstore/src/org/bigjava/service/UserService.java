package org.bigjava.service;

import org.bigjava.pojo.User;

/**
 * 提供业务接口
 * @ProjectName: JavaWeb
 * @ClassName: UserService
 * @Description: 提供业务接口
 * @Author: 洛笙
 * @Date: 2020-05-25 23:13
 * @Version v1.0
 */
public interface UserService {

   /**
    * 用户注册
    * @data: 2020-05-30-17:33
    * @User: 洛笙
    * @method: register
    * @params: [user]
    * @return: void
    * @Description: 描述
    */
    public void register(User user);
    
    /**
     * @data: 2020-05-25-23:16
     * @User: 洛笙
     * @method: login
     * @params: [user]
     * @return: org.bigjava.pojo.User
     * @Description: 用户登录
     */
    public User login(User user);
    /**
     * @data: 2020-05-25-23:16
     * @User: 洛笙
     * @method: existsUsername
     * @params: []
     * @return: boolean
     * @Description: 判断用户是否存在
     */
    public boolean existsUsername(String username);
}
