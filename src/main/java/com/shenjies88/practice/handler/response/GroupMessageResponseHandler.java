package com.shenjies88.practice.handler.response;

import com.shenjies88.practice.packet.GroupMessageResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {

    public static final GroupMessageResponseHandler INSTANCE = new GroupMessageResponseHandler();

    private GroupMessageResponseHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket packet) {
        System.out.println("来自群:" + packet.getFromGroupId() + " " + packet.getFromUser().getUserName() + "的消息:" + packet.getMessage());
    }
}
