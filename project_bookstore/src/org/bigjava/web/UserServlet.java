package org.bigjava.web;

import com.google.gson.Gson;
import org.bigjava.pojo.User;
import org.bigjava.service.impl.UserServiceImpl;
import org.bigjava.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


/**
 * @ProjectName: JavaWeb
 * @ClassName: UserServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-04 22:05
 * @Version v1.0
 */
public class UserServlet extends BaseServlet {

    /**
     * 处理登录操作
     * @data: 2020-06-04-22:24
     * @User: 洛笙
     * @method: login
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = new UserServiceImpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(null,username,password,null);
        User loginUser = userService.login(user);
        if (loginUser == null) {
            //把错误信息和回显的表单项信息，保存到request域中
            req.setAttribute("msg", "用户名或密码错误，登录失败");
            req.setAttribute("username", username);
            //登录失败
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else {
            HttpSession session = req.getSession();
            session.setAttribute("user", loginUser);
            //登录成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
    /**
     * 处理注册操作
     * @data: 2020-06-04-22:24
     * @User: 洛笙
     * @method: regist
     * @params: [req, resp]
     * @return: void
     * @Description: 描述
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String session = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        UserServiceImpl userService = new UserServiceImpl();
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User bean = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2.检查 验证码是否正确
        if ( session!= null && session.equalsIgnoreCase(code)){
            //3.检查用户名是否可用
            if (userService.existsUsername(username)){
                //用户名已存在不可用，跳回注册页面
                System.out.println("用户名已存在！请重新输入用户名！");
                //把回显信息保存到request域中
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                //用户名不存在，可用，调用service保存到数据库
                User user = new User(null,username,password,email);
                userService.register(user);
                req.getSession().setAttribute("user", user);
                //跳转到注册成功的页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else {
            //把回显信息保存到request域中
            req.setAttribute("msg", "验证码错误！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("验证码【"+ code +"】错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    /**
     * 注销
     * @data: 2020-06-11-11:50
     * @method: logout
     * @params: [req, resp]
     * @return: void
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁Session中的用户登录信息（或者销毁Session）
        req.getSession().invalidate();
        //重定向到首页（或登录页面）
        resp.sendRedirect(req.getContextPath());
    }

    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        //调用userService.existsUsername(username)
        UserServiceImpl userService = new UserServiceImpl();
        boolean existsUsername = userService.existsUsername(username);

        //把返回的结果封装成map对象
        HashMap<String, Object> map = new HashMap<>();
        map.put("existsUsername", existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }
}
