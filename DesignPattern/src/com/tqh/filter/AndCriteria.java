package com.tqh.filter;

import java.util.List;

/**
 * @Author: Mcorleon
 * @Date: 18-8-5 11:21
 */
public class AndCriteria implements Criteria{
    Criteria criteria1;
    Criteria criteria2;
    public AndCriteria(Criteria criteria1,Criteria criteria2){
        this.criteria1=criteria1;
        this.criteria2=criteria2;
    }
    @Override
    public List<Dog> meetCriteria(List<Dog> dogs) {
        List<Dog> result=criteria1.meetCriteria(dogs);
        return criteria2.meetCriteria(result);
    }
}
