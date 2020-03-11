package com.shenjies88.practice.handler.response;

import com.shenjies88.practice.packet.MessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    public static final MessageResponseHandler INSTANCE = new MessageResponseHandler();

    private MessageResponseHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket messageResponsePacket) {
        String fromUserId = messageResponsePacket.getFromUserId();
        String fromUserName = messageResponsePacket.getFromUserName();
        System.out.println(fromUserId + ":" + fromUserName + " -> " + messageResponsePacket.getMessage());
    }
}
