package com.shenjies88.practice.handler;

import com.shenjies88.practice.packet.MessageRequestPacket;
import com.shenjies88.practice.packet.MessageResponsePacket;
import com.shenjies88.practice.impl.Session;
import com.shenjies88.practice.utils.LoginUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket requestPacket) {
        // 1.拿到消息发送方的会话信息
        Session session = LoginUtil.getSession(ctx.channel());

        // 2.通过消息发送方的会话信息构造要发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(requestPacket.getMessage());

        // 3.拿到消息接收方的 channel
        Channel toUserChannel = LoginUtil.getChannel(requestPacket.getToUserId());

        // 4.将消息发送给消息接收方
        if (toUserChannel != null && LoginUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.err.println("[" + requestPacket.getToUserId() + "] 不在线，发送失败!");
        }
    }
}
