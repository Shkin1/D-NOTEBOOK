package com.pushkin.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 10:54
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class FirstClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(byteBuf.toString(Charset.forName("UTF-8")));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 获取数据
        ByteBuf buffer = getByteBuf(ctx, "client: hello server");
        // 写数据
        ctx.channel().writeAndFlush(buffer);
    }


    private ByteBuf getByteBuf(ChannelHandlerContext ctx, String inputStr) {
        // 1. 获取二进制抽象 ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        // 2. 准备数据
        byte[] bytes = inputStr.getBytes(Charset.forName("UTF-8"));
        buffer.writeBytes(bytes);
        return buffer;
    }
}
