package com.kangyonggan.rpc.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import org.apache.log4j.Logger;

/**
 * @author kangyonggan
 * @since 2019-02-14
 */
public class RpcServerHandler extends ChannelInboundHandlerAdapter {

    Logger logger = Logger.getLogger(RpcServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info("RPC服务端收到消息");

        try {
            ByteBuf in = (ByteBuf) msg;
            logger.info(in.toString(CharsetUtil.UTF_8));
        } finally {
            // 丢弃接收到的数据
            ReferenceCountUtil.release(msg);
        }
    }
}
