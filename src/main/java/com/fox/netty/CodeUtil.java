package com.fox.netty;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/9/3
 * @Version: [v1.0]
 */
public class CodeUtil {

    @SuppressWarnings("unused")
    public static ByteBuffer read(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int count = channel.read(buffer);
        if (count == -1) {
            return null;
        }

        return buffer;
    }

    @SuppressWarnings("unused")
    public static void write(SocketChannel channel, String content) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //不考虑是否超过 buffer上限
        buffer.put(content.getBytes("utf-8"));

        buffer.flip();

        //此处不考虑超过 channel缓存区上限
        channel.write(buffer);
    }

    @SuppressWarnings("unused")
    public static String newString(ByteBuffer buffer) throws UnsupportedEncodingException {
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        System.arraycopy(buffer.array(), buffer.position(), bytes, 0, buffer.remaining());
        return new String(bytes, "utf-8");
    }
}
