package com.tqh.io;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Test1 {
    public static void main(String[] args){
        File file=new File("src/com/tqh/generic");
        String[] list=file.list();
        ArrayList<File> files=new ArrayList<File>();
        for(int i=0;i<list.length ;i++){
            files.add(new File("src/com/tqh/generic/"+list[i]));
        }

        for(int i=0;i<files.size() ;i++){
            Date date=new Date(files.get(i).lastModified());
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date endDate=simpleDateFormat.parse("2017-12-28 12:00:00");
                if (date.getTime()>endDate.getTime())
                    System.out.println(files.get(i));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
