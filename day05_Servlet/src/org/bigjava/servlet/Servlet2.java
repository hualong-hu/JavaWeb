package org.bigjava.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: Servlet2
 * @Description: 请求转发
 * @Author: 洛笙
 * @Date: 2020-05-24 0:03
 * @Version v1.0
 */
public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在servlet1中的材料查看" + username);

        //查看servlet1盖的章
        Object key1 = req.getAttribute("key1");
        System.out.println("Servlet1是否有盖章" + key1);


        //servlet2处理自己的业务
        System.out.println("servlet2处理自己的业务");
    }
}
