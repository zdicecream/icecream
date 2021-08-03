package com.zdinit.icecream.bankinterface.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NettyClient{
    @Value("${client.ip}")
    private String ip;
    @Value("${client.port}")
    private int port;

    public void sendMessage(String content) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new NettyClientChannelInitializer());

            ChannelFuture future = b.connect(ip, port).sync();
            future.channel().writeAndFlush(content);
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
