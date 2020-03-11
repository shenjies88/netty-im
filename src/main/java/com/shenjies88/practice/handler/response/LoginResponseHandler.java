package com.shenjies88.practice.handler.response;

import com.shenjies88.practice.impl.Session;
import com.shenjies88.practice.packet.LoginResponsePacket;
import com.shenjies88.practice.utils.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

@ChannelHandler.Sharable
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    public static final LoginResponseHandler INSTANCE = new LoginResponseHandler();

    private LoginResponseHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket packet) throws Exception {
        if (packet.isSuccess()) {
            System.out.println(new Date() + ": 客户端登录成功");
            SessionUtil.markAsLogin(ctx.channel());
            SessionUtil.bindSession(new Session(packet.getUserId(), packet.getUserName()), ctx.channel());
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + packet.getReason());
        }
    }

    // 用户断线之后取消绑定
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }
}
