package com.nio.buffer;

import java.nio.ByteBuffer;

/**
 * flip()，rewind()，clear()
 *
 * @author huang
 * @date 2019/4/16
 */
public class BufferDemo1 {

    /**
     * position：缓冲区正在操作的位置，默认从0开始
     * limit：界面（缓冲区可用大小）
     * capacity：缓冲区最大容量，一旦声明不能改变
     * <p>
     * 核心方法
     * put：往buffer存在数据
     * get：获取数据
     */
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        System.out.println("position:" + byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println("-------------------往byteBuffer存在数据-----------------------");
        byteBuffer.put("abcd1".getBytes());
        System.out.println("position:" + byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println("-------------------读取值--------------------");
        //开启读取模式
        byteBuffer.flip();
        System.out.println("position:" + byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));

        System.out.println("-------------------重复读取--------------------");
        //开启读取模式，位置会重置之前位置，报异常
        byteBuffer.rewind();
        System.out.println("position:" + byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] bytes2 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes2);
        System.out.println(new String(bytes2, 0, bytes2.length));

        System.out.println("-------------------清空缓冲区--------------------");
        //开启读取模式，位置会重置之前位置，报异常
        byteBuffer.clear();
        System.out.println("position:" + byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] bytes3 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes3);
        System.out.println(new String(bytes3, 0, bytes3.length));
    }
}
