package com.pushkin.demo.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>Title: IOUtils</p>
 *
 * <p>Description:
 * 描述：
 * </p>
 *
 * @author jinpu.shi
 * @version v1.0.0
 * @since 2020-04-19 08:36
 */
public class IOUtils {

    public static void copyFile (String srcFileName, String dstFileName) throws IOException {
        FileInputStream fis = new FileInputStream(srcFileName);
        FileOutputStream fos = new FileOutputStream(dstFileName);

        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            buffer.clear();
            if ( readChannel.read(buffer) == -1 ){
                break;
            }
            // 将当前位置设置为limit, 然后再将缓存区游标置于0, 0-limit写入Channel
            buffer.flip();
            writeChannel.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
