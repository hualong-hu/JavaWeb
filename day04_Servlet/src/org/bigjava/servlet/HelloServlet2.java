package org.bigjava.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: HelloServlet2
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-21 21:23
 * @Version v1.0
 */
public class HelloServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的doGet方法");
        
        String servletName = getServletName();
        System.out.println("servletName = " + servletName);

        ServletContext context = getServletContext();
        System.out.println("context = " + context);

        String name = getInitParameter("name");
        System.out.println("name = " + name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的doPost方法");
    }
}
