package com.tqh.argorithms;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Author Mcorleon
 * @Date 2019/4/13 11:06
 */
public class StringEncode {
    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        return out.toString("ISO-8859-1");

    }

    public static String uncompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toString();
    }

    public static void main(String[] args){
//        String s="%5B%7B%22lastUpdat%3A%221gnfsidbgksdbnfkjsdnvducivghxicvxjkcvkxcbvksxdufghisuedhfisudhfisduhfsuidhfsiudhfsdidufhw457238975" +
//                "221gnfsidbgksdbnfkjsdnvducivghxicvxjkcvkxcbvksxdufghisuedhfisudhfisduhfsuidhfsiudhfsdidufhw457238975rwehfksdjfvsdfsdf7ws738ry82347yr823h45uh23i534h654j35h6e3h45uh23i534h654j35h63" +
//                "221gnfsidbgksdbnfkj452345sdnv2lastUpdaducivgdicvxjkcvkxcbvksxdufghisuedhfidsudhfisduhfsfguidhfsiudhfsdidufhw457238975rwehfksdjfvsdfsdf7ws738ry82347yr823h45uh2rg3i534h654j35h63" +
//                "221gnfsidbgksdbnfkjsdnvvkxcbvksxdducivghxicvxjkcvkxcbvk4rsxd2lastcpdaufghisuedhfisudh2lastUpda345fisduhfsuidhfsiudhfsdidufhw457238975rwehfksdjfvsdfsdf7ws738ry82347yr823h45uh23i534h654j35h63" +
//                "221gnfsidb2lastUpdagksdbnfkjsd2fb3nvducivgh2lastUpdaxicvxjk3453er4cvkxcbvktsxdvkxcbvksxdu2lastUpdafghisuedhfisudhfisduhfsuidhfsiudhfsdidufhw457238975rdfwehfksdjfvsdfsdf7wsergfgeg38ry82347yr823h45uh23i534h654j35h63" +
//                "221gnfsidbgksdbnfkjvkxcbvkrtgsxdsdnvducivghxicvxjkfcvkxcbvksxdufvdfkxcbvksxdghisuwsgfhfghdhfisudhfisduhfsuidhfsiudhfsdidufhw457238975rwehfksdjfvsdfsdf7ws738ry82347yr823h45uh23i534dfg654j35h63" +
//                "221gnfsidbgksdbnfkjsdnvducivghxicvxjkc2lastUpdavkxcbvksxdufgh2lastUp2lastUpdaaisuedhfisudhfisduhfsuidhfsiudhfsdidufhw457238975rwehfksdjfvsdfsdf7ws738ry82347yr823h45uh23i534h654j35h63rwedfhfgdfksdjfvsdfsdf7ws738ry82347yr823h45uh23i534h654j35h63";
//        System.out.println("原长度："+s.length());
//        String temp= null;
//        try {
//            temp = compress(s);
//            System.out.println("压缩后："+temp.length());
//            System.out.println(temp);
//            System.out.println("解压缩："+uncompress(temp));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        HashSet<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        HashSet<Integer> set2=new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        System.out.println(set1.retainAll(set2));

    }
}
