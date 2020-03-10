package com.shenjies88.practice.impl;

import com.shenjies88.practice.interfaces.Command;
import com.shenjies88.practice.interfaces.Packet;
import lombok.Data;

import java.util.List;

@Data
public class CreateGroupRequestPacket extends Packet {
    private List<String> userIdList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_REQUEST;
    }
}