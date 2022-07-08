package lougao.netty.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.UUID;


/**
 * @author: lou_gao
 * @description:
 */
public class ClientSimpleHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接成功！");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        int readableBytes = byteBuf.readableBytes();
        byte[] readBytes = new byte[readableBytes];
        byteBuf.readBytes(readBytes);
        System.out.println("客户端接收到服务端消息:" + new String(readBytes));
        super.channelRead(ctx, msg);
    }
}
