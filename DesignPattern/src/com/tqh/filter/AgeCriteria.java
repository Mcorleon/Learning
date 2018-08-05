package com.tqh.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mcorleon
 * @Date: 18-8-5 11:19
 */
public class AgeCriteria implements Criteria {
    @Override
    public List<Dog> meetCriteria(List<Dog> dogs) {
        List<Dog> result=new ArrayList<>();
        for(Dog dog:dogs){
            if(dog.getAge()<8){
                result.add(dog);
            }
        }
        return result;
    }
}
