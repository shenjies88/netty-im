package com.shenjies88.practice.handler;

import com.shenjies88.practice.packet.GroupMessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket packet) {
        System.out.println("来自群:" + packet.getFromGroupId() + " " + packet.getFromUser().getUserName() + "的消息:" + packet.getMessage());
    }
}