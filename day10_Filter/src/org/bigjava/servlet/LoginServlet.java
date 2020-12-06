package org.bigjava.servlet;

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
 * @Date: 2020-06-15 16:04
 * @Version v1.0
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("admin".equals(username) && "123456".equals(password)){
            req.getSession().setAttribute("user", username);
            resp.getWriter().write("登录成功！！！");
        }else {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
}
