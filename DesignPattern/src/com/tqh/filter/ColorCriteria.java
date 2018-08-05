package com.tqh.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mcorleon
 * @Date: 18-8-5 11:17
 */
public class ColorCriteria implements Criteria{
    @Override
    public List<Dog> meetCriteria(List<Dog> dogs) {
        List<Dog> result=new ArrayList<>();
        for (Dog dog:dogs){
            if (dog.getColor().equals("black")){
                result.add(dog);
            }
        }
        return result;
    }
}
