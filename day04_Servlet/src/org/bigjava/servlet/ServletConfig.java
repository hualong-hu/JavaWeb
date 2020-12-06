package org.bigjava.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: ${NAME}
 * @Description: ServletConfig 类的三大作用
 * @Author: 洛笙
 * @Date: 2020-05-22 21:41
 * @Version v1.0
 *一、ServletConfig 类的三大作用
 * 1、可以获取 Servlet 程序的别名 servlet-name 的值
 * 2、获取初始化参数 init-param
 * 3、获取 ServletContext 对象
 *
 *二、ServletConfig的常用方法
 * 1.getServletName():可以获取Servlet程序的别名servlet-name的值
 * 2.getInitParameter(" "):获取初始化参数init.param
 * 3.getServletContext():获取ServletContext对象
 */
public class ServletConfig extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.getServletName():可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是："+getServletName());

        //2.getInitParameter(" "):获取初始化参数init.param
        System.out.println("username初始化参数是："+getInitParameter("username"));
        System.out.println("url初始化参数是："+getInitParameter("url"));

        //3.getServletContext():获取ServletContext对象
        System.out.println("ServletContext对象是："+getServletContext());
    }
}
