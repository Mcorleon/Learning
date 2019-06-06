package com.tqh.deep_learing_data_sort;

/**
 * @Author Mcorleon
 * @Date 2019/4/22 17:18
 */
public class LAndDegree {
    double L;
    double degree;

    public double getL() {
        return L;
    }

    public void setL(double l) {
        L = l;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public LAndDegree(double L, double degree){
        this.L=L;
        this.degree=degree;
    }
}
