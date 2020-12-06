package org.bigjava.servlet;

import org.bigjava.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ProjectName: JavaWeb
 * @ClassName: SearchStudentServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-05-30 21:07
 * @Version v1.0
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        //发sql语句给数据库
        //使用for循环生成查询到的数据做模拟
        ArrayList<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            studentList.add(new Student(i+1, "student"+(i+1), 18+i, "phone"+i));
        }
        //保存查询到的结果（学生信息）到request域中
        req.setAttribute("student", studentList);
        //请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req, resp);
    }
}
