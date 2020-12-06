package org.bigjava.service;


import org.bigjava.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
