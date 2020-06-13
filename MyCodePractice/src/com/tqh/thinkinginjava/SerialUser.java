package com.tqh.thinkinginjava;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @Author Mcorleon
 * @Date 2020/2/24 13:49
 */
public class SerialUser implements Serializable {
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
    }
}
