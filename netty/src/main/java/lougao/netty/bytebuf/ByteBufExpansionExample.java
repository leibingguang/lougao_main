package lougao.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

/**
 * 文档中描述的ByteBuf扩容有误，应该是小于4MB，2倍扩容，大于4MB，每次扩容+4MB
 *
 * @author: lou_gao
 * @description:
 */
public class ByteBufExpansionExample {
    public static void main(String[] args) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();

        System.out.println("capacity: " + byteBuf.capacity());
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 256 * 1024; i++) {
                long beforeCapacity = byteBuf.capacity();
                byteBuf.writeInt(i);
                long afterCapacity = byteBuf.capacity();

                if (beforeCapacity != afterCapacity) {
                    System.out.println("capacity expansion: " + byteBuf.capacity());
                }
            }
        }
    }
}
