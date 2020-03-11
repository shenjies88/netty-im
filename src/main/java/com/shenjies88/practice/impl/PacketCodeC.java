package com.shenjies88.practice.impl;

import com.shenjies88.practice.interfaces.Packet;
import com.shenjies88.practice.interfaces.Serializer;
import io.netty.buffer.ByteBuf;

public class PacketCodeC  {

    public static final int MAGIC_NUMBER = 0x12345678;

    public static PacketCodeC INSTANCE = new PacketCodeC();

    public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }

    public Packet decode(ByteBuf byteBuf) {
        // 跳过 magic number
        byteBuf.skipBytes(4);

        // 跳过版本号
        byteBuf.skipBytes(1);

        // 序列化算法标识
        byte serializeAlgorithm = byteBuf.readByte();

        // 指令
        byte command = byteBuf.readByte();

        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {
        switch (serializeAlgorithm) {
            case 1:
                return new JSONSerializer();
            default:
                return new JSONSerializer();
        }
    }

    private Class<? extends Packet> getRequestType(byte command) {
        switch (command) {
            case 1:
                return LoginRequestPacket.class;
            case 2:
                return LoginResponsePacket.class;
            case 3:
                return MessageRequestPacket.class;
            case 4:
                return MessageResponsePacket.class;
            case 5:
                return CreateGroupRequestPacket.class;
            case 6:
                return CreateGroupResponsePacket.class;
            case 7:
                return QuitGroupRequestPacket.class;
            case 8:
                return QuitGroupResponsePacket.class;
            case 9:
                return JoinGroupRequestPacket.class;
            case 10:
                return JoinGroupResponsePacket.class;
            case 11:
                return ListGroupMembersRequestPacket.class;
            case 12:
                return ListGroupMembersResponsePacket.class;
            default:
                return Packet.class;
        }
    }
}
