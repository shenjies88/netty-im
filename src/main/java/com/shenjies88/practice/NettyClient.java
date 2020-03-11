package com.shenjies88.practice;

import com.shenjies88.practice.command.LoginConsoleCommand;
import com.shenjies88.practice.handler.PacketCodecHandler;
import com.shenjies88.practice.handler.Spliter;
import com.shenjies88.practice.handler.response.*;
import com.shenjies88.practice.manage.ConsoleCommandManager;
import com.shenjies88.practice.utils.SessionUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(Spliter.INSTANCE);
                        ch.pipeline().addLast(PacketCodecHandler.INSTANCE);
                        ch.pipeline().addLast(LoginResponseHandler.INSTANCE);
                        ch.pipeline().addLast(CreateGroupResponseHandler.INSTANCE);
                        ch.pipeline().addLast(JoinGroupResponseHandler.INSTANCE);
                        ch.pipeline().addLast(ListGroupMembersResponseHandler.INSTANCE);
                        ch.pipeline().addLast(GroupMessageResponseHandler.INSTANCE);
                        ch.pipeline().addLast(MessageResponseHandler.INSTANCE);
                    }
                });

        bootstrap.connect("127.0.0.1", 8000).addListener(future -> {
            if (future.isSuccess()) {
                Channel channel = ((ChannelFuture) future).channel();
                // 连接成功之后，启动控制台线程
                startConsoleThread(channel);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
        Scanner scanner = new Scanner(System.in);

        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (!SessionUtil.hasLogin(channel)) {
                    loginConsoleCommand.exec(scanner, channel);
                    waitForLoginResponse();
                } else {
                    consoleCommandManager.exec(scanner, channel);
                }
            }
        }).start();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}