package org.bigjava.servlet;

import org.bigjava.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: CookieServlet
 * @Description: 创建Cookie
 * @Author: 洛笙
 * @Date: 2020-06-09 22:44
 * @Version v1.0
 */
public class CookieServlet extends BaseServlet{
/**
 * 创建Cookie
 * @data: 2020-06-09-23:26
 * @User: 洛笙
 * @method: creatCookie
 * @params: [req, resp]
 * @return: void
 * @Description: 描述
 */
    protected void creatCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie1 = new Cookie("key1", "value1");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie1);
        Cookie cookie2 = new Cookie("key2", "value2");
        resp.addCookie(cookie2);
        Cookie cookie3 = new Cookie("key3", "value3");
        resp.addCookie(cookie3);

        resp.getWriter().write("Cookie创建成功！");
    }
    /**
     * 获取Cookie
     * @data: 2020-06-09-23:26
     * @User: 洛笙
     * @method: getCookie
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //getName():返回Cookie的key(名)
            //getValue()：返回Cookie的value(值)
            resp.getWriter().write("Cookie["+ cookie.getName() +"="+cookie.getValue() +"] <br/>");
        }
        //遍历寻找某个Cookie的值
        Cookie iWantCookie = CookieUtils.findCookie("key2",cookies);
//        for (Cookie cookie : cookies) {
//            if ("key3".equals(cookie.getName())){
//                iWantCookie = cookie;
//                break;
//            }
//        }
        //如果不等于null说明找到了需要的Cookie
        if (iWantCookie !=null){
            resp.getWriter().write("所需要的Cookie找到了！！！");
        }
    }
    /**
     * 修改Cookie的值
     * @data: 2020-06-09-23:41
     * @User: 洛笙
     * @method: updateCookie
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //方法一：
//        //1.先创建一个要修改的同名的Cookie对象，在构造器中同时赋予新的Cookie值
//        Cookie cookie = new Cookie("key2", "newValue2");
//        //2调用resp.addCookie(),通知客户端保存修改
//        resp.addCookie(cookie);
//        resp.getWriter().write("key2的Cookie值已修改！");

        //方法二：
        //1.先查找到需要修改的Cookie对象
        Cookie[] cookies = req.getCookies();
        Cookie cookie1 = CookieUtils.findCookie("key1", cookies);
        if (cookies != null) {
            //2.调用setValue()方法赋予新的Cookie值
            cookie1.setValue("newValue1");
            //3.调用resp.addCookie(),通知客户端保存修改
            resp.addCookie(cookie1);
            resp.getWriter().write("key1的Cookie值已修改！");
        }
    }
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultKey", "defaultValue");
        //设置Cookie的存活时间，-1为默认值
        //表示浏览器一关，Cookie就会被删除（默认值为-1）
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先找到需要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie!=null){
            //调用cookie.setMaxAge(0);，表示当前Cookie值立即删除
            cookie.setMaxAge(0);
            //resp.addCookie(cookie);通知客户端保存修改
            resp.addCookie(cookie);
            resp.getWriter().write("key2的Cookie已经被删除");
        }
    }
    protected void lifeHour(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("keyHour", "valueHour");
        //设置该Cookie存活时间为1小时，单位是秒
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建一个存活一小时的Cookie");
    }
    protected void setPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "pathValue");
        //req.getContextPath() 获取工程路径
        //cookie.setPath()设置当前Cookie的路径 ---> /工程量就/abc
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有path路径的Cookie");
    }

}
