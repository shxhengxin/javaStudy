package xin.shenheng.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * tcp通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
       Socket socket = new Socket("127.0.0.1",8888);

        OutputStream outputStream = socket.getOutputStream();

        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        outputStream.write(next.getBytes());


        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);

        System.out.println(new String(bytes,0,len));

        socket.close();

    }
}
