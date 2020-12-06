package org.bigjava.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ProjectName: JavaWeb
 * @ClassName: HttpServletRequestTest1
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-23 23:12
 * @Version v1.0
 */
public class HttpServletRequestTest1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("**********doGet**********");
        // v. getParameter() 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // vi. getParameterValues() 获取请求的参数（多个值的时候使用）
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("hobbies = " + Arrays.asList(hobbies));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("**********doPost**********");
        //设置请求体的字符集为UTF-8，从而解决post请求中中文乱码问题
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("hobbies = " + Arrays.asList(hobbies));
    }
}
