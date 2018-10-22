package com.tqh.container;

import java.io.*;
import java.util.*;

public class Text2 {
    public static void main(String[] args){
//        File file=new File("src/test.txt");
//        try {
//            Scanner scanner=new Scanner(file);
//            while (scanner.hasNext()){
//                System.out.println(scanner.next());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        ArrayList arrayList=new ArrayList();
        CollectionGenerator<ArrayList> collectionGenerator=new CollectionGenerator<ArrayList>(arrayList);
        System.out.println(arrayList);
    }
}

class CollectionGenerator<T extends Collection>{

    public CollectionGenerator(T x){
        try {
            File file=new File("src/test.txt");
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String[] strings=bufferedReader.readLine().split(" ");
            for (int i = 0; i <strings.length ; i++) {
                x.add(strings[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}