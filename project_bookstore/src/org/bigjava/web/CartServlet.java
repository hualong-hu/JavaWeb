package org.bigjava.web;
import	java.util.HashMap;


import com.google.gson.Gson;
import org.bigjava.pojo.Book;
import org.bigjava.pojo.Cart;
import org.bigjava.pojo.CartItem;
import org.bigjava.service.BookService;
import org.bigjava.service.impl.BookServiceImpl;
import org.bigjava.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: JavaWeb
 * @ClassName: CartServlet
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-13 18:11
 * @Version v1.0
 */
public class CartServlet extends BaseServlet {

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id):Book得到图书的信息
        BookServiceImpl bookService = new BookServiceImpl();
        Book book = bookService.queryBookById(id);
        //把图书信息转换成CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart ==null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItems(cartItem);

        //保存最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());
        //返回购物车总的商品数量和最后一个添加的商品名称
        HashMap<String, Object> map = new HashMap<>();

        map.put("totalCount", cart.getTotalCount());
        map.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String json = gson.toJson(map);

        resp.getWriter().write(json);


    }

    /**
     * 添加商品项到购物车
     * @data: 2020-06-14-11:15
     * @method: addItem
     * @params: [req, resp]
     * @return: void
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id):Book得到图书的信息
        BookServiceImpl bookService = new BookServiceImpl();
        Book book = bookService.queryBookById(id);
        //把图书信息转换成CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem)添加商品项

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart ==null){
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItems(cartItem);

        System.out.println(cart);
//        System.out.println("请求头Referer的值："+req.getHeader("Referer"));
        //保存最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());
        //重定向回商品列表页面
        resp.sendRedirect(req.getHeader("Referer"));
    }
    /**
     * 删除购物车中的商品项
     * @data: 2020-06-14-11:16
     * @method: deleteItem
     * @params: [req, resp]
     * @return: void
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            //删除购物车中的商品项
            cart.deleteItem(id);
            //重定向回商品列表页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    /**
     * 清空购物车
     * @data: 2020-06-14-11:33
     * @method: clearItem
     * @params: [req, resp]
     * @return: void
     */
    protected void clearItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //清空购物车
            cart.clearItem();
            //重定向回商品列表页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    /**
     * 修改商品数量
     * @data: 2020-06-14-14:54
     * @method: updateCount
     * @params: [req, resp]
     * @return: void
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的商品编号与商品数量
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        //获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //修改商品数量
            cart.updateCount(id, count);
            //重定向回商品列表页面
            resp.sendRedirect(req.getHeader("Referer"));

        }

    }
}
