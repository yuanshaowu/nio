package com.nio.block;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) throws IOException {
        System.out.println("socket tcp服务器端启动....");
        ServerSocket serverSocket = new ServerSocket(8077);
        // 等待客户端请求
        try {
            while (true) {
                Socket accept = serverSocket.accept();
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            InputStream inputStream = accept.getInputStream();
                            // 转换成string类型
                            byte[] buf = new byte[1024];
                            int len = inputStream.read(buf);
                            String str = new String(buf, 0, len);
                            System.out.println("服务器接受客户端内容:" + str);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }

                    }
                }).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}