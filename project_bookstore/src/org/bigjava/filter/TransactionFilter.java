package org.bigjava.filter;

import org.bigjava.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: TransactionFilter
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-16 22:59
 * @Version v1.0
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            //把错误抛给Tomcat管理展示友好的错误页面
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
