package org.bigjava.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: SessionServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-10 21:42
 * @Version v1.0
 */
public class SessionServlet extends BaseServlet{

    /**
     * 创建或获取session会话对象
     * @data: 2020-06-10-21:49
     * @User: 洛笙
     * @method: creatSession
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void creatSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Session会话对象
        HttpSession session = req.getSession();
        //2.判断当前Session会话是否是新创建出来的
        boolean sessionNew = session.isNew();
        //3.获取Session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的session，它的id是"+id+"<br/>");
        resp.getWriter().write("得到的session，它是否是新创建的"+sessionNew+"<br/>");

    }
    /**
     * 往session中保存数据
     * @data: 2020-06-10-21:50
     * @User: 洛笙
     * @method: setAttribute
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("数据存储成功！！");
    }
    /**
     * 获取session域中的数据
     * @data: 2020-06-10-21:50
     * @User: 洛笙
     * @method: getAttribute
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("Session域中key1的值是"+key1);
    }
    /**
     * 获取Session的默认超时时长
     * @data: 2020-06-10-22:17
     * @User: 洛笙
     * @method: defaultLife
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认超时时长为"+maxInactiveInterval+"秒");
    }
    /**
     * 设置当前Session会话对象的超时时长
     * @data: 2020-06-10-22:17
     * @User: 洛笙
     * @method: life
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void life(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //设置当前Session3秒超时
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前Session已经设置为3秒后超时");
    }
    /**
     * 设置当前Session立刻超时销毁
     * @data: 2020-06-10-22:21
     * @User: 洛笙
     * @method: deleteNow
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //设置当前Session会话立刻超时销毁
        session.invalidate();
        resp.getWriter().write("当前Session已经设置为超时（无效）");
    }
}
