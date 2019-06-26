package xin.shenheng.jdbc01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPCient {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("D:\\a.jpg");//本地流

        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        int len = 0;

        byte[] bytes = new byte[1024];
        while ((len = file.read(bytes)) != -1) {
            os.write(bytes,0,len);
        }

        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
            os.write(bytes,0,len);
        }



        file.close();
        socket.close();



    }
}
