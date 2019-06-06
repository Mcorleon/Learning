package com.tqh.argorithms;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Mcorleon
 * @Date 2019/4/9 20:45
 */
public class LRUCache {
    private static final int SIZE = 10;
    private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    private static LinkedList<String> list = new LinkedList<String>();

    public static void add(String key, String value) {
        if (map.containsKey(key)) {
            System.out.println("缓存名称不能重复");
            return;
        }
        if (list.size() >= SIZE) {
            //删除最后一个再添加
            map.remove(list.removeLast());
        }
        map.put(key, value);
        list.addFirst(key);
        System.out.print("add:" + key);
        print();
    }

    public static String get(String key) {
        if (!map.contains(key)) {
            return null;
        }
        String value = map.get(key);
        //移到最前面
        list.remove(key);
        list.addFirst(key);
        System.out.print("get:" + key + "->" + value);
        print();
        return value;
    }

    public static void print() {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s += " " + list.get(i);
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        LRUCache.add("1", "a");
        LRUCache.add("2", "b");
        LRUCache.add("3", "c");
        LRUCache.add("4", "d");
        LRUCache.add("5", "e");
        LRUCache.add("6", "f");
        LRUCache.add("7", "g");
        LRUCache.add("8", "h");
        LRUCache.add("9", "i");
        LRUCache.add("10", "j");
        LRUCache.get("7");
        LRUCache.add("666", "g");
    }
}

