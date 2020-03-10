package com.shenjies88.practice.handler;

import com.shenjies88.practice.impl.LoginResponsePacket;
import com.shenjies88.practice.impl.Session;
import com.shenjies88.practice.utils.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class LoginResponseHandler  extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket packet) throws Exception {
        if (packet.isSuccess()) {
            System.out.println(new Date() + ": 客户端登录成功");
            LoginUtil.markAsLogin(ctx.channel());
            LoginUtil.bindSession(new Session(packet.getUserId(), packet.getUserName()), ctx.channel());
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + packet.getReason());
        }
    }

    // 用户断线之后取消绑定
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        LoginUtil.unBindSession(ctx.channel());
    }
}
