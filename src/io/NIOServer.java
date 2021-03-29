package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    int port = 3000;
	    ServerSocketChannel socketChannel = ServerSocketChannel.open();
	    Selector selector = Selector.open();
	    
	    socketChannel.configureBlocking(false);
	    socketChannel.socket().bind(new InetSocketAddress(port));
	    socketChannel.register(selector, SelectionKey.OP_ACCEPT);
	    while (true) {
	    	selector.select(1000);
	    	Set<SelectionKey> selectionKeys = selector.selectedKeys();
	    	Iterator<SelectionKey> iterable = selectionKeys.iterator();
	    	SelectionKey key;
	    	while(iterable.hasNext()) {
	    		key = iterable.next();
	    		if (key.isValid()) {
    	           //判断是否是连接请求，对所有连接请求进行处理
    	           if (key.isAcceptable()) {
    	               ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
    	               SocketChannel channel = serverSocketChannel.accept();
    	               channel.configureBlocking(false);
    	               //在selector上注册通道，监听读事件
    	               channel.register(selector, SelectionKey.OP_READ);
    	           } else if (key.isReadable()) {
    	               SocketChannel channel = (SocketChannel) key.channel();
    	               //分配一个1024字节的缓冲区
    	               ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    	               int readBytes = channel.read(byteBuffer);
    	               if (readBytes > 0) {
    	                   //从写模式切换到读模式
    	                   byteBuffer.flip();
    	                   byte[] bytes = new byte[byteBuffer.remaining()];
    	                   byteBuffer.get(bytes);
    	                   String message  = new String(bytes, "UTF-8");
    	                   System.out.println("收到客户端消息: " + message);
    	                   //回复客户端
    	                   message = "answer: " + message;
    	                   byte[] responseByte = message.getBytes();
    	                   ByteBuffer writeBuffer = ByteBuffer.allocate(responseByte.length);
    	                   writeBuffer.put(responseByte);
    	                   writeBuffer.flip();
    	                   channel.write(writeBuffer);
    	               }
    	           }
	    		}
	    	}
	    }
	}

}
