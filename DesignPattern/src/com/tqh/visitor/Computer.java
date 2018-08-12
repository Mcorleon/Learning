package com.tqh.visitor;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 15:04
 */
public class Computer implements ComputerPart {
    private ComputerPart[] parts;
    public Computer(){
        parts=new ComputerPart[]{new KeyBoard(),new Mouse(),new Screen()};
    }
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (ComputerPart computerPart:parts){
            computerPart.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
