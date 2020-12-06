package org.bigjava.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @ProjectName: JavaWeb
 * @ClassName: Cart
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-13 11:05
 * @Version v1.0
 */
public class Cart {
    /**
     * 商品总数量
     */
//    private Integer totalCount;

    /**
     * 商品总价
     */
//    private BigDecimal totalPrice;
    /**
     * 商品项集合
     * key是商品编号
     * value是商品信息
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<>();

    /**
     * 添加商品项
     * @data: 2020-06-13-11:27
     * @method: addItems
     * @params: [cartItem]
     * @return: void
     */
    public void addItems(CartItem cartItem){
        //先查看购物车中是否已经添加过此商品，如果已添加，则数量累加，总金额更新，如果没有添加，直接放到集合中！！
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        }else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())) );
        }
    }
    /**
     * 删除商品项
     * @data: 2020-06-13-11:28
     * @method: deleteItem
     * @params: [id]
     * @return: void
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }
    /**
     * 清空购物车
     * @data: 2020-06-13-11:29
     * @method: clearItem
     * @params: []
     * @return: void
     */
    public void clearItem(){
        items.clear();
    }
    /**
     * 修改商品数量
     * @data: 2020-06-13-11:29
     * @method: updateCount
     * @params: [id, count]
     * @return: void
     */
    public void updateCount(Integer id,Integer count){
        CartItem cartItem = items.get(id);
        if (cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }


    }

    public Cart() {
    }

    public Cart(Integer totalCount, BigDecimal totalPrice, Map<Integer, CartItem> items) {
//        this.totalCount = totalCount;
//        this.totalPrice = totalPrice;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
