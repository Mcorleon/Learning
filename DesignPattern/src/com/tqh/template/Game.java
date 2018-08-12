package com.tqh.template;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 14:40
 */
public abstract class Game {
    abstract void init();
    abstract void start();
    abstract void end();

    public final void play(){
        init();
        start();
        end();
    }
}
