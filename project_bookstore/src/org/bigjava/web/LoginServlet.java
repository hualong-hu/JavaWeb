package org.bigjava.web;

import org.bigjava.pojo.User;
import org.bigjava.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: LoginServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-26 22:26
 * @Version v1.0
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(null,username,password,null);
        User loginUser = userService.login(user);
        if (loginUser == null) {
            //把错误信息和回显的表单项信息，保存到request域中
            req.setAttribute("msg", "用户名或密码错误，登录失败");
            req.setAttribute("username", username);
            //登录失败
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else {
            //登录成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }
}
