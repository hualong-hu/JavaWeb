package org.bigjava.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: TestServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-10 14:02
 * @Version v1.0
 */
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuery === 请求开始");

        String username = req.getParameter("username");
        System.out.println("username = " + username);

        Gson gson = new Gson();
        //将java对象转换成json字符串
        String json = gson.toJson(username);

        resp.getWriter().write(json);
    }
}
