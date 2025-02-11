package com.suda.javaee.nio;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author alien
 * @program myrepo
 * @description
 * @date 2025/2/5$
 */
public class ExpBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        ByteBuffer buffer1 = ByteBuffer.allocateDirect(10);
        System.out.println("put");
        for (int i = 0; i < 8; i ++ ) {
            buffer.put((byte) i);
        }
        printBuf(buffer);
        buffer.flip();  // 转换为读模式，将当前的limit 设置为写入时的 position
        for (int i = 0; i < 5; i ++ ) {
            byte b = buffer.get();
            System.out.print(b);
        }
        System.out.println();
        System.out.println("slice");
        printBuf(buffer);
        ByteBuffer sliceBuf = buffer.slice();   // 浅拷贝切片
        ByteBuffer duplicatedBuf = buffer.duplicate();  // 浅拷贝整个Buffer
        printBuf(sliceBuf);
        printBuf(duplicatedBuf);
    }

    private static void printBuf(ByteBuffer buffer) {
        StringBuilder builder = new StringBuilder();
        builder.append("position: ").append(buffer.position()).append("; limit: ").append(buffer.limit())
                .append("; capacity").append(buffer.capacity()).append(" Content:[");
        for (int i = 0; i < buffer.array().length; i ++ ) {
            if (i != 0) builder.append(",");
            builder.append(buffer.array()[i]);
        }
        builder.append("]");
        builder.append("\tcontentHashCode:").append(Arrays.hashCode(buffer.array()));
        System.out.println(builder);
    }
}
