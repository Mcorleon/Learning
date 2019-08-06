package com.tqh.argorithms;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Mcorleon
 * @Date 2019/4/9 20:45
 */
public class LRUCache {
    private static ConcurrentHashMap<Integer, User> map = new ConcurrentHashMap<>();
    private static User head;

    public static void add(User user) {
        if (map.containsKey(user.id)) {
            System.out.println("不能重复添加用户");
            return;
        }

        map.put(user.id, user);

        User next = head;
        head = user;
        user.next = next;
        if (next != null) {
            next.pre = user;
        }

        System.out.println("add:" + user.id);
        print();
    }

    public static String get(int id) {
        if (!map.containsKey(id)) {
            return null;
        }
        User user = map.get(id);
        //移到最前面
        if (user != head) {
            User next = user.next;
            User pre = user.pre;
            pre.next = next;
            if (next != null) {
                next.pre = pre;
            }
            User nx = head;
            head = user;
            user.next = nx;
            nx.pre = user;

        }
        System.out.println("get:" + id + "->" + user.info);
        print();
        return user.info;
    }

    public static void print() {
        String s = "";
        User p = head;
        while (p != null) {
            if (p.next != null) {
                s += p.id + "->";
            } else {
                s += p.id;
            }
            p = p.next;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        LRUCache.add(new User(1, "tqh"));
        LRUCache.add(new User(2, "henry"));
        LRUCache.add(new User(3, "john"));
        LRUCache.add(new User(4, "Maria"));
        LRUCache.add(new User(5, "Sam"));
        LRUCache.get(3);
        LRUCache.get(1);
        LRUCache.get(4);


    }
}

class User {
    public int id;
    public String info;
    public User next;
    public User pre;

    public User(int id, String info) {
        this.id = id;
        this.info = info;
    }
}
