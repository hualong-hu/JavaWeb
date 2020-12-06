package org.bigjava.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: HttpServletRequestTest
 * @Description: HttpServletRequest类常用API的测试
 * @Author: 洛笙
 * @Date: 2020-05-22 20:47
 * @Version v1.0
 */

public class HttpServletRequestTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //i. getRequestURI() 获取请求的资源路径
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);

        // ii.getRequestURL() 获取请求的统一资源定位符（绝对路径）
        StringBuffer url = request.getRequestURL();
        System.out.println("url = " + url);

        // iii. getRemoteHost() 获取客户端的 ip 地址
        String host = request.getRemoteHost();
        System.out.println("host = " + host);

        // iv.getHeader() 获取请求头
        String header = request.getHeader("User-Agent");
        System.out.println("header = " + header);




        // vii. getMethod() 获取请求的方式 GET 或 POST
        String method = request.getMethod();
        System.out.println("method = " + method);

        // viii. setAttribute(key, value); 设置域数据
        request.setAttribute("key1", "value1");


        // ix.getAttribute(key); 获取域数据
        Object value1 = request.getAttribute("key1");
        System.out.println("value1 = " + value1);

        // x. getRequestDispatcher() 获取请求转发对象



    }
}
