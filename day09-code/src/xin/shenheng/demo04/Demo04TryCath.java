package xin.shenheng.demo04;

import java.io.IOException;

public class Demo04TryCath {

    public static void main(String[] args) {
        try{
            readFile("d:\\a.txt");
        }catch (IOException e){
            System.out.println("1111111111");
        }
        System.out.println("22222222222");
    }

    public static void readFile(String fileName) throws IOException {
        if(!fileName.endsWith(".txt")) {
            throw new IOException("文件后缀名不对");
        }
    }
}
