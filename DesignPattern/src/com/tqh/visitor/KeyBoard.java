package com.tqh.visitor;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 15:03
 */
public class KeyBoard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
