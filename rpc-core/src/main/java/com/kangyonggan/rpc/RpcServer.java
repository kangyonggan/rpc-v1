package com.kangyonggan.rpc;

import com.kangyonggan.rpc.handler.RpcServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

/**
 * @author kangyonggan
 * @since 2019-02-14
 */
public class RpcServer extends Thread {

    private Logger logger = Logger.getLogger(RpcServer.class);

    private Integer port;

    public RpcServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        logger.info("RPC服务端正在启动...");

        // 接收客户端的链接
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        // 处理已被接收的链接
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            // 自定义处理器
                            ch.pipeline().addLast(new RpcServerHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);

            // 绑定端口，开始接收进来的链接
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            logger.info("RPC服务端启动完成，监听【" + port + "】端口");

            // 等待服务器关闭
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("RPC服务端启动异常，监听【" + port + "】端口", e);
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
