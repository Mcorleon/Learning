package com.tqh.filter;

import java.util.List;

/**
 * @Author: Mcorleon
 * @Date: 18-8-5 11:15
 */
public interface Criteria {

    List<Dog> meetCriteria(List<Dog> dogs);
}