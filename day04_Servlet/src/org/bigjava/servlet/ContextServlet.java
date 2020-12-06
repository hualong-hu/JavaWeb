package org.bigjava.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: ${NAME}
 * @Description: ServletContext类的测试
 * @Author: 洛笙
 * @Date: 2020-05-22 20:47
 * @Version v1.0
 *一、什么是 ServletContext?
 *  1、ServletContext 是一个接口，它表示 Servlet 上下文对象
 *  2、一个 web 工程，只有一个 ServletContext 对象实例。
 *  3、ServletContext 对象是一个域对象。
 *  4、ServletContext 是在 web 工程部署启动的时候创建。在 web 工程停止的时候销毁。
 *
 *二、ServletContext的常用方法
 * 1.getInitParameter("  "):获取web.xml中配置的上下文参数context-param
 * 2.getContextPath():获取当前的工程路径，格式： /工程路径
 * 3.getRealPath("/"):获取工程部署后在服务器硬盘上的绝对路径
 *   '/' 斜杠被服务器解析地址为http://ip:port/工程名/   映射到IDEA代码的web目录
 * 4.像map一样存储数据
 *    setAttribute("key1", "value1");存储数据
 *    getAttribute("key1")：读取数据
 *    removeAttribute("key1");删除数据！
 */
public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getServletContext():通过getServletConfig()获取ServletContext对象
        ServletContext context = getServletContext();

        //1.getInitParameter("  "):获取web.xml中配置的上下文参数context-param
        String username = context.getInitParameter("username");
        System.out.println("username = " + username);
        String password = getServletContext().getInitParameter("password");
        System.out.println("password = " + password);

        //2.getContextPath():获取当前的工程路径，格式： /工程路径
        String contextPath = context.getContextPath();
        System.out.println("contextPath = " + contextPath);

        //3.getRealPath("/"):获取工程部署后在服务器硬盘上的绝对路径
        /*
            '/' 斜杠被服务器解析地址为http://ip:port/工程名/   映射到IDEA代码的web目录
         */
        String realPath = context.getRealPath("/");
        System.out.println("realPath = " + realPath);

        //4.像map一样存储数据
        /*
            setAttribute("key1", "value1");存储数据
            getAttribute("key1")：读取数据
            removeAttribute("key1");删除数据！
         */
        context.setAttribute("key1", "value1");
        context.removeAttribute("key1");
        System.out.println("key1的值是："+context.getAttribute("key1"));
        context.setAttribute("key2","value2");
        System.out.println("key2的值是："+context.getAttribute("key2"));


    }
}
