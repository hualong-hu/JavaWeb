package org.bigjava.servlet;

import org.bigjava.bean.Book;
import org.bigjava.service.Dom4jService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: JavaWeb
 * @ClassName: Dome4jServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-09-27 9:36
 * @Version v1.0
 */
@WebServlet("/test")
public class Dome4jServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dom4jService service = new Dom4jService();
        List book = service.getBook();




        req.setAttribute("map", book);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
