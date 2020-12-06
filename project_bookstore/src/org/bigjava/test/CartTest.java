package org.bigjava.test;

import org.bigjava.pojo.Cart;
import org.bigjava.pojo.CartItem;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @ProjectName: JavaWeb
 * @ClassName: CartTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-13 15:39
 * @Version v1.0
 */
public class CartTest {

    @Test
    public void addItems() {
        Cart cart = new Cart();
        cart.addItems(new CartItem(1, "java从入门到精通", 2, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItems(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItems(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100), new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItems(new CartItem(1, "java从入门到精通", 2, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItems(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItems(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.deleteItem(1);
        System.out.println(cart);

    }

    @Test
    public void clearItem() {
        Cart cart = new Cart();
        cart.addItems(new CartItem(1, "java从入门到精通", 2, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItems(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItems(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.deleteItem(1);
        cart.clearItem();
        System.out.println(cart);
    }
    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItems(new CartItem(1, "java从入门到精通", 2, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItems(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItems(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.deleteItem(1);
        System.out.println(cart);
        cart.clearItem();
        cart.addItems(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.updateCount(1,10);
        System.out.println(cart);
    }
}