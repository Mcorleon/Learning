package com.tqh.visitor;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 15:00
 */
public interface ComputerPartVisitor {
    void visit(Mouse mouse);
    void visit(KeyBoard keyBoard);
    void visit(Screen screen);
    void visit(Computer computer);
}
