package org.bigjava.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: AdminFilter
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-15 15:47
 * @Version v1.0
 */
public class AdminFilter implements Filter {
    /**
     *
     * @data: 2020-06-15-16:33
     * @method: init
     * @params: [filterConfig] 获取filter的文档信息
     * @return: void
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取filter的名称filter-name的内容
        System.out.println("filter-name的值是："+filterConfig.getFilterName());
        //获取在web.xml中配置的init-param初始化参数
        System.out.println("初始化name的值是"+filterConfig.getInitParameter("name"));
        System.out.println("初始化url的值是"+filterConfig.getInitParameter("url"));
        //获取servletContext对象
        System.out.println(filterConfig.getServletContext());
    }
    /**
     * 专门用于拦截请求。
     * @data: 2020-06-15-15:49
     * @method: doFilter
     * @params: [request, response, chain]
     * @return: void
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            //让程序继续往下访问用户的目标资源
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
