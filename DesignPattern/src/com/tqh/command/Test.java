package com.tqh.command;

/**
 * @Author: Mcorleon
 * @Date: 18-8-9 16:32
 */
public class Test {
    public static void main(String[] args){
        Database database=new Database();
        Broker broker=new Broker();
        broker.takeOrder(new DeleteData(database));
        broker.takeOrder(new InsertData(database));
        broker.placeOrder();
    }
}
