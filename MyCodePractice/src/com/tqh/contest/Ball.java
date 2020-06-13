package com.tqh.contest;

public enum Ball{
    FOOTBALL(20,3),BASKETBALL(30,5);
    private final double raduis;
    private final double weight;
    Ball(double raduis,double weight){
        this.raduis=raduis;
        this.weight=weight;
    }
    public double getVolume(){return Math.PI*raduis*raduis*raduis;}
}