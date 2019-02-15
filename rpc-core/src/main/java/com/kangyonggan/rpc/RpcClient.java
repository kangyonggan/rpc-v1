package com.kangyonggan.rpc;

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
import org.apache.log4j.Logger;

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
        logger.info("正在连接服务端的引用:" + refrence);
        // 客户端线程
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);

        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                // 自定义处理器
                handler = new RpcClientHandler();
                ch.pipeline().addLast(handler);
            }
        });

        try {
            channelFuture = bootstrap.connect("127.0.0.1", 9203).sync();

            logger.info("连接服务端引用成功:" + refrence);
        } catch (Exception e) {
            logger.error("连接服务端引用异常", e);
        }
    }

    public Object send() throws Exception {
        // 发送请求
        channelFuture.channel().writeAndFlush("test".getBytes()).sync();
        channelFuture.channel().closeFuture().sync();

        // 接收响应
        Object response = handler.getResponse();

        logger.info(response);

        return null;
    }
}
