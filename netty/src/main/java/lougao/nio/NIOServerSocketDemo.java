/**
 * @Description
 * @author lou_gao
 */
package lougao.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * nio
 */
public class NIOServerSocketDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8081));
        int i=0;
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                socketChannel.configureBlocking(false);
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int length = socketChannel.read(byteBuffer);
                System.out.println(new String(byteBuffer.array()));
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
            } else {
                i++;
                Thread.sleep(1000L);
                System.out.println("未准备就绪: i=" + i);
            }
        }
    }
}
