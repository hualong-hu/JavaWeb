package org.bigjava.web;

import org.bigjava.pojo.Book;
import org.bigjava.pojo.Page;
import org.bigjava.service.BookService;
import org.bigjava.service.impl.BookServiceImpl;
import org.bigjava.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: ClientBookServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-08 12:32
 * @Version v5.0
 */
public class ClientBookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用BookService.page(pageNo,pageSize)
        Page<Book> page = bookService.page(pageNo,pageSize);

        page.setUrl("client/bookServlet?action=page");

        //3.保存page对象到Request域中
        req.setAttribute("page", page);
        //4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        //2.调用BookService.page(pageNo,pageSize)
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder builder = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小价格的参数，追加到到分页条的地址参数中
        if (req.getParameter("min") != null){
            builder.append("&min=").append(req.getParameter("min"));
        }
        //如果有最大价格的参数，追加到到分页条的地址参数中
        if (req.getParameter("max") != null){
            builder.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(builder.toString());

        //3.保存page对象到Request域中
        req.setAttribute("page", page);
        //4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

}
