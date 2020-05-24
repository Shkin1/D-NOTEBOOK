package com.pushkin.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2020/5/24 10:59
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(msg);
        System.out.println("收到客户端心跳监测, 开始响应客户端");
        ByteBuf byteBuf = getByteBuf(ctx, "你好 客户端, xxx服务运行正常....");
        ctx.channel().writeAndFlush(byteBuf);
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

