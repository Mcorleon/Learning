package com.tqh.template;

/**
 * @Author: Mcorleon
 * @Date: 18-8-12 14:41
 */
public class FootballGame extends Game {
    @Override
    void init() {
        System.out.println("football game init");
    }

    @Override
    void start() {
        System.out.println("football game start");
    }

    @Override
    void end() {
        System.out.println("football game end");
    }
}
