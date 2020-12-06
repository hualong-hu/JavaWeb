package org.bigjava.web;


import org.bigjava.pojo.Cart;
import org.bigjava.pojo.User;
import org.bigjava.service.OrderService;
import org.bigjava.service.impl.OrderServiceImpl;
import org.bigjava.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     * @data: 2020-06-16-15:31
     * @method: createOrder
     * @params: [req, resp]
     * @return: void
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //调用orderService.createOrder(Cart,Userid);生成订单
            Integer userId = loginUser.getId();
            String orderId = orderService.createOrder(cart, userId);
            req.getSession().setAttribute("orderId", orderId);
            resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
        }

    }

}
