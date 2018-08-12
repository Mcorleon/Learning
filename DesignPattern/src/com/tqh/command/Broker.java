package com.tqh.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mcorleon
 * @Date: 18-8-9 16:30
 */
public class Broker {
    private List<Order> orderList=new ArrayList<>();
    public void takeOrder(Order order){
        orderList.add(order);
    }
    public void placeOrder(){
        for (Order order:orderList){
            order.execute();
        }
        orderList.clear();
    }
}
