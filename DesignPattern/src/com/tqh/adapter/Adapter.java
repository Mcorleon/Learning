package com.tqh.adapter;

/**
 * @Author: Mcorleon
 * @Date: 18-8-5 10:38
 */
public class Adapter extends USBentity implements TTL{
    @Override
    public void isTTL() {
        isUsb();
    }
}
