package org.bigjava.servlet;

import com.google.gson.Gson;
import org.bigjava.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: AjaxServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-17 23:45
 * @Version v1.0
 */
public class AjaxServlet extends BaseServlet{

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求过来了");

        Person person = new Person(1, "国哥");
        Gson gson = new Gson();
        //将java对象转换成json字符串
        String json = gson.toJson(person);


        resp.getWriter().write(json);

    }
    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuery === 请求开始");

        String username = req.getParameter("username");
        System.out.println("username = " + username);

        String password = req.getParameter("password");
        System.out.println("password = " + password);

        Person person = new Person(1, "国哥");
        Gson gson = new Gson();
        //将java对象转换成json字符串
        String json = gson.toJson(person);

        resp.getWriter().write(json);

    }
    protected void getAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getAjax === 请求开始");

        Person person = new Person(1, "国哥");
        Gson gson = new Gson();
        //将java对象转换成json字符串
        String json = gson.toJson(person);

        resp.getWriter().write(json);

    }
    protected void postAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("postAjax === 请求开始");

        Person person = new Person(1, "国哥");
        Gson gson = new Gson();
        //将java对象转换成json字符串
        String json = gson.toJson(person);

        resp.getWriter().write(json);

    }
    protected void getJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getJson === 请求开始");

        Person person = new Person(1, "国哥");
        Gson gson = new Gson();
        //将java对象转换成json字符串
        String json = gson.toJson(person);

        resp.getWriter().write(json);

    }
    protected void ajaxSerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajaxSerialize === 请求开始");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        Person person = new Person(1, "国哥");

        Gson gson = new Gson();
        //将java对象转换成json字符串
        String json = gson.toJson(person);

        resp.getWriter().write(json);

    }
}
