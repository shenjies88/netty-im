package com.shenjies88.practice.handler.response;

import com.shenjies88.practice.packet.ListGroupMembersResponsePacket;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

@ChannelHandler.Sharable
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {

    public static final ListGroupMembersResponseHandler INSTANCE = new ListGroupMembersResponseHandler();

    private ListGroupMembersResponseHandler() {

    }

    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResponsePacket responsePacket) {
        System.out.println("群[" + responsePacket.getGroupId() + "]中的人包括：" + responsePacket.getSessionList());
    }
}