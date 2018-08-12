package com.tqh.visitor;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 15:09
 */
public class Test{
    public static void main(String[] args){
        Computer computer=new Computer();
        computer.accept(new ComputerDisplayVisitor());
    }

}
