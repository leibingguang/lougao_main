package lougao.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

/**
 * @author: lou_gao
 * @description:
 */
public class ByteBufSimpleExample {
    public static void main(String[] args) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        System.out.println("========================================init===================================================");
        log(byteBuf);
        for (int i = 0; i < 20; i++) {
            byteBuf.writeInt(i);
        }
        System.out.println("========================================after write ====================================================");

        log(byteBuf);

        System.out.println("=========================================after read =============================================");
        byteBuf.readInt();
        log(byteBuf);

        System.out.println("==========================================mark readIndex and reset ========================================");
        byteBuf.markReaderIndex();
        byteBuf.readInt();
        byteBuf.resetReaderIndex();
        log(byteBuf);


        System.out.println("==========================================mark writeIndex========================================");
        byteBuf.markWriterIndex();
        byteBuf.writeInt(100);
        log(byteBuf);
        System.out.println("==========================================mark writeIndex: reset ========================================");
        byteBuf.resetWriterIndex();
        log(byteBuf);
        byteBuf.writeInt(33);
        log(byteBuf);

        byteBuf.readBytes(10000);

    }

    private static void log(ByteBuf byteBuf) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("read index: " + byteBuf.readerIndex())
                .append(("write index: " + byteBuf.writerIndex()))
                .append("capacity: " + byteBuf.capacity());
        System.out.println(ByteBufUtil.prettyHexDump(byteBuf));
    }
}
