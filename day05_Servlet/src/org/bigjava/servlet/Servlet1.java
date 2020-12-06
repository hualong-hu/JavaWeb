package org.bigjava.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: Servlet1
 * @Description: 请求转发
 * @Author: 洛笙
 * @Date: 2020-05-24 0:02
 * @Version v1.0
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在servlet1中的材料查看" + username);

        //给材料盖一个章，并传输给servlet2（柜台2）去查看
        req.setAttribute("key1", "servlet1的章");

        //问路，Servlet2（柜台2）怎么走
        /*
          请求转发必须要以斜杠打头，斜杠表示地址为：http://ip:port/工程名/，映射搭配IDEA代码的web目录
         */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

        //走向servlet2（柜台2）
        requestDispatcher.forward(req, resp);


    }
}
