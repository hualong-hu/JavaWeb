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
 * @ClassName: RegisterServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-26 0:02
 * @Version v1.0
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查 验证码是否正确 ---- 写死，要求验证码为abcde
        if ("abcde".equalsIgnoreCase(code)){
            //3.检查用户名是否可用
            if (userService.existsUsername(username)){
                //用户名已存在不可用，跳回注册页面
                System.out.println("用户名已存在！请重新输入用户名！");
                //把回显信息保存到request域中
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);


                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                //用户名不存在，可用，调用service保存到数据库
                User user = new User(null,username,password,email);
                userService.register(user);
                //跳转到注册成功的页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else {
            //把回显信息保存到request域中
            req.setAttribute("msg", "验证码错误！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);


            System.out.println("验证码【"+ code +"】错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }
}
