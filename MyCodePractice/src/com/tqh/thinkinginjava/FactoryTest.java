package com.tqh.thinkinginjava;

public class FactoryTest {
    public static void main(String[] args){
        gogogo(new UnicycleFactory());
        gogogo(new TricycleFactory());
        gogogo(new BicycleFactory());
    }

    public static void gogogo(CycleFactory cycleFactory){
        Cycle cycle=cycleFactory.getCycle();
        cycle.move();
    }
}


interface Cycle{
    void move();
}

interface CycleFactory {
    Cycle getCycle();
}
class Unicycle implements Cycle{

    @Override
    public void move() {
        System.out.println("Unicycle run");
    }
}
class Bicycle implements Cycle{

    @Override
    public void move() {
        System.out.println("Bicycle run");
    }
}
class Tricycle implements Cycle{

    @Override
    public void move() {
        System.out.println("Tricycle run");
    }
}
class UnicycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}
class BicycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}
class TricycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}