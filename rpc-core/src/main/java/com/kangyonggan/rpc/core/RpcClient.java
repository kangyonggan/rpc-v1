package com.kangyonggan.rpc.core;

import com.kangyonggan.rpc.handler.RpcClientHandler;
import com.kangyonggan.rpc.pojo.Refrence;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.apache.log4j.Logger;

import java.util.UUID;

/**
 * 客户端
 *
 * @author kangyonggan
 * @since 2019-02-15
 */
public class RpcClient {

    private Logger logger = Logger.getLogger(RpcClient.class);

    private Refrence refrence;

    private ChannelFuture channelFuture;

    private RpcClientHandler handler;

    public RpcClient(Refrence refrence) {
        this.refrence = refrence;
        connectRemoteService();
    }

    /**
     * 连接远程服务
     */
    private void connectRemoteService() {
        logger.info("正在连接远程服务端:" + refrence);
        // 客户端线程
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);

        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                // 编码
                ch.pipeline().addLast(new ObjectEncoder());

                // 收发消息
                handler = new RpcClientHandler();
                ch.pipeline().addLast(handler);
            }
        });

        try {
            channelFuture = bootstrap.connect("127.0.0.1", 9203).sync();

            logger.info("连接远程服务端成功:" + refrence);
        } catch (Exception e) {
            logger.error("连接远程服务端异常", e);
        }
    }

    /**
     * 发送消息
     *
     * @return
     * @throws Exception
     */
    public Object send() throws Exception {
        // 请求参数
        RpcRequest request = new RpcRequest();
        request.setUuid(UUID.randomUUID().toString());

        // 发送请求
        channelFuture.channel().writeAndFlush(request).sync();
        channelFuture.channel().closeFuture().sync();

        // 接收响应
        Object response = handler.getResponse();

        logger.info(response);

        return null;
    }
}
