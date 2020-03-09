package com.shenjies88.practice.impl;

import com.shenjies88.practice.interfaces.Packet;
import lombok.Data;

import static com.shenjies88.practice.interfaces.Command.MESSAGE_REQUEST;

@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}