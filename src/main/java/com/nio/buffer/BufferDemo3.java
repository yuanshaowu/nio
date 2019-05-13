package com.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @author huang
 * @date 2019/4/1
 */
public class BufferDemo3 {

    public static void main(String[] args) {
        //分配比较
        directMemoryAllocate();

        //读写比较
        readerAndWriter();
    }

    /**
     * 内存分配
     */
    private static void directMemoryAllocate() {
        long tsStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(400);
        }
        System.out.println("direct memory allocate: " + (System.currentTimeMillis() - tsStart) + " ms");
        tsStart = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            ByteBuffer buffer = ByteBuffer.allocate(400);
        }
        System.out.println("heap memory allocate： " + (System.currentTimeMillis() - tsStart) + " ms");
    }

    /**
     * 读写
     */
    private static void readerAndWriter() {
        int foreachCount = 1000_0000;
        ByteBuffer buffer = ByteBuffer.allocateDirect(400);
        ByteBuffer buffer2 = ByteBuffer.allocate(400);

        long tsStart = System.currentTimeMillis();
        byteBuffer(foreachCount, buffer);
        System.out.println("direct memory rw： " + (System.currentTimeMillis() - tsStart) + " ms");

        tsStart = System.currentTimeMillis();
        byteBuffer(foreachCount, buffer2);
        System.out.println("heap memory rw： " + (System.currentTimeMillis() - tsStart) + " ms");
    }

    /**
     * byteBuffer
     *
     * @param foreachCount 循环次数
     * @param byteBuffer   字节流
     */
    private static void byteBuffer(int foreachCount, ByteBuffer byteBuffer) {
        for (int i = 0; i < foreachCount; i++) {
            for (int j = 0; j < 100; j++) {
                byteBuffer.putInt(j);
            }
            byteBuffer.flip();
            for (byte j = 0; j < 100; j++) {
                byteBuffer.getInt();
            }
            byteBuffer.clear();
        }
    }
}
