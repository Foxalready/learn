package com.fox.netty;

//import org.jboss.netty.channel.socket.SocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/8/26
 * @Version: [v1.0]
 */
public class NettyTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InterruptedException {


        TimeUnit.SECONDS.sleep(2);

        int a = 1 | 4;
        if (a == 1) {
            System.out.println("111111");
        }
        if (a == 4) {
            System.out.println("4444444444");
        }

        System.out.println(a);

//        Selector selector = new Selector();

//        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//        theUnsafe.setAccessible(true);
//        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
//        long l = unsafe.allocateMemory(1024);


//        Unsafe unsafe = Unsafe.getUnsafe();

//        long directBuffer = unsafe.allocateMemory(1024);
//
//        System.out.println(directBuffer);

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://baidu.com", 80));

        Selector open = Selector.open();

        socketChannel.register(Selector.open(), SelectionKey.OP_READ | SelectionKey.OP_WRITE);
//
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        int bytesRead = socketChannel.read(buffer);
//lis
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
//        LongBuffer allocate = LongBuffer.allocate(2014);
//
//        String s = "hello world";
//        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
//        writeBuffer.clear();
//        writeBuffer.put(s.getBytes());
//
//        writeBuffer.flip();
//
//        while (writeBuffer.hasRemaining()){
//            socketChannel.write(writeBuffer);
//        }
//
//        socketChannel.close();
    }

    private void serverSocket() throws IOException {

        Buffer buffer;

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while (true) {
            SocketChannel accept = serverSocketChannel.accept();
        }
    }
}
