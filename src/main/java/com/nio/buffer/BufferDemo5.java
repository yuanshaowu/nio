package com.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * 编码格式
 *
 * @author huang
 * @date 2019/4/1
 */
public class BufferDemo5 {

    public static void main(String[] args) throws CharacterCodingException {
        Charset charset = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder charsetEncoder = charset.newEncoder();
        //获取解析器
        CharsetDecoder charsetDecoder = charset.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("啊哈哈，你好啊");
        charBuffer.flip();

        //编码
        ByteBuffer byteBuffer = charsetEncoder.encode(charBuffer);
        for (int i = 0; i < 12; i++) {
            System.out.println(byteBuffer.get());
        }
        byteBuffer.flip();
        //解码
        CharBuffer decode = charsetDecoder.decode(byteBuffer);
        System.out.println(decode.toString());
    }
}
