package org.bigjava.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: HelloServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-20 22:05
 * @Version v1.0
 */
public  class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1.构造方法被执行了！");
    }


    @Override
    public void init(javax.servlet.ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init方法被执行了！！");

        //1.getServletName():可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是："+servletConfig.getServletName());

        //2.getInitParameter(" "):获取初始化参数init.param
        System.out.println("username初始化参数是："+servletConfig.getInitParameter("username"));
        System.out.println("url初始化参数是："+servletConfig.getInitParameter("url"));

        //3.getServletContext():获取ServletContext对象
        System.out.println("ServletContext对象是："+servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * @data: 2020-05-20-22:07
     * @User: 洛笙
     * @method: service
     * @params: [servletRequest, servletResponse]
     * @return: void
     * @Description: 该方法专门用来处理请求和响应的
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.service被访问了");
        //类型转换（因为它有getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        //获取请求的方式
        String method = httpServletRequest.getMethod();
        if ("GET".equalsIgnoreCase(method)){
            doGet();
        }else if ("POST".equalsIgnoreCase(method)){
           doPost();
        }

    }
    /**
     * @data: 2020-05-21-21:11
     * @User: 洛笙
     * @method: doGet
     * @params: []
     * @return: void
     * @Description: 做get请求的操作
     */
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
    }
    /**
     * @data: 2020-05-21-21:12
     * @User: 洛笙
     * @method: doPost
     * @params: []
     * @return: void
     * @Description: 做post请求的操作
     */
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.Servlet被销毁了！");
    }
}
