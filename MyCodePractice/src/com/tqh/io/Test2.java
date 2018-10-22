package com.tqh.io;

import java.io.*;

public class Test2 {
    public static void main(String[] args){
        File file=new File("src/data/hhh.txt");
        try {
            InputStream inputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            FileReader fileReader=new FileReader(file);

            OutputStream outputStream=new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
            PrintStream printStream=new PrintStream(bufferedOutputStream);
            System.setOut(printStream);
            System.out.println("滴滴滴");
            printStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
