package lougao.netty.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.UUID;

/**
 * @author: lou_gao
 * @description:
 */
public class ServerSimpleHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接成功！");
        for (int i = 0; i < 10; i++) {
            ctx.channel().writeAndFlush(Unpooled.directBuffer().writeBytes(UUID.randomUUID().toString().getBytes()));
        }
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        int readableBytes = byteBuf.readableBytes();
        byte[] readBytes = new byte[readableBytes];
        byteBuf.readBytes(readBytes);
        System.out.println("服务端接收到客户端消息:" + new String(readBytes));

//        super.channelRead(ctx, msg);
    }
}
