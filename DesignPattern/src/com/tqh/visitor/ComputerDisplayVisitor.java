package com.tqh.visitor;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 15:08
 */
public class ComputerDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Mouse mouse) {
        System.out.println("dispaly mouse");
    }

    @Override
    public void visit(KeyBoard keyBoard) {
        System.out.println("dispaly keyBoard");
    }

    @Override
    public void visit(Screen screen) {
        System.out.println("dispaly screen");
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("dispaly computer");
    }
}
