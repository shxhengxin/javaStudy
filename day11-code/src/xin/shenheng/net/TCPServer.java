package xin.shenheng.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        
        byte[] bytes = new byte[1024];

        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        OutputStream outputStream = socket.getOutputStream();

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();

        outputStream.write(next.getBytes());


        socket.close();
        serverSocket.close();

    }
}
