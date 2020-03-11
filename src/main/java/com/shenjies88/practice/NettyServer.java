package com.shenjies88.practice;

import com.shenjies88.practice.handler.AuthHandler;
import com.shenjies88.practice.handler.PacketDecoder;
import com.shenjies88.practice.handler.PacketEncoder;
import com.shenjies88.practice.handler.Spliter;
import com.shenjies88.practice.handler.request.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(Spliter.INSTANCE);
                        ch.pipeline().addLast(PacketDecoder.INSTANCE);
                        ch.pipeline().addLast(LoginRequestHandler.INSTANCE);
                        ch.pipeline().addLast(AuthHandler.INSTANCE);
                        ch.pipeline().addLast(CreateGroupRequestHandler.INSTANCE);
                        ch.pipeline().addLast(JoinGroupRequestHandler.INSTANCE);
                        ch.pipeline().addLast(ListGroupMembersRequestHandler.INSTANCE);
                        ch.pipeline().addLast(GroupMessageRequestHandler.INSTANCE);
                        ch.pipeline().addLast(QuitGroupRequestHandler.INSTANCE);
                        ch.pipeline().addLast(MessageRequestHandler.INSTANCE);
                        ch.pipeline().addLast(PacketEncoder.INSTANCE);
                    }
                }).bind(8000);
    }
}