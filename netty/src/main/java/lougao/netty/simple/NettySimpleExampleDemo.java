package lougao.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * netty的简单应用
 *
 * @author leibingguang
 * @since 2022/7/5 10:31 PM
 */
public class NettySimpleExampleDemo {
    public static void main(String[] args) throws Exception {
        // 主线程,轮询线程，一个线程足够处理轮询事件了
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // 子线程, 处理除了accept之外的所有事件，默认线程数为cpu的两倍
        EventLoopGroup workerGroup = new NioEventLoopGroup(4);

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        try {
                            ch.pipeline().addLast(new NormalMessageHandler());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();

        channelFuture.channel().closeFuture().sync();
    }
}
