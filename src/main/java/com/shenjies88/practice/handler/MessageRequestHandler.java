package com.shenjies88.practice.handler;

import com.shenjies88.practice.impl.MessageRequestPacket;
import com.shenjies88.practice.impl.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket requestPacket) {
        ctx.channel().writeAndFlush(receiveMessage(requestPacket));
    }

    private MessageResponsePacket receiveMessage(MessageRequestPacket packet) {
        System.out.println(new Date() + ": 收到客户端消息: " + packet.getMessage());

        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("服务端回复【" + packet.getMessage() + "】");
        return messageResponsePacket;
    }
}
