package com.nio.block;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("socket tcp 客户端启动....");
        Socket socket = new Socket("127.0.0.1", 8077);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好你好你好啊啊啊啊".getBytes());
        socket.close();
    }
}