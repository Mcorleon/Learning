package com.tqh.io;

import java.io.*;
import java.nio.charset.Charset;

public class Test3 {
    public static void main(String[] args){
        Cat cat=new Cat("NaNa",2,"Sam");
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("cat.out"));
            objectOutputStream.writeObject(cat);
            objectOutputStream.close();
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("cat.out"));
            Cat another=(Cat)objectInputStream.readObject();
            System.out.println(another.getName());
            System.out.println(another.getAge());
            System.out.println(another.getMaster());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Cat implements Serializable{
    private String name;
    public int age;
    transient String master;
    public  Cat(String name,int age,String master){
        this.name=name;
        this.age=age;
        this.master=master;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}