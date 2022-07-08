/**
 * @Description
 * @author lou_gao
 */
package lougao.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO 选择器
 */
public class NIOSelectorServerSocketDemo implements Runnable{
    SocketChannel socketChannel = null;
    Selector selector = null;

    public NIOSelectorServerSocketDemo(int port) throws Exception {
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        socketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public static void main(String[] args) throws Exception{
        new Thread(new NIOSelectorServerSocketDemo(8888)).start();
    }

    @Override
    public void run() {
//        while (selector.in)
    }
}
