package xin.shenheng.jdbc01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();


        //判断文件夹是否存在
        File file = new File("D:\\upload");
        if(!file.exists()) {
            file.mkdirs();
        }

        FileOutputStream fos = new FileOutputStream(file+"\\1.jpg");//本地流

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }


        socket.getOutputStream().write("上传成功".getBytes());

        socket.close();
        fos.close();
        serverSocket.close();





    }
}
