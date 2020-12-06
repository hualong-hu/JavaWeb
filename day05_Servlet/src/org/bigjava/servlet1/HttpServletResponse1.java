package org.bigjava.servlet1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServletResponse 类的作用
 * 字节流 getOutputStream(); 常用于下载（传递二进制数据）
 * 字符流 getWriter(); 常用于回传字符串（常用）
 * 两个流同时只能使用一个。 使用了字节流，就不能再使用字符流，反之亦然，否则就会报错。
 *
 *
 * @ProjectName: JavaWeb
 * @ClassName: HttpServletResponse1
 * @Description: HttpServletResponse的使用
 * @Author: 洛笙
 * @Date: 2020-05-24 17:55
 * @Version v1.0
 */
public class HttpServletResponse1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //方式一
//        //设置服务器的字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");
//        //通过响应头设置浏览器的字符集为UTF-8
//        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

        //方式二
        //同时设置服务器和客户端都使用UTF-8字符集，并设置了响应头
        //此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.println("龙哥帅炸了");
    }
}
