package org.bigjava.dao.impl;


import org.bigjava.dao.BaseDAO;
import org.bigjava.dao.OrderItemDao;
import org.bigjava.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDAO implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
