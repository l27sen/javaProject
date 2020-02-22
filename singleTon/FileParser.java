package singleTon;

import javax.sound.sampled.Line;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileParser {

    public static void main(String[] a) {
        try {

            File f = new File("C:\\Users\\sen\\Desktop\\doc\\5.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer dateBuffer = new StringBuffer();

            List<LineContent> lineContents = new ArrayList<>();
            while ((readLine = b.readLine()) != null) {
                //System.out.println(readLine);
                if (readLine.trim().length()>0) {
                    stringBuffer.append(readLine).append("\n");
                }
                if (readLine.contains("发表于:") && readLine.contains("主题")) {
                    dateBuffer.append(readLine.substring(readLine.indexOf("发表于:") + 4, readLine.length() - 1));
//                    System.out.println(dateBuffer.toString());
                }
                if (readLine.endsWith("--")) {
                     LineContent lineContent = new LineContent();
                    System.out.println(stringBuffer.toString());
                    lineContent.setContent(new String(stringBuffer.toString()));
                    Date date =convert(dateBuffer.toString());
                    if(date ==null){
                        continue;
                    }
                    lineContent.setCreateDate(date);
                    dateBuffer.setLength(0);
                    lineContents.add(lineContent);
                    stringBuffer.setLength(0);


                }

            }

            Collections.sort(lineContents);
            System.out.println("size " + lineContents.size());

           for(LineContent lineContent:lineContents){
               try
               {
                   String filename= "5460.txt";
                   FileWriter  fw = new FileWriter(filename,true); //the true will append the new data
                   String str=lineContent.getContent();
                   str+="\r\n";
                   fw.write(str);//appends the string to the file
                   fw.close();
               }
               catch(IOException ioe)
               {
                   System.err.println("IOException: " + ioe.getMessage());
               }
           }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Date convert(String input) {

        if(input.isEmpty()){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {

            date = formatter.parse(input);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            System.out.println("wrong input "+input);
            e.printStackTrace();
            System.exit(1);
        }
        return date;
    }



}
