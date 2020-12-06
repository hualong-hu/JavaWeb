package org.bigjava.servlet1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: Response1
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-24 18:24
 * @Version v1.0
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Response1曾到此一游");
//        //设置响应状态码302，表示重新定向（已搬迁）
//        resp.setStatus(302);
//        //设置响应头，说明新的地址在哪里
//        resp.setHeader("Location", "http://localhost:8080/day05_Servlet_war_exploded/response2");

        resp.sendRedirect("http://localhost:8080/day05_Servlet_war_exploded/response2");
    }
}
