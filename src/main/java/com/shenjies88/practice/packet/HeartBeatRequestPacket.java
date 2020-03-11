package com.shenjies88.practice.packet;

import com.shenjies88.practice.interfaces.Packet;

import static com.shenjies88.practice.interfaces.Command.HEART_BEAT_REQUEST;

public class HeartBeatRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return HEART_BEAT_REQUEST;
    }
}
