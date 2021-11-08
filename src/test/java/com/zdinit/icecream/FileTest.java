package com.zdinit.icecream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("c:\\temp.txt"); //创建文件对象
        try {
            // 通过文件对象创建文件输入流
            FileInputStream filein = new FileInputStream(f);
            //创建字节数组，用于接收从文件中读取的字节
            byte buf[] = new byte[1024];
            String instr = ""; //接收字节转化的字符串
            int length = filein.read(buf);
            instr = new String(buf,0,length);//将字节转化成字符串
            System.out.println(instr);
            filein.close(); //关闭输入流
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
