package com.tqh.work;

/**
 * @Author Mcorleon
 * @Date 2019/4/22 16:21
 */
public class ViData {
    private float t_x;
    private float t_y;
    private float r_x;
    private float r_y;
    private float r_z;
    private float r_w;

    public ViData(float t_x,float t_y,float r_x,float r_y,float r_z,float r_w){
        setT_x(t_x);
        setT_y(t_y);
        setR_x(r_x);
        setR_y(r_y);
        setR_z(r_z);
        setR_w(r_w);
    }
    public float getT_x() {
        return t_x;
    }

    public void setT_x(float t_x) {
        this.t_x = t_x;
    }

    public float getT_y() {
        return t_y;
    }

    public void setT_y(float t_y) {
        this.t_y = t_y;
    }

    public float getR_x() {
        return r_x;
    }

    public void setR_x(float r_x) {
        this.r_x = r_x;
    }

    public float getR_y() {
        return r_y;
    }

    public void setR_y(float r_y) {
        this.r_y = r_y;
    }

    public float getR_z() {
        return r_z;
    }

    public void setR_z(float r_z) {
        this.r_z = r_z;
    }

    public float getR_w() {
        return r_w;
    }

    public void setR_w(float r_w) {
        this.r_w = r_w;
    }
}
