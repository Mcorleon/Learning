package com.tqh.visitor;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 15:04
 */
public class Screen implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
