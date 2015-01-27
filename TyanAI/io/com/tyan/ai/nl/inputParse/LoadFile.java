package com.tyan.ai.nl.inputParse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LoadFile {
	
	public static String[] readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        String context = "";
        try {
        	
        	String encoding="GBK";
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file),encoding);
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                  //  System.out.print((char) tempchar);
                    context += (char)tempchar;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  System.out.println(context);
        String[] subStrings = context.split("\n");
/*        for(String xx : subStrings){
        	System.out.println(xx);
        	//break;
        }*/
        return subStrings;
	}

	public static void readTxtFile(String filePath){
		String context = "";
        try {
        	
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    //    System.out.println(lineTxt);
                        context += lineTxt;
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }finally{
        //	System.out.println(context);
        }
        
        String[] subStrings = context.split("\n");
        for(String xx : subStrings){
        	System.out.println(xx);
        	//break;
        }
     
    }
     

}
