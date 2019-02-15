package com.kangyonggan.rpc.handler;

import com.kangyonggan.rpc.core.RpcRequest;
import com.kangyonggan.rpc.core.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

/**
 * @author kangyonggan
 * @since 2019-02-14
 */
public class RpcServerHandler extends ChannelInboundHandlerAdapter {

    Logger logger = Logger.getLogger(RpcServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        RpcResponse response = new RpcResponse();
        try {
            RpcRequest rpcRequest = (RpcRequest) msg;
            logger.info("RPC服务端收到消息:" + rpcRequest);

            // 获取本地服务，反射获取返回值
            response.setIsSuccess(true);
            response.setResult(3);
        } catch (Exception e) {
            logger.error("服务端接收消息发送异常", e);
            response.setIsSuccess(false);
            response.setThrowable(e);
        }

        // 写响应
        logger.info("服务端响应内容:" + response);
        ctx.write(response);
        ctx.flush();
    }
}
