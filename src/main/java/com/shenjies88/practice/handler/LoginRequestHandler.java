package com.shenjies88.practice.handler;

import com.shenjies88.practice.packet.LoginRequestPacket;
import com.shenjies88.practice.packet.LoginResponsePacket;
import com.shenjies88.practice.impl.Session;
import com.shenjies88.practice.utils.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket packet) {
        ctx.channel().writeAndFlush(login(ctx,packet));
    }

    private LoginResponsePacket login(ChannelHandlerContext ctx, LoginRequestPacket packet) {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(packet.getVersion());
        String userId = UUID.randomUUID().toString();
        loginResponsePacket.setUserId(userId);
        loginResponsePacket.setUserName(packet.getUserName());
        LoginUtil.bindSession(new Session(userId, packet.getUserName()), ctx.channel());
        // 登录校验
        if (true) {
            LoginUtil.markAsLogin(ctx.channel());
            loginResponsePacket.setSuccess(true);
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
        }
        System.out.println(userId+":登陆");
        return loginResponsePacket;
    }

    // 用户断线之后取消绑定
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        LoginUtil.unBindSession(ctx.channel());
    }
}
