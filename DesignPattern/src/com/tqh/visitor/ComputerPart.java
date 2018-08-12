package com.tqh.visitor;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 15:00
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
