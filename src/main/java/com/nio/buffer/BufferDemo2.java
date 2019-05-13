package com.nio.buffer;

import java.nio.ByteBuffer;

/**
 * mark(),rest()
 *
 * @author huang
 * @date 2019/4/16
 */
public class BufferDemo2 {

    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put("yswKnight".getBytes());
        System.out.println("------开启读取模式------");

        allocate.flip();
        byte[] bytes = new byte[allocate.limit()];
        //获取缓冲区数据
        allocate.get(bytes, 0, 3);
        //mark是一个索引，通过此方法指定Buffer中一个特定的position
        allocate.mark();
        System.out.println(new String(bytes, 0, 3));
        System.out.println(allocate.position());


        //这时重新获取缓冲区数据，position为4（get中获取到的第三个参数加起来的值）
        allocate.get(bytes, 3, 2);
        System.out.println(new String(bytes, 3, 2));
        System.out.println(allocate.position());

        //然后可以通过调用reset()方法恢复到这个position
        allocate.reset();
        System.out.println("------重置恢复到mark位置------");
        System.out.println(allocate.position());
    }
}
