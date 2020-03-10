package com.shenjies88.practice.impl;

import com.shenjies88.practice.interfaces.Packet;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.shenjies88.practice.interfaces.Command.MESSAGE_REQUEST;

@Data
@AllArgsConstructor
public class MessageRequestPacket extends Packet {

    private String toUserId;
    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}