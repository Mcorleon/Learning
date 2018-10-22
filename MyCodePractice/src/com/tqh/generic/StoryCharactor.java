package com.tqh.generic;

import java.lang.reflect.InvocationTargetException;

public class StoryCharactor {
    private String name;
    private String located;
    public StoryCharactor(String name,String located){
        this.name=name;
        this.located=located;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocated() {
        return located;
    }

    public void setLocated(String located) {
        this.located = located;
    }
}

class GoodGuys extends StoryCharactor{

    public GoodGuys(String name, String located) {
        super(name, located);
    }
}

class BadGuys extends StoryCharactor {
    public BadGuys(String name, String located) {
        super(name, located);
    }
}

class StoryCharactorGenerator{
    public StoryCharactorGenerator(){

    }

    public StoryCharactor next(){
        try {
            return (StoryCharactor) BadGuys.class.getConstructors()[0].newInstance("1","2");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}