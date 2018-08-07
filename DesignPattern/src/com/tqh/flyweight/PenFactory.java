package com.tqh.flyweight;

import java.util.HashMap;

/**
 * @Author: Mcorleon
 * @Date: 18-8-7 10:47
 */
public class PenFactory {
    private static final HashMap<String,Tool> penMap=new HashMap<>();
    public static Tool getPen(String name){
        Tool tool=penMap.get(name);
        if(null==tool){
            Pen pen=new Pen(name);
            penMap.put(name,pen);
            tool=pen;
            System.out.println("create pen "+name);
        }
        return tool;
    }
}
