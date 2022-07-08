package lougao.netty.bytebuf;

import io.netty.buffer.*;

/**
 * 零拷贝，共用内存地址
 *
 * @author: lou_gao
 * @description:
 */
public class ByteBufZeroCopyExample {
    public static void main(String[] args) {
        // slice方式
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeBytes(new byte[]{'1', '2', '3', '4'});
        ByteBuf slice1 = byteBuf.slice(0, 2);
        ByteBuf slice2 = byteBuf.slice(2, 2);
        log(byteBuf);
        log(slice1);
        log(slice2);

        System.out.println("============== after change ===========");
        byteBuf.setBytes(1, new byte[]{'a'});
        log(byteBuf);
        log(slice1);
        log(slice2);

        System.out.println("============= CompositeByte ==============");
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        compositeByteBuf.addComponents(true, byteBuf, slice2);
        log(compositeByteBuf);


    }

    private static void log(ByteBuf byteBuf) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("read index: " + byteBuf.readerIndex())
                .append(("   write index: " + byteBuf.writerIndex()))
                .append("    capacity: " + byteBuf.capacity());
        System.out.println(stringBuilder);
        System.out.println(ByteBufUtil.prettyHexDump(byteBuf));
    }
}
