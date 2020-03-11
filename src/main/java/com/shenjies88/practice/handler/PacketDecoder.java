package com.shenjies88.practice.handler;

import com.shenjies88.practice.impl.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

@ChannelHandler.Sharable
public class PacketDecoder extends ByteToMessageDecoder {

    public static final PacketDecoder INSTANCE = new PacketDecoder();

    protected PacketDecoder() {
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) {
        out.add(PacketCodeC.INSTANCE.decode(in));
    }
}
