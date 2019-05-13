package com.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 分散读取，聚集写入
 * @author huang
 * @date 2019/4/1
 */
public class BufferDemo4 {

    public static void main(String[] args) throws IOException {
        //随机访问
        RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt", "rw");
        //获取通道
        FileChannel channel = randomAccessFile.getChannel();
        //分配指定大小指定缓冲区
        ByteBuffer buffer100 = ByteBuffer.allocate(100);
        ByteBuffer buffer1024 = ByteBuffer.allocate(1024);
        //分散读取
        ByteBuffer[] byteBuffers = {buffer100, buffer1024};
        channel.read(byteBuffers);
        for (ByteBuffer byteBuffer : byteBuffers) {
            //切换读类型
            byteBuffer.flip();
        }
        System.out.println(new String(byteBuffers[0].array(), 0, byteBuffers[0].limit()));
        System.out.println(new String(byteBuffers[1].array(), 0, byteBuffers[1].limit()));
        System.out.println("--------------------聚集读取----------------------------");
        RandomAccessFile randomAccessFile2 = new RandomAccessFile("test2.txt", "rw");
        //获取通道
        FileChannel channel2 = randomAccessFile2.getChannel();
        channel2.write(byteBuffers);
        //关闭通道
        randomAccessFile.close();
        randomAccessFile2.close();
    }
}
