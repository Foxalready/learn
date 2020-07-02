package com.fox.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Description: [描述此类]
 * @Author: gaoyimin
 * @CreateDate: 2019/9/3
 * @Version: [v1.0]
 */
public class NioServer {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;


    public static void main(String[] args) throws IOException {
        NioServer server = new NioServer();
    }

    public NioServer() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8087));

        selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server 启动完成");

        handleKeys();
    }

    private void handleKeys() throws IOException {
        while (true) {
            int selectNums = selector.select(30 * 1000L);
            if (selectNums == 0) {
                continue;
            }
            System.out.println("选择channel数量 ：" + selectNums);

            //遍历可选择的 Channel 的 SelectionKey 集合
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (!key.isValid()) {
                    continue;
                }

                handleKey(key);
            }
        }
    }

    private void handleKey(SelectionKey key) {

    }

    private void handleAcceptableKey(SelectionKey key) throws IOException {
        //接受 Client Socket Channel
        SocketChannel clientSocketChannel = ((ServerSocketChannel) key.channel()).accept();
        clientSocketChannel.configureBlocking(false);
        System.out.println("接受新的channel");

        clientSocketChannel.register(selector, SelectionKey.OP_READ, new ArrayList<String>());
    }

    @SuppressWarnings("unchecked")
    private void handleReadalbeKey(SelectionKey key) throws IOException {
        SocketChannel clientSocketChannel = (SocketChannel) key.channel();

        ByteBuffer readBuffer = CodeUtil.read(clientSocketChannel);
        if (readBuffer == null) {
            System.out.println("断开 channel");
            clientSocketChannel.register(selector, 0);
            return;
        }

        if (readBuffer.position() > 0) {
            //写入模式
            String content = CodeUtil.newString(readBuffer);
            System.out.println("读取数据: " + content);

            //添加到响应队列
            ArrayList<String> responseQueue = (ArrayList<String>) key.attachment();
            responseQueue.add("响应： " + content);
            //注册
            clientSocketChannel.register(selector, SelectionKey.OP_WRITE, key.attachment());
        }
    }

    @SuppressWarnings("unchecked")
    private void handleWriteableKey(SelectionKey key) throws IOException {
        SocketChannel clientSocketChannel = (SocketChannel) key.channel();

        //遍历响应队列
        ArrayList<String> responseQueue = (ArrayList<String>) key.attachment();
        for (String content : responseQueue) {
            System.out.println("写入数据: " + content);
            CodeUtil.write(clientSocketChannel, content);
        }
        responseQueue.clear();

        clientSocketChannel.register(selector, SelectionKey.OP_READ, responseQueue);

    }
}
